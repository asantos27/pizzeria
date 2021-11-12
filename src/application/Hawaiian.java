package application;

import java.util.ArrayList;

/**
 * This class creates an object for a hawaiian pizza
 * @author Daniel Flts, Alyssa Santos
 */
public class Hawaiian extends Pizza {

    private double pizzaPrice = 10.99;
    private static int defaultTopping = 2;

    /**
     * Constructor for Hawaiian class
     */
    public Hawaiian() {
        super();
        this.addTopping(Topping.HAM);
        this.addTopping(Topping.PINEAPPLE);
    }

    /**
     * Calculates the price of a hawaiian pizza
     * @return price of a hawaiian pizza
     */
    @Override
    public double price() {
        pizzaPrice += this.getSizePrice() + Math.max(0, toppings.size() - defaultTopping) * additionalTopping;
        return pizzaPrice;
    }
}