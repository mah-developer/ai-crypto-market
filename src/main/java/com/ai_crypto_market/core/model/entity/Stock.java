package com.ai_crypto_market.core.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_STOCK")
public class Stock extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_TB_STOCK")
    private Long id;

    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ExchangeStock> exchangeStocks = new HashSet<>();

    @OneToMany(mappedBy = "stock",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Position> positions = new HashSet<>();

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String symbol;

    @Transient
    private String rsi; // last 5 items based on timeFrame
    @Transient
    private String ma7;
    @Transient
    private String ma14;
    @Transient
    private String ma21;
    @Transient
    private String volume; // last 5 items based on timeFrame
    @Transient
    private String candle; // last 5 items based on timeFrame
    @Transient
    private int priceAction;
    @Transient
    private int aiNews;
    @Transient
    private int smartMoney;
    @Transient
    private BigDecimal currentPrice;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "FK_STRATEGY", nullable = false)
//    private Strategy strategy;

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Stock setName(String name) {
        this.name = name;
        return this;
    }

    public String getSymbol() {
        return symbol;
    }

    public Stock setSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public String getRsi() {
        return rsi;
    }

    public Stock setRsi(String rsi) {
        this.rsi = rsi;
        return this;
    }

    public String getMa7() {
        return ma7;
    }

    public Stock setMa7(String ma7) {
        this.ma7 = ma7;
        return this;
    }

    public String getMa14() {
        return ma14;
    }

    public Stock setMa14(String ma14) {
        this.ma14 = ma14;
        return this;
    }

    public String getMa21() {
        return ma21;
    }

    public Stock setMa21(String ma21) {
        this.ma21 = ma21;
        return this;
    }

    public String getVolume() {
        return volume;
    }

    public Stock setVolume(String volume) {
        this.volume = volume;
        return this;
    }

    public String getCandle() {
        return candle;
    }

    public Stock setCandle(String candle) {
        this.candle = candle;
        return this;
    }

    public int getPriceAction() {
        return priceAction;
    }

    public Stock setPriceAction(int priceAction) {
        this.priceAction = priceAction;
        return this;
    }

    public int getAiNews() {
        return aiNews;
    }

    public Stock setAiNews(int aiNews) {
        this.aiNews = aiNews;
        return this;
    }

    public int getSmartMoney() {
        return smartMoney;
    }

    public Stock setSmartMoney(int smartMoney) {
        this.smartMoney = smartMoney;
        return this;
    }

    public Set<ExchangeStock> getExchangeStocks() {
        return exchangeStocks;
    }

    public Stock setExchangeStocks(Set<ExchangeStock> exchangeStocks) {
        this.exchangeStocks = exchangeStocks;
        return this;
    }

    public Set<Position> getPositions() {
        return positions;
    }

    public Stock setPositions(Set<Position> positions) {
        this.positions = positions;
        return this;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public Stock setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
        return this;
    }
}
