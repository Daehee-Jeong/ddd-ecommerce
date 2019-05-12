package io.github.wotjd243.ecommerce.order.domain;

public class PayInfo {
    private Buyer buyer;
    private ShoppingBasket basket;
    private PayState payState;
    private PayMethod payMethod;

    public PayInfo(Buyer buyer, ShoppingBasket basket, PayMethod payMethod, PayState payState) {
        this.buyer = buyer;
        this.basket = basket;
        this.payMethod = payMethod;
        this.payState = payState;
    }

    public PayState getResult() {
          return this.payState;
    }

    public double getPayTotal() {
        return this.basket.sumPrice();
    }

    public boolean isPayStateSuccess() {

        // 결과값이 성공이고, 결제합이 같아야함
        if (PayState.FAIL.equals(getResult())) {
            throw new IllegalStateException("결제도중 오류가 발생했습니다");
        }

        return PayState.SUCCESS.equals(getResult());
        //return this.getResult().equals(PayState.SUCCESS);
    }
}
