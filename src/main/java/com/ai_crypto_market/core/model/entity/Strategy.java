package com.ai_crypto_market.core.model.entity;

import com.ai_crypto_market.core.model.enums.StrategyType;
import com.ai_crypto_market.core.model.enums.TimeFrame;
import com.ai_crypto_market.core.model.enums.TradeAction;
import com.ai_crypto_market.core.model.enums.PositionStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_TRADE")
public class Strategy extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_TB_TRADE")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_STOCK", nullable = false)
    private Stock stock;

    @Column(nullable = false)
    private TimeFrame timeFrame;

    @Column(nullable = false, precision = 15, scale = 2)
    private float stopLoss;

    @Column(nullable = false, precision = 15, scale = 2)
    private float targetPrice;

    @Column(nullable = false, precision = 15, scale = 2)
    private float entryPrice; // Entry price

    @Column(precision = 15, scale = 2)
    private float exitPrice; // Added for trade

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TradeAction tradeAction;

    @Column(nullable = false, precision = 5, scale = 2)
    private int leverage;

    @Enumerated(EnumType.STRING)
    private StrategyType type;

    @Column(precision = 5, scale = 2)
    private float buyPercent;

    @Column(precision = 5, scale = 2)
    private float sellPercent;

    @Column
    private String positionId; // Added for exchange position tracking

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_WALLET")
    private Wallet wallet; // Added for trade context

    @Column(precision = 15, scale = 2)
    private float quantity; // Added for trade

    @Enumerated(EnumType.STRING)
    private PositionStatus status; // Added for trade (e.g., PENDING, OPEN, CLOSED)

    @Column
    private LocalDateTime entryTime; // Added for trade

    @Column
    private LocalDateTime exitTime; // Added for trade

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public float getStopLoss() {
        return stopLoss;
    }

    public void setStopLoss(float stopLoss) {
        this.stopLoss = stopLoss;
    }

    public float getTargetPrice() {return targetPrice;}

    public void setTargetPrice(float targetPrice) {
        this.targetPrice = targetPrice;
    }

    public float getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(float price) {
        this.entryPrice = price;
    }

    public TradeAction getTradeAction() {
        return tradeAction;
    }

    public void setTradeAction(TradeAction tradeAction) {
        this.tradeAction = tradeAction;
    }

    public int getLeverage() {
        return leverage;
    }

    public void setLeverage(int leverage) {
        this.leverage = leverage;
    }

    public StrategyType getType() {
        return type;
    }

    public void setType(StrategyType type) {
        this.type = type;
    }

    public float getBuyPercent() {
        return buyPercent;
    }

    public void setBuyPercent(float buyPercent) {
        this.buyPercent = buyPercent;
    }

    public float getSellPercent() {
        return sellPercent;
    }

    public void setSellPercent(float sellPercent) {
        this.sellPercent = sellPercent;
    }

    public String getPositionId() {
        return positionId;
    }

    public Strategy setPositionId(String positionId) {
        this.positionId = positionId;
        return this;
    }

    public float getExitPrice() {
        return exitPrice;
    }

    public Strategy setExitPrice(float exitPrice) {
        this.exitPrice = exitPrice;
        return this;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public Strategy setWallet(Wallet wallet) {
        this.wallet = wallet;
        return this;
    }

    public float getQuantity() {
        return quantity;
    }

    public Strategy setQuantity(float quantity) {
        this.quantity = quantity;
        return this;
    }

    public PositionStatus getStatus() {
        return status;
    }

    public Strategy setStatus(PositionStatus status) {
        this.status = status;
        return this;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public Strategy setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
        return this;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public Strategy setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
        return this;
    }
    public TimeFrame getTimeFrame() {
        return timeFrame;
    }

    public Strategy setTimeFrame(TimeFrame timeFrame) {
        this.timeFrame = timeFrame;
        return this;
    }
}