package com.ai_crypto_market.core.model.entity;

import com.ai_crypto_market.core.model.enums.StrategyType;
import com.ai_crypto_market.core.model.enums.TimeFrame;
import com.ai_crypto_market.core.model.enums.TradeAction;
import com.ai_crypto_market.core.model.enums.PositionStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_TRADE")
public class Strategy extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_TB_TRADE")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_STOCK", nullable = false)
    private Stock stock;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TradeAction tradeAction;

    @Enumerated(EnumType.STRING)
    private StrategyType type;

    @Column(precision = 5, scale = 2)
    private BigDecimal buyPercent;

    @Column(precision = 5, scale = 2)
    private BigDecimal sellPercent;

    @Enumerated(EnumType.STRING)
    private TimeFrame timeFrame;

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public Stock getStock() {
        return stock;
    }

    public Strategy setStock(Stock stock) {
        this.stock = stock;
        return this;
    }

    public TradeAction getTradeAction() {
        return tradeAction;
    }

    public Strategy setTradeAction(TradeAction tradeAction) {
        this.tradeAction = tradeAction;
        return this;
    }

    public StrategyType getType() {
        return type;
    }

    public Strategy setType(StrategyType type) {
        this.type = type;
        return this;
    }

    public BigDecimal getBuyPercent() {
        return buyPercent;
    }

    public Strategy setBuyPercent(BigDecimal buyPercent) {
        this.buyPercent = buyPercent;
        return this;
    }

    public BigDecimal getSellPercent() {
        return sellPercent;
    }

    public Strategy setSellPercent(BigDecimal sellPercent) {
        this.sellPercent = sellPercent;
        return this;
    }
}