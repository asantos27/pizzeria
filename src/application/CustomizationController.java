package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Controller to the Pizza Customization UI
 * @author Daniel Flts, Alyssa Santos
 */
public class CustomizationController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}