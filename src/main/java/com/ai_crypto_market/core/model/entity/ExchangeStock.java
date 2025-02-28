package com.ai_crypto_market.core.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_EXCHANGE_STOCK")
public class ExchangeStock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // todo junction table

    private Double lot;
}
