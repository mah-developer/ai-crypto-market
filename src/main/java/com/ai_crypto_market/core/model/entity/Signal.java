package com.ai_crypto_market.core.model.entity;

import com.ai_crypto_market.core.model.enums.SignalType;
import com.ai_crypto_market.core.model.enums.TradeAction;
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
    private TradeAction tradeAction;

    @Column(nullable = false)
    private Double leverage;

    private SignalType type;

    private Double buyPercent;

    private Double sellPercent;


    // GETTERS AND SETTERS


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Double getStopLoss() {
        return stopLoss;
    }

    public void setStopLoss(Double stopLoss) {
        this.stopLoss = stopLoss;
    }

    public Double getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(Double targetPrice) {
        this.targetPrice = targetPrice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public TradeAction getTradeAction() {
        return tradeAction;
    }

    public void setTradeAction(TradeAction tradeAction) {
        this.tradeAction = tradeAction;
    }

    public Double getLeverage() {
        return leverage;
    }

    public void setLeverage(Double leverage) {
        this.leverage = leverage;
    }

    public SignalType getType() {
        return type;
    }

    public void setType(SignalType type) {
        this.type = type;
    }

    public Double getBuyPercent() {
        return buyPercent;
    }

    public void setBuyPercent(Double buyPercent) {
        this.buyPercent = buyPercent;
    }

    public Double getSellPercent() {
        return sellPercent;
    }

    public void setSellPercent(Double sellPercent) {
        this.sellPercent = sellPercent;
    }
}