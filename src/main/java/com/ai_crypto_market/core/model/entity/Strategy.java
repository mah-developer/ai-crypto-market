package com.ai_crypto_market.core.model.entity;

import com.ai_crypto_market.core.model.enums.StrategyType;
import com.ai_crypto_market.core.model.enums.TimeFrame;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TB_STRATEGY")
public class Strategy extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_TB_STRATEGY")
    private Long id;

//    @OneToMany(mappedBy = "strategy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<Stock> stocks = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private StrategyType type;

    @Column(precision = 5, scale = 2)
    private BigDecimal defaultStopLossPercent;

    @Column(precision = 5, scale = 2)
    private BigDecimal defaultTargetPercent;

    @Column(precision = 5, scale = 2)
    private BigDecimal defaultLeverage;

    @Enumerated(EnumType.STRING)
    private TimeFrame timeFrame;

    private String category;

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public Strategy setCategory(String category) {
        this.category = category;
        return this;
    }

    public StrategyType getType() {
        return type;
    }

    public Strategy setType(StrategyType type) {
        this.type = type;
        return this;
    }

    public BigDecimal getDefaultStopLossPercent() {
        return defaultStopLossPercent;
    }

    public Strategy setDefaultStopLossPercent(BigDecimal defaultStoplossPercent) {
        this.defaultStopLossPercent = defaultStoplossPercent;
        return this;
    }

    public BigDecimal getDefaultTargetPercent() {
        return defaultTargetPercent;
    }

    public Strategy setDefaultTargetPercent(BigDecimal defaultTargetPercent) {
        this.defaultTargetPercent = defaultTargetPercent;
        return this;
    }
    public TimeFrame getTimeFrame() {
        return timeFrame;
    }

    public Strategy setTimeFrame(TimeFrame timeFrame) {
        this.timeFrame = timeFrame;
        return this;
    }

    public BigDecimal getDefaultLeverage() {
        return defaultLeverage;
    }

    public Strategy setDefaultLeverage(BigDecimal defaultLeverage) {
        this.defaultLeverage = defaultLeverage;
        return this;
    }


}