package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Indicator;
import com.ai_crypto_market.core.model.entity.Stock;

public interface IndicatorService {
    Indicator getCurrentSignal(Stock stock);
}
