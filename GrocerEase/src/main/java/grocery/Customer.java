package grocery;

import exceptions.InsufficientFundsException;
import exceptions.InvalidPhoneNumberException;
import exceptions.InvalidNameException;

public class Customer {
    private String name;
    private String phoneNumber;
    private double balance;

    public Customer(String name, String phoneNumber, double balance) throws InvalidPhoneNumberException, InvalidNameException {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        validateName(name);
        validatePhoneNumber(phoneNumber);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void addFunds(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Cannot add zero or negative funds.");
        }
        this.balance += amount;
    }

    public void deductFunds(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount to deduct must be positive.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient balance. Current balance: $" + balance);
        }
        this.balance -= amount;
    }

    private void validateName(String name) throws InvalidNameException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidNameException("Name cannot be null or empty.");
        }
        if (!name.matches("[A-Za-z ]+")) {
            throw new InvalidNameException("Name must contain only alphabetic characters and spaces.");
        }
    }

    private void validatePhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
        if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException("Phone number must contain exactly 10 digits.");
        }
    }

    @Override
    public String toString() {
        return "Customer: " + name + " (Phone: " + phoneNumber + ", Balance: $" + String.format("%.2f", balance) + ")";
    }
}
