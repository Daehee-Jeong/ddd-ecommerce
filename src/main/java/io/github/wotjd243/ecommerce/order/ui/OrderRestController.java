package io.github.wotjd243.ecommerce.order.ui;

import io.github.wotjd243.ecommerce.order.application.OrderService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {
    private OrderService orderService;

    public OrderRestController(final OrderService orderService) {
        this.orderService = orderService;
    }


}
