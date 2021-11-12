package application;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This class creates an object for a deluxe pizza
 * @author Daniel Flts, Alyssa Santos
 */
public class Deluxe extends Pizza {

    private double pizzaPrice = 12.99;
    private static int defaultTopping = 5;

    /**
     * Constructor for Deluxe class
     */
    public Deluxe() {
        super();
        this.addTopping(Topping.CHEESE);
        this.addTopping(Topping.HAM);
        this.addTopping(Topping.MUSHROOMS);
        this.addTopping(Topping.ONIONS);
        this.addTopping(Topping.SAUSAGE);
    }

    /**
     * Calculates the price of a deluxe pizza
     * @return price of a deluxe pizza
     */
    @Override
    public double price() {
        pizzaPrice += this.getSizePrice() + Math.max(0, toppings.size() - defaultTopping) * additionalTopping;
        return pizzaPrice;
    }
}