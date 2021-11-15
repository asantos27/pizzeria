package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;

public class MainMenuController {

    @FXML
    private Button currOrderButton;

    @FXML
    private TextField inputPhoneNum;

    @FXML
    private Button orderDeluxeButton;

    @FXML
    private Button orderHawaiianButton;

    @FXML
    private Button orderPepperoniButton;

    @FXML
    private Button storeOrdersButton;

    Order order = new Order();
    StoreOrders storeOrder = new StoreOrders();
    /**
     * Method to set customer phone number from main menu
     */
    @FXML
    void setCustomerPhoneNumber(ActionEvent event) {
        try {
            order = new Order();
            order.setPhoneNumber(Integer.parseInt(inputPhoneNum.getText()));
        } catch (NumberFormatException e) {
            //System.out.println("error");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Starting a new order!");
        alert.showAndWait();
    }

    /**
     * Method to open the current order view
     * @param event
     * @throws IOException
     */
    @FXML
    void openCurrOrder(ActionEvent event) {
       try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("CurrentOrderView.fxml"));
           Parent root = (Parent) loader.load();
           CurrentOrderController currentOrderView = loader.getController();
          // StoreOrdersController storeOrdersView = loader.getController();

           Scene scene = new Scene(root, 600, 550);
           Stage stage = new Stage();
           stage.setTitle("Order Detail");
           stage.setScene(scene);
           stage.show();

           currentOrderView.setCurrOrder(order);
           currentOrderView.setStoreOrders(storeOrder);
           currentOrderView.loadCurrOrder(order);
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    /**
     * Method to open the store orders view
     * @param event
     * @throws IOException
     */
    @FXML
    void openStoreOrders(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StoreOrdersView.fxml"));
            Parent root = (Parent) loader.load();
            StoreOrdersController storeOrdersView = loader.getController();

            Scene scene = new Scene(root, 600, 550);
            Stage stage = new Stage();
            stage.setTitle("Store Orders");
            stage.setScene(scene);
            stage.show();

            storeOrdersView.setStoreOrders(storeOrder);
            storeOrdersView.loadPhoneNumbers();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Method to open the deluxe pizza customization view
     * @param event
     */
    @FXML
    void orderDeluxe(ActionEvent event) {
       try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomizationView.fxml"));
           Parent root = (Parent) loader.load();
           CustomizationController pizzaView = loader.getController();

           Scene scene = new Scene(root, 600, 550);
           Stage stage = new Stage();
           stage.setTitle("Order Deluxe Pizza");
           stage.setScene(scene);
           stage.show();

           pizzaView.setPizzaFlavor("Deluxe");
           pizzaView.setPizzaOrder(order);
           pizzaView.loadPizzaData();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    /**
     * Method to open the hawaiian pizza customization view
     * @param event
     * @throws IOException
     */
    @FXML
    void orderHawaiian(ActionEvent event) {
       try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomizationView.fxml"));
           Parent root = (Parent) loader.load();
           CustomizationController pizzaView = loader.getController();

           Scene scene = new Scene(root, 600, 550);
           Stage stage = new Stage();
           stage.setTitle("Order Hawaiian Pizza");
           stage.setScene(scene);
           stage.show();

           pizzaView.setPizzaFlavor("Hawaiian");
           pizzaView.setPizzaOrder(order);
           pizzaView.loadPizzaData();
       } catch (IOException e) {
            e.printStackTrace();
       }
    }

    /**
     * Method to open the pepperoni pizza customization view
     * @param event
     * @throws IOException
     */
    @FXML
    void orderPepperoni(ActionEvent event) {
       try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomizationView.fxml"));
           Parent root = (Parent) loader.load();
           CustomizationController pizzaView = loader.getController();

           Scene scene = new Scene(root, 600, 550);
           Stage stage = new Stage();
           stage.setTitle("Order Pepperoni Pizza");
           stage.setScene(scene);
           stage.show();

           pizzaView.setPizzaFlavor("Pepperoni");
           pizzaView.setPizzaOrder(order);
           pizzaView.loadPizzaData();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

}
