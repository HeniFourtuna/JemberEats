package memento;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<String> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
        System.out.println(item + " ditambahkan ke keranjang.");
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public CartMemento createMemento() {
        return new CartMemento(items);
    }

    public void restore(CartMemento memento) {
        items = memento.getSavedItems();

        System.out.println("Keranjang berhasil dipulihkan.");
    }

    public List<String> getItems() {
        return new ArrayList<>(items);
    }

    public void displayCart() {
        System.out.println("\nIsi Keranjang:");

        for (String item : items) {
            System.out.println("- " + item);
        }
    }
}