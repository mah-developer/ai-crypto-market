package com.ai_crypto_market.core.model.entity;

import com.ai_crypto_market.core.model.enums.Exchanges;
import com.ai_crypto_market.core.model.enums.MarketType;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "EXCHANGE", indexes = {
    @Index(name = "idx_name", columnList = "name"),
    @Index(name = "idx_api_url", columnList = "api_url")
})
public class Exchange extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_TB_EXCHANGE")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Exchanges exchangeName;

    @Column(nullable = false)
    private String baseApiUrl;

    @OneToMany(mappedBy = "exchange", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Wallet> wallets = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MarketType marketType;

    @OneToMany(mappedBy = "exchange", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ExchangeStock> exchangeStocks = new HashSet<>();

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public Exchanges getExchangeName() {
        return exchangeName;
    }

    public Exchange setExchangeName(Exchanges exchangeName) {
        this.exchangeName = exchangeName;
        return this;
    }

    public String getBaseApiUrl() {
        return baseApiUrl;
    }

    public Exchange setBaseApiUrl(String baseApiUrl) {
        this.baseApiUrl = baseApiUrl;
        return this;
    }

    public Set<Wallet> getWallets() {
        return wallets;
    }

    public Exchange setWallets(Set<Wallet> wallets) {
        this.wallets = wallets;
        return this;
    }

    public MarketType getExchangeType() {
        return marketType;
    }

    public Exchange setExchangeType(MarketType marketType) {
        this.marketType = marketType;
        return this;
    }

    public MarketType getMarketType() {
        return marketType;
    }

    public Exchange setMarketType(MarketType marketType) {
        this.marketType = marketType;
        return this;
    }

    public Set<ExchangeStock> getExchangeStocks() {
        return exchangeStocks;
    }

    public Exchange setExchangeStocks(Set<ExchangeStock> exchangeStocks) {
        this.exchangeStocks = exchangeStocks;
        return this;
    }
}
