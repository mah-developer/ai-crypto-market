package com.ai_crypto_market.core.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_WALLET_SETTINGS")
public class WalletSettings extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_TB_WALLET_SETTINGS")
    private Long id;

    @Column(nullable = false)
    private Double maxLeverage;

    @Column(nullable = false)
    private Double riskPerTrade;

    @Column(nullable = false)
    private Double riskOnTotalBalance;

    private boolean walletIsOn; // if true we can trade and means wallet is on and if false means wallet is off and no any trade do on this wallet

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn()
    private Wallet wallet;

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public Double getMaxLeverage() {
        return maxLeverage;
    }

    public WalletSettings setMaxLeverage(Double maxLeverage) {
        this.maxLeverage = maxLeverage;
        return this;
    }

    public Double getRiskPerTrade() {
        return riskPerTrade;
    }

    public WalletSettings setRiskPerTrade(Double riskPerTrade) {
        this.riskPerTrade = riskPerTrade;
        return this;
    }

    public Double getRiskOnTotalBalance() {
        return riskOnTotalBalance;
    }

    public WalletSettings setRiskOnTotalBalance(Double riskOnTotalBalance) {
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
