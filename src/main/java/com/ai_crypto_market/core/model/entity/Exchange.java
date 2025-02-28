package com.ai_crypto_market.core.model.entity;

import com.ai_crypto_market.core.model.enums.MarketType;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_EXCHANGE")
public class Exchange extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_TB_EXCHANGE")
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String apiUrl;

    @OneToMany(mappedBy = "exchange", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Wallet> wallets;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MarketType marketType;

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Exchange setName(String name) {
        this.name = name;
        return this;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public Exchange setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
        return this;
    }

    public List<Wallet> getWallets() {
        return wallets;
    }

    public Exchange setWallets(List<Wallet> wallets) {
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
}
