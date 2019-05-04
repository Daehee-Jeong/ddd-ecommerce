package io.github.wotjd243.ecommerce.product.application;

import io.github.wotjd243.ecommerce.item.application.ItemService;
import io.github.wotjd243.ecommerce.item.domain.Item;
import io.github.wotjd243.ecommerce.item.domain.search.*;
import io.github.wotjd243.ecommerce.item.infra.DummyItemRepository;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemServiceTest {
    ItemService service = new ItemService(new DummyItemRepository());

    @Test
    public void 키워드를_기준으로_검색한다() {
        QueryKeyword keywords = new QueryKeyword("DDD");
        List<Item> items = service.findItems(keywords, new Page(1, 1), new Sort(SortParameter.NAME, SortOrder.ASCENDING));

        assertThat(items.get(0).isSamePrice(25.0)).isTrue();
    }
}