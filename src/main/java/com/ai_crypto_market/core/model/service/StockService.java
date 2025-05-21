package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Stock;

import java.util.List;
import java.util.Set;

public interface StockService {
    Stock getFullStockInfoFromExternalServiceApiAndProvideMoreAnaliticInfoOfThisStock(Stock stock);
    List<Stock> findAll();
}
