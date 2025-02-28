package com.ai_crypto_market.core.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_EXCHANGE_STOCK_HISTORY")
public class ExchangeStockHistory extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_TB_EXCHANGE_STOCK_HISTORY")
    private long id;

    @ManyToOne
    @JoinColumn(name = "FK_TB_EXCHANGE_STOCK", nullable = false)
    private ExchangeStock exchangeStock;

    @Column(nullable = false)
    private Double openPrice;

    @Column(nullable = false)
    private Double closePrice;

    @Column(nullable = false)
    private Double high;

    @Column(nullable = false)
    private Double low;

    @Column(nullable = false)
    private Double volume;

    // GETTERS AND SETTERS


    public long getId() {
        return id;
    }

    public ExchangeStock getExchangeStock() {
        return exchangeStock;
    }

    public ExchangeStockHistory setExchangeStock(ExchangeStock exchangeStock) {
        this.exchangeStock = exchangeStock;
        return this;
    }

    public Double getOpenPrice() {
        return openPrice;
    }

    public ExchangeStockHistory setOpenPrice(Double openPrice) {
        this.openPrice = openPrice;
        return this;
    }

    public Double getClosePrice() {
        return closePrice;
    }

    public ExchangeStockHistory setClosePrice(Double closePrice) {
        this.closePrice = closePrice;
        return this;
    }

    public Double getHigh() {
        return high;
    }

    public ExchangeStockHistory setHigh(Double high) {
        this.high = high;
        return this;
    }

    public Double getLow() {
        return low;
    }

    public ExchangeStockHistory setLow(Double low) {
        this.low = low;
        return this;
    }

    public Double getVolume() {
        return volume;
    }

    public ExchangeStockHistory setVolume(Double volume) {
        this.volume = volume;
        return this;
    }
}
