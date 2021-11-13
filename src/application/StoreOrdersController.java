package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Controller to the Store Orders UI
 * @author Daniel Flts, Alyssa Santos
 */
public class StoreOrdersController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}