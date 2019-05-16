package io.github.wotjd243.ecommerce.order.domain;

import io.github.wotjd243.ecommerce.order.application.dto.OrderResponseDto;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Order {
    public static final String PRICE_FORMAT_PATTERN = "%.2f";

    @Id
    private String id;
    private Buyer buyer;
    private PayMethod payMethod;
    private List<OrderItem> orderItems;

    private Order() {
    }

    public Order(String id, Buyer buyer, PayMethod payMethod, List<OrderItem> orderItems) {
        this.id = id;
        this.buyer = buyer;
        this.payMethod = payMethod;
        this.orderItems = orderItems;
    }

    public Order(Buyer buyer, PayMethod payMethod, List<OrderItem> orderItems) {
        this.buyer = buyer;
        this.payMethod = payMethod;
        this.orderItems = orderItems;
    }

    public OrderResponseDto toDto() {
        return new OrderResponseDto(
                id,
                buyer.getUserId(),
                buyer.getAddress(),
                this.getItemsName(),
                this.sumPrice()
        );
    }

    public List<String> getItemsName() {
        return orderItems.stream().map(v -> v.getTitle()).collect(Collectors.toList());
    }

    public double sumPrice() {
        return format(orderItems.stream().map(v -> v.sum()).reduce(0.0, Double::sum));
    }

    public double format(double value) {
        return Double.parseDouble(String.format(PRICE_FORMAT_PATTERN, value));
    }


    public boolean isOwn(Buyer buyer) {
        return this.buyer == buyer;
    }

    public boolean match(String orderId) {
        return this.id == orderId;
    }
}
