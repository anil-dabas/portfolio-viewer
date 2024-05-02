package com.crypto.portfolio.model;

import com.crypto.portfolio.domainValue.PositionType;
import com.crypto.portfolio.domainValue.SecurityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.crypto.portfolio.constants.UtilityConstant.STRING_PADDING;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioElement {

    private String symbol;
    private Double price;
    private Integer quantity;
    private Double value;
    private String underlying;
    private PositionType positionType;
    private SecurityType securityType;

    @Override
    public String toString() {
        quantity = PositionType.SHORT.equals(positionType) ? -1*quantity :quantity;
        return String.format(STRING_PADDING,symbol )+ "        "+String.format(STRING_PADDING,price)+"       "+String.format(STRING_PADDING,quantity)+"        "+String.format(STRING_PADDING,value);
    }
}
