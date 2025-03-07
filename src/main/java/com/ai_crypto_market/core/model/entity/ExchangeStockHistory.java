package com.ai_crypto_market.core.model.entity;

import com.ai_crypto_market.core.model.enums.ChangeType;
import jakarta.persistence.*;

@Entity
@Table(name = "TB_EXCHANGE_STOCK_HISTORY")
public class ExchangeStockHistory extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_TB_EXCHANGE_STOCK_HISTORY")
    private long id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "exchange_id", referencedColumnName = "exchange_id"),
            @JoinColumn(name = "stock_id", referencedColumnName = "stock_id")
    })
    private ExchangeStock exchangeStock;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ChangeType changeType;

    @Column(name = "previous_exchange_id")
    private Long previousExchangeId;


    @Column(name = "previous_stock_id")
    private Long previousStockId;

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

    public Long getPreviousExchangeId() {
        return previousExchangeId;
    }

    public ExchangeStockHistory setPreviousExchangeId(Long previousExchangeId) {
        this.previousExchangeId = previousExchangeId;
        return this;
    }

    public Long getPreviousStockId() {
        return previousStockId;
    }

    public ExchangeStockHistory setPreviousStockId(Long previousStockId) {
        this.previousStockId = previousStockId;
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

    // Constructors


    public ExchangeStockHistory() {
    }

    public ExchangeStockHistory(ExchangeStock exchangeStock, ChangeType changeType, Long previousExchangeId, Long previousStockId, Double openPrice, Double closePrice, Double high, Double low, Double volume) {
        this.id = id;
        this.exchangeStock = exchangeStock;
        this.changeType = changeType;
        this.previousExchangeId = previousExchangeId;
        this.previousStockId = previousStockId;
        this.openPrice = openPrice;
        this.closePrice = closePrice;
        this.high = high;
        this.low = low;
        this.volume = volume;
    }
}
