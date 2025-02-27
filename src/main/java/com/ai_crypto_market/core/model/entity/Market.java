package com.ai_crypto_market.core.model.entity;

import jakarta.persistence.*;

import java.security.Timestamp;

@Entity
@Table(name = "TB_MARKET")
public class Market extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_TB_MARKET")
    private Long id;

    private Long high;
    private Long low;
    private Long volume;
    private Long open;
    private Long close;
    private Timestamp times;
    private String stockName;

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public Market setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getHigh() {
        return high;
    }

    public Market setHigh(Long high) {
        this.high = high;
        return this;
    }

    public Long getLow() {
        return low;
    }

    public Market setLow(Long low) {
        this.low = low;
        return this;
    }

    public Long getVolume() {
        return volume;
    }

    public Market setVolume(Long volume) {
        this.volume = volume;
        return this;
    }

    public Long getOpen() {
        return open;
    }

    public Market setOpen(Long open) {
        this.open = open;
        return this;
    }

    public Long getClose() {
        return close;
    }

    public Market setClose(Long close) {
        this.close = close;
        return this;
    }

    public Timestamp getTimes() {
        return times;
    }

    public Market setTimes(Timestamp times) {
        this.times = times;
        return this;
    }

    public String getStockName() {
        return stockName;
    }

    public Market setStockName(String stockName) {
        this.stockName = stockName;
        return this;
    }

}
