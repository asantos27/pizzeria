package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class CurrentOrderController {

    @FXML
    private ListView<String> currOrderList;

    @FXML
    private TextField orderTotalText;

    @FXML
    private TextField outputPhoneNum;

    @FXML
    private Button placeOrder;

    @FXML
    private Button removePizza;

    @FXML
    private TextField salesTaxText;

    @FXML
    private TextField subtotalText;

    @FXML
    void placeOrder(ActionEvent event) {

    }

    @FXML
    void removePizza(ActionEvent event) {

    }

}
