package memento;

import java.util.ArrayList;
import java.util.List;

public class CartHistory {

    private List<CartMemento> history = new ArrayList<>();

    public void save(Cart cart) {
        history.add(cart.createMemento());

        System.out.println("Kondisi keranjang berhasil disimpan.");
    }

    public void restore(Cart cart) {

        if (history.isEmpty()) {
            System.out.println("Tidak ada riwayat keranjang.");
            return;
        }

        CartMemento memento = history.get(history.size() - 1);

        cart.restore(memento);
    }
}