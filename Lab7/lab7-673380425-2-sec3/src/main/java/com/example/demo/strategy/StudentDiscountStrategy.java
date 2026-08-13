package com.example.demo.strategy;

public class StudentDiscountStrategy implements DiscountStrategy {

    @Override
    public double calculateDiscount(double price) {
        return price * 0.9;
    }

    @Override
    public String getDisplayName() {
        return "ส่วนลดนักศึกษา 10%";
    }
}
