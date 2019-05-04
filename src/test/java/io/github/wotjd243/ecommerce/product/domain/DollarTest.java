package io.github.wotjd243.ecommerce.product.domain;

import io.github.wotjd243.ecommerce.item.domain.Dollar;
import org.junit.Test;

public class DollarTest {

    @Test(expected = IllegalArgumentException.class)
    public void 음수체크() {
        new Dollar(-1.0);
    }

}