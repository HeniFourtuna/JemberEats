package observer;

import model.Order;

public class CustomerNotifier implements OrderObserver {

    @Override
    public void update(Order order) {
        System.out.println(
            "[NOTIFIKASI PELANGGAN] Halo "
            + order.getCustomer().getName()
            + ", pesanan "
            + order.getOrderId()
            + " sekarang berstatus "
            + order.getStatus()
        );
    }
}