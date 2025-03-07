package com.ai_crypto_market.core.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_NEWS")
public class News extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_TB_NEWS")
    private Long id;

    @Column(nullable = false)
    private String source;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double sentimentScore; // AI-driven sentiment analysis

    private String author;
    private String tags;
    private String effects;// it is the real output effect on market

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public News setId(Long id) {
        this.id = id;
        return this;
    }

    public String getSource() {
        return source;
    }

    public News setSource(String source) {
        this.source = source;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public News setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public News setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getSentimentScore() {
        return sentimentScore;
    }

    public News setSentimentScore(Double sentimentScore) {
        this.sentimentScore = sentimentScore;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public News setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getTags() {
        return tags;
    }

    public News setTags(String tags) {
        this.tags = tags;
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