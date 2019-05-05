package io.github.wotjd243.ecommerce.user.domain;

import lombok.EqualsAndHashCode;
import org.springframework.util.StringUtils;

@EqualsAndHashCode(exclude = {"id"})
public class ShippingAddress {
    private Long id;
    private String userId;
    private String address;
    private String zipcode;

    public ShippingAddress(String address, String zipcode) {
        if (StringUtils.isEmpty(address) || StringUtils.isEmpty(zipcode)) {
            throw new IllegalArgumentException();
        }
        this.address = address;
        this.zipcode = zipcode;
    }
}
