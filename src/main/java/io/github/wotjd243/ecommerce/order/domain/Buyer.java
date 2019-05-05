package io.github.wotjd243.ecommerce.order.domain;

import lombok.Getter;

@Getter
public class Buyer {
    private final String userId;
    private final String userAddress;

    public Buyer(String userId, String userAddress) {
        this.userId = userId;
        this.userAddress = userAddress;
    }
}
