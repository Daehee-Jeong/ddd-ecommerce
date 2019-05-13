package io.github.wotjd243.ecommerce.order.application;

import io.github.wotjd243.ecommerce.order.application.dto.OrderResponseDto;
import io.github.wotjd243.ecommerce.order.domain.*;
import io.github.wotjd243.ecommerce.user.application.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final ShoppingBasketService shoppingBasketService;

    public OrderService(OrderRepository OrderRepository, UserService userService, ShoppingBasketService shoppingBasketService) {
        this.orderRepository = OrderRepository;
        this.userService = userService;
        this.shoppingBasketService = shoppingBasketService;
    }

    public OrderResponseDto order(Buyer buyer, PayMethod method) {
        userService.checkValid(buyer.getUserId());
        ShoppingBasket basket = shoppingBasketService.findByBuyer(buyer.getUserId());

        PayInfo payInfo = new PayInfo(buyer, basket, method);

        if (!payInfo.isPayStateSuccess()) {
            return null;
        }

        if (payInfo.isPaySumSame(payInfo, basket)) {
            Order order = new Order(buyer, method, basket);
            return orderRepository.save(order).toDto();
        }

        return null;
    }


    public List<OrderResponseDto> findOrders(Buyer buyer) {
        List<Order> orders = orderRepository.findByBuyer(buyer);
        return orders.stream().map(v -> v.toDto()).collect(Collectors.toList());
    }

    public OrderResponseDto findOrder(String orderId) {
        return orderRepository.findById(orderId).toDto();
    }
}
