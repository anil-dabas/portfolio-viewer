package com.crypto.portfolio.calculation;

import org.junit.jupiter.api.Test;

import static com.crypto.portfolio.calculation.CommonCalculations.calPositionValue;
import static com.crypto.portfolio.constants.TestConstants.TESLA_QTY;
import static com.crypto.portfolio.constants.TestConstants.UNDERLYING_PRICE_TESLA;
import static com.crypto.portfolio.domainValue.PositionType.LONG;
import static com.crypto.portfolio.domainValue.PositionType.SHORT;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CommonCalculationsTest {

    @Test
    void calculateTotalValueOfShortPosition(){
        double actualResult = calPositionValue(SHORT,UNDERLYING_PRICE_TESLA,TESLA_QTY);
        assertEquals(-450000.0,actualResult);
    }

    @Test
    void calculateTotalValueOfLongPosition(){
        double actualResult = calPositionValue(LONG,UNDERLYING_PRICE_TESLA,TESLA_QTY);
        assertEquals(450000.0,actualResult);
    }

}