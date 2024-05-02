package com.crypto.portfolio.calculation;

import java.util.Random;

import static com.crypto.portfolio.constants.UtilityConstant.GBMConstant;

public class CalculateStockPrice {
    private static Random random = new Random();

    public static double generateStockPrice(Double mu, Double sigma, int delay, Double price) {
        double value =  geometricMotionForStocks(mu, sigma,delay,price,random.nextGaussian());
        if(value<=0){
            return generateStockPrice(mu, sigma,delay,price);
        }
        return value;
    }

    private static double geometricMotionForStocks(Double mu, Double sigma, int time, Double price, Double normalDistFactor){
        double part = (double) time / GBMConstant;
        double muPart = mu*part;
        double ndPart = (sigma*normalDistFactor)*Math.sqrt(part);
        double delS = price*(muPart+ndPart);
        return price + delS;
    }
}
