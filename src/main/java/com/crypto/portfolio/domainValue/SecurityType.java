package com.crypto.portfolio.domainValue;

public enum SecurityType {
    STOCK, CALL, PUT;
    public static SecurityType fromSecurityTypeString(String value) {
        for (SecurityType positionType : SecurityType.values()) {
            if (positionType.name().equalsIgnoreCase(value)) {
                return positionType;
            }
        }
        throw new IllegalArgumentException("Invalid SecurityType: " + value);
    }
}
