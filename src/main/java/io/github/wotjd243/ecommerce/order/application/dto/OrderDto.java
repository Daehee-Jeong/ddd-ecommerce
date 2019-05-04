package io.github.wotjd243.ecommerce.order.application.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class OrderDto {
    private final String orderId;
    private final String buyerName;
    private final String buyerAddress;
    private final List<String> orderedItems;
    private final double totalPrice;
}
