package strategy;

public class PickupStrategy implements OrderStrategy {

    @Override
    public void processOrder() {
        System.out.println(
            "Layanan: Pickup (Pelanggan mengambil pesanan)"
        );
    }

    @Override
    public double calculateFee() {
        return 0;
    }
}