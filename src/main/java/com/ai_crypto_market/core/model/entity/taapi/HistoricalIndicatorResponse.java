package com.ai_crypto_market.core.model.entity.taapi;

import lombok.Builder;
import lombok.Data;

import java.util.List;


public class HistoricalIndicatorResponse {

    private List<HistoricalIndicatorItem> data;


    public List<HistoricalIndicatorItem> getData() {
        return data;
    }

    public HistoricalIndicatorResponse setData(List<HistoricalIndicatorItem> data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "HistoricalIndicatorResponse{" +
                "data=" + data +
                '}';
    }
}
