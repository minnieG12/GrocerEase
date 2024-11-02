# GrocerEase

## Overview
GrocerEase (The Grocery Manager App) is a JavaFX-based application designed for managing a grocery store. It features an inventory management system, customer handling, and a streamlined checkout process. The app incorporates various core Java concepts, including classes, exceptions, threads, generics, and packages, to deliver a robust user experience.

## Features
- Inventory management with 20+ grocery items
- Customer information handling
- Secure checkout process
- Custom exception handling for various scenarios
- Responsive UI with JavaFX

## Project Structure
```
GrocerEase/
├── src/
│   ├── main/
│   │   ├── MainApp.java
│   │   ├── WelcomeController.java
│   │   ├── MainController.java
│   │   ├── CheckoutThread.java
│   │   ├── resources/
│   │       ├── MainView.fxml
│   │       └── WelcomeView.fxml
│   ├── grocery/
│   │   ├── Cart.java
│   │   ├── Customer.java
│   │   ├── GroceryItem.java
│   │   ├── Inventory.java
│   ├── exceptions/
│   │   ├── InsufficientFundsException.java
│   │   ├── OutOfStockException.java
│   │   ├── InvalidNameException.java
│   ├── resources/
│   │   ├── MainView.fxml
│   │   └── WelcomeView.fxml
├── .vscode/
│   ├── launch.json
│   ├── settings.json
├── lib
├── bin
└── README.md

```

## Technologies Used
- **Java**: Programming language used for the application.
- **JavaFX**: Framework for building the GUI.
- **Scene Builder**: Visual design tool for FXML layout creation.

## Getting Started

### Prerequisites
- JDK 11 or higher
- JavaFX SDK
- Scene Builder (optional for GUI design)

### Installation
1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd GroceryManagerApp
   ```
2. Set up the JavaFX SDK in your IDE (e.g., IntelliJ, Eclipse, VS Code).
3. Run `MainApp.java` to start the application.

### Usage
- Enter customer details on the welcome page.
- Select items from the inventory to add to the cart.
- Proceed to checkout and handle payment.

## Exception Handling
The application includes custom exceptions to handle specific scenarios:
- **InsufficientFundsException**: Thrown when a customer attempts to check out without enough balance.
- **OutOfStockException**: Thrown when an item is out of stock during the checkout process.
- **InvalidNameException**: Thrown when the customer name entered contains invalid characters.

## Contributing
Contributions are welcome! Please feel free to submit a pull request or open an issue for suggestions and improvements.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments
- JavaFX documentation
- Scene Builder documentation
- OpenJDK community

