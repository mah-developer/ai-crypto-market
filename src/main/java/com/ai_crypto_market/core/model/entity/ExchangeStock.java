package com.ai_crypto_market.core.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_EXCHANGE_STOCK", indexes = {
    @Index(name = "idx_exchange_stock", columnList = "exchange_id, stock_id")
})
public class ExchangeStock extends AuditableEntity {
    @EmbeddedId
    private ExchangeStockId id = new ExchangeStockId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("exchangeId")
    @JoinColumn(name = "exchange_id", nullable = false)
    private Exchange exchange;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("stockId")
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;

    @OneToMany(mappedBy = "exchangeStock", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExchangeStockHistory> history = new ArrayList<>();

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal lot;


    public ExchangeStock() {}

    public ExchangeStock(Exchange exchange, Stock stock) {
        this.id = new ExchangeStockId(exchange.getId(), stock.getId());
        this.exchange = exchange;
        this.stock = stock;
    }

//
//
//    @PrePersist
//    public void logInsert() {
//        ExchangeStockHistory historyEntry = new ExchangeStockHistory(this, ChangeType.INSERT, null, null, null, null, null, null, null);
//        history.add(historyEntry);
//    }
//
//    @PreUpdate
//    public void logUpdate() {
//        ExchangeStockHistory historyEntry = new ExchangeStockHistory(this, ChangeType.UPDATE, id.getExchangeId(), id.getStockId(), null, null, null, null, null);
//        history.add(historyEntry);
//    }
//
//    @PreRemove
//    public void logDelete() {
//        ExchangeStockHistory historyEntry = new ExchangeStockHistory(this, ChangeType.DELETE, id.getExchangeId(), id.getStockId(), null, null, null, null, null);
//        history.add(historyEntry);
//    }


    public ExchangeStockId getId() {
        return id;
    }

    public Exchange getExchange() {
        return exchange;
    }

    public ExchangeStock setExchange(Exchange exchange) {
        this.exchange = exchange;
        return this;
    }

    public Stock getStock() {
        return stock;
    }

    public ExchangeStock setStock(Stock stock) {
        this.stock = stock;
        return this;
    }

    public List<ExchangeStockHistory> getHistory() {
        return history;
    }

    public ExchangeStock setHistory(List<ExchangeStockHistory> history) {
        this.history = history;
        return this;
    }

    public BigDecimal getLot() {
        return lot;
    }

    public ExchangeStock setLot(BigDecimal lot) {
        this.lot = lot;
        return this;
    }
}
