package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.AppConfig;
import com.ai_crypto_market.core.model.entity.Position;
import com.ai_crypto_market.core.model.entity.Stock;
import com.ai_crypto_market.core.model.entity.Wallet;
import com.ai_crypto_market.core.model.enums.PositionActivity;
import com.ai_crypto_market.core.model.enums.PositionType;
import com.ai_crypto_market.core.model.enums.StrategyType;
import com.ai_crypto_market.core.model.enums.TradeAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Qualifier("strategyServiceFibonacci")
public class StrategyServiceFibonacciImpl implements StrategyService {

    @Qualifier("apiServiceTaapi")
    @Autowired
    private ApiService apiServiceTaapi;

    @Override
    public StrategyType getStrategyType() {
        return StrategyType.FIBONACCI;
    }

    @Override
    public Position analyzeUpdate(Position position,Position newPosition,List<Position> positionHistoryBasedOnExchangeId) {
        // we have new position here
        // todo get fresh value of currentPrice, availableBalance and profit from exchange here

        BigDecimal currentTP = position.getCurrentTargetPrice();
        BigDecimal currentSL = position.getCurrentStopLoss();
        BigDecimal currentPrice = position.getCurrentPrice();
        BigDecimal currentProfit = position.getProfit();
        BigDecimal entryPrice = position.getEntryPrice();
        BigDecimal quantity = position.getQuantity(); //
        PositionType positiontype = position.getPositionType(); //
        // اولین حجمی که بار اول وارد معاماه شده
        BigDecimal entryQuantity=positionHistoryBasedOnExchangeId.getFirst().getQuantity();
        boolean close21Percent = positionHistoryBasedOnExchangeId.stream()
                .anyMatch(pos -> pos.getActivities().contains(PositionActivity.close21PercentinFibonacci.name()));
        boolean buy13Percent = positionHistoryBasedOnExchangeId.stream()
                .anyMatch(pos -> pos.getActivities().contains(PositionActivity.buy13PercentinFibonacci.name()));

        // START STRATEGY -----------------------------------------------

        // اگر قیمت از قیمت ورود 34% رفت بال یع کاری انجام بده
        BigDecimal threshold = (currentTP.subtract(entryPrice)).multiply(new BigDecimal("0.34")); // Calculate 34% of currentTP
        BigDecimal limitPrice = entryPrice.add(threshold); // Add the threshold to the entryPrice
        //  مقدار limitPrice برابر 34% اختلاف قیمت قیمت اولیه با TP است. یعنی اگر قیمت اولیه 1000$ باشه و تارگت 1200$ باشه limitPrice برابر 34% از 200 بعلاوه مقدار قیمت اولیه خواهد بود که برابر با 68$ + 1000$ است
        threshold = (currentTP.subtract(entryPrice)).multiply(new BigDecimal("0.5")); // Calculate 50% of currentTP
        BigDecimal changeSL = entryPrice.add(threshold); // Add the threshold to the changeSL
        //  مقدار changeSL برابر 50% اختلاف قیمت قیمت اولیه با TP است. یعنی اگر قیمت اولیه 1000$ باشه و تارگت 1200$ باشه limitPrice برابر 34% از 200 بعلاوه مقدار قیمت اولیه خواهد بود که برابر با 68$ + 1000$ است
        // اگر قیمت به TP رسید، یا قیمت به SL رسید ، کل پوزیشن را ببند
        if (
                (currentPrice.compareTo(currentSL) < 0 && positiontype==PositionType.LONG)
                || (currentPrice.compareTo(currentSL) > 0 && positiontype==PositionType.SHORT)
                || (currentPrice.compareTo(currentTP) > 0 && positiontype==PositionType.LONG)
                || (currentPrice.compareTo(currentTP) < 0 && positiontype==PositionType.SHORT)
            )
        {
            newPosition.setQuantity(quantity);
            newPosition.setTradeAction(TradeAction.CLOSE);
            newPosition.setActivities(PositionActivity.closeAllPosition.name());
        }
        // اگر قیمت از نقطه ورود 34% TP رفت بالا، 21% پوزیشن را ببند
        else if (
                ((currentPrice.compareTo(limitPrice) > 0  && positiontype==PositionType.LONG)
                || (currentPrice.compareTo(limitPrice) < 0  && positiontype==PositionType.SHORT))
                && !close21Percent
                )
        {
            BigDecimal percentage = quantity.multiply(new BigDecimal("0.21")); // Calculate 21% of quantity
            newPosition.setQuantity(percentage);
            newPosition.setTradeAction(TradeAction.CLOSE);
            newPosition.setActivities(PositionActivity.close21PercentinFibonacci.name());
        }
        // اگر قیمت برگشت به نقطه خرید و قبلا 21% فروخته شده بود، 13% مبلغ ورود را مجددا بخر
        else if (
                    ((currentPrice.compareTo(entryPrice) < 0 && positiontype==PositionType.LONG)
                    || (currentPrice.compareTo(entryPrice) > 0 && positiontype==PositionType.SHORT))
                    && close21Percent
                    && !buy13Percent
                )
        {
            BigDecimal percentage = entryQuantity.multiply(new BigDecimal("0.13")); // Calculate 21% of quantity
            newPosition.setQuantity(percentage);
            newPosition.setTradeAction(TradeAction.BUY);
            newPosition.setActivities(PositionActivity.buy13PercentinFibonacci.name());
        }
        // اگر قیمت تا 50 درصد TP بالا رفت ، SL را به نقطه ورود منتقل کن
        else if (
                    (currentPrice.compareTo(changeSL) > 0 && positiontype==PositionType.LONG)
                    || (currentPrice.compareTo(changeSL) < 0 && positiontype==PositionType.SHORT)
                )
        {
            newPosition.setTradeAction(TradeAction.CHANGETPSL);
            newPosition.setCurrentStopLoss(entryPrice);
            newPosition.setActivities(PositionActivity.changeTpSl.name());
        }
        else
            newPosition.setTradeAction(TradeAction.NONE);

        return newPosition;
    }

    @Override
    public Position analyzeNew(Stock stock)
    {
          Position position = new Position();
//        // THIS BLOCK CODE FOR NEW POSITION in STRATEGY ////////////////////////
//        var timeframe= Strategy // 1H
//        var TP=position.getStrategy().getDefaultTargetPercent(); // 5%
//        var SL=position.getStrategy().getDefaultStoplossPercent(); // 3%
//        if (position.getStrategy().getBuyPercent().compareTo(position.getWallet().getMaxPercentOfAvailablePerPosition()) > 0) {
//            position.getStrategy().setBuyPercent(position.getWallet().getMaxPercentOfAvailablePerPosition());
//        }
//        var perbalance=position.getStrategy().getBuyPercent(); // 8%
//        if (position.getStrategy().getDefaultLeverage().compareTo(position.getWallet().getMaxLeverage()) > 0) {
//            position.getStrategy().setDefaultLeverage(position.getWallet().getMaxLeverage());
//        }
//        var leverage=position.getStrategy().getDefaultLeverage(); // 2%
//        /// //////////////////////////////////////////////////////////////////


        return position;
    }

    @Override
    public void onInitialApplicationPersistDefaultStrategy() {

    }


}
