package com.ai_crypto_market.core.model.enums;

public enum TimeFrame {
    ONE_MINUTE("1m"),
    FIVE_MINUTES("5m"),
    FIFTEEN_MINUTES("15m"),
    THIRTY_MINUTES("30m"),
    ONE_HOUR("1h"),
    FOUR_HOURS("4h"),
    ONE_DAY("1d");


    public final String value;

    TimeFrame(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
