package main;

import exceptions.InvalidNameException;
import exceptions.InvalidPhoneNumberException;
import grocery.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField balanceField;

    @FXML
    public void onProceed(ActionEvent event) {
        String name = nameField.getText().trim();
        String phone = phoneField.getText().trim();
        double initialBalance;

        try {
            // Parse the initial balance and check if it's valid
            initialBalance = Double.parseDouble(balanceField.getText().trim());
            if (initialBalance < 0) {
                throw new IllegalArgumentException("Balance cannot be negative.");
            }

            // Create a new Customer to validate input
            Customer customer = new Customer(name, phone, initialBalance);

            // Load the main view
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainView.fxml"));
            Parent mainView = loader.load();

            // Get the controller for the main view
            MainController mainController = loader.getController();
            mainController.setCustomer(customer); // Pass the customer to MainController

            // Retrieve current stage and set main view scene
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(mainView));
            stage.setTitle("GrocerEase - Main");
            stage.show();

        } catch (NumberFormatException e) {
            // Handle invalid number format for balance
            showAlert(Alert.AlertType.ERROR, "Invalid Balance", "Please enter a valid number for balance.", "Balance must be a positive number.");
        } catch (IllegalArgumentException e) {
            // Handle negative balance input
            showAlert(Alert.AlertType.ERROR, "Invalid Balance", "Please enter a valid balance.", e.getMessage());
        } catch (InvalidNameException | InvalidPhoneNumberException e) {
            // Show error alert if validation fails
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter valid information.", e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Load Error", "Could not load main view.", "Please try again later.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String header, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
