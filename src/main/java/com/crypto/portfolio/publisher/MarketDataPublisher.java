package com.crypto.portfolio.publisher;

import com.crypto.portfolio.model.Stock;
import com.crypto.portfolio.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static com.crypto.portfolio.calculation.CalculateStockPrice.generateStockPrice;

@Component
public class MarketDataPublisher {

    @Autowired
    private MarketService marketService;

    @Autowired
    private JmsTemplate jmsTemplate;

    private Map<String, Double> priceMap;

    static Timer timer = new Timer();

    public void initMarket() {
        List<Stock> stocks = marketService.getAllStocks();
        priceMap = getStockPriceMap(stocks);
        CompletableFuture.runAsync(() -> stocks.forEach(stock -> new Task(stock).run()));
    }

    private Map<String, Double> getStockPriceMap(List<Stock> allStocks) {
        return allStocks.stream().collect(Collectors.toConcurrentMap(Stock::getCode, Stock::getDayStartPrice));
    }

    class Task extends TimerTask {
        Stock stock;

        Task(Stock stock) {
            this.stock = stock;
        }

        @Override
        public void run() {
            int delay = (5 + new Random().nextInt(20)) * 100;
            timer.schedule(new Task(stock), delay);
            double stockPrice = generateStockPrice(stock.getExpectedReturn(),stock.getVolatility(), delay,priceMap.get(stock.getCode()));
            stock.setDayStartPrice(stockPrice);
            priceMap.put(stock.getCode(), stockPrice);
            publish(stock.getCode(), stockPrice);
        }
    }

    public void publish(String stockCode, Double price) {
        jmsTemplate.convertAndSend(stockCode, price);
    }

}
