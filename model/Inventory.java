package model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
        initializeStock();
    }

    private void initializeStock() {
        items.add(new Item("Apple", 1.0, 100));
        items.add(new Item("Banana", 0.5, 150));
        items.add(new Item("Milk", 2.5, 50));
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void updateItemStock(String name, int newQuantity) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                item.adjustQuantity(newQuantity);
                System.out.println("Updated stock for: " + name);
                break;
            }
        }
    }

    public void displayStock() {
        for (Item item : items) {
            System.out.println(item);
        }
    }
}

