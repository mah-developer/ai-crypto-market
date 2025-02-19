package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.common.annotation.RSI;
import com.ai_crypto_market.core.model.entity.Stock;

import java.util.HashMap;
import java.util.Map;

@RSI
public class RSIIndicatorServiceImpl implements IndicatorService {
    public Map<String, String> getCurrentSignal(Stock stock) {
        Map<String, String> result = new HashMap<>();
        result.put("percent of buy", "percent of cell");
        return result;
    }
}