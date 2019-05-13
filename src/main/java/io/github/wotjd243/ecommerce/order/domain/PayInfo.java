package io.github.wotjd243.ecommerce.order.domain;

public class PayInfo {
    private Buyer buyer;
    private ShoppingBasket basket;
    private PayState payState;
    private PayMethod payMethod;
    private Double sumPrice;

    public PayInfo(Buyer buyer, ShoppingBasket basket, PayMethod payMethod, Double sumPrice) {
        this.buyer = buyer;
        this.basket = basket;
        this.payMethod = payMethod;
        this.payState = payState.SUCCESS;
        this.sumPrice = sumPrice;
    }

    public PayState getResult() {
          return this.payState;
    }

    public boolean isPayStateSuccess() {
        return PayState.SUCCESS.equals(getResult());
    }

    public boolean isPaySumSame() {
        return this.sumPrice == this.basket.sumPrice();
    }
}
