package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Stock;

public interface StockService {
    Stock getFullStockInfoFromExternalServiceApi(Stock stock);
}
