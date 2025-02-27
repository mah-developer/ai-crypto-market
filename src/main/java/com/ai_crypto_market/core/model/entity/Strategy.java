package com.ai_crypto_market.core.model.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TB_STRATEGY")
public class Strategy extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_TB_STRATEGY")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FK_TB_STOCK", nullable = false)
    private Stock stock;

    @Column(nullable = false)
    private Double buyPercent;

    @Column(nullable = false)
    private Double sellPercent;

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public Strategy setId(Long id) {
        this.id = id;
        return this;
    }

    public Stock getStock() {
        return stock;
    }

    public Strategy setStock(Stock stock) {
        this.stock = stock;
        return this;
    }

    public Double getBuyPercent() {
        return buyPercent;
    }

    public Strategy setBuyPercent(Double buyPercent) {
        this.buyPercent = buyPercent;
        return this;
    }

    public Double getSellPercent() {
        return sellPercent;
    }

    public Strategy setSellPercent(Double sellPercent) {
        this.sellPercent = sellPercent;
        return this;
    }
}
