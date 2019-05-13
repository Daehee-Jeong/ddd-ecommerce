package io.github.wotjd243.ecommerce.order.infra;

import io.github.wotjd243.ecommerce.order.domain.ShoppingBasket;
import io.github.wotjd243.ecommerce.order.domain.ShoppingBasketRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DummyShoppingBasketRepository implements ShoppingBasketRepository {

    private List<ShoppingBasket> basketList = new ArrayList<>();

    @Override
    public List<ShoppingBasket> save(ShoppingBasket shoppingBasket) {
        basketList.add(shoppingBasket);
        return basketList;
    }

    @Override
    public ShoppingBasket findByBuyer(String userId) {
        return basketList.stream().filter(v -> v.match(userId)).findFirst().get();
    }

}
