package io.github.wotjd243.ecommerce.order.domain;

public class Buyer {
    private final String userName;
    private final String userAddress;

    public Buyer(String userName, String userAddress) {
        this.userName = userName;
        this.userAddress = userAddress;
    }
}
