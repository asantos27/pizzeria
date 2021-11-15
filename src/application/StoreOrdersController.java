package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

public class StoreOrdersController {

    @FXML
    private Button cancelOrder;

    @FXML
    private Button exportOrders;

    @FXML
    private TextField orderTotal;

    @FXML
    private ComboBox<Order> phoneNumList;

    @FXML
    private ListView<Pizza> storeOrdersList;

    StoreOrders currStoreOrders = new StoreOrders();

    @FXML
    public void setStoreOrders(StoreOrders storeOrders) {
        currStoreOrders = storeOrders;
    }

    @FXML
    public void loadPhoneNumbers() {
        phoneNumList.getItems().clear();
        for (Order o: currStoreOrders.storeOrderList) {
            phoneNumList.getItems().add(o);
        }
    }

    @FXML
    void loadCustomerOrder(ActionEvent event) {
        DecimalFormat df = new DecimalFormat("###,##0.00");
        storeOrdersList.getItems().clear();
        if (phoneNumList.getSelectionModel().getSelectedItem() != null) {
           Order custOrder = phoneNumList.getSelectionModel().getSelectedItem();
           storeOrdersList.getItems().addAll(custOrder.getOrderList());
           orderTotal.setText(df.format(custOrder.getOrderTotal()));
        }
    }

    @FXML
    void cancelOrder(ActionEvent event) {
        if (phoneNumList.getSelectionModel().getSelectedItem() != null) {
            Order custOrder = phoneNumList.getSelectionModel().getSelectedItem();
            currStoreOrders.remove(custOrder);
            phoneNumList.getItems().remove(custOrder);
            storeOrdersList.getItems().remove(custOrder);
            orderTotal.setText(" ");
        }

    }

    @FXML
    void exportOrders(ActionEvent event) {

    }

}
