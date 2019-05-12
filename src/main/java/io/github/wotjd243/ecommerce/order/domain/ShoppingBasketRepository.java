package io.github.wotjd243.ecommerce.order.domain;

import java.util.List;

public interface ShoppingBasketRepository {
    List<ShoppingBasket> save(ShoppingBasket shoppingBasket);

    ShoppingBasket findByBuyer(String userId);

}
