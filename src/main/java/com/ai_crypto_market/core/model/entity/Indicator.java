package com.ai_crypto_market.core.model.entity;

import jakarta.persistence.*;

@Entity
public class Indicator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private int accuracy;
    @Column
    private int buyPercent;
    @Column
    private int sellPercent;

    public Long getId() {
        return id;
    }

    public Indicator setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Indicator setName(String name) {
        this.name = name;
        return this;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public Indicator setAccuracy(int accuracy) {
        this.accuracy = accuracy;
        return this;
    }

    public int getBuyPercent() {
        return buyPercent;
    }

    public Indicator setBuyPercent(int buyPercent) {
        this.buyPercent = buyPercent;
        return this;
    }

    public int getSellPercent() {
        return sellPercent;
    }

    public Indicator setSellPercent(int sellPercent) {
        this.sellPercent = sellPercent;
        return this;
    }
}
