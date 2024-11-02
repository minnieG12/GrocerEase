package main;

import grocery.Cart;
import grocery.Customer;
import grocery.GroceryItem;
import grocery.Inventory;
import exceptions.InsufficientFundsException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import threads.CheckoutThread;

public class MainController {

    @FXML
    private ListView<String> itemListView;
    @FXML
    private ListView<String> cartListView;
    @FXML
    private Label totalLabel;

    private Inventory<GroceryItem> inventory = new Inventory<>();
    private Cart cart = new Cart();
    private Customer customer;

    @FXML
    public void initialize() {
        // Load inventory items into the ListView
        itemListView.setItems(FXCollections.observableArrayList(
                inventory.getItems().stream().map(GroceryItem::toString).toList()
        ));
        updateTotalLabel();
    }

    @FXML
    public void onAddToCart() {
        String selectedItem = itemListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            GroceryItem item = inventory.getItemByName(selectedItem.split(" ")[0]);
            if (item != null) {
                cart.addItem(item, 1);
                cartListView.getItems().add(item.toString());
                updateTotalLabel(); // Update total label after adding an item
            }
        }
    }

    @FXML
    public void onCheckout() {
        double totalValue = cart.getTotalValue(); // Calculate total value of the cart

        // Debugging outputs
        System.out.println("Total Cart Value: " + totalValue);
        System.out.println("Customer Balance: " + customer.getBalance());

        try {
            // Check if the customer has sufficient funds
            customer.deductFunds(totalValue); // Attempt to deduct funds, which will throw an exception if insufficient

            // Proceed with the checkout if no exception was thrown
            CheckoutThread checkoutThread = new CheckoutThread(cart);
            checkoutThread.start();
        } catch (InsufficientFundsException e) {
            // Handle the insufficient funds case
            showAlert("Checkout Error", "Insufficient funds for checkout.\n" +
                    "Total: $" + totalValue + ", Available: $" + customer.getBalance());
        }
    }

    private void updateTotalLabel() {
        double totalValue = cart.getTotalValue();
        totalLabel.setText("Total: $" + totalValue);
    }

    public void setCustomer(Customer customer) {
        this.customer = customer; // Method to set the customer from WelcomeController
        updateTotalLabel(); // Update the total label in case the customer balance affects the total
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
