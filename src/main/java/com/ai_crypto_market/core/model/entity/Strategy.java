package com.ai_crypto_market.core.model.entity;

import com.ai_crypto_market.core.model.enums.StrategyType;
import com.ai_crypto_market.core.model.enums.TimeFrame;
import com.ai_crypto_market.core.model.enums.TradeAction;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "TB_STRATEGY")
public class Strategy extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_TB_STRATEGY")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_STOCK", nullable = false)
    private Stock stock;

    @Enumerated(EnumType.STRING)
    private StrategyType type;

    @Column(precision = 5, scale = 2)
    private BigDecimal defaultStopLossPercent;

    @Column(precision = 5, scale = 2)
    private BigDecimal defaultTargetPercent;


    private int defaultLeverage;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal defaultPercentOfAvailablePerPosition; // این استراتژی میخواد بره از ولت طرف بیت بخره. بهش میگیم اولین بار که میخوای بخری به این میزان درصد از موجودی ولت برو خرید کن.

    @Enumerated(EnumType.STRING)
    private TimeFrame timeFrame;

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public Stock getStock() {
        return stock;
    }

    public Strategy setStock(Stock stock) {
        this.stock = stock;
        return this;
    }

    public StrategyType getType() {
        return type;
    }

    public Strategy setType(StrategyType type) {
        this.type = type;
        return this;
    }

    public BigDecimal getDefaultStopLossPercent() {
        return defaultStopLossPercent;
    }

    public Strategy setDefaultStopLossPercent(BigDecimal defaultStoplossPercent) {
        this.defaultStopLossPercent = defaultStoplossPercent;
        return this;
    }

    public BigDecimal getDefaultTargetPercent() {
        return defaultTargetPercent;
    }

    public Strategy setDefaultTargetPercent(BigDecimal defaultTargetPercent) {
        this.defaultTargetPercent = defaultTargetPercent;
        return this;
    }
    public TimeFrame getTimeFrame() {
        return timeFrame;
    }

    public Strategy setTimeFrame(TimeFrame timeFrame) {
        this.timeFrame = timeFrame;
        return this;
    }

    public int getDefaultLeverage() {
        return defaultLeverage;
    }

    public Strategy setDefaultLeverage(int defaultLeverage) {
        this.defaultLeverage = defaultLeverage;
        return this;
    }

    public BigDecimal getDefaultPercentOfAvailablePerPosition() {
        return defaultPercentOfAvailablePerPosition;
    }

    public Strategy setDefaultPercentOfAvailablePerPosition(BigDecimal defaultPercentOfAvailablePerPosition) {
        this.defaultPercentOfAvailablePerPosition = defaultPercentOfAvailablePerPosition;
        return this;
    }
}