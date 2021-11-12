package application;

import java.util.ArrayList;

/**
 * This class creates an object for a pepperoni pizza
 * @author Daniel Flts, Alyssa Santos
 */
public class Pepperoni extends Pizza {

    private double pizzaPrice = 8.99;
    private static int defaultTopping = 1;

    /**
     * Constructor for Pepperoni class
     */
    public Pepperoni() {
        super();
        this.addTopping(Topping.PEPPERONI);
    }

    /**
     * Calculates the price of a pepperoni pizza
     * @return price of a pepperoni pizza
     */
    @Override
    public double price() {
        pizzaPrice += this.getSizePrice() + Math.max(0, toppings.size() - defaultTopping) * additionalTopping;
        return pizzaPrice;
    }

}