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
            if (!(checkPhoneNumValidity(Integer.parseInt(inputPhoneNum.getText())))) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Not a valid number! Please enter a valid number.");
                alert.showAndWait();
                return;
            }

            if (phoneNumExists(Integer.parseInt(inputPhoneNum.getText()))) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Customer's phone number already exists! Please enter a new number.");
                alert.showAndWait();
                return;
            }
            order.setPhoneNumber(Integer.parseInt(inputPhoneNum.getText()));
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Starting a new order!");
            alert.showAndWait();

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Not a valid number! Please enter a valid number.");
            alert.showAndWait();
            return;
        }
    }

    /**
     * Method that handles checks for valid phone numbers
     */
    public boolean validPhoneNumber() {
        try {
            if (!(checkPhoneNumValidity(Integer.parseInt(inputPhoneNum.getText())))) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Not a valid number! Please enter a valid number.");
                alert.showAndWait();
                return false;
            }
            if (phoneNumExists(Integer.parseInt(inputPhoneNum.getText()))) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Customer's phone number already exists! Please enter a new number.");
                alert.showAndWait();
                return false;
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Not a valid number! Please enter a valid number.");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    /**
     * Method that checks validity of phone number length
     * @return false if number is not valid
     */
    public boolean checkPhoneNumValidity(int phoneNumber) {
        if (String.valueOf(phoneNumber).length() != 10) {
            return false;
        } else if (phoneNumber == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Method that checks if given customer phone number already exists
     * @param phoneNumber
     * @return true if number exists, false if unique
     */
    public boolean phoneNumExists(int phoneNumber) {
        for (Order o: storeOrder.storeOrderList) {
            if (phoneNumber == o.getPhoneNumber()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to open the current order view
     * @param event
     * @throws IOException
     */
    @FXML
    void openCurrOrder(ActionEvent event) {
        if (validPhoneNumber() == false) {
            return;
        }

        try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("CurrentOrderView.fxml"));
           Parent root = (Parent) loader.load();
           CurrentOrderController currentOrderView = loader.getController();

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
        if (validPhoneNumber() == false) {
            return;
        }

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
        if (validPhoneNumber() == false) {
            return;
        }

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
        if (validPhoneNumber() == false) {
            return;
        }

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
