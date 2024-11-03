# GrocerEase - JavaFX Grocery Management Application

GrocerEase is a JavaFX-based mini-project for managing grocery items, designed to demonstrate core Java concepts such as classes, inheritance, custom exceptions, threads, and JavaFX UI elements. The application includes features like inventory management, shopping cart, and exception handling for various invalid inputs (e.g., insufficient funds, out-of-stock items).

## Project Structure

```
GrocerEase/
│ 
├── src/main/java/
│   ├── main/
│   │   ├── MainApp.java
│   │   ├── WelcomeController.java
│   │   ├── MainController.java
│   ├── grocery/
│   │   ├── Cart.java
│   │   ├── Customer.java
│   │   ├── GroceryItem.java
│   │   ├── Inventory.java
│   ├── exceptions/
│   │   ├── InsufficientFundsException.java
│   │   ├── OutOfStockException.java
│   │   ├── InvalidNameException.java
│   │   ├── InvalidPhoneNumberException.java
│   ├── threads/
│   │   ├── CheckoutThread.java
│ 
│── src/main/resources/
│   ├── MainView.fxml
│   └── WelcomeView.fxml
│ 
├── lib/
│ 
├── bin/
│ 
└── README.md
```

## Prerequisites
- [Java 11+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
- [JavaFX SDK](https://gluonhq.com/products/javafx/) (if not bundled with IntelliJ)

## Steps to Create GrocerEase in IntelliJ

### 1. **Create the Project**
1. Open IntelliJ, go to **File > New > Project**.
2. Select **Java** or **JavaFX** as the project type.
3. Name the project **GrocerEase** and choose your project location.
4. Click **Create**.

### 2. **Set Up JavaFX**
1. Download the JavaFX SDK if it’s not included in IntelliJ.
2. In IntelliJ, go to **File > Project Structure > Libraries**.
3. Click the **+** button, select **Java**, and add the path to the JavaFX SDK.
4. Ensure JavaFX libraries are included by adding them to your `lib` folder if needed.

### 3. **Organize Project Structure**
1. In the **Project Explorer** (left sidebar), right-click on **src** and select **New > Package**.
2. Create the following packages:
    - `main` (for main application files)
    - `grocery` (for classes related to grocery items and cart functionality)
    - `exceptions` (for custom exceptions)
    - `threads` (for checkout thread)
    - `resources` (for FXML files)
3. Right-click each package and select **New > Java Class** to create the necessary classes in each package.

### 4. **Create Java Classes**

- **`main` package**:
    - `MainApp.java`: The entry point for launching the JavaFX application.
    - `WelcomeController.java`: Controls the welcome screen view.
    - `MainController.java`: Manages main interactions, such as adding items to the cart.

- **`grocery` package**:
    - `Cart.java`: Represents a shopping cart.
    - `Customer.java`: Represents a customer’s account.
    - `GroceryItem.java`: Represents individual grocery items.
    - `Inventory.java`: Manages the collection of grocery items.

- **`exceptions` package**:
    - `InsufficientFundsException.java`: Custom exception for insufficient funds.
    - `OutOfStockException.java`: Custom exception for out-of-stock items.
    - `InvalidNameException.java`: Custom exception for invalid item names.
    - `InvalidPhoneNumberException.java`: Custom exception for invalid phone numbers.

- **`threads` package**:
    - `CheckoutThread.java`: Manages checkout operations using multithreading.


### 5. **Create FXML Files**
1. In the `resources` folder, right-click and select **New > File**.
2. Create `MainView.fxml` and `WelcomeView.fxml` to define the UI structure.

### 6. **Configure and Run MainApp**
1. Go to **Run > Edit Configurations**.
2. Under **Application** in the **Main class** field, set it to `main.MainApp`.
3. Add JavaFX VM options (replace `/path/to/javafx-sdk` with your SDK path):
   ```
   --module-path /path/to/javafx-sdk/lib --add-modules=javafx.controls,javafx.fxml
   ```
4. Run `MainApp` to launch the application.

### 7. **Add `.vscode` Folder (Optional for VS Code Users)**
If you’re using Visual Studio Code settings, create a `.vscode` folder and add `launch.json` and `settings.json` for configuration.

### 8. **README.md**
- Document the project details, setup instructions, and usage information in this README file.

## Example Initialization Code
Example initialization code for `Inventory.java` (with prices in INR):

```java
public void initializeInventory() {
    items.put("Apple", new GroceryItem("Apple", 40.0, 50));       // ₹40 per kg
    items.put("Banana", new GroceryItem("Banana", 30.0, 30));     // ₹30 per dozen
    items.put("Orange", new GroceryItem("Orange", 50.0, 40));     // ₹50 per kg
    items.put("Milk", new GroceryItem("Milk", 60.0, 20));         // ₹60 per liter
    // Add remaining items similarly...
}
```
## JavaFX Application Details
### 1. Welcome Screen
The Welcome screen (`WelcomeView.fxml`) prompts users for their name and phone number to proceed. The `WelcomeController.java` handles user inputs and validates them by instantiating a `Customer` object. If invalid, the application displays an error alert.

### 2. Main Shopping Screen
The Main Shopping screen (`MainView.fxml`) shows two `ListView`s for inventory and the cart. `MainController.java` provides functionalities to add items from inventory to the cart, view the cart's total, and initiate checkout.

### 3. Total Cart Value Display
The `totalLabel` at the bottom of the main screen displays the cart’s current total. The label is updated whenever items are added or removed from the cart.

## Exception Handling
The project includes custom exception handling to ensure data integrity and provide user feedback.
- `InvalidNameException`: Thrown if the user enters an invalid name (e.g., an empty string).
- `InvalidPhoneNumberException`: Thrown if the phone number does not meet the required format.
- `InsufficientFundsException`: Thrown if cart value exceeds customer balance.
- `OutOfStockException`: Thrown if an item is out of stock.

First 2 exceptions are handled in the `WelcomeController`, and any validation error triggers a popup alert with the relevant message.
Last 2 exceptions are handled in the `MainController`, and any validation error triggers a popup alert with the relevant message.

## Multi-threading with CheckoutThread
The `CheckoutThread.java` class handles the checkout process in a separate thread, preventing the UI from freezing during long operations. Upon clicking "Checkout," the thread calculates the total and clears the cart asynchronously, allowing the user to continue interacting with the application.

### Thread Workflow
1. **Initialization**: The `onCheckout` method in `MainController` initializes `CheckoutThread` with the current cart.
2. **Execution**: The thread calculates the total in the background.
3. **Completion**: The UI updates to show a confirmation or message once checkout is complete.
## Additional Notes
- Each exception should be handled in the respective methods to display error messages or alert dialogs.
- UI elements like buttons, labels, and list views can be customized in the FXML files.

## License
This project is licensed under the MIT License.

---

This README file should help guide developers through creating, setting up, and running the GrocerEase project in IntelliJ.
