package com.crypto.portfolio.service;

import com.crypto.portfolio.model.Stock;

import java.util.List;
import java.util.Set;

public interface MarketService {
    List<Stock> getAllStocks();

    List<Stock> getStocksForCodes(Set<String> codes);

    List<String> getAllStockCodes();

}
