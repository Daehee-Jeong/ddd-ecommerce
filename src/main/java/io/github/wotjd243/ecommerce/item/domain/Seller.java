package io.github.wotjd243.ecommerce.item.domain;

import lombok.Getter;

@Getter
public class Seller {
    private final String userId;

    public Seller(String userId) {
        this.userId = userId;
    }
}
