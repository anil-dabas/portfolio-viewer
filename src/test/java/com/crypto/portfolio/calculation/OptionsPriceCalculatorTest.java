package com.crypto.portfolio.calculation;

import org.junit.jupiter.api.Test;

import static com.crypto.portfolio.constants.TestConstants.*;
import static com.crypto.portfolio.domainValue.SecurityType.CALL;
import static com.crypto.portfolio.domainValue.SecurityType.PUT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class OptionsPriceCalculatorTest {

    OptionsPriceCalculator optionsPriceCalculator = new OptionsPriceCalculator();

    @Test
    void testCalculateCallOptionPrice(){
        OptionsPriceCalculator spyCalculator = spy(optionsPriceCalculator);
        doReturn(0.5).when(spyCalculator).getTimeToExpiry(MATURITY_TESLA_CALL);
        double actualResult = spyCalculator.calculateOptionPrice(UNDERLYING_PRICE_TESLA,STRIKE_PRICE_TESLA,MATURITY_TESLA_CALL,VOLATILITY_TESLA_CALL, CALL);
        assertEquals(54.39841586889219,actualResult);
    }


    @Test
    void testCalculatePutOptionPrice(){
        OptionsPriceCalculator spyCalculator = spy(optionsPriceCalculator);
        doReturn(0.5).when(spyCalculator).getTimeToExpiry(MATURITY_TESLA_PUT);
        double actualResult = spyCalculator.calculateOptionPrice(UNDERLYING_PRICE_TESLA,STRIKE_PRICE_TESLA,MATURITY_TESLA_PUT,VOLATILITY_TESLA_PUT, PUT);
        assertEquals(5.94763332853438,actualResult);
    }
}