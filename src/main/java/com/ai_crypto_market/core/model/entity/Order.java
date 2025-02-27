package com.ai_crypto_market.core.model.entity;

import com.ai_crypto_market.core.model.enums.PositionType;
import com.ai_crypto_market.core.model.enums.TradeStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "TB_ORDER")
public class Order extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_TB_ORDER")
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
    private PositionType positionType; // BUY, SELL, SHORT, LONG

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TradeStatus status = TradeStatus.PENDING;

    // GETTERS AND SETTERS


    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public Stock getStock() {
        return stock;
    }

    public Order setStock(Stock stock) {
        this.stock = stock;
        return this;
    }

    public Double getStopLoss() {
        return stopLoss;
    }

    public Order setStopLoss(Double stopLoss) {
        this.stopLoss = stopLoss;
        return this;
    }

    public Double getTargetPrice() {
        return targetPrice;
    }

    public Order setTargetPrice(Double targetPrice) {
        this.targetPrice = targetPrice;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Order setPrice(Double price) {
        this.price = price;
        return this;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public Order setPositionType(PositionType positionType) {
        this.positionType = positionType;
        return this;
    }

    public TradeStatus getStatus() {
        return status;
    }

    public Order setStatus(TradeStatus status) {
        this.status = status;
        return this;
    }
}
