package com.ai_crypto_market.core.model.entity.taapi;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RsiResponse {
    private String symbol;
    private String exchange;
    private String interval;
    private long timestamp;
    private double value;

    @Override
    public String toString() {
        return "RsiResponse{" +
                "symbol='" + symbol + '\'' +
                ", exchange='" + exchange + '\'' +
                ", interval='" + interval + '\'' +
                ", timestamp=" + timestamp +
                ", value=" + value +
                '}';
    }
}
