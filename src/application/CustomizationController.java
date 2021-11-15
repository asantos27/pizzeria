package application;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Alert.AlertType;

public class CustomizationController extends PizzaMaker{

    @FXML
    private Button addOrderButton;

    @FXML
    private Button addToppingButton;

    @FXML
    private ListView<Topping> additionalToppingsList;

    @FXML
    private ImageView pizzaImage;

    @FXML
    private TextField pizzaPriceText;

    @FXML
    private Button removeToppingButton;

    @FXML
    private ListView<Topping> selectedToppingsList;

    @FXML
    private ComboBox<Size> sizeComboBox;

    String pizzaFlavor;
    Alert a = new Alert(AlertType.NONE);
    private Pizza pizza = new Deluxe();
    private Order pizzaOrder = new Order();

    /**
     * Setter method to set flavor of pizza
     * @param pizzaFlavor
     */
    @FXML
    void setPizzaFlavor(String pizzaFlavor) {
        this.pizzaFlavor = pizzaFlavor;
    }

    @FXML
    public void setPizzaOrder(Order order) {
        pizzaOrder = order;
    }

    /**
     * Getter method to get flavor of pizza
     * @return flavor of pizza
     */
    @FXML
    private String getPizzaFlavor() {
        return this.pizzaFlavor;
    }

    /**
     * Method to load the correct Pizza data based on flavor
     * @param String flavor of pizza
     */
    @FXML
    public void loadPizzaData() {
        sizeComboBox.getItems().addAll(Size.SMALL, Size.MEDIUM, Size.LARGE);
        sizeComboBox.setValue(Size.SMALL);

        if (getPizzaFlavor() == "Deluxe") {
            Image deluxeImage = new Image("https://www.killingthyme.net/wp-content/uploads/2020/09/veggie-deluxe-pizza-4.jpg");
            pizzaImage.setImage(deluxeImage);
            pizza = createPizza("Deluxe");

        } else if (getPizzaFlavor() == "Hawaiian") {
            Image hawaiianImage = new Image("https://img.kidspot.com.au/pZnR2nZu/kk/2015/03/hawaiian-pizza-recipe-605894-2.jpg");
            pizzaImage.setImage(hawaiianImage);
            pizza = createPizza("Hawaiian");

        } else if (getPizzaFlavor() == "Pepperoni") {
            Image pepperoniImage = new Image("https://cdn.tasteatlas.com/images/dishes/b05a0af72ad845f3a6abe16143d7853a.jpg?w=600&h=450");
            pizzaImage.setImage(pepperoniImage);
            pizza = createPizza("Pepperoni");
        }
        pizza.setPizzaSize(sizeComboBox.getValue());
        selectedToppingsList.getItems().addAll(pizza.getDefaultToppings());
        additionalToppingsList.getItems().addAll(pizza.getAllToppings());
        pizzaPriceText.setText(pizza.getPizzaPrice());

    }

    /**
     * Method to add order to current order
     * @param event
     */
    @FXML
    void addToOrder(ActionEvent event) {
        pizzaOrder.add(pizza);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText("Pizza added to order!");
        alert.showAndWait();
    }

    /**
     * Helper method to change price of pizza based on pizza size
     * @param event
     */
    @FXML
    void changePizzaSize(ActionEvent event) {
        pizza.setPizzaSize(sizeComboBox.getValue());
        pizzaPriceText.setText(pizza.getPizzaPrice());
    }

    /**
     * Helper method to add toppings
     * Changes price of pizza based on toppings
     * @param event
     */
    @FXML
    void addToppingButton(ActionEvent event) {
        Topping topping = additionalToppingsList.getSelectionModel().getSelectedItem();

        if (topping == null) {
            return;
        }

        if (selectedToppingsList.getItems().size() >= 7) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Maximum toppings (7) have been reached !");
            alert.showAndWait();
            return;
        }

        additionalToppingsList.getItems().remove(topping);
        selectedToppingsList.getItems().add(topping);

        pizza.addTopping(topping);
        pizzaPriceText.setText(pizza.getPizzaPrice());
    }

    @FXML
    void removeToppingButton(ActionEvent event) {
        Topping topping = selectedToppingsList.getSelectionModel().getSelectedItem();

        if (topping == null) {
            return;
        }

        for (Topping t: pizza.getDefaultToppings()) {
            if (t == topping) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setHeaderText("You are removing the essential toppings!");
                alert.showAndWait();
            }
        }

        selectedToppingsList.getItems().remove(topping);
        additionalToppingsList.getItems().add(topping);

        pizza.removeTopping(topping);
        pizzaPriceText.setText(pizza.getPizzaPrice());

    }




}
