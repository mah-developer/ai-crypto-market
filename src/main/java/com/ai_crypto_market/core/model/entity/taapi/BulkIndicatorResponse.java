package com.ai_crypto_market.core.model.entity.taapi;


import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class BulkIndicatorResponse {
    private String symbol;
    private String interval;
    private String exchange;
    private Map<String, Object> results;


    @Override
    public String toString() {
        return "BulkIndicatorResponse{" +
                "symbol='" + symbol + '\'' +
                ", interval='" + interval + '\'' +
                ", exchange='" + exchange + '\'' +
                ", results=" + results +
                '}';
    }
}
