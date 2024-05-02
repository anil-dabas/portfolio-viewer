package com.crypto.portfolio.calculation;

import com.crypto.portfolio.domainValue.PositionType;

public class CommonCalculations {


    public static double calPositionValue(PositionType positionType, double price, int quantity) {
        double value = quantity * price;
        return PositionType.SHORT.equals(positionType) ? -1 * value : value;
    }
}
