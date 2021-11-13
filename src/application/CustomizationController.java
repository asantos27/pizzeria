package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class CustomizationController {

    @FXML
    private Button addOrderButton;

    @FXML
    private Button addToppingButton;

    @FXML
    private ListView<String> additionalToppingsList;

    @FXML
    private ImageView pizzaImage;

    @FXML
    private TextField pizzaPriceText;

    @FXML
    private Button removeToppingButton;

    @FXML
    private ListView<String> selectedToppingsList;

    @FXML
    private ComboBox<String> sizeComboBox;

}
