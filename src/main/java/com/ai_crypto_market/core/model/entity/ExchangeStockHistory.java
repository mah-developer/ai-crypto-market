package com.ai_crypto_market.core.model.entity;

import com.ai_crypto_market.core.model.enums.ChangeType;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "TB_EXCHANGE_STOCK_HISTORY")
public class ExchangeStockHistory extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_TB_EXCHANGE_STOCK_HISTORY")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "exchange_id", referencedColumnName = "exchange_id", nullable = false),
        @JoinColumn(name = "stock_id", referencedColumnName = "stock_id", nullable = false)
    })
    private ExchangeStock exchangeStock;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ChangeType changeType;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal openPrice;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal closePrice;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal high;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal low;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal volume;

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

    public BigDecimal getOpenPrice() {
        return openPrice;
    }

    public ExchangeStockHistory setOpenPrice(BigDecimal openPrice) {
        this.openPrice = openPrice;
        return this;
    }

    public BigDecimal getClosePrice() {
        return closePrice;
    }

    public ExchangeStockHistory setClosePrice(BigDecimal closePrice) {
        this.closePrice = closePrice;
        return this;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public ExchangeStockHistory setHigh(BigDecimal high) {
        this.high = high;
        return this;
    }

    public BigDecimal getLow() {
        return low;
    }

    public ExchangeStockHistory setLow(BigDecimal low) {
        this.low = low;
        return this;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public ExchangeStockHistory setVolume(BigDecimal volume) {
        this.volume = volume;
        return this;
    }

    // Constructors


    public ExchangeStockHistory() {
    }

    public ExchangeStockHistory(ExchangeStock exchangeStock, ChangeType changeType, BigDecimal openPrice, BigDecimal closePrice, BigDecimal high, BigDecimal low, BigDecimal volume) {
        this.id = id;
        this.exchangeStock = exchangeStock;
        this.changeType = changeType;
        this.openPrice = openPrice;
        this.closePrice = closePrice;
        this.high = high;
        this.low = low;
        this.volume = volume;
    }
}
