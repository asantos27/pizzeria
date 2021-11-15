package application;

/**
 * This class is used in controller classes to create an instance of Pizza class
 * based on a chosen flavor.
 * @author Daniel Flts, Alyssa Santos
 */
public class PizzaMaker { //create an instance of subclasses based on the chosen flavor

    public static Pizza createPizza(String flavor) {
        Deluxe tempPizza = new Deluxe();
        if (flavor == "Deluxe") {
            Deluxe deluxePizza = new Deluxe();
            return deluxePizza;
        } else if (flavor == "Hawaiian") {
            Hawaiian hawaiianPizza = new Hawaiian();
            return hawaiianPizza;
        } else if (flavor == "Pepperoni") {
            Pepperoni pepperoniPizza = new Pepperoni();
            return pepperoniPizza;
        }
       return tempPizza;
    }
}