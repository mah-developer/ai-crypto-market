package com.ai_crypto_market.core.model.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Strategy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private int buyPercent;
    @Column
    private int sellPercent;

    public Long getId() {
        return id;
    }
    public Strategy setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }
    public Strategy setName(String name) {
        this.name = name;
        return this;
    }

    public int getBuyPercent() {
        return buyPercent;
    }

    public Strategy setBuyPercent(int buyPercent) {
        this.buyPercent = buyPercent;
        return this;
    }

    public int getSellPercent() {
        return sellPercent;
    }

    public Strategy setSellPercent(int sellPercent) {
        this.sellPercent = sellPercent;
        return this;
    }

}
