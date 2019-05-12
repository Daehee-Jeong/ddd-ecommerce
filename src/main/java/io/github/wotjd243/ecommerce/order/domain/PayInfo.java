package io.github.wotjd243.ecommerce.order.domain;

public class PayInfo {
    private Buyer buyer;
    private ShoppingBasket basket;
    private PayState payState;
    private PayMethod payMethod;

    public PayInfo(Buyer buyer, ShoppingBasket basket, PayMethod payMethod) {
        this.buyer = buyer;
        this.basket = basket;
        this.payMethod = payMethod;
    }

    public PayState getResult() {
        return this.payState;
    }

    public double getPayTotal() {
        return this.basket.sumPrice();
    }

    public boolean isPayStateSuccess() {

        // 결과값이 성공이고, 결제합이 같아야함
        if (this.getResult().equals(payState.FAIL)) {
            throw new IllegalStateException("결제도중 오류가 발생했습니다");
        }
        return this.getResult().equals(payState.SUCCESS);
    }
}
