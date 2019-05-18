package io.github.wotjd243.ecommerce.user.domain;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.Set;

@Embeddable
public class ShippingAddresses {

    @ElementCollection
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

    public Set<ShippingAddress> getShippingAddresses() {
        return shippingAddresses;
    }
}
