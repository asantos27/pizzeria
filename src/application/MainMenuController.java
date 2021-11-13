package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

    @FXML
    void openCurrOrder(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CurrentOrderView.fxml"));

        CurrentOrderController currentOrderView = loader.getController();
        //pizzaView.loadPizzaData(pizza type)
        //pizzaView.setMainController(this);
        Scene scene = new Scene(loader.load(), 600, 550);
        Stage stage = new Stage();
        stage.setTitle("Order Detail");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void openStoreOrders(ActionEvent event) {

    }

    @FXML
    void orderDeluxe(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomizationView.fxml"));

        CustomizationController pizzaView = loader.getController();
        //pizzaView.loadPizzaData(pizza type)
        //pizzaView.setMainController(this);
        Scene scene = new Scene(loader.load(), 600, 550);
        Stage stage = new Stage();
        stage.setTitle("Order Deluxe Pizza");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void orderHawaiian(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomizationView.fxml"));

        CustomizationController pizzaView = loader.getController();
        //pizzaView.loadPizzaData(pizza type)
        //pizzaView.setMainController(this);
        Scene scene = new Scene(loader.load(), 600, 550);
        Stage stage = new Stage();
        stage.setTitle("Order Hawaiian Pizza");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void orderPepperoni(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomizationView.fxml"));

        CustomizationController pizzaView = loader.getController();
        //pizzaView.loadPizzaData(pizza type)
        //pizzaView.setMainController(this);
        Scene scene = new Scene(loader.load(), 600, 550);
        Stage stage = new Stage();
        stage.setTitle("Order Pepperoni Pizza");
        stage.setScene(scene);
        stage.show();
    }

}
