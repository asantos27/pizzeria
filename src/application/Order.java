package application;
import java.util.ArrayList;

/**
 * This class creates a new pizza order
 * An instance of this class has a unique phone number
 * @author Daniel Flts, Alyssa Santos
 */
public class Order implements Customizable{
    public static int phoneNumber;
    public ArrayList<Pizza> orderList = new ArrayList<Pizza>();

    private double subtotal = 0;
    private double salesTax = 0;
    private double orderTotal = 0;

    /**
     * Method to add pizza
     * @param pizza to add
     * @return true if added, false otherwise
     */
    @Override
    public boolean add(Object obj) {
        Pizza pizza = (Pizza) obj;
        orderList.add(pizza);
        return true;
    }

    /**
     * Method to remove pizza
     * @param pizza to remove
     * @return true if removed, false otherwise
     */
    @Override
    public boolean remove(Object obj) {
        if (orderList.size() <= 0) {
            return false;
        }

        Pizza pizza = (Pizza) obj;
        orderList.remove(pizza);
        return true;
    }

    /**
     * Method to clear order list
     */
    public void clearList() {
        orderList.clear();
        subtotal = 0;
        salesTax = 0;
        orderTotal = 0;
    }

    /**
     * Getter method to get the list of orders
     * @return list of orders
     */
    public ArrayList getOrderList() {
        return orderList;
    }

    /**
     * Setter method to set the subtotal
     * @param subtotal of pizza
     */
    public void setSubTotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * Getter method to get the subtotal
     * @return subtotal
     */
    public double getSubtotal() {
        return this.subtotal;
    }

    /**
     * Setter method to calculate sales tax
     */
    public void calculateSalesTax() {
        this.salesTax = this.subtotal * 0.0625;
    }

    /**
     * Getter method to get sales tax
     * @return sales tax
     */
    public double salesTax() {
        return this.salesTax;
    }

    /**
     * Setter method to calculate order total
     */
    public void calculateOrderTotal() {
        this.orderTotal = this.subtotal + this.salesTax;
    }

    /**
     * Getter method to get order total
     * @return order total
     */
    public double getOrderTotal() {
        return this.orderTotal;
    }

}
