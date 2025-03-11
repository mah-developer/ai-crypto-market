package com.ai_crypto_market.core.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "TB_WALLET_SETTINGS")
public class WalletSettings extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_TB_WALLET_SETTINGS")
    private Long id;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal maxLeverage;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal riskPerTrade;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal riskOnTotalBalance;

    @Column(nullable = false)
    private boolean walletIsOn; // if true we can trade and means wallet is on and if false means wallet is off and no any trade do on this wallet

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_WALLET", nullable = false)
    private Wallet wallet;

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public BigDecimal getMaxLeverage() {
        return maxLeverage;
    }

    public WalletSettings setMaxLeverage(BigDecimal maxLeverage) {
        this.maxLeverage = maxLeverage;
        return this;
    }

    public BigDecimal getRiskPerTrade() {
        return riskPerTrade;
    }

    public WalletSettings setRiskPerTrade(BigDecimal riskPerTrade) {
        this.riskPerTrade = riskPerTrade;
        return this;
    }

    public BigDecimal getRiskOnTotalBalance() {
        return riskOnTotalBalance;
    }

    public WalletSettings setRiskOnTotalBalance(BigDecimal riskOnTotalBalance) {
        this.riskOnTotalBalance = riskOnTotalBalance;
        return this;
    }

    public boolean isWalletIsOn() {
        return walletIsOn;
    }

    public WalletSettings setWalletIsOn(boolean walletIsOn) {
        this.walletIsOn = walletIsOn;
        return this;
    }
}
