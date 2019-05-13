package io.github.wotjd243.ecommerce.user.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingBasket {

    public static final String PRICE_FORMAT_PATTERN = "%.2f";
    private List<ConsideringItem> consideringItems;

    public ConsideringItem addConsideringItem(ConsideringItem consideringItem) {
        if (!consideringItems.add(consideringItem)) {
            throw new IllegalArgumentException();
        }
        return consideringItem;
    }

    public boolean removeConsideringItem(ConsideringItem consideringItem) {
        return consideringItems.remove(consideringItem);
    }

    public double sumPrice() {
        return format(consideringItems.stream().map(v -> v.sum()).reduce(0.0, Double::sum));
    }

    public double format(double value) {
        return Double.parseDouble(String.format(PRICE_FORMAT_PATTERN, value));
    }

    public List<String> getItemsName() {
        return consideringItems.stream().map(v -> v.getTitle()).collect(Collectors.toList());
    }

    public int size() {
        return consideringItems.size();
    }
}
