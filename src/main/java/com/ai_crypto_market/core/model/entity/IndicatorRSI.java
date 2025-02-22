package com.ai_crypto_market.core.model.entity;

import jakarta.persistence.*;

@Entity
public class IndicatorRSI extends Indicator {
    @Column
    private float rsiVal;
    @Column
    private float rsiMA;

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
