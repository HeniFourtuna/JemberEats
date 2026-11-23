package chain;

import model.Order;

public class BalanceHandler extends ValidationHandler {

    @Override
    public boolean validate(Order order, String promoCode) {

        System.out.println("[VALIDASI] Memeriksa saldo pelanggan...");

        double total = order.getTotalPrice()
                    + order.calculateServiceFee();

        if (order.getCustomer().getBalance() < total) {
            System.out.println("Gagal: Saldo tidak mencukupi!");
            return false;
        }

        System.out.println("Saldo mencukupi.");

        return validateNext(order, promoCode);
    }
}