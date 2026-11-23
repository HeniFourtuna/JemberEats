package command;

import model.Order;
import java.util.List;

public class RepeatOrderCommand implements OrderCommand {

    private Order previousOrder;

    public RepeatOrderCommand(Order previousOrder) {
        this.previousOrder = previousOrder;
    }

    @Override
    public void execute() {

        System.out.println("\n=== ULANGI PESANAN ===");

        List<String> items = previousOrder.getItems();

        System.out.println("Pesanan sebelumnya:");

        for (String item : items) {
            System.out.println("- " + item);
        }

        System.out.println(
            "Daftar makanan berhasil disalin."
        );

        System.out.println(
            "Silakan lakukan checkout untuk pesanan baru."
        );
    }
}