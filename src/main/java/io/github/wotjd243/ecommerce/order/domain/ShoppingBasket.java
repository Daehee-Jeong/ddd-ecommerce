package io.github.wotjd243.ecommerce.order.domain;

import java.util.List;

public class ShoppingBasket {
    private final List<ConsideringItem> items;

    public ShoppingBasket(List<ConsideringItem> items) {
        this.items = items;
    }

    public double sumPrice() {
        return format(items.stream().map(v -> v.sum()).reduce(0.0, Double::sum));
    }

    public double format(double value) {
        return Double.parseDouble(String.format("%.2f", value));
    }
}
