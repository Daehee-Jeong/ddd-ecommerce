package io.github.wotjd243.ecommerce.order.application;

import io.github.wotjd243.ecommerce.order.application.dto.ShoppingBasketDto;
import io.github.wotjd243.ecommerce.order.domain.Buyer;
import io.github.wotjd243.ecommerce.order.domain.ConsideringItem;
import io.github.wotjd243.ecommerce.order.domain.ShoppingBasket;
import io.github.wotjd243.ecommerce.order.domain.ShoppingBasketRepository;

import java.util.List;

public class ShoppingBasketService {
    private ShoppingBasketRepository shoppingBasketRepository;


    public ShoppingBasketService(ShoppingBasketRepository shoppingBasketRepository, ShoppingBasketService shoppingBasketService) {
        this.shoppingBasketRepository = shoppingBasketRepository;
    }

    public ShoppingBasket saveShoppingBasket(Buyer buyer, ShoppingBasketDto shoppingBasketDto) {
        ShoppingBasket shoppingBasket = new ShoppingBasket(shoppingBasketDto.getConsideringItems());
        return shoppingBasketRepository.save(shoppingBasket);
    }

//    public List<ShoppingBasket> findBasketList(Buyer buyer) {
//        List<ShoppingBasket> shoppingBasketList = shoppingBasketRepository.findByBuyer(buyer);
//
//    }

    public ShoppingBasket findBasketItem(String basketId) {
        return shoppingBasketRepository.findById(basketId);
    }

}
