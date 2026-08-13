package com.example.demo.strategy;

public class SeasonalSaleStrategy implements DiscountStrategy {

    @Override
    public double calculateDiscount(double price) {
        return price * 0.8;
    }

    @Override
    public String getDisplayName() {
        return "ส่วนลดเทศกาล 20%";
    }

}
