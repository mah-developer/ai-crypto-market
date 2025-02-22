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


}
