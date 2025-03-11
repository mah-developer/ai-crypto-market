package com.ai_crypto_market.core.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "TB_WALLET", indexes = {
    @Index(name = "idx_fk_user", columnList = "FK_USER"),
    @Index(name = "idx_fk_exchange", columnList = "FK_EXCHANGE")
})
public class Wallet extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_TB_WALLET")
    private Long id;
    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_USER", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_EXCHANGE", nullable = false)
    private Exchange exchange;

    @Column(nullable = false, unique = true)
    private String publicKey;
    @Column(nullable = false)
    private String encryptedPrivateKey; // Store securely

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal usdBalance;

    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<WalletSettings> walletSettings = new HashSet<>();

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
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


    public BigDecimal getUsdBalance() {
        return usdBalance;
    }

    public Wallet setUsdBalance(BigDecimal usdBalance) {
        this.usdBalance = usdBalance;
        return this;
    }

    public Set<WalletSettings> getWalletSettings() {
        return walletSettings;
    }

    public Wallet setWalletSettings(Set<WalletSettings> walletSettings) {
        this.walletSettings = walletSettings;
        return this;
    }
}
