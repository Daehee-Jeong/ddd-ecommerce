package io.github.wotjd243.ecommerce.user.domain;

import javax.persistence.*;
import java.util.Collections;

@Entity
public class User {

    @Id
    private long id;

    private String userId;

    private String address;

    @Embedded
    private ShippingAddresses shippingAddresses;

    public User() {
    }

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
