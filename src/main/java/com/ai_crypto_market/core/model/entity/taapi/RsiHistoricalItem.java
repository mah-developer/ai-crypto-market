package com.ai_crypto_market.core.model.entity.taapi;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RsiHistoricalItem {
    private long timestamp;
    private double value;

}