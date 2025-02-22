package com.ai_crypto_market.core.model.entity;

import jakarta.persistence.Column;

public class IndicatorIchimoku extends Indicator {
    @Column
    private float conversionLine;
    @Column
    private float baseLine;
    @Column
    private float loggingSpan;
    @Column
    private float LeadingSpanA;
    @Column
    private float LeadingSpanB;
    @Column
    private float kumoUpper;
    @Column
    private float kumoLower;

    public float getConversionLine() {return conversionLine;}
    public IndicatorIchimoku setConversionLine(float conversionLine) {
        this.conversionLine = conversionLine;
        return this;
    }

    public float getBaseLine() {return baseLine;}
    public IndicatorIchimoku setBaseLine(float baseLine) {
        this.baseLine = baseLine;
        return this;
    }

    public float getLoggingSpan() {return loggingSpan;}
    public IndicatorIchimoku setLoggingSpan(float loggingSpan) {
        this.loggingSpan = loggingSpan;
        return this;
    }

    public float getLeadingSpanA() {return LeadingSpanA;}
    public IndicatorIchimoku setLeadingSpanA(float leadingSpanA) {
        this.LeadingSpanA = leadingSpanA;
        return this;
    }

    public float getLeadingSpanB() {return LeadingSpanB;}
    public IndicatorIchimoku setLeadingSpanB(float leadingSpanB) {
        this.LeadingSpanB = leadingSpanB;
        return this;
    }

    public float getKumoUpper() {return kumoUpper;}
    public IndicatorIchimoku setKumoUpper(float kumoUpper) {
        this.kumoUpper = kumoUpper;
        return this;
    }

    public float getKumoLower() {return kumoLower;}
    public IndicatorIchimoku setKumoLower(float kumoLower) {
        this.kumoLower = kumoLower;
        return this;
    }



}
