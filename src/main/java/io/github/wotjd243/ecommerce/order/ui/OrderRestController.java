package io.github.wotjd243.ecommerce.order.ui;

import io.github.wotjd243.ecommerce.order.application.OrderService;
import io.github.wotjd243.ecommerce.order.application.dto.OrderResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {
    private OrderService orderService;

    public OrderRestController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/e-commercce/order/{orderId}")
    public OrderResponseDto getOrder(
            @PathVariable String orderId
    ) {
        return orderService.findOrder(orderId);
    }


}
