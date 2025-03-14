package com.ai_crypto_market.core.model.entity;

import com.ai_crypto_market.core.model.enums.PositionStatus;
import com.ai_crypto_market.core.model.enums.PositionType;

public class Position {
    private Long id;
    private Strategy strategy;
    private Wallet wallet;
    private Long currentTargetPrice;
    private Long currentStopLoss;
    private Long entryPrice;
    private Long quantity;
    private PositionStatus positionStatus;
    private PositionType positionType;
    private Long profit;
    private String exchangePositionId;
    private Long currentPrice;

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

    public PositionStatus getTradeStatus() {
        return positionStatus;
    }

    public Position setTradeStatus(PositionStatus positionStatus) {
        this.positionStatus = positionStatus;
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
}
