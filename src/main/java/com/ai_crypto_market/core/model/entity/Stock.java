package com.ai_crypto_market.core.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_STOCK")
public class Stock extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_TB_STOCK")
    private Long id;

    @Column(nullable = false, unique = true)
    private String name; // Example: Bitcoin

    @Column(nullable = false, unique = true)
    private String symbol; // Example: BTC/USDT

    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Signal> signals;


    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public Stock setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Stock setName(String name) {
        this.name = name;
        return this;
    }

    public String getSymbol() {
        return symbol;
    }

    public Stock setSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public List<Signal> getTrades() {
        return signals;
    }

    public Stock setTrades(List<Signal> signals) {
        this.signals = signals;
        return this;
    }

}
