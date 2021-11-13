package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Controller to the Main Menu UI
 * @author Daniel Flts, Alyssa Santos
 */
public class MainMenuController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}