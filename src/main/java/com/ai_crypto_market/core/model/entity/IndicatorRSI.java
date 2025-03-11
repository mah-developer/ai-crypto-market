package com.ai_crypto_market.core.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_INDICATOR_RSI")
public class IndicatorRSI extends Indicator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_TB_INDICATOR_RSI")
    private Long id;

    @Column(nullable = false)
    private float rsiVal;
    @Column(nullable = false)
    private float rsiMA;

    // todo review this relation
/*    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "exchange_id", referencedColumnName = "exchange_id", nullable = false),
            @JoinColumn(name = "stock_id", referencedColumnName = "stock_id", nullable = false)
    })
    private ExchangeStock exchangeStock;*/

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
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
