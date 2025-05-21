package com.ai_crypto_market.core.model.entity.taapi;

import lombok.Builder;
import lombok.Data;

import java.util.Arrays;

@Data
@Builder
public class VolumeResponse {
    private String symbol;
    private String exchange;
    private String interval;
    private long timestamp;
    private String[] value;

    @Override
    public String toString() {
        return "VolResponse{" +
                "symbol='" + symbol + '\'' +
                ", exchange='" + exchange + '\'' +
                ", interval='" + interval + '\'' +
                ", timestamp=" + timestamp +
                ", value=" + Arrays.toString(value) +
                '}';
    }
}
