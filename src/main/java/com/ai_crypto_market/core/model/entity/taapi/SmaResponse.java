package com.ai_crypto_market.core.model.entity.taapi;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SmaResponse {
    private String value;
    private String indicator;
    private String symbol;
    private String exchange;
    private String interval;
    private long timestamp;
}
