package io.github.wotjd243.ecommerce.utils;

import io.github.wotjd243.ecommerce.item.domain.Item;
import io.github.wotjd243.ecommerce.order.domain.ConsideringItem;

import java.util.List;
import java.util.stream.Collectors;

public class BasketUtils {
    private static final int DEFAULT_CONSIDERING_QUANTITY = 2;

    public static List<ConsideringItem> consider(List<Item> items) {
        return items.stream().map(v ->
                new ConsideringItem(v.getTitle(), v.getPrice(), v.getGalleryUrl(), DEFAULT_CONSIDERING_QUANTITY))
                .collect(Collectors.toList());
    }
}
