package com.ai_crypto_market.core.model.entity;

import jakarta.persistence.*;


@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String apiKey;
    @Column
    private String apiSecret;
    //@Column
    //private float usdtBalance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_EXCHANGE")
    public Exchange exchange;

}
