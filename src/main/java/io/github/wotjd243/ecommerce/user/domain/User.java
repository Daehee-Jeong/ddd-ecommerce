package io.github.wotjd243.ecommerce.user.domain;

import java.util.Collections;

public class User {

    private Long id;
    private final String userId;
    private String address;

    private ShippingAddresses shippingAddresses;

    public User(String userId, String address) {
        this.userId = userId;
        this.address = address;
        this.shippingAddresses = new ShippingAddresses(Collections.emptySet());
    }

    public boolean match(String userId) {
        return this.userId.equals(userId);
    }

    public ShippingAddress addShippingAddress(String address, String zipCode) {
        return shippingAddresses.add(new ShippingAddress(address, zipCode));
    }

    public ShippingAddresses getShippingAddresses() {
        return shippingAddresses;
    }

    public String getUserId() {
        return userId;
    }

    public String getAddress() {
        return address;
    }
}
