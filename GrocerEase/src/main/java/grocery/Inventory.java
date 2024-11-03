package grocery;

import java.util.ArrayList;
import java.util.List;

public class Inventory<T extends GroceryItem> {
    private List<T> items;

    public Inventory() {
        items = new ArrayList<>();
        initializeStock();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public T getItemByName(String name) {
        for (T item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public List<T> getItems() {
        return items;
    }

    public void reduceItemStock(String itemName, int quantity) {
        T item = getItemByName(itemName);
        if (item != null) {
            int newQuantity = item.getQuantity() - quantity;
            if (newQuantity < 0) {
                throw new IllegalArgumentException(item.getName() + " is out of stock or requested quantity exceeds available stock.");
            }
            item.setQuantity(newQuantity);
        }
    }

    private void initializeStock() {
        // Add 20 items with unique names, prices in rupees, and quantities
        items.add((T) new GroceryItem("Apples", 1.00, 50));
        items.add((T) new GroceryItem("Bananas", 0.40, 80));
        items.add((T) new GroceryItem("Oranges", 0.80, 60));
        items.add((T) new GroceryItem("Tomatoes", 1.20, 40));
        items.add((T) new GroceryItem("Potatoes", 0.60, 100));
        items.add((T) new GroceryItem("Onions", 0.90, 70));
        items.add((T) new GroceryItem("Carrots", 0.50, 90));
        items.add((T) new GroceryItem("Broccoli", 1.30, 30));
        items.add((T) new GroceryItem("Cucumbers", 0.80, 50));
        items.add((T) new GroceryItem("Lettuce", 1.00, 40));
        items.add((T) new GroceryItem("Milk", 1.20, 60));
        items.add((T) new GroceryItem("Cheese", 2.00, 25));
        items.add((T) new GroceryItem("Eggs", 0.20, 120));
        items.add((T) new GroceryItem("Chicken", 4.00, 20));
        items.add((T) new GroceryItem("Tofu", 3.00, 15));
        items.add((T) new GroceryItem("Bread", 1.10, 50));
        items.add((T) new GroceryItem("Rice", 0.70, 100));
        items.add((T) new GroceryItem("Pasta", 0.80, 80));
        items.add((T) new GroceryItem("Cereal", 1.80, 30));
        items.add((T) new GroceryItem("Juice", 1.60, 40));
    }

    @Override
    public String toString() {
        return "Inventory: " + items;
    }
}
