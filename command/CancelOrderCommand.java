package command;

import model.Order;

public class CancelOrderCommand implements OrderCommand {

    private Order order;

    public CancelOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {

        System.out.println("\n=== PEMBATALAN PESANAN ===");

        if (order.getStatus().equals("DIBATALKAN")
                || order.getStatus().equals("SELESAI")) {

            System.out.println(
                "Pesanan tidak dapat dibatalkan."
            );

            return;
        }

        order.getCustomer().addBalance(
            order.getTotalPrice() + order.calculateServiceFee()
        );

        order.setStatus("DIBATALKAN");

        System.out.println("Pesanan berhasil dibatalkan.");
        System.out.println("Saldo pembayaran dikembalikan.");
    }
}