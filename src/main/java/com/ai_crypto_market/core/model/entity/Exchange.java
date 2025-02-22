package com.ai_crypto_market.core.model.entity;

import jakarta.persistence.*;

@Entity
public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;


    public Long getId() {
        return id;
    }
    public Exchange setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }
    public Exchange setName(String name) {
        this.name = name;
        return this;
    }

}
