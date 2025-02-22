package com.ai_crypto_market.core.model.entity;

import jakarta.persistence.*;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Float price;
    @Column
    private Float stopLossPrice;
    @Column
    private Float targetPrice;
    @Column
    private Float percentBalance;
    // and others

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_Stock")
    public Stock stoke;

    public Long getId() {
        return id;
    }
    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public Float getPrice() {return price;}
    public Order setPrice(Float price) {
        this.price = price;
        return this;
    }

    public Float getStopLossPrice() {return stopLossPrice;}
    public Order setStopLossPrice(Float stopLossPrice) {
        this.stopLossPrice = stopLossPrice;
        return this;
    }

    public Float getTargetPrice() {return targetPrice;}
    public Order setTargetPrice(Float targetPrice) {
        this.targetPrice = targetPrice;
        return this;
    }

    public Float getPercentBalance() {return percentBalance;}
    public Order setPercentBalance(Float percentBalance) {
        this.percentBalance = percentBalance;
        return this;
    }

    public Stock getStock() {return stoke;}
    public Order setStock(Stock stoke) {
        this.stoke = stoke;
        return this;
    }



}
