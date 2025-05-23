package com.ai_crypto_market.core.model.entity;

import com.ai_crypto_market.core.model.enums.ExchangeName;
import com.ai_crypto_market.core.model.enums.TimeFrame;
import jakarta.persistence.*;

@Entity
@Table(name = "TB_APP_CONFIG")
// todo: should load in first load as a global Bean
public class AppConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_TB_APP_CONFIG")
    private Long id;

    private int defaultPercentOfAvailablePerCryptoPosition = 10; // این استراتژی میخواد بره از ولت طرف بیت بخره. بهش میگیم اولین بار که میخوای بخری به این میزان درصد از موجودی ولت برو خرید کن.

    private int allowedWeightForOpenNewPositionCryptoStock = 80;// وزن مورد قبول برای هر ارز کریپتو برای اینکه پوزیشن روی این Stock باز شود

    private ExchangeName defaultExchangeCryptoName = ExchangeName.BINANCE;// مقدار پیش فرض نام صرافی کریپتو برای دریافت قیمت ارز از صرافی

    private TimeFrame defaultTimeFrameCrypto = TimeFrame.THIRTY_MINUTES;// مقدار پیش فرض تایم فریم کریپتو برای دریافت حجم ارز از صرافی

    public Long getId() {
        return id;
    }

    public int getDefaultPercentOfAvailablePerCryptoPosition() {return defaultPercentOfAvailablePerCryptoPosition;}

    public AppConfig setDefaultPercentOfAvailablePerCryptoPosition(int defaultPercentOfAvailablePerCryptoPosition) {
        this.defaultPercentOfAvailablePerCryptoPosition = defaultPercentOfAvailablePerCryptoPosition;
        return this;
    }

    public int getAllowedWeightForOpenNewPositionCryptoStock() {
        return allowedWeightForOpenNewPositionCryptoStock;
    }

    public AppConfig setAllowedWeightForOpenNewPositionCryptoStock(int allowedWeightForOpenNewPositionCryptoStock) {
        this.allowedWeightForOpenNewPositionCryptoStock = allowedWeightForOpenNewPositionCryptoStock;
        return this;
    }

    public ExchangeName getdefaultExchangeCryptoName() {
        return defaultExchangeCryptoName;
    }

    public AppConfig setdefaultExchangeCryptoName(ExchangeName defaultExchangeCryptoName) {
        this.defaultExchangeCryptoName = defaultExchangeCryptoName;
        return this;
    }

    public TimeFrame getdefaultTimeFrameCrypto() {
        return defaultTimeFrameCrypto;
    }

    public AppConfig setdefaultTimeFrameCrypto(TimeFrame defaultTimeFrameCrypto) {
        this.defaultTimeFrameCrypto = defaultTimeFrameCrypto;
        return this;
    }
}
