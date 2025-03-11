package com.ai_crypto_market.core.model.entity;

import com.ai_crypto_market.core.model.enums.NewsImpact;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_NEWS")
public class News extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_TB_NEWS")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDateTime publishTime;
    @Column(nullable = false)
    private String source;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NewsImpact impact;

    @Column(length = 1000)
    private String description;

    private String effects;// it is the real output effect on market

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public News setTitle(String title) {
        this.title = title;
        return this;
    }

    public LocalDateTime getPublishTime() {
        return publishTime;
    }

    public News setPublishTime(LocalDateTime publishTime) {
        this.publishTime = publishTime;
        return this;
    }

    public String getSource() {
        return source;
    }

    public News setSource(String source) {
        this.source = source;
        return this;
    }

    public NewsImpact getImpact() {
        return impact;
    }

    public News setImpact(NewsImpact impact) {
        this.impact = impact;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public News setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getEffects() {
        return effects;
    }

    public News setEffects(String effects) {
        this.effects = effects;
        return this;
    }
}