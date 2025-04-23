package com.ai_crypto_market.core.model.entity.taapi;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class HistoricalRsiResponse {
    private String symbol;
    private String interval;
    private List<RsiHistoricalItem> data;
}