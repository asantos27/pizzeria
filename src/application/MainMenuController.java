package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;

public class MainMenuController {

    @FXML
    private Button currOrderButton;

    @FXML
    private Button orderDeluxeButton;

    @FXML
    private Button orderHawaiianButton;

    @FXML
    private Button orderPepperoniButton;

    @FXML
    private Button storeOrdersButton;

    /**
     * Method to open the current order view
     * @param event
     * @throws IOException
     */
    @FXML
    void openCurrOrder(ActionEvent event) throws IOException{
       try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("CurrentOrderView.fxml"));
           CurrentOrderController currentOrderView = loader.getController();
           Scene scene = new Scene(loader.load(), 600, 550);
           Stage stage = new Stage();
           stage.setTitle("Order Detail");
           stage.setScene(scene);
           stage.show();
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
    void openStoreOrders(ActionEvent event) throws IOException{
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StoreOrdersView.fxml"));
            StoreOrdersController storeOrdersView = loader.getController();
            Scene scene = new Scene(loader.load(), 600, 550);
            Stage stage = new Stage();
            stage.setTitle("Store Orders");
            stage.setScene(scene);
            stage.show();
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
           pizzaView.loadPizzaData();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

}
