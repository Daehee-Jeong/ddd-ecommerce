package io.github.wotjd243.ecommerce.product.domain;


import io.github.wotjd243.ecommerce.item.domain.Item;
import io.github.wotjd243.ecommerce.order.application.OrderService;
import io.github.wotjd243.ecommerce.order.domain.Buyer;
import io.github.wotjd243.ecommerce.order.infra.ItemRepository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderTest {
    private final static String TEST_USER_ID = "TEST_USER";
    private final static String TEST_USER_ADDRESS = "서울시";
    private static List<Item> items = new ArrayList<>();

    Buyer user = new Buyer(TEST_USER_ID, TEST_USER_ADDRESS);
    static {
        Item item1 = new Item("DDD Start", 25.00, "http://thumbs1.ebaystatic.com/m/m80hGwQEYVi2QUduAtjeVhw/140.jpg");
        items.add(item1);

        Item item2 = new Item("도메인 주도 설계 구현", 23.00, "http://thumbs1.ebaystatic.com/m/m80hGwQEYVi2QUduAtjeVhw/139.jpg");
        items.add(item2);
    }

    @Test
    public void 구매_생성() {
        ItemRepository itemRepository = new ItemRepository();
        OrderService orderService = new OrderService(itemRepository);

//        new Order(user, PayMethod.CARD, items);
    }

    @Test void 결제_총합() {

    }

}
