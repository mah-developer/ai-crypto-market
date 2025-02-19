package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Stock;

import java.util.Map;

public interface IndicatorService {
    Map<String, String> getCurrentSignal(Stock stock);
}
