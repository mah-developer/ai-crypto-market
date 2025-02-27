package com.ai_crypto_market.core.model.entity;

import jakarta.persistence.*;

@MappedSuperclass
public class Indicator extends AuditableEntity {
    @Column
    private String name;
    @Column
    private int accuracy;

    // GETTERS AND SETTERS

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


}
