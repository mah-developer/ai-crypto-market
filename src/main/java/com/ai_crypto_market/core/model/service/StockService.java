package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Position;
import com.ai_crypto_market.core.model.entity.Stock;
import com.ai_crypto_market.core.model.enums.ExchangeName;
import com.ai_crypto_market.core.model.enums.TimeFrame;

import java.util.List;
import java.util.Set;

public interface StockService {
    Stock getFullStockInfoFromExternalServiceApiAndProvideMoreAnaliticInfoOfThisStock(Stock stock, ExchangeName exchangeName, TimeFrame timeFrame);
    List<Stock> findAll();
}
