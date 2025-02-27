package com.ai_crypto_market.core.model.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "TB_WALLET")
public class Wallet extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_TB_WALLET")
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "FK_TB_USERS", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "FK_TB_EXCHANGE", nullable = false)
    private Exchange exchange;

    @Column(nullable = false, unique = true)
    private String publicKey;
    @Column(nullable = false)
    private String encryptedPrivateKey; // Store securely

    @Column(nullable = false)
    private Double usdBalance;

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public Wallet setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Wallet setName(String name) {
        this.name = name;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Wallet setUser(User user) {
        this.user = user;
        return this;
    }

    public Exchange getExchange() {
        return exchange;
    }

    public Wallet setExchange(Exchange exchange) {
        this.exchange = exchange;
        return this;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public Wallet setPublicKey(String publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    public String getEncryptedPrivateKey() {
        return encryptedPrivateKey;
    }

    public Wallet setEncryptedPrivateKey(String encryptedPrivateKey) {
        this.encryptedPrivateKey = encryptedPrivateKey;
        return this;
    }

    public Double getUsdBalance() {
        return usdBalance;
    }

    public Wallet setUsdBalance(Double usdBalance) {
        this.usdBalance = usdBalance;
        return this;
    }
}
