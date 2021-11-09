package application;

import java.util.ArrayList;

/**
 * This class creates an object for a new pizza
 * @author Daniel Flts, Alyssa Santos
 */
public abstract class Pizza {
    protected ArrayList<Topping> toppings = new ArrayList<Topping>();
    protected Size size;

    final static int maxToppings = 7;
    final static double sizeIncrease = 2;
    final static double additionalTopping = 1.49;
    /**
     * Abstract method implemented in its subclasses to return the price of a pizza
     * @return price of pizza
     */
    public abstract double price();

    /**
     * Getter method to set number of toppings
     * @return number of toppings
     */
    public int getNumberOfToppings() {
        return this.toppings.size();
    }
}