package io.github.wotjd243.ecommerce.order.domain;

import io.github.wotjd243.ecommerce.item.domain.Item;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Order {
    private String id;
    private Date orderDate;
    private Buyer buyer;
    private PayMethod payMethod;
    private ShoppingBasket basket;
    private double totalPrice;

    public Order(Buyer buyer, PayMethod payMethod, ShoppingBasket basket) {
        this.id = UUID.randomUUID().toString();
        this.buyer = buyer;
        this.payMethod = payMethod;
        this.basket = basket;
//        computeTotalPrice(items);
    }

    private void sumPrice(List<Item> items) {
        for (Item item: items) {
            this.totalPrice = Double.sum(item.price(), this.totalPrice);
        }
    }

    public enum PayMethod {
        CARD,
        HP
    }
}
