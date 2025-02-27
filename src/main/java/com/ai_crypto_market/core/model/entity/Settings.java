package com.ai_crypto_market.core.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_SETTINGS")
public class Settings extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_TB_SETTINGS")
    private Long id;

    @Column(nullable = false)
    private Double leverage;

    @Column(nullable = false)
    private Double maxDrawdown;

    @Column(nullable = false)
    private Double riskPerTrade;

    @Column(nullable = false)
    private Double slippageTolerance;

    // GETTERS AND SETTERS


    public Long getId() {
        return id;
    }

    public Settings setId(Long id) {
        this.id = id;
        return this;
    }

    public Double getLeverage() {
        return leverage;
    }

    public Settings setLeverage(Double leverage) {
        this.leverage = leverage;
        return this;
    }

    public Double getMaxDrawdown() {
        return maxDrawdown;
    }

    public Settings setMaxDrawdown(Double maxDrawdown) {
        this.maxDrawdown = maxDrawdown;
        return this;
    }

    public Double getRiskPerTrade() {
        return riskPerTrade;
    }

    public Settings setRiskPerTrade(Double riskPerTrade) {
        this.riskPerTrade = riskPerTrade;
        return this;
    }

    public Double getSlippageTolerance() {
        return slippageTolerance;
    }

    public Settings setSlippageTolerance(Double slippageTolerance) {
        this.slippageTolerance = slippageTolerance;
        return this;
    }
}
