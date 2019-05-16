package io.github.wotjd243.ecommerce.order.domain;

import io.github.wotjd243.ecommerce.item.domain.Dollar;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderItemTest {

    @Test
    public void 고려중인_상품의_금액() throws MalformedURLException {
        String itemTitle = "머그컵";
        Dollar unitPrice = new Dollar(100.0);
        int quantity = 2;
        URL galleryUrl = new URL("http://www.naver.com");
        OrderItem orderItem = new OrderItem(itemTitle, unitPrice, galleryUrl, quantity);

        double price = orderItem.sum();
        assertThat(price).isEqualTo(200.0);
    }
}