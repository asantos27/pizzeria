package application;

import java.util.ArrayList;

/**
 * This class keeps the list of orders placed by the user
 * @author Daniel Flts, Alyssa Santos
 */
public class StoreOrders implements Customizable {

    public ArrayList<Order> storeOrderList = new ArrayList<Order>();

    /**
     * Method to add order
     * @param order to add
     * @return true if added, false otherwise
     */
    @Override
    public boolean add(Object obj) {
        Order order = (Order) obj;
        this.storeOrderList.add(order);
        return true;
    }

    /**
     * Method to remove order
     * @param order to remove
     * @return true if removed, false otherwise
     */
    @Override
    public boolean remove(Object obj) {
        if (storeOrderList.size() <= 0) {
            return false;
        }

        Order order = (Order) obj;
        storeOrderList.remove(order);
        return true;
    }



    //export() method
}
