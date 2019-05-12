package io.github.wotjd243.ecommerce.order.domain;

public class PayInfo {
    private Buyer buyer;
    private ShoppingBasket basket;
    private PayState payState;

    public PayInfo(Buyer buyer, ShoppingBasket basket) {
        this.buyer = buyer;
        this.basket = basket;
    }

    public PayState getResult() {
        return this.payState;
    }

    public double getPayTotal() {
        return this.basket.sumPrice();
    }
}
