package io.github.wotjd243.ecommerce.order.domain;

import io.github.wotjd243.ecommerce.item.application.ItemService;
import io.github.wotjd243.ecommerce.item.domain.Item;
import io.github.wotjd243.ecommerce.item.infra.DummyItemRepository;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingBasketTest {
    private static final int DEFAULT_CONSIDERING_QUANTITY = 2;
    ItemService service = new ItemService(new DummyItemRepository());
    List<Item> items = service.findAll();

    @Test
    public void 장바구니에_담은_상품의_총_금액_계산() {
        ShoppingBasket basket = new ShoppingBasket(consider(items));

        assertThat(basket.sumPrice()).isEqualTo(251.46);
    }

    private List<ConsideringItem> consider(List<Item> items) {
        return items.stream().map(v ->
                new ConsideringItem(v.getTitle(), v.getPrice(), v.getGalleryUrl(), DEFAULT_CONSIDERING_QUANTITY))
                .collect(Collectors.toList());
    }
}