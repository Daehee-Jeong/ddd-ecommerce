package io.github.wotjd243.ecommerce.order.application;

import io.github.wotjd243.ecommerce.item.application.ItemService;
import io.github.wotjd243.ecommerce.item.application.dto.PagingDto;
import io.github.wotjd243.ecommerce.item.domain.search.SortOrder;
import io.github.wotjd243.ecommerce.item.domain.search.SortParameter;
import io.github.wotjd243.ecommerce.item.infra.DummyItemRepository;
import io.github.wotjd243.ecommerce.order.application.dto.OrderResponseDto;
import io.github.wotjd243.ecommerce.order.domain.*;
import io.github.wotjd243.ecommerce.order.infra.JpaOrderRepository;
import io.github.wotjd243.ecommerce.user.application.UserService;
import io.github.wotjd243.ecommerce.user.infra.DummyUserRepository;
import io.github.wotjd243.ecommerce.utils.BasketUtils;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {
    private final static String TEST_USER_ID = "TEST_USER";
    private final static String TEST_USER_ADDRESS = "서울시";

    UserService userService = new UserService(new DummyUserRepository());

    OrderService orderService = new OrderService(new JpaOrderRepository(), userService);
    ItemService itemService = new ItemService(new DummyItemRepository(), userService);

    @Test
    public void 한개_주문() {
        Buyer buyer = new Buyer(TEST_USER_ID, TEST_USER_ADDRESS);
        PayMethod method = PayMethod.CARD;
        PagingDto paging = new PagingDto(1, 10000, SortParameter.TITLE, SortOrder.ASCENDING);
        List<OrderItem> orderList = BasketUtils.consider(itemService.searchItems("DDD", paging));

        OrderResponseDto result = orderService.order(buyer, method, orderList);

        OrderResponseDto order = orderService.findOrder(result.getOrderId());
        assertThat(order).isEqualTo(result);
    }

    @Test
    public void 여러개_주문() {
        Buyer buyer = new Buyer(TEST_USER_ID, TEST_USER_ADDRESS);
        PayMethod method = PayMethod.CARD;
        List<OrderItem> orderList = BasketUtils.consider(itemService.searchAll());

        OrderResponseDto result = orderService.order(buyer, method, orderList);
        List<OrderResponseDto> orders = orderService.findOrders(buyer);

        assertThat(orders).contains(result);
    }

    @Test
    public void 결제성공플레그_테스트() {
        Buyer buyer = new Buyer(TEST_USER_ID, TEST_USER_ADDRESS);
        List<OrderItem> orderList = BasketUtils.consider(itemService.searchAll());
        PayInfo payInfo = new PayInfo(buyer, orderList, PayMethod.CARD);

        assertThat(payInfo.isPayStateSuccess()).isTrue();
    }
}