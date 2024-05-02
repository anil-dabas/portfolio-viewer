package com.crypto.portfolio;

import com.crypto.portfolio.cache.SecurityDerivativesCache;
import com.crypto.portfolio.exception.PortfolioSnapshotMissingException;
import com.crypto.portfolio.publisher.MarketDataPublisher;
import com.crypto.portfolio.viewer.PortfolioViewer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class PortfolioViewerApplication {

    public static void main(String[] args) throws PortfolioSnapshotMissingException, InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(PortfolioViewerApplication.class, args);
        SecurityDerivativesCache securityDerivativesCache = context.getBean(SecurityDerivativesCache.class);
        securityDerivativesCache.initCache();
        PortfolioViewer portfolioViewer = context.getBean(PortfolioViewer.class);
        portfolioViewer.positionSnapshot();
        Thread.sleep(4000);
        MarketDataPublisher marketDataPublisher = context.getBean(MarketDataPublisher.class);
        marketDataPublisher.initMarket();

    }


}
