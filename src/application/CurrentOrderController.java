package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Controller to the Current Order UI
 * @author Daniel Flts, Alyssa Santos
 */
public class CurrentOrderController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}