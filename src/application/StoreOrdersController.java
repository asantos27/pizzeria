package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class StoreOrdersController {

    @FXML
    private Button cancelOrder;

    @FXML
    private Button exportOrders;

    @FXML
    private TextField orderTotal;

    @FXML
    private ComboBox<Integer> phoneNumList;

    @FXML
    private ListView<String> storeOrdersList;


    @FXML
    void cancelOrder(ActionEvent event) {

    }

    @FXML
    void exportOrders(ActionEvent event) {

    }

}
