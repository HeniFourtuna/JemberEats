package command;

import model.Order;
import chain.ValidationHandler;

public class PlaceOrderCommand implements OrderCommand {

    private Order order;
    private ValidationHandler validator;
    private String promoCode;

    public PlaceOrderCommand(
            Order order,
            ValidationHandler validator,
            String promoCode) {

        this.order = order;
        this.validator = validator;
        this.promoCode = promoCode;
    }

    @Override
    public void execute() {

        System.out.println("\n=== PROSES CHECKOUT ===");

        boolean valid = validator.validate(order, promoCode);

        if (!valid) {
            System.out.println("Pesanan gagal diproses.");
            return;
        }

        double total = order.getTotalPrice()
                    + order.calculateServiceFee();

        boolean paid = order.getCustomer().deductBalance(total);

        if (!paid) {
            System.out.println("Pembayaran gagal.");
            return;
        }

        order.processService();

        System.out.println("Total pembayaran: Rp" + total);

        order.setStatus("DIPROSES");

        System.out.println("Pesanan berhasil dibuat!");
    }
}