package application;

/**
 * Java interface to be implemented by Pizza and its subclasses
 * @author
 */
public interface Customizable {

    /**
     * Method to add an item
     * @param obj to add
     * @return true if added, false otherwise
     */
    boolean add(Object obj);

    /**
     * Method to remove an item
     * @param obj to remove
     * @return true if removed, false otherwise
     */
    boolean remove(Object obj);
}