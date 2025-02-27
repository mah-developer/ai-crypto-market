package com.ai_crypto_market.core.model.entity;

import com.ai_crypto_market.core.model.enums.UserRole;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_USERS")
public class User extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_TB_USERS")
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Wallet> wallets;

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public User setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
        return this;
    }

    public UserRole getRole() {
        return role;
    }

    public User setRole(UserRole role) {
        this.role = role;
        return this;
    }

    public List<Wallet> getWallets() {
        return wallets;
    }

    public User setWallets(List<Wallet> wallets) {
        this.wallets = wallets;
        return this;
    }
}
