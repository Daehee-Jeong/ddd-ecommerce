package io.github.wotjd243.ecommerce.order.domain;

import io.github.wotjd243.ecommerce.order.application.dto.OrderDto;

import java.time.LocalDateTime;
import java.util.UUID;

public class Order {
    private String id;
    private LocalDateTime createdDate;
    private Buyer buyer;
    private PayMethod payMethod;
    private ShoppingBasket basket;

    public Order(Buyer buyer, PayMethod payMethod, ShoppingBasket basket) {
        this.id = UUID.randomUUID().toString();
        this.buyer = buyer;
        this.payMethod = payMethod;
        this.basket = basket;
    }

    public OrderDto toDto() {
        return new OrderDto(
                id,
                buyer.getUserName(),
                buyer.getUserAddress(),
                basket.getItemsName(),
                basket.sumPrice()
        );
    }

    public boolean isOwn(Buyer buyer) {
        return this.buyer == buyer;
    }

    public boolean match(String orderId) {
        return this.id == orderId;
    }

    public enum PayMethod {
        CARD,
        HP
    }
}
