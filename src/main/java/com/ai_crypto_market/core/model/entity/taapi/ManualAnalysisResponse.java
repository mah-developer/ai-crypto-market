package com.ai_crypto_market.core.model.entity.taapi;


import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class ManualAnalysisResponse {
    private String symbol;
    private String interval;
    private Map<String, Object> indicatorValues;

    @Override
    public String toString() {
        return "ManualAnalysisResponse{" +
                "symbol='" + symbol + '\'' +
                ", interval='" + interval + '\'' +
                ", indicatorValues=" + indicatorValues +
                '}';
    }
}