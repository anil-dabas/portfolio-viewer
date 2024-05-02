package com.crypto.portfolio.domainValue;

public enum PositionType {
    LONG,SHORT;

    public static PositionType fromPositionTypeString(String value) {
        for (PositionType positionType : PositionType.values()) {
            if (positionType.name().equalsIgnoreCase(value)) {
                return positionType;
            }
        }
        throw new IllegalArgumentException("Invalid PositionType: " + value);
    }
}
