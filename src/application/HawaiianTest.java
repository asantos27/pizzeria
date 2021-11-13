package application;
import static org.junit.Assert.*;

public class HawaiianTest {
    /**
     * Test method for {@link Hawaiian#price()}.
     */
    @org.junit.Test
    public void test_Hawaiian_price() {
        Hawaiian pizza = new Hawaiian();
        pizza.setPizzaSize(Size.LARGE);
        assertTrue(pizza.price() == 14.99);
    }

    /**
     * Test method for {@link Hawaiian#price()}.
     */
    @org.junit.Test
    public void test_Hawaiian_add() {
        Hawaiian pizza = new Hawaiian();
        pizza.setPizzaSize(Size.MEDIUM);
        pizza.addTopping(Topping.CHEESE);
        pizza.addTopping(Topping.MUSHROOMS);
        //System.out.println(pizza.price());
        assertTrue(pizza.price() == 15.97);
    }

    /**
     * Test method for {@link Hawaiian#price()}.
     */
    @org.junit.Test
    public void test_Hawaiian_remove() {
        Hawaiian pizza = new Hawaiian();
        pizza.setPizzaSize(Size.LARGE);
        pizza.removeTopping(Topping.HAM);
        pizza.removeTopping(Topping.PINEAPPLE);
        assertTrue(pizza.price() == 14.99);
    }


}