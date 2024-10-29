package model;

public class Transaction {
    private String transactionID;
    private Customer customer;
    private double totalAmount;

    public Transaction(String transactionID, Customer customer, double totalAmount) {
        this.transactionID = transactionID;
        this.customer = customer;
        this.totalAmount = totalAmount;
    }

    public void processTransaction() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Total Amount: $" + totalAmount);
    }

    public String generateReceipt() {
        return "Transaction ID: " + transactionID + "\nCustomer: " + customer.getName() + "\nTotal: $" + totalAmount;
    }
}
