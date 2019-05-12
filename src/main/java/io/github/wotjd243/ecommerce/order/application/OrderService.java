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

    //TODO: 장바구니에 담기 기능이 구현되어야 한다.

    public OrderResponseDto order(Buyer buyer, PayMethod method) {
        userService.checkValid(buyer.getUserId());
        ShoppingBasket basket = shoppingBasketService.findByBuyer(buyer.getUserId());

        //TODO: 주문이 완료되기 전에 결재가 진행되어야 한다.
        PayInfo payInfo = new PayInfo(buyer, basket, method);

        if (payInfo.isPayStateSuccess()) {
            return null;
        }

        if (isPaySumSame(payInfo, basket)) {
            Order order = new Order(buyer, method, basket);
            return orderRepository.save(order).toDto();
        }

        return null;
    }

    public boolean isPaySumSame(PayInfo payInfo, ShoppingBasket shoppingBasket) {

        // 결과값이 성공이고, 결제합이 같아야함
        if (payInfo.getPayTotal() != shoppingBasket.sumPrice()) {
            throw new IllegalStateException("결제도중 오류가 발생했습니다");
        }
        return payInfo.getPayTotal() == shoppingBasket.sumPrice();
    }


    public List<OrderResponseDto> findOrders(Buyer buyer) {
        List<Order> orders = orderRepository.findByBuyer(buyer);
        return orders.stream().map(v -> v.toDto()).collect(Collectors.toList());
    }

    public OrderResponseDto findOrder(String orderId) {
        return orderRepository.findById(orderId).toDto();
    }
}
