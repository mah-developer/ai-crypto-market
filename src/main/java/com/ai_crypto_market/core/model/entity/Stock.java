package com.ai_crypto_market.core.model.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TB_STOCK")
public class Stock extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_TB_STOCK")
    private Long id;

    @Column(nullable = false)
    private String name; // Example: Bitcoin

    @Column(nullable = false, unique = true)
    private String symbol; // Example: BTC/USDT

    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Signal> signals = new HashSet<>();

    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ExchangeStock> exchangeStocks = new HashSet<>();

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
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

    public Set<Signal> getSignals() {
        return signals;
    }

    public Stock setSignals(Set<Signal> signals) {
        this.signals = signals;
        return this;
    }

    public Set<ExchangeStock> getExchangeStocks() {
        return exchangeStocks;
    }

    public Stock setExchangeStocks(Set<ExchangeStock> exchangeStocks) {
        this.exchangeStocks = exchangeStocks;
        return this;
    }
}
