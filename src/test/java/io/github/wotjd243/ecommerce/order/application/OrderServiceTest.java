package io.github.wotjd243.ecommerce.order.application;

import io.github.wotjd243.ecommerce.item.application.ItemService;
import io.github.wotjd243.ecommerce.item.application.dto.PagingDto;
import io.github.wotjd243.ecommerce.item.domain.search.SortOrder;
import io.github.wotjd243.ecommerce.item.domain.search.SortParameter;
import io.github.wotjd243.ecommerce.item.infra.DummyItemRepository;
import io.github.wotjd243.ecommerce.order.application.dto.OrderResponseDto;
import io.github.wotjd243.ecommerce.order.domain.*;
import io.github.wotjd243.ecommerce.order.infra.DummyOrderRepository;
import io.github.wotjd243.ecommerce.order.infra.DummyShoppingBasketRepository;
import io.github.wotjd243.ecommerce.user.application.UserService;
import io.github.wotjd243.ecommerce.user.infra.DummyUserRepository;
import io.github.wotjd243.ecommerce.utils.BasketUtils;
import org.junit.Test;

import java.util.List;

import static io.github.wotjd243.ecommerce.order.domain.PayState.SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {
    private final static String TEST_USER_ID = "TEST_USER";
    private final static String TEST_USER_ADDRESS = "서울시";

    UserService userService = new UserService(new DummyUserRepository());
    ShoppingBasketService shoppingBasketService = new ShoppingBasketService(new DummyShoppingBasketRepository());

    OrderService orderService = new OrderService(new DummyOrderRepository(), userService, shoppingBasketService);
    ItemService itemService = new ItemService(new DummyItemRepository(), userService);

    @Test
    public void 한개_주문() {
        Buyer buyer = new Buyer(TEST_USER_ID, TEST_USER_ADDRESS);
        PayMethod method = PayMethod.CARD;
        PagingDto paging = new PagingDto(1, 10000, SortParameter.TITLE, SortOrder.ASCENDING);
        ShoppingBasket basket = new ShoppingBasket(BasketUtils.consider(itemService.searchItems("DDD", paging)));

        OrderResponseDto result = orderService.order(buyer, method);
        assertThat(basket.size()).isEqualTo(1);

        OrderResponseDto order = orderService.findOrder(result.getOrderId());
        assertThat(order).isEqualTo(result);
    }

    @Test
    public void 여러개_주문() {
        Buyer buyer = new Buyer(TEST_USER_ID, TEST_USER_ADDRESS);
        PayMethod method = PayMethod.CARD;
        ShoppingBasket basket = new ShoppingBasket(BasketUtils.consider(itemService.searchAll()));

        OrderResponseDto result = orderService.order(buyer, method);
        List<OrderResponseDto> orders = orderService.findOrders(buyer);

        assertThat(basket.size()).isEqualTo(4);
        assertThat(orders).contains(result);
    }

    @Test
    public void 결제성공플레그_테스트() {
        Buyer buyer = new Buyer(TEST_USER_ID, TEST_USER_ADDRESS);
        ShoppingBasket basket = new ShoppingBasket(BasketUtils.consider(itemService.searchAll()));
        PayInfo payInfo = new PayInfo(buyer, basket, PayMethod.CARD);

        assertThat(payInfo.getResult()).isEqualTo(SUCCESS);
    }

    @Test
    public void 결제금액변조_테스트() {
        Buyer buyer = new Buyer(TEST_USER_ID, TEST_USER_ADDRESS);
        ShoppingBasket basket = new ShoppingBasket(BasketUtils.consider(itemService.searchAll()));
        PayInfo payInfo = new PayInfo(buyer, basket, PayMethod.PHONE);

        assertThat(payInfo.getPayTotal()).isEqualTo(basket.sumPrice());
    }
}