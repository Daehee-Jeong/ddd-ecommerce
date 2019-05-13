package io.github.wotjd243.ecommerce.order.domain.exception;

public class NotValidPayException extends RuntimeException {
    public NotValidPayException(String messages) {
        super(messages);
    }
}
