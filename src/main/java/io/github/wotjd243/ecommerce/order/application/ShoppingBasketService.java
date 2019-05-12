package io.github.wotjd243.ecommerce.order.application;

import io.github.wotjd243.ecommerce.order.application.dto.ShoppingBasketDto;
import io.github.wotjd243.ecommerce.order.domain.Buyer;
import io.github.wotjd243.ecommerce.order.domain.ConsideringItem;
import io.github.wotjd243.ecommerce.order.domain.ShoppingBasket;
import io.github.wotjd243.ecommerce.order.domain.ShoppingBasketRepository;

import java.util.List;

public class ShoppingBasketService {
    private ShoppingBasketRepository shoppingBasketRepository;

    public ShoppingBasketService(ShoppingBasketRepository shoppingBasketRepository) {
        this.shoppingBasketRepository = shoppingBasketRepository;
    }

    public ShoppingBasket findByBuyer(String userId) {
        return shoppingBasketRepository.findByBuyer(userId);
    }
}
