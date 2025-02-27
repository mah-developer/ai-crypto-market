package com.ai_crypto_market.core.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_INDICATOR_RSI")
public class IndicatorRSI extends Indicator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_TB_INDICATOR_RSI")
    private Long id;
    private float rsiVal;
    private float rsiMA;

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public IndicatorRSI setId(Long id) {
        this.id = id;
        return this;
    }

    public float getRsiVal() {return rsiVal;}
    public IndicatorRSI setRsiVal(float rsiVal) {
        this.rsiVal = rsiVal;
        return this;
    }

    public float getRsiMA() {return rsiMA;}
    public IndicatorRSI setRsiMA(float rsiMA) {
        this.rsiMA = rsiMA;
        return this;
    }
}
