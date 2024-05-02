package com.crypto.portfolio.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity(name = "Security_Definition")
@Table(name = "Security_Definition")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class SecurityDefinition {

    @Id
    private String id;
    private String name;
    private String type;
    private String code;
    private Double volatility;
    private Double strikePrice;
    private LocalDate maturity;
}
