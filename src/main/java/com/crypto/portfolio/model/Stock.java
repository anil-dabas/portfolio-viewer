package com.crypto.portfolio.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "stock")
@Entity(name = "stock")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

    @Id
    private String id;
    private String name;
    private String code;
    private Double dayStartPrice;
    private Double expectedReturn;
    private Double volatility;

}
