package chain;

import model.Order;

public abstract class ValidationHandler {

    protected ValidationHandler next;

    public ValidationHandler setNext(ValidationHandler next) {
        this.next = next;
        return next;
    }

    public abstract boolean validate(Order order, String promoCode);

    protected boolean validateNext(Order order, String promoCode) {
        if (next == null) {
            return true;
        }

        return next.validate(order, promoCode);
    }
}