package chain;

import model.Order;

public class PromoHandler extends ValidationHandler {

    @Override
    public boolean validate(Order order, String promoCode) {

        System.out.println("[VALIDASI] Memeriksa kode promo...");

        if (promoCode != null
                && !promoCode.isEmpty()
                && !promoCode.equals("JEMBER10")) {

            System.out.println("Gagal: Kode promo tidak valid!");
            return false;
        }

        if (promoCode != null && promoCode.equals("JEMBER10")) {
            System.out.println("Kode promo berhasil digunakan.");
        } else {
            System.out.println("Tidak menggunakan kode promo.");
        }

        return validateNext(order, promoCode);
    }
}