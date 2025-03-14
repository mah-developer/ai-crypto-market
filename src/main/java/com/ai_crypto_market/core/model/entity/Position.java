package com.ai_crypto_market.core.model.entity;

import com.ai_crypto_market.core.model.enums.PositionStatus;
import com.ai_crypto_market.core.model.enums.PositionType;

public class Position {
    private Long id;
    private Strategy strategy;
    private Wallet wallet;
    private float currentTargetPrice;
    private float currentStopLoss;
    private float entryPrice;
    private float quantity;
    private PositionStatus positionStatus;
    private PositionType positionType;
    private float profit;
    private String exchangePositionId;
    private float currentPrice;

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

    public float getCurrentTargetPrice() {
        return currentTargetPrice;
    }

    public Position setCurrentTargetPrice(float currentTargetPrice) {
        this.currentTargetPrice = currentTargetPrice;
        return this;
    }

    public float getCurrentStopLoss() {
        return currentStopLoss;
    }

    public Position setCurrentStopLoss(float currentStopLoss) {
        this.currentStopLoss = currentStopLoss;
        return this;
    }

    public float getEntryPrice() {
        return entryPrice;
    }

    public Position setEntryPrice(float entryPrice) {
        this.entryPrice = entryPrice;
        return this;
    }

    public float getQuantity() {
        return quantity;
    }

    public Position setQuantity(float quantity) {
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

    public float getProfit() {
        return profit;
    }

    public Position setProfit(float profit) {
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

    public float getCurrentPrice() {
        return currentPrice;
    }

    public Position setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
        return this;
    }
}
