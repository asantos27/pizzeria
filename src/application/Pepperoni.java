package application;

import java.text.DecimalFormat;
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
     * Getter method to get default toppings for a pepperoni pizzaa
     * @return default toppings for pepperoni
     */
    @Override
    public ArrayList<Topping> getDefaultToppings() {
        ArrayList<Topping> defaultToppings = new ArrayList<Topping>();
        defaultToppings.add(Topping.PEPPERONI);
        return defaultToppings;
    }

    /**
     * Getter method to get remaining toppings for a deluxe pizza
     * @return remaining toppings for deluxe
     */
    @Override
    public ArrayList<Topping> getAllToppings() {
        ArrayList<Topping> remainingToppings = new ArrayList<Topping>();
        for (Topping t: Topping.values()) {
            if (!(getDefaultToppings().contains(t))) {
                remainingToppings.add(t);
            }
        }
        return remainingToppings;
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

    /**
     * Getter method to get the string value of the pizza's price
     * @return string of pizza's price
     */
    @Override
    public String getPizzaPrice() {
        price();
        DecimalFormat df = new DecimalFormat("###,##0.00");
        return df.format(pizzaPrice);
    }

}