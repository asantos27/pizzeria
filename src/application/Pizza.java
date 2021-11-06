package application;

import java.util.ArrayList;

/**
 * This class creates an object for a new pizza
 * @author Daniel Flts, Alyssa Santos
 */
public abstract class Pizza {
    protected ArrayList<Topping> toppings = new ArrayList<Topping>();
    protected Size size;

    /**
     * Abstract method implemented in its subclasses to return the price of a pizza
     * @return price of pizza
     */
    public abstract double price();
}