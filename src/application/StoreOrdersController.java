package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
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

    /**
     * Setter method for store orders data to be shrared between controllers
     * @param storeOrders
     */
    @FXML
    public void setStoreOrders(StoreOrders storeOrders) {
        currStoreOrders = storeOrders;
    }

    /**
     * Helper method to load phone numbers into combo box
     */
    @FXML
    public void loadPhoneNumbers() {
        phoneNumList.getItems().clear();
        for (Order o: currStoreOrders.storeOrderList) {
            phoneNumList.getItems().add(o);
        }
    }

    /**
     * Helper method to load customer order based on customer phone number
     * @param event
     */
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

    /**
     * Helper method that gives functionality to the cancel button
     * @param event
     */
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
        currStoreOrders.export();
    }

}
