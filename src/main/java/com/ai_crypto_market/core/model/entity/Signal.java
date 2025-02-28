package com.ai_crypto_market.core.model.entity;

import com.ai_crypto_market.core.model.enums.PositionType;
import com.ai_crypto_market.core.model.enums.StrategyType;
import com.ai_crypto_market.core.model.enums.TradeAction;
import com.ai_crypto_market.core.model.enums.TradeStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "TB_TRADE")
public class Signal extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_TB_TRADE")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FK_TB_STOCK", nullable = false)
    private Stock stock;

    @Column(nullable = false)
    private Double stopLoss;

    @Column(nullable = false)
    private Double targetPrice;

    @Column(nullable = false)
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PositionType positionType; // BUY, SELL

    @Column(nullable = false)
    private Double leverage;

    private StrategyType type;

    private Double buyPercent;

    private Double sellPercent;

    private TradeAction tradeAction;

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public Signal setId(Long id) {
        this.id = id;
        return this;
    }

    public Stock getStock() {
        return stock;
    }

    public Signal setStock(Stock stock) {
        this.stock = stock;
        return this;
    }

    public Double getStopLoss() {
        return stopLoss;
    }

    public Signal setStopLoss(Double stopLoss) {
        this.stopLoss = stopLoss;
        return this;
    }

    public Double getTargetPrice() {
        return targetPrice;
    }

    public Signal setTargetPrice(Double targetPrice) {
        this.targetPrice = targetPrice;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Signal setPrice(Double price) {
        this.price = price;
        return this;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public Signal setPositionType(PositionType positionType) {
        this.positionType = positionType;
        return this;
    }

    public Double getLeverage() {
        return leverage;
    }

    public Signal setLeverage(Double leverage) {
        this.leverage = leverage;
        return this;
    }
}
