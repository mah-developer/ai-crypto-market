package com.ai_crypto_market.core.model.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ExchangeStockId implements Serializable {
    private Long exchangeId;
    private Long stockId;
    public ExchangeStockId() {}
    public ExchangeStockId(Long exchangeId, Long stockId) {
        this.exchangeId = exchangeId;
        this.stockId = stockId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeStockId that = (ExchangeStockId) o;
        return Objects.equals(exchangeId, that.exchangeId) &&
                Objects.equals(stockId, that.stockId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exchangeId, stockId);
    }


    // Getters and Setters

    public Long getExchangeId() {
        return exchangeId;
    }

    public ExchangeStockId setExchangeId(Long exchangeId) {
        this.exchangeId = exchangeId;
        return this;
    }

    public Long getStockId() {
        return stockId;
    }

    public ExchangeStockId setStockId(Long stockId) {
        this.stockId = stockId;
        return this;
    }
}
