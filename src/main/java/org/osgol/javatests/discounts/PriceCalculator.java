package org.osgol.javatests.discounts;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {

    private final List<Double> prices;
    private double discount;

    public PriceCalculator()
    {
        prices = new ArrayList<>();
        discount = 0;
    }

    public double getTotal() {

        return prices.stream().mapToDouble(price -> price).sum() * (1 - discount / 100);
    }

    public void addPrice(double price) {
        prices.add(price);
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
