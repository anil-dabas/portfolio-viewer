package com.crypto.portfolio.calculation;

import com.crypto.portfolio.domainValue.SecurityType;
import org.apache.commons.math3.distribution.NormalDistribution;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static com.crypto.portfolio.constants.UtilityConstant.RISK_FREE_RATE;
import static com.crypto.portfolio.domainValue.SecurityType.CALL;
import static com.crypto.portfolio.domainValue.SecurityType.PUT;

public class OptionsPriceCalculator {

    private NormalDistribution normalDistribution = new NormalDistribution();

    public double calculateOptionPrice(double underlyingPrice, double strike, LocalDate maturity, double volatility, SecurityType type) {
        double timeToExpiry = getTimeToExpiry(maturity);
        double d1 = calculateD1(underlyingPrice, strike, volatility, timeToExpiry);
        double d2 = calculateD2(d1, volatility, timeToExpiry);

        if (CALL.equals(type)) {
            return calculateCallOptionPrice(underlyingPrice, strike, d1, d2, timeToExpiry);
        } else if (PUT.equals(type)) {
            return calculatePutOptionPrice(underlyingPrice, strike, d1, d2, timeToExpiry);
        } else {
            throw new IllegalArgumentException("Unsupported option type: " + type);
        }
    }

    private double calculateD1(double underlyingPrice, double strike, double volatility, double timeToExpiry) {
        double numerator = Math.log(underlyingPrice / strike) + (RISK_FREE_RATE + (Math.pow(volatility, 2) / 2)) * timeToExpiry;
        double denominator = volatility * Math.sqrt(timeToExpiry);
        return numerator / denominator;
    }

    private double calculateD2(double d1, double volatility, double timeToExpiry) {
        return d1 - (volatility * Math.sqrt(timeToExpiry));
    }

    private double calculateCallOptionPrice(double underlyingPrice, double strike, double d1, double d2, double timeToExpiry) {
        double term1 = underlyingPrice * normalDistribution.cumulativeProbability(d1);
        double term2 = strike * Math.exp(-RISK_FREE_RATE * timeToExpiry) * normalDistribution.cumulativeProbability(d2);
        return term1 - term2;
    }

    private double calculatePutOptionPrice(double underlyingPrice, double strike, double d1, double d2, double timeToExpiry) {
        double term1 = strike * Math.exp(-RISK_FREE_RATE * timeToExpiry) * (1 - normalDistribution.cumulativeProbability(d2));
        double term2 = underlyingPrice * (1 - normalDistribution.cumulativeProbability(d1));
        return term1 - term2;
    }

    protected double getTimeToExpiry(LocalDate maturityDate) {
        LocalDate today = LocalDate.now();
        long daysToExpiry = ChronoUnit.DAYS.between(today, maturityDate);
        return daysToExpiry / 365.0;
    }
}
