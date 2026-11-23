package strategy;

public class DineInStrategy implements OrderStrategy {

    @Override
    public void processOrder() {
        System.out.println(
            "Layanan: Dine In (Makan di restoran)"
        );
    }

    @Override
    public double calculateFee() {
        return 0;
    }
}