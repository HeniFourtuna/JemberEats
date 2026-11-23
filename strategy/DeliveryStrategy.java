package strategy;

public class DeliveryStrategy implements OrderStrategy {

    @Override
    public void processOrder() {
        System.out.println(
            "Layanan: Delivery (Pesanan diantar kurir)"
        );
    }

    @Override
    public double calculateFee() {
        return 10000;
    }
}