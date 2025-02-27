package com.ai_crypto_market.core.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_INDICATOR_ICHIMOKU")
public class IndicatorIchimoku extends Indicator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_TB_INDICATOR_ICHIMOKU")
    private Long id;
    private float conversionLine;
    private float baseLine;
    private float loggingSpan;
    private float leadingSpanA;
    private float leadingSpanB;
    private float kumoUpper;
    private float kumoLower;

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public IndicatorIchimoku setId(Long id) {
        this.id = id;
        return this;
    }

    public float getConversionLine() {
        return conversionLine;
    }

    public IndicatorIchimoku setConversionLine(float conversionLine) {
        this.conversionLine = conversionLine;
        return this;
    }

    public float getBaseLine() {
        return baseLine;
    }

    public IndicatorIchimoku setBaseLine(float baseLine) {
        this.baseLine = baseLine;
        return this;
    }

    public float getLoggingSpan() {
        return loggingSpan;
    }

    public IndicatorIchimoku setLoggingSpan(float loggingSpan) {
        this.loggingSpan = loggingSpan;
        return this;
    }

    public float getLeadingSpanA() {
        return leadingSpanA;
    }

    public IndicatorIchimoku setLeadingSpanA(float leadingSpanA) {
        this.leadingSpanA = leadingSpanA;
        return this;
    }

    public float getLeadingSpanB() {
        return leadingSpanB;
    }

    public IndicatorIchimoku setLeadingSpanB(float leadingSpanB) {
        this.leadingSpanB = leadingSpanB;
        return this;
    }

    public float getKumoUpper() {
        return kumoUpper;
    }

    public IndicatorIchimoku setKumoUpper(float kumoUpper) {
        this.kumoUpper = kumoUpper;
        return this;
    }

    public float getKumoLower() {
        return kumoLower;
    }

    public IndicatorIchimoku setKumoLower(float kumoLower) {
        this.kumoLower = kumoLower;
        return this;
    }
}
