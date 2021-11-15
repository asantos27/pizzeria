package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

public class CurrentOrderController {

    @FXML
    private ListView<Pizza> currOrderList;

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

    private Order currOrder;
    private StoreOrders storeOrders;

    @FXML
    void placeOrder(ActionEvent event) {
        storeOrders.add(currOrder);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Order added!");
        alert.showAndWait();
        outputPhoneNum.setText(" ");
        orderTotalText.setText(" ");
        salesTaxText.setText(" ");
        subtotalText.setText(" ");
        currOrderList.getItems().clear();
    }

    @FXML
    public void setCurrOrder(Order order) {
        currOrder = order;
    }

    @FXML
    public void setStoreOrders(StoreOrders storeOrder) {
        storeOrders = storeOrder;
    }

    @FXML
    void removePizza(ActionEvent event) {
       removeSelectedPizza();
    }

    @FXML
    void removeSelectedPizza() {
        Pizza removedPizza = currOrderList.getSelectionModel().getSelectedItem();

        for (int i = 0; i <= currOrder.orderList.size()-1; i++) {
            if (currOrder.orderList.get(i) == removedPizza) {
                currOrderList.getItems().remove(removedPizza);
                currOrder.orderList.remove(removedPizza);
            }
        }
        updatePrices();
    }

    @FXML
    public void loadCurrOrder(Order order) {
        outputPhoneNum.setText(String.valueOf(currOrder.getPhoneNumber()));
        for (Pizza p : currOrder.orderList) {
            currOrderList.getItems().addAll(p);
        }
        updatePrices();
  }

    @FXML
    void updatePrices() {
        double subtotal = 0;
        DecimalFormat df = new DecimalFormat("###,##0.00");

        for (Pizza p : currOrder.orderList) {
            subtotal += p.price();
        }
        currOrder.setSubTotal(subtotal);
        currOrder.calculateSalesTax();
        currOrder.calculateOrderTotal();

        subtotalText.setText(df.format(currOrder.getSubtotal()));
        salesTaxText.setText(df.format(currOrder.getSalesTax()));
        orderTotalText.setText(df.format(currOrder.getOrderTotal()));
    }

}
