package ui;

import model.*;
import java.util.Scanner;

public class GroceryUI {
    private Inventory inventory;
    private Customer customer;

    public GroceryUI(Inventory inventory, Customer customer) {
        this.inventory = inventory;
        this.customer = customer;
    }

    public void launchApp() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Grocery Store ---");
            System.out.println("1. View Stock");
            System.out.println("2. Purchase Item");
            System.out.println("3. Add Balance");
            System.out.println("4. View Purchase History");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    inventory.displayStock();
                    break;
                case 2:
                    handlePurchase(scanner);
                    break;
                case 3:
                    handleAddBalance(scanner);
                    break;
                case 4:
                    displayPurchaseHistory();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void handlePurchase(Scanner scanner) {
        System.out.print("Enter item name: ");
        String itemName = scanner.next();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        for (Item item : inventory.getItems()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                try {
                    customer.purchaseItem(item, quantity);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
        System.out.println("Item not found.");
    }

    private void handleAddBalance(Scanner scanner) {
        System.out.print("Enter amount to add: ");
        double amount = scanner.nextDouble();
        customer.addBalance(amount);
        System.out.println("Balance updated. Current balance: $" + customer.getBalance());
    }

    private void displayPurchaseHistory() {
        System.out.println("--- Purchase History ---");
        for (Item item : customer.getPurchaseHistory()) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
    }
}

