package com.ai_crypto_market.core.model.entity;

import com.ai_crypto_market.core.model.enums.ChangeType;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_EXCHANGE_STOCK")
public class ExchangeStock extends AuditableEntity {
    @EmbeddedId
    private ExchangeStockId id = new ExchangeStockId();

    @ManyToOne
    @MapsId("exchangeId")
    @JoinColumn(name = "exchange_id", nullable = false)
    private Exchange exchange;

    @ManyToOne
    @MapsId("stockId")
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;

    @OneToMany(mappedBy = "exchangeStock", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExchangeStockHistory> history;

    private Double lot;

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


}
