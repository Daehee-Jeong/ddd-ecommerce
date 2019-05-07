package io.github.wotjd243.ecommerce.user.domain;

import java.util.Set;

public class ShippingAddresses {

    private final Set<ShippingAddress> shippingAddresses;

    public ShippingAddresses(Set<ShippingAddress> shippingAddresses) {
        this.shippingAddresses = shippingAddresses;
    }

    public ShippingAddress add(ShippingAddress shippingAddress) {
        if (!shippingAddresses.add(shippingAddress)) {
            throw new IllegalArgumentException();
        }
        return shippingAddress;
    }
}
