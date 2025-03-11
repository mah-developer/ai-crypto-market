package com.ai_crypto_market.core.model.entity;

import java.math.BigDecimal;

public class MarketData {
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;
    private BigDecimal volume;

    // Getters, setters, constructor
    public MarketData(BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close, BigDecimal volume) {
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }
    // ... getters and setters


    public BigDecimal getOpen() {
        return open;
    }

    public MarketData setOpen(BigDecimal open) {
        this.open = open;
        return this;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public MarketData setHigh(BigDecimal high) {
        this.high = high;
        return this;
    }

    public BigDecimal getLow() {
        return low;
    }

    public MarketData setLow(BigDecimal low) {
        this.low = low;
        return this;
    }

    public BigDecimal getClose() {
        return close;
    }

    public MarketData setClose(BigDecimal close) {
        this.close = close;
        return this;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public MarketData setVolume(BigDecimal volume) {
        this.volume = volume;
        return this;
    }
}