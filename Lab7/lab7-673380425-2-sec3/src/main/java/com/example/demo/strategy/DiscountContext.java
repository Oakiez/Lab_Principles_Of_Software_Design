package com.example.demo.strategy;

import org.springframework.stereotype.Component;

@Component
public class DiscountContext {

    public double applyDiscount(double price, String discountType) {
        if (discountType == null || discountType.isEmpty()) {
            return new NoDiscountStrategy().calculateDiscount(price);
        }

        switch (discountType.toLowerCase()) {
            case "student":
                return new StudentDiscountStrategy().calculateDiscount(price);
            case "seasonal":
                return new SeasonalSaleStrategy().calculateDiscount(price);
            default:
                return new NoDiscountStrategy().calculateDiscount(price);
        }
    }

    public String getDisplayName(String discountType) {
        if (discountType == null || discountType.isEmpty()) {
            return new NoDiscountStrategy().getDisplayName();
        }

        switch (discountType.toLowerCase()) {
            case "student":
                return new StudentDiscountStrategy().getDisplayName();
            case "seasonal":
                return new SeasonalSaleStrategy().getDisplayName();
            default:
                return new NoDiscountStrategy().getDisplayName();
        }
    }
}
