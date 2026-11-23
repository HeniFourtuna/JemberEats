package chain;

import model.Order;

public class RestaurantOpenHandler extends ValidationHandler {

    private boolean restaurantOpen;

    public RestaurantOpenHandler(boolean restaurantOpen) {
        this.restaurantOpen = restaurantOpen;
    }

    @Override
    public boolean validate(Order order, String promoCode) {

        System.out.println("[VALIDASI] Memeriksa jam operasional restoran...");

        if (!restaurantOpen) {
            System.out.println("Gagal: Restoran sedang tutup!");
            return false;
        }

        System.out.println("Restoran sedang buka.");

        return validateNext(order, promoCode);
    }
}