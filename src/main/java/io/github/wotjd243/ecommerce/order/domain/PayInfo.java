package io.github.wotjd243.ecommerce.order.domain;

public class PayInfo {
    private Buyer buyer;
    private ShoppingBasket basket;
    private PayState payState;
    private double sumPrice;

    public PayInfo(Buyer buyer, ShoppingBasket basket) {
        this.buyer = buyer;
        this.basket = basket;
        this.sumPrice = basket.sumPrice();
    }

    public PayState getResult() {
        return payState.SUCCESS;
    }

    public double getPayTotal() {
        return sumPrice;
    }
}
