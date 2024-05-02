package com.crypto.portfolio.subscriber;

import com.crypto.portfolio.service.MarketService;
import com.crypto.portfolio.viewer.PortfolioViewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListenerConfigurer;
import org.springframework.jms.config.JmsListenerEndpointRegistrar;
import org.springframework.jms.config.SimpleJmsListenerEndpoint;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class PortfolioSubscriber implements JmsListenerConfigurer{

    @Autowired
    PortfolioViewer portfolioViewer;

    @Autowired
    MarketService marketService;

    @Override
    public void configureJmsListeners(JmsListenerEndpointRegistrar registrar) {
        marketService.getAllStockCodes().forEach(stockCode -> {
            SimpleJmsListenerEndpoint endpoint = new SimpleJmsListenerEndpoint();
            endpoint.setId(stockCode);
            endpoint.setDestination(stockCode);
            endpoint.setMessageListener(message -> {
                try {
                    TextMessage message1 = (TextMessage)message;
                    Double price = Double.valueOf(message1.getText());
                    portfolioViewer.updateAndPublishPortfolio(stockCode,price);
                } catch (JMSException e) {
                    throw new RuntimeException(e);
                }
            });
            registrar.registerEndpoint(endpoint);
        });
    }
}

