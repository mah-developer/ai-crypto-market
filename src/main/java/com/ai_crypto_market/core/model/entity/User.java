package com.ai_crypto_market.core.model.entity;

import com.ai_crypto_market.core.model.enums.UserRole;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_USER", indexes = {@Index(name = "idx_email", columnList = "email")})
public class User extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_TB_USER")
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String firstName;

    @Column(nullable = false, unique = true, length = 50)
    private String lastName;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 255)
    private String passwordHash;



    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Wallet> wallets = new ArrayList<>();

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
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

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }
}
