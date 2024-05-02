package com.crypto.portfolio.constants;

import java.util.Random;

public class UtilityConstant {
    public final static int GBMConstant = 7257600;
    public static final String COMMA = ",";
    public static final String STRING_PADDING = "%-20s";
    public static final double RISK_FREE_RATE = 0.02;
    public static final Random RANDOM = new Random();
    public static double getNormalDistributionFactor() {
        return RANDOM.nextGaussian();
    }
}
