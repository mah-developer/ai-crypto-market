package com.ai_crypto_market.core.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_STOCK_HISTORY")
public class StockHistory extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_TB_STOCK_HISTORY")
    private long id;

    @ManyToOne
    @JoinColumn(name = "FK_TB_STOCK", nullable = false)
    private Stock stock;

    @Column(nullable = false)
    private Double openPrice;

    @Column(nullable = false)
    private Double closePrice;

    @Column(nullable = false)
    private Double high;

    @Column(nullable = false)
    private Double low;

    @Column(nullable = false)
    private LocalDateTime time;

    // GETTERS AND SETTERS

    public long getId() {
        return id;
    }

    public StockHistory setId(long id) {
        this.id = id;
        return this;
    }

    public Stock getStock() {
        return stock;
    }

    public StockHistory setStock(Stock stock) {
        this.stock = stock;
        return this;
    }

    public Double getOpenPrice() {
        return openPrice;
    }

    public StockHistory setOpenPrice(Double openPrice) {
        this.openPrice = openPrice;
        return this;
    }

    public Double getClosePrice() {
        return closePrice;
    }

    public StockHistory setClosePrice(Double closePrice) {
        this.closePrice = closePrice;
        return this;
    }

    public Double getHigh() {
        return high;
    }

    public StockHistory setHigh(Double high) {
        this.high = high;
        return this;
    }

    public Double getLow() {
        return low;
    }

    public StockHistory setLow(Double low) {
        this.low = low;
        return this;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public StockHistory setTime(LocalDateTime time) {
        this.time = time;
        return this;
    }
}
