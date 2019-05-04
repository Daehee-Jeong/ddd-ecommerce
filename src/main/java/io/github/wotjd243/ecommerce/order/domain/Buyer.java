package io.github.wotjd243.ecommerce.order.domain;

import lombok.Getter;

@Getter
public class Buyer {
    private final Long userId;
    private final String userName;
    private final String userAddress;

    public Buyer(Long userId, String userName, String userAddress) {
        this.userId = userId;
        this.userName = userName;
        this.userAddress = userAddress;
    }
}
