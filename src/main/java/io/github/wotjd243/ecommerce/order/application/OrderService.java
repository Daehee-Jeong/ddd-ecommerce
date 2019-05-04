package io.github.wotjd243.ecommerce.order.application;

import io.github.wotjd243.ecommerce.order.application.dto.OrderDto;
import io.github.wotjd243.ecommerce.order.domain.Buyer;
import io.github.wotjd243.ecommerce.order.domain.Order;
import io.github.wotjd243.ecommerce.order.domain.Order.PayMethod;
import io.github.wotjd243.ecommerce.order.domain.OrderRepository;
import io.github.wotjd243.ecommerce.order.domain.ShoppingBasket;

import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository OrderRepository) {
        this.orderRepository = OrderRepository;
    }

    public OrderDto order(Buyer buyer, PayMethod method, ShoppingBasket basket) {
        Order order = new Order(buyer, method, basket);
        return orderRepository.save(order).toDto();
    }

    public List<OrderDto> findOrders(Buyer buyer) {
        List<Order> orders = orderRepository.findByBuyer(buyer);
        return orders.stream().map(v -> v.toDto()).collect(Collectors.toList());
    }

    public OrderDto findOrder(String orderId) {
        return orderRepository.findById(orderId).toDto();
    }
}
