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
     * Pizza constructor
     */
    public Pizza() {
    }

    /**
     * Pizza constructor
     */
    public void Pizza() {
    }

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

    /**
     * Setter method to set the size of pizza
     * @param size of pizza
     */
    public void setPizzaSize(Size size) {
        this.size = size;
    }

    /**
     * Getter method to set the size of pizza
     * @return size of pizza
     */
    public Size getPizzaSize() {
        return this.size;
    }

    /**
     * Getter method to get the default toppings of a pizza
     * @return array list of default toppings
     */
    public ArrayList<Topping> getDefaultToppings() {
        return new ArrayList<Topping>();
    }

    /**
     * Getter method to get the remaining toppings of a pizza
     * @return array list of remaining toppings
     */
    public ArrayList<Topping> getAllToppings() {
        return new ArrayList<Topping>();
    }

    /**
     * Getter method to get the string representation price of a pizza
     * @return string of pizza's price
     */
    public String getPizzaPrice() {
        return "";
    }



    /**
     * Getter method to get additional price of pizza per size increase
     * @return the increased price of pizza for each size
     */
    public double getSizePrice() {
        if (this.size == Size.MEDIUM) {
            return 2.00;
        } else if (this.size == Size.LARGE) {
            return 4.00;
        } else {
            return 0;
        }
    }


    /**
     * Adds toppings to pizza
     * @param toppings to be added
     */
    public boolean addTopping(Topping topping) {
        if (this.toppings.size() == maxToppings) {
            return false;
        } else {
            this.toppings.add(topping);
            return true;
        }
    }

    /**
     * Removes toppings to pizza
     * @param toppings to be removed
     */
    public boolean removeTopping(Topping topping) {
        for (int i = 0; i < toppings.size(); i++) {
            if (this.toppings.get(i) == topping) {
                this.toppings.remove(topping);
            }
        }
        return true;
    }

}