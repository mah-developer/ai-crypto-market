package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Position;
import com.ai_crypto_market.core.model.enums.TradeAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Qualifier("signalServiceFibonacci")
public class StrategyServiceFibonacciImpl implements StrategyService {

    @Override
    public Position analyzeUpdate(Position position,Position newPosition,List<Position> positionHistoryBasedOnExchangeId) {
        // we have new position here
        // todo get fresh value of currentPrice, availableBalance and profit from exchange here

        // check Strategy For Update Position ////////
        BigDecimal currentTP = position.getCurrentTargetPrice();
        BigDecimal currentSL = position.getCurrentStopLoss();
        Long currentPrice = position.getCurrentPrice();
        Long currentProfit = position.getProfit();
        BigDecimal entryPrice = position.getEntryPrice();
        BigDecimal quantity = position.getQuantity(); //
        // برای دریافت quantity اولیه

        Position entryPositionSnapshot = positionHistoryBasedOnExchangeId.getFirst();

        /// ///////////////////////////////////////////
        // START STRATEGY -----------------------------------------------
        // اگر قیمت به TP رسید، یا قیمت به SL رسید ، کل پوزیشن را ببند
        // اگر قیمت از نقطه ورود 34% TP رفت بالا، 21% پوزیشن را ببند
        // اگر قیمت برگشت به نقطه خرید و  قبلا 21% فروخته شده بود، 13% مبلغ ورود را مجددا بخر
        // اگر 2% نسبت به نقطه ورود افت قیمت داشت و مقدار خرید همان مقدار ورود است، به میزان 55% سرمایه ورود اولیه، مجددا وارد شو و TP را 1% کم کن

        // START STRATEGY -----------------------------------------------
        // check price, profit, and stoploss to set ( tradeaction , and if needed ( set stoploss,target or quantity ) )
        if(newPosition.getProfit()>12)
        {
            newPosition.setTradeAction(TradeAction.CHANGETPSL);
            newPosition.setCurrentStopLoss(new BigDecimal(0));
            newPosition.setCurrentTargetPrice(new BigDecimal(0));
        }
        else if(newPosition.getProfit()<21)
        {
            newPosition.setQuantity(new BigDecimal(0));
            newPosition.setTradeAction(TradeAction.BUY);
        }
        else if(newPosition.getProfit()==21)
        {
            newPosition.setQuantity(new BigDecimal(20));
            newPosition.setTradeAction(TradeAction.CLOSE);
        }
        else if(newPosition.getProfit()>=55)
        {
//            newPosition.getStrategy().setTradeAction(TradeAction.CLOSEALL);
        }
        else
            newPosition.setTradeAction(TradeAction.NONE);

        return newPosition;
    }

    @Override
    public Position analyzeNew()
    {
//        Position newPosition = positionService.fillPositionObject(position);
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


        return null;
    }
}
