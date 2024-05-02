package com.crypto.portfolio.calculation;

import com.crypto.portfolio.constants.UtilityConstant;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static com.crypto.portfolio.calculation.CalculateStockPrice.generateStockPrice;
import static com.crypto.portfolio.constants.TestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculateStockPriceTest {

    @Test
    void generateStockPriceTest(){
        MockedStatic<UtilityConstant> utilityConstantMockedStatic = Mockito.mockStatic(UtilityConstant.class);
        utilityConstantMockedStatic.when(UtilityConstant::getNormalDistributionFactor).thenReturn(0.45);
        double actualResult = generateStockPrice(EXPECTED_RETURN_TESLA,AN_STD_DEV_TESLA,10,UNDERLYING_PRICE_TESLA);
        assertEquals(450.02389397135073,actualResult);
    }

}