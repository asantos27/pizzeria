package application;
import static org.junit.Assert.*;

public class DeluxeTest {
    /**
     * Test method for {@link Deluxe#price()}.
     */
    @org.junit.Test
    public void test_Deluxe_price() {
        Deluxe pizza = new Deluxe();
        pizza.setPizzaSize(Size.SMALL);
        assertTrue(pizza.price() == 12.99);
    }

    /**
     * Test method for {@link Deluxe#price()}.
     */
    @org.junit.Test
    public void test_Deluxe_add() {
        Deluxe pizza = new Deluxe();
        pizza.setPizzaSize(Size.MEDIUM);
        pizza.addTopping(Topping.CHEESE);
        pizza.addTopping(Topping.MUSHROOMS);
        assertTrue(pizza.price() == 17.97);
    }

    /**
     * Test method for {@link Pepperoni#price()}.
     */
    @org.junit.Test
    public void test_Pepperoni_remove() {
        Deluxe pizza = new Deluxe();
        pizza.setPizzaSize(Size.MEDIUM);
        pizza.removeTopping(Topping.SAUSAGE);
        System.out.println(pizza.toppings);
        pizza.addTopping(Topping.PINEAPPLE);
        System.out.println(pizza.toppings);
     //   pizza.addTopping(Topping.MUSHROOMS);
        System.out.println(pizza.price());
      //  assertTrue(pizza.price() == 14.99);
    }


}