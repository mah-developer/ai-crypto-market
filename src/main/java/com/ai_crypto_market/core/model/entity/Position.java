package com.ai_crypto_market.core.model.entity;

import com.ai_crypto_market.core.model.enums.PositionStatus;
import com.ai_crypto_market.core.model.enums.PositionType;
import com.ai_crypto_market.core.model.enums.TradeAction;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Position extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_STRATEGY")
    private Strategy strategy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_WALLET")
    private Wallet wallet;

    @Enumerated(EnumType.STRING)
    private PositionStatus positionStatus;

    @Enumerated(EnumType.STRING)
    private PositionType positionType;

    @Column(precision = 15, scale = 2)
    private BigDecimal exitPrice; // Added for trade

    @Enumerated(EnumType.STRING)
    @Transient
    private TradeAction tradeAction;

    @Column(nullable = false, precision = 5, scale = 2)
    private int leverage;

    @Column
    private LocalDateTime entryTime; // Added for trade

    @Column
    private LocalDateTime exitTime; // Added for trade

    @Column(precision = 15, scale = 2)
    private BigDecimal currentTargetPrice;

    @Column(precision = 15, scale = 2)
    private BigDecimal currentStopLoss;

    @Column(precision = 15, scale = 2)
    private BigDecimal entryPrice;

    @Column(precision = 15, scale = 2)
    private BigDecimal quantity;

    private String activities; // whole activities applied on this (current) position

    private String exchangePositionId;

    @Transient
    private BigDecimal profit;

    @Transient
    private BigDecimal currentPrice;

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public Position setStrategy(Strategy strategy) {
        this.strategy = strategy;
        return this;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public Position setWallet(Wallet wallet) {
        this.wallet = wallet;
        return this;
    }

    public PositionStatus getPositionStatus() {
        return positionStatus;
    }

    public Position setPositionStatus(PositionStatus positionStatus) {
        this.positionStatus = positionStatus;
        return this;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public Position setPositionType(PositionType positionType) {
        this.positionType = positionType;
        return this;
    }

    public BigDecimal getExitPrice() {
        return exitPrice;
    }

    public Position setExitPrice(BigDecimal exitPrice) {
        this.exitPrice = exitPrice;
        return this;
    }

    public TradeAction getTradeAction() {
        return tradeAction;
    }

    public Position setTradeAction(TradeAction tradeAction) {
        this.tradeAction = tradeAction;
        return this;
    }

    public int getLeverage() {
        return leverage;
    }

    public Position setLeverage(int leverage) {
        this.leverage = leverage;
        return this;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public Position setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
        return this;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public Position setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
        return this;
    }

    public BigDecimal getCurrentTargetPrice() {
        return currentTargetPrice;
    }

    public Position setCurrentTargetPrice(BigDecimal currentTargetPrice) {
        this.currentTargetPrice = currentTargetPrice;
        return this;
    }

    public BigDecimal getCurrentStopLoss() {
        return currentStopLoss;
    }

    public Position setCurrentStopLoss(BigDecimal currentStopLoss) {
        this.currentStopLoss = currentStopLoss;
        return this;
    }

    public BigDecimal getEntryPrice() {
        return entryPrice;
    }

    public Position setEntryPrice(BigDecimal entryPrice) {
        this.entryPrice = entryPrice;
        return this;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public Position setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getActivities() {
        return activities;
    }

    public Position setActivities(String activities) {
        this.activities = activities;
        return this;
    }

    public String getExchangePositionId() {
        return exchangePositionId;
    }

    public Position setExchangePositionId(String exchangePositionId) {
        this.exchangePositionId = exchangePositionId;
        return this;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public Position setProfit(BigDecimal profit) {
        this.profit = profit;
        return this;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public Position setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
        return this;
    }
}
