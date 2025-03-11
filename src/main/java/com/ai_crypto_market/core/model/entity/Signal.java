package com.ai_crypto_market.core.model.entity;

import com.ai_crypto_market.core.model.enums.SignalType;
import com.ai_crypto_market.core.model.enums.TradeAction;
import com.ai_crypto_market.core.model.enums.TradeStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_TRADE")
public class Signal extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_TB_TRADE")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_STOCK", nullable = false)
    private Stock stock;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal stopLoss;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal targetPrice;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal entryPrice; // Entry price

    @Column(precision = 15, scale = 2)
    private BigDecimal exitPrice; // Added for trade

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TradeAction tradeAction;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal leverage;

    @Enumerated(EnumType.STRING)
    private SignalType type;

    @Column(precision = 5, scale = 2)
    private BigDecimal buyPercent;

    @Column(precision = 5, scale = 2)
    private BigDecimal sellPercent;

    @Column
    private String positionId; // Added for exchange position tracking

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_WALLET")
    private Wallet wallet; // Added for trade context

    @Column(precision = 15, scale = 2)
    private BigDecimal quantity; // Added for trade

    @Enumerated(EnumType.STRING)
    private TradeStatus status; // Added for trade (e.g., PENDING, OPEN, CLOSED)

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

    public BigDecimal getStopLoss() {
        return stopLoss;
    }

    public void setStopLoss(BigDecimal stopLoss) {
        this.stopLoss = stopLoss;
    }

    public BigDecimal getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(BigDecimal targetPrice) {
        this.targetPrice = targetPrice;
    }

    public BigDecimal getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(BigDecimal price) {
        this.entryPrice = price;
    }

    public TradeAction getTradeAction() {
        return tradeAction;
    }

    public void setTradeAction(TradeAction tradeAction) {
        this.tradeAction = tradeAction;
    }

    public BigDecimal getLeverage() {
        return leverage;
    }

    public void setLeverage(BigDecimal leverage) {
        this.leverage = leverage;
    }

    public SignalType getType() {
        return type;
    }

    public void setType(SignalType type) {
        this.type = type;
    }

    public BigDecimal getBuyPercent() {
        return buyPercent;
    }

    public void setBuyPercent(BigDecimal buyPercent) {
        this.buyPercent = buyPercent;
    }

    public BigDecimal getSellPercent() {
        return sellPercent;
    }

    public void setSellPercent(BigDecimal sellPercent) {
        this.sellPercent = sellPercent;
    }

    public String getPositionId() {
        return positionId;
    }

    public Signal setPositionId(String positionId) {
        this.positionId = positionId;
        return this;
    }

    public BigDecimal getExitPrice() {
        return exitPrice;
    }

    public Signal setExitPrice(BigDecimal exitPrice) {
        this.exitPrice = exitPrice;
        return this;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public Signal setWallet(Wallet wallet) {
        this.wallet = wallet;
        return this;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public Signal setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
        return this;
    }

    public TradeStatus getStatus() {
        return status;
    }

    public Signal setStatus(TradeStatus status) {
        this.status = status;
        return this;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public Signal setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
        return this;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public Signal setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
        return this;
    }
}