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
        for (Topping t: getDefaultToppings()) {
            this.addTopping(t);
        }
    }

    /**
     * Getter method to get default toppings for a deluxe pizza
     * @return default toppings for deluxe
     */
    @Override
    public ArrayList<Topping> getDefaultToppings() {
        ArrayList<Topping> defaultToppings = new ArrayList<Topping>();
        defaultToppings.add(Topping.CHEESE);
        defaultToppings.add(Topping.HAM);
        defaultToppings.add(Topping.MUSHROOMS);
        defaultToppings.add(Topping.ONIONS);
        defaultToppings.add(Topping.SAUSAGE);
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
     * Calculates the price of a deluxe pizza
     * @return price of a deluxe pizza
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