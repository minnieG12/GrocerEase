package util;

import model.Inventory;

public class StockUpdater implements Runnable {
    private Inventory inventory;

    public StockUpdater(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10000); // Check stock every 10 seconds
                System.out.println("\n--- Stock Update ---");
                for (var item : inventory.getItems()) {
                    if (item.getQuantity() < 10) {
                        System.out.println("Low stock alert: " + item.getName());
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Stock update thread interrupted.");
            }
        }
    }
}

