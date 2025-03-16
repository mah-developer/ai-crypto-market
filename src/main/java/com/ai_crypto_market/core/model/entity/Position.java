package com.ai_crypto_market.core.model.entity;

import com.ai_crypto_market.core.model.enums.PositionStatus;
import com.ai_crypto_market.core.model.enums.PositionType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Transient;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Position {
    private Long id;
    private Strategy strategy;
    private Wallet wallet;
    private Long currentTargetPrice;
    private Long currentStopLoss;
    private Long entryPrice;
    private Long quantity;

    @Enumerated(EnumType.STRING)
    private PositionStatus positionStatus;
    @Enumerated(EnumType.STRING)
    private PositionType positionType;
    @Transient
    private Long profit;
    private String exchangePositionId;
    @Transient
    private Long currentPrice;
    @Column(precision = 15, scale = 2)
    private BigDecimal exitPrice; // Added for trade

    @Column(nullable = false, precision = 5, scale = 2)
    private int leverage;

    @Column
    private String openedPositionId; // Added for exchange position tracking

    @Column
    private LocalDateTime entryTime; // Added for trade

    @Column
    private LocalDateTime exitTime; // Added for trade

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

    public Long getCurrentTargetPrice() {
        return currentTargetPrice;
    }

    public Position setCurrentTargetPrice(Long currentTargetPrice) {
        this.currentTargetPrice = currentTargetPrice;
        return this;
    }

    public Long getCurrentStopLoss() {
        return currentStopLoss;
    }

    public Position setCurrentStopLoss(Long currentStopLoss) {
        this.currentStopLoss = currentStopLoss;
        return this;
    }

    public Long getEntryPrice() {
        return entryPrice;
    }

    public Position setEntryPrice(Long entryPrice) {
        this.entryPrice = entryPrice;
        return this;
    }

    public Long getQuantity() {
        return quantity;
    }

    public Position setQuantity(Long quantity) {
        this.quantity = quantity;
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

    public Long getProfit() {
        return profit;
    }

    public Position setProfit(Long profit) {
        this.profit = profit;
        return this;
    }

    public String getExchangePositionId() {
        return exchangePositionId;
    }

    public Position setExchangePositionId(String exchangePositionId) {
        this.exchangePositionId = exchangePositionId;
        return this;
    }

    public Long getCurrentPrice() {
        return currentPrice;
    }

    public Position setCurrentPrice(Long currentPrice) {
        this.currentPrice = currentPrice;
        return this;
    }

    public BigDecimal getExitPrice() {
        return exitPrice;
    }

    public Position setExitPrice(BigDecimal exitPrice) {
        this.exitPrice = exitPrice;
        return this;
    }

    public int getLeverage() {
        return leverage;
    }

    public Position setLeverage(int leverage) {
        this.leverage = leverage;
        return this;
    }

    public String getOpenedPositionId() {
        return openedPositionId;
    }

    public Position setOpenedPositionId(String openedPositionId) {
        this.openedPositionId = openedPositionId;
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
}
