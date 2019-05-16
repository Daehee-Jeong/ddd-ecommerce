package io.github.wotjd243.ecommerce.order.domain;

import java.util.List;

public class PayInfo {
    public static final String PRICE_FORMAT_PATTERN = "%.2f";
    private Buyer buyer;
    private List<OrderItem> orderItemList;
    private PayState payState;
    private PayMethod payMethod;

    public PayInfo(Buyer buyer, List<OrderItem> orderItemList, PayMethod payMethod) {
        this.buyer = buyer;
        this.orderItemList = orderItemList;
        this.payMethod = payMethod;
        this.payState = payState.SUCCESS;
    }

    public PayState getResult() {
        return this.payState;
    }
    public boolean isPayStateSuccess() {

        if (PayState.FAIL.equals(getResult())) {
            return false;
        }

        return PayState.SUCCESS.equals(getResult());
    }

    public double sumPrice() {
        return format(orderItemList.stream().map(v -> v.sum()).reduce(0.0, Double::sum));
    }

    public double format(double value) {
        return Double.parseDouble(String.format(PRICE_FORMAT_PATTERN, value));
    }
}
