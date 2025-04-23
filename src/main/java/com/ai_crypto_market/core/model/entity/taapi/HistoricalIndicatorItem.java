package com.ai_crypto_market.core.model.entity.taapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
public class HistoricalIndicatorItem {
    private Double value;
    private Long timestamp;

    @Override
    public String toString() {
        return "HistoricalIndicatorItem{" +
                "value=" + value +
                ", timestamp=" + timestamp +
                '}';
    }
}