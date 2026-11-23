package observer;

import model.Order;

public class RestaurantNotifier implements OrderObserver {

    @Override
    public void update(Order order) {
        System.out.println(
            "[NOTIFIKASI RESTORAN] Pesanan "
            + order.getOrderId()
            + " diperbarui menjadi "
            + order.getStatus()
        );
    }
}