package com.ai_crypto_market.core.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity
@Table(name = "TB_WALLET", indexes = {
    @Index(name = "idx_fk_user", columnList = "FK_USER"),
    @Index(name = "idx_fk_exchange", columnList = "FK_EXCHANGE")
})
public class Wallet extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_TB_WALLET")
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_USER", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_EXCHANGE", nullable = false)
    private Exchange exchange;

    @Column(nullable = false, unique = true)
    private String apiKey;

    @Column(nullable = false)
    private String apiSecret; // Store securely

    // todo update this when strategy check rules and give us NONE action
    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal availableBalance;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal maxLeverage;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal maxPercentOfAvailablePerPosition;

    @Column(nullable = false)
    private boolean status; // if true we can trade and means wallet is on and if false means wallet is off and no any trade do on this wallet

    // GETTERS AND SETTERS


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Wallet setName(String name) {
        this.name = name;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Wallet setUser(User user) {
        this.user = user;
        return this;
    }

    public Exchange getExchange() {
        return exchange;
    }

    public Wallet setExchange(Exchange exchange) {
        this.exchange = exchange;
        return this;
    }

    public String getApiKey() {
        return apiKey;
    }

    public Wallet setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public Wallet setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
        return this;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public Wallet setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
        return this;
    }

    public BigDecimal getMaxLeverage() {
        return maxLeverage;
    }

    public Wallet setMaxLeverage(BigDecimal maxLeverage) {
        this.maxLeverage = maxLeverage;
        return this;
    }

    public BigDecimal getMaxPercentOfAvailablePerPosition() {
        return maxPercentOfAvailablePerPosition;
    }

    public Wallet setMaxPercentOfAvailablePerPosition(BigDecimal maxPercentOfAvailablePerPosition) {
        this.maxPercentOfAvailablePerPosition = maxPercentOfAvailablePerPosition;
        return this;
    }

    public boolean isStatus() {
        return status;
    }

    public Wallet setStatus(boolean status) {
        this.status = status;
        return this;
    }
}
