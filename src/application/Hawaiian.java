package application;

import java.text.DecimalFormat;
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
        for (Topping t: getDefaultToppings()) {
            this.addTopping(t);
        }
    }

    /**
     * Getter method to get default toppings for a hawaiian pizza
     * @return defaault toppings for hawaiian
     */
    @Override
    public ArrayList<Topping> getDefaultToppings() {
        ArrayList<Topping> defaultToppings = new ArrayList<Topping>();
        defaultToppings.add(Topping.HAM);
        defaultToppings.add(Topping.PINEAPPLE);
        return defaultToppings;
    }

    /**
     * Getter method to get remaining toppings for a deluxe pizza
     * @return remaining toppings for ddeluxe
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
     * Calculates the price of a hawaiian pizza
     * @return price of a hawaiian pizza
     */
    @Override
    public double price() {
        return pizzaPrice + this.getSizePrice() + Math.max(0, toppings.size() - defaultTopping) * additionalTopping;
    }

    /**
     * Getter method to get the string value of the pizza's price
     * @return string of pizza's price
     */
    @Override
    public String getPizzaPrice() {
        DecimalFormat df = new DecimalFormat("###,##0.00");
        return df.format(this.price());
    }

    /**
     * Method that returns a hawaiian pizza order and its details
     * @return String: pizza, toppings, size, and extras
     */
    public String toString() {
        String toppingsList = toppings.toString().substring(1, toppings.toString().length() - 1);
        return "Hawaiian pizza, " + toppingsList + ", " + String.valueOf(this.getPizzaSize()) + ", $" + getPizzaPrice();
    }
}