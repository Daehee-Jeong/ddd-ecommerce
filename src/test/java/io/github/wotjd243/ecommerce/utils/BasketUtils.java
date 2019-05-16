package io.github.wotjd243.ecommerce.utils;

import io.github.wotjd243.ecommerce.item.application.dto.ItemResponseDto;
import io.github.wotjd243.ecommerce.item.domain.Dollar;
import io.github.wotjd243.ecommerce.order.domain.OrderItem;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class BasketUtils {
    private static final int DEFAULT_CONSIDERING_QUANTITY = 2;

    public static List<OrderItem> consider(List<ItemResponseDto> items) {
        return items.stream().map(v ->
                new OrderItem(v.getTitle(), new Dollar(v.getPrice()), generateUrl(v), DEFAULT_CONSIDERING_QUANTITY))
                .collect(Collectors.toList());
    }

    private static URL generateUrl(ItemResponseDto v) {
        try {
            return new URL(v.getUrl());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
