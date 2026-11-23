package memento;

import java.util.ArrayList;
import java.util.List;

public class CartMemento {

    private final List<String> savedItems;

    public CartMemento(List<String> items) {
        this.savedItems = new ArrayList<>(items);
    }

    public List<String> getSavedItems() {
        return new ArrayList<>(savedItems);
    }
}