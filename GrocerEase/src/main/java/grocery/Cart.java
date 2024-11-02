package grocery;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<GroceryItem, Integer> items;

    public Cart() {
        items = new HashMap<>();
    }

    public void addItem(GroceryItem item, int quantity) {
        items.put(item, items.getOrDefault(item, 0) + quantity);
    }

    public Map<GroceryItem, Integer> getItems() {
        return items;
    }

    // New clear method to empty the cart
    public void clear() {
        items.clear();
    }

    // New method to calculate the total value of items in the cart
    public double getTotalValue() {
        double total = 0.0;
        for (Map.Entry<GroceryItem, Integer> entry : items.entrySet()) {
            GroceryItem item = entry.getKey();
            int quantity = entry.getValue();
            total += item.getPrice() * quantity; // Assuming GroceryItem has a getPrice() method
        }
        return total;
    }

    @Override
    public String toString() {
        return "Cart: " + items;
    }
}

