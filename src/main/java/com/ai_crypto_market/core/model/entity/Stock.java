package com.ai_crypto_market.core.model.entity;

public class Stock {
    private Long id;
    private String name;

    public String getName() {
        return name;
    }

    public Stock setName(String name) {
        this.name = name;
        return this;
    }
}
