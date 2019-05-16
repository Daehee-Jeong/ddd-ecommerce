package io.github.wotjd243.ecommerce.order.infra;

import io.github.wotjd243.ecommerce.order.domain.Buyer;
import io.github.wotjd243.ecommerce.order.domain.Order;
import io.github.wotjd243.ecommerce.order.domain.OrderRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JpaOrderRepository implements OrderRepository {
    private static List<Order> orders = new ArrayList<>();
    private EntityManager entityManager;

    @Override
    public Order save(Order order) {
        this.entityManager.persist(order);

        return order;
    }

    @Override
    public Order findById(String orderId) {
        return this.entityManager.find(Order.class, orderId);
    }

    @Override
    public List<Order> findByBuyer(Buyer buyer) {
        return orders.stream().filter(v -> v.isOwn(buyer)).collect(Collectors.toList());
    }
}
