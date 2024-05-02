package com.crypto.portfolio.constants;

import java.time.LocalDate;

public class TestConstants {
    public static final double UNDERLYING_PRICE_TESLA = 450.00;
    public static final int TESLA_QTY = 1000;
    public static final double STRIKE_PRICE_TESLA = 400.00;
    public static final double VOLATILITY_TESLA_CALL = 0.1;
    public static final double VOLATILITY_TESLA_PUT = 0.2;
    public static final double EXPECTED_RETURN_TESLA = 0.2;
    public static final double AN_STD_DEV_TESLA = 0.1;
    public static final LocalDate MATURITY_TESLA_CALL = LocalDate.of(2024,12,19);
    public static final LocalDate MATURITY_TESLA_PUT = LocalDate.of(2024,10,19);
}
