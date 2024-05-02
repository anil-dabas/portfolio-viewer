package com.crypto.portfolio.model;

import com.crypto.portfolio.domainValue.PositionType;
import com.crypto.portfolio.domainValue.SecurityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Position {

    private String symbol;
    private PositionType positionType;
    private SecurityType securityType;
    private int size;
    private String underlying;

}
