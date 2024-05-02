package com.crypto.portfolio.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Portfolio{

    private Map<String, PortfolioElement> stockElements ;
    private Map<String, List<PortfolioElement>> optionsElements ;
    private Double nav;

}

