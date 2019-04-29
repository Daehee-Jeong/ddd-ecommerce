package io.github.wotjd243.ecommerce.product.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemTest {


    @Test
    public void 아이템_생성() {
        Item item = createItem(25.75);

        assertThat(item).isNotNull();
        assertThat(item.isActive()).isTrue();
    }

    public static Item createItem(double price) {
        String title = "Harry Potter";
        String url = "http://thumbs1.ebaystatic.com/m/m80hGwQEYVi2QUduAtjeVhw/140.jpg";

        return new Item(title, price, url);
    }
}