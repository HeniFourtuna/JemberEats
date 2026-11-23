package observer;

import model.Order;

public class CourierNotifier implements OrderObserver {

    @Override
    public void update(Order order) {
        System.out.println(
            "[NOTIFIKASI KURIR] Informasi pesanan "
            + order.getOrderId()
            + ": "
            + order.getStatus()
        );
    }
}