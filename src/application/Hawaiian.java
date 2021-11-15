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