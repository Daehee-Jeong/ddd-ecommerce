package io.github.wotjd243.ecommerce.user.domain;

import io.github.wotjd243.ecommerce.product.domain.Item;
import io.github.wotjd243.ecommerce.product.domain.Product;
import org.junit.Test;

import java.util.List;

import static io.github.wotjd243.ecommerce.product.domain.ItemTest.createItem;
import static org.assertj.core.api.Assertions.assertThat;

public class SellerTest {
    private final static String TEST_USER_ID = "TEST_USER";
    private final static String TEST_ANOTHER_ID = "TEST_ANTHER";
    private final static String TEST_PRODUCT_NAME = "TEST_PRODUCT";

    Seller seller = new Seller(TEST_USER_ID);
    Seller anotherSeller = new Seller(TEST_ANOTHER_ID);
    Product product = new Product(TEST_PRODUCT_NAME);

    @Test
    public void 판매자가_물품을_등록() {
        Item item = createItem(100.7);
        seller.registerGoods(product, item);

        List<Item> items = seller.retrieve(product);
        assertThat(items.get(0)).isEqualTo(item);
    }

    @Test
    public void 판매자별로_물품의_가격을_다르게_설정() {
        double firstPrice = 100.8;
        double secondPrice = 25.8;
        seller.registerGoods(product, createItem(firstPrice));
        anotherSeller.registerGoods(product, createItem(secondPrice));
        List<Item> items = product.getItems();

        assertThat(items.get(0).isSamePrice(secondPrice)).isFalse();
    }
}