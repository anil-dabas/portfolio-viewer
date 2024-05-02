package com.crypto.portfolio.service;

import com.crypto.portfolio.model.Stock;
import com.crypto.portfolio.repo.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class MarketServiceImpl implements MarketService{

    @Autowired
    StockRepository stockRepository;

    @Override
    public List<Stock> getAllStocks(){
        return stockRepository.findAll();
    }

    @Override
    public List<Stock> getStocksForCodes(Set<String> codes) {
        return stockRepository.findByCodeIn(new ArrayList<>(codes));
    }

    @Override
    public List<String> getAllStockCodes() {
        return stockRepository.findAllStockCodes();
    }

}
