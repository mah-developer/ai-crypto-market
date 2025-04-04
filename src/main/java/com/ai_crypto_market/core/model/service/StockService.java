package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Stock;

import java.util.List;

public interface StockService {
    Stock getFullStockInfoFromExternalServiceApi(Stock stock);
    // todo میشه اینو توی انتیتی استراتژی بیاریم که لیستی از استاک برگردونه؟ Transient
    List<Stock> findAllByStrategyIdOrderByCreatedAtDesc(Long strategyId);

}
