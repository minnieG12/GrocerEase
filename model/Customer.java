package model;

import java.util.ArrayList;
import java.util.List;

import exceptions.InsufficientFundsException;
import exceptions.OutOfStockException;

public class Customer {
    private String customerID;
    private String name;
    private double balance;
    private List<Item> purchasedItems;

    public Customer(String customerID, String name, double balance) {
        this.customerID = customerID;
        this.name = name;
        this.balance = balance;
        this.purchasedItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }

    public void purchaseItem(Item item, int quantity) throws Exception {
        double totalCost = item.getPrice() * quantity;
        if (totalCost > this.balance) {
            throw new InsufficientFundsException("Not enough balance to complete the purchase.");
        }
        if (quantity > item.getQuantity()) {
            throw new OutOfStockException("Item is out of stock.");
        }

        item.adjustQuantity(-quantity);
        this.balance -= totalCost;
        purchasedItems.add(item);
        System.out.println("Purchased: " + item.getName());
    }

    public List<Item> getPurchaseHistory() {
        return purchasedItems;
    }
}
