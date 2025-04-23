package com.ai_crypto_market.core.model.entity.taapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
public class MacdResponse {
    private Double valueMACD;
    private Double valueMACDSignal;
    private Double valueMACDHist;

    @Override
    public String toString() {
        return "MACD: " + valueMACD + ", Signal: " + valueMACDSignal + ", Histogram: " + valueMACDHist;
    }
}
