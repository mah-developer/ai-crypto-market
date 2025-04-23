package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.taapi.*;

public interface ApiService {
    MacdResponse getMacdIndicator(String exchange, String symbol, String interval);
    RsiResponse getRsiIndicator(String exchange, String symbol, String interval);
    BulkIndicatorResponse getBulkIndicators(String exchange, String symbol, String interval);
    ManualAnalysisResponse getManualAnalysis(String exchange, String symbol, String interval, String indicators);
    HistoricalIndicatorResponse getHistoricalAnalysis(String exchange, String symbol, String interval, String indicator, int backtrack);
    SmaResponse getSmaIndicator(String exchange, String symbol, String interval, int period);
    EmaResponse getEmaIndicator(String exchange, String symbol, String interval, int period);
}
