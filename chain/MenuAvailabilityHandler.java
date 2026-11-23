package chain;

import model.Order;

public class MenuAvailabilityHandler extends ValidationHandler {

    @Override
    public boolean validate(Order order, String promoCode) {

        System.out.println("[VALIDASI] Memeriksa ketersediaan menu...");

        if (order.getItems().isEmpty()) {
            System.out.println("Gagal: Keranjang masih kosong!");
            return false;
        }

        System.out.println("Menu tersedia.");

        return validateNext(order, promoCode);
    }
}