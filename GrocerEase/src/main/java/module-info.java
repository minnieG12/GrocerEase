module com.example.grocerease {
    requires javafx.controls;
    requires javafx.fxml;

    // Open 'main' package to javafx.fxml for FXML injection and javafx.graphics for main application access
    opens main to javafx.fxml, javafx.graphics;
    exports main;
}
