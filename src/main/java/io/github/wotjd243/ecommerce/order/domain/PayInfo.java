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
        this.payState = payState.SUCCESS;
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
            return false;
        }

        return PayState.SUCCESS.equals(getResult());
    }

    public boolean isPaySumSame(PayInfo payInfo, ShoppingBasket shoppingBasket) {

        // 결과값이 성공이고, 결제합이 같아야함
        if (payInfo.getPayTotal() != shoppingBasket.sumPrice()) {
            return false;
        }
        return payInfo.getPayTotal() == shoppingBasket.sumPrice();
    }
}
