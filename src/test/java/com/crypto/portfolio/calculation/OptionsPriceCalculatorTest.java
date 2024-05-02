package com.crypto.portfolio.calculation;

import org.junit.jupiter.api.Test;

import static com.crypto.portfolio.constants.TestConstants.*;
import static com.crypto.portfolio.domainValue.SecurityType.CALL;
import static com.crypto.portfolio.domainValue.SecurityType.PUT;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OptionsPriceCalculatorTest {

    OptionsPriceCalculator optionsPriceCalculator = new OptionsPriceCalculator();

    @Test
    void testCalculateCallOptionPrice(){
        double actualResult = optionsPriceCalculator.calculateOptionPrice(UNDERLYING_PRICE_TESLA,STRIKE_PRICE_TESLA,MATURITY_TESLA_CALL,VOLATILITY_TESLA_CALL, CALL);
        assertEquals(55.740173825561726,actualResult);
    }


    @Test
    void testCalculatePutOptionPrice(){
        double actualResult = optionsPriceCalculator.calculateOptionPrice(UNDERLYING_PRICE_TESLA,STRIKE_PRICE_TESLA,MATURITY_TESLA_PUT,VOLATILITY_TESLA_PUT, PUT);
        assertEquals(5.457580942062066,actualResult);
    }
}