package application;
import static org.junit.Assert.*;

public class PepperoniTest {
    /**
     * Test method for {@link Pepperoni#price()}.
     */
    @org.junit.Test
    public void test_Pepperoni_price() {
        Pepperoni pizza = new Pepperoni();
        pizza.setPizzaSize(Size.SMALL);
        assertTrue(pizza.price() == 8.99);
    }

    /**
     * Test method for {@link Pepperoni#price()}.
     */
    @org.junit.Test
    public void test_Pepperoni_add() {
        Pepperoni pizza = new Pepperoni();
        pizza.setPizzaSize(Size.MEDIUM);
        pizza.addTopping(Topping.CHEESE);
        pizza.addTopping(Topping.MUSHROOMS);
        assertTrue(pizza.price() == 13.97);
    }

    /**
     * Test method for {@link Pepperoni#price()}.
     */
    @org.junit.Test
    public void test_Pepperoni_remove() {
        Pepperoni pizza = new Pepperoni();
        pizza.setPizzaSize(Size.LARGE);
        pizza.removeTopping(Topping.PEPPERONI);
        assertTrue(pizza.price() == 12.99);
    }


}