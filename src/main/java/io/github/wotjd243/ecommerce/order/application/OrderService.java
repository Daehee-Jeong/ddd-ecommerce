package io.github.wotjd243.ecommerce.order.application;

import io.github.wotjd243.ecommerce.order.application.dto.OrderResponseDto;
import io.github.wotjd243.ecommerce.order.domain.*;
import io.github.wotjd243.ecommerce.order.domain.exception.NotValidPayException;
import io.github.wotjd243.ecommerce.user.application.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final ShoppingBasketService shoppingBasketService;

    public OrderService(OrderRepository OrderRepository, UserService userService, ShoppingBasketService shoppingBasketService) {
        this.orderRepository = OrderRepository;
        this.userService = userService;
        this.shoppingBasketService = shoppingBasketService;
    }

    public OrderResponseDto order(Buyer buyer, PayMethod method, Double sumPrice) {
        userService.checkValid(buyer.getUserId());
        ShoppingBasket basket = shoppingBasketService.findByBuyer(buyer.getUserId());

        PayInfo payInfo = new PayInfo(buyer, basket, method, sumPrice);

        if (!payInfo.isPayStateSuccess()) {
            throw new NotValidPayException("정상적인 결제가 이루어지지않았습니다");
        }

        if (!payInfo.isPaySumSame()) {
            throw new NotValidPayException("정상적인 결제가 이루어지지않았습니다");
        }

        Order order = new Order(buyer, method, basket);
        return orderRepository.save(order).toDto();
    }


    public List<OrderResponseDto> findOrders(Buyer buyer) {
        List<Order> orders = orderRepository.findByBuyer(buyer);
        return orders.stream().map(v -> v.toDto()).collect(Collectors.toList());
    }

    public OrderResponseDto findOrder(String orderId) {
        return orderRepository.findById(orderId).toDto();
    }
}
