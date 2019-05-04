package io.github.wotjd243.ecommerce.order.domain;

import java.util.List;

public interface OrderRepository {
    Order save(Order order);

    List<Order> findByBuyer(Buyer buyer);
}
