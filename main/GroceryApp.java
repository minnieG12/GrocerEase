package main;

import model.*;
import ui.GroceryUI;
import util.StockUpdater;

public class GroceryApp {
    public static void main(String[] args) {
        // Initialize inventory and customers
        Inventory inventory = new Inventory();
        Customer customer = new Customer("C001", "John Doe", 500.0);

        // Start the UI
        GroceryUI ui = new GroceryUI(inventory, customer);
        ui.launchApp();

        // Start stock updater thread
        Thread stockUpdater = new Thread(new StockUpdater(inventory));
        stockUpdater.start();
    }
}
