package io.github.wotjd243.ecommerce.user.domain;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ShippingAddressTest {

    @Test
    public void 우편번호와_주소가_값이_존재하는지_확인() {
        String TEST_ADDRESS = "TEST_ADDRESS";
        String TEST_ZIPCODE = "TEST_ZIPCODE";

        ShippingAddress shippingAddress = new ShippingAddress(TEST_ADDRESS, TEST_ZIPCODE);
        assertThat(shippingAddress).isNotNull();
    }
}