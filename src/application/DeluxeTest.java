package application;
import static org.junit.Assert.*;

public class DeluxeTest {
    /**
     * Test method for {@link Deluxe#price()}.
     * Testing a size small Deluxe
     */
    @org.junit.Test
    public void test_Deluxe_smallSizePrice() {
        Deluxe pizza = new Deluxe();
        pizza.setPizzaSize(Size.SMALL);
        assertTrue(pizza.price() == 12.99);
    }

    /**
     * Test method for {@link Deluxe#price()}.
     * Testing a size medium Deluxe
     */
    @org.junit.Test
    public void test_Deluxe_mediumSizePrice() {
        Deluxe pizza = new Deluxe();
        pizza.setPizzaSize(Size.MEDIUM);
        assertTrue(pizza.price() == 14.99);
    }

    /**
     * Test method for {@link Deluxe#price()}.
     * Testing a size large Deluxe
     */
    @org.junit.Test
    public void test_Deluxe_largeSizePrice() {
        Deluxe pizza = new Deluxe();
        pizza.setPizzaSize(Size.LARGE);
        assertTrue(pizza.price() == 16.990000000000002);
    }

    /**
     * Test method for {@link Deluxe#price()}.
     * Testing adding extra toppings to a small deluxe pizza
     */
    @org.junit.Test
    public void test_Deluxe_addToSmall() {
        Deluxe pizza = new Deluxe();
        pizza.setPizzaSize(Size.SMALL);
        pizza.addTopping(Topping.CHEESE);
        pizza.addTopping(Topping.MUSHROOMS);
        assertTrue(pizza.price() == 15.97);
    }

    /**
     * Test method for {@link Deluxe#price()}.
     * Testing adding extra toppings to a medium deluxe pizza
     */
    @org.junit.Test
    public void test_Deluxe_addToMedium() {
        Deluxe pizza = new Deluxe();
        pizza.setPizzaSize(Size.MEDIUM);
        pizza.addTopping(Topping.BEEF);
        assertTrue(pizza.price() == 16.48);
    }

    /**
     * Test method for {@link Deluxe#price()}.
     * Testing adding 3 extra toppings to a large deluxe pizza
     * Since there can only be a max of seven toppings, the last topping should not be added to the price
     */
    @org.junit.Test
    public void test_Deluxe_addToLarge() {
        Deluxe pizza = new Deluxe();
        pizza.setPizzaSize(Size.LARGE);
        pizza.addTopping(Topping.OLIVES);
        pizza.addTopping(Topping.PINEAPPLE);
        pizza.addTopping(Topping.PEPPERONI);
        assertTrue(pizza.price() == 19.970000000000002);
    }

    /**
     * Test method for {@link Deluxe#price()}.
     * Testing removing essential toppings to a small deluxe pizza
     * Price should not change
     */
    @org.junit.Test
    public void test_Deluxe_removeEssentialSmall() {
        Deluxe pizza = new Deluxe();
        pizza.setPizzaSize(Size.SMALL);
        pizza.removeTopping(Topping.CHEESE);
        assertTrue(pizza.price() == 12.99);
    }

    /**
     * Test method for {@link Deluxe#price()}.
     * Testing removing essential toppings to a medium deluxe pizza
     * Price should not change
     */
    @org.junit.Test
    public void test_Deluxe_removeEssentialMedium() {
        Deluxe pizza = new Deluxe();
        pizza.setPizzaSize(Size.MEDIUM);
        pizza.removeTopping(Topping.CHEESE);
        pizza.removeTopping(Topping.MUSHROOMS);
        assertTrue(pizza.price() == 14.99);
    }

    /**
     * Test method for {@link Deluxe#price()}.
     * Testing removing essential toppings to a medium deluxe pizza
     * Price should not change
     */
    @org.junit.Test
    public void test_Deluxe_removeEssentialLarge() {
        Deluxe pizza = new Deluxe();
        pizza.setPizzaSize(Size.LARGE);
        pizza.removeTopping(Topping.CHEESE);
        pizza.removeTopping(Topping.MUSHROOMS);
        pizza.removeTopping(Topping.SAUSAGE);
        pizza.removeTopping(Topping.HAM);
        assertTrue(pizza.price() == 16.990000000000002);
    }

    /**
     * Test method for {@link Deluxe#price()}.
     * Testing adding toppings then removing to a small deluxe
     */
    @org.junit.Test
    public void test_Deluxe_addAndRemoveSmall() {
        Deluxe pizza = new Deluxe();
        pizza.setPizzaSize(Size.SMALL);
        pizza.addTopping(Topping.BEEF);
        assertTrue(pizza.price() == 14.48);
        pizza.removeTopping(Topping.BEEF);
        assertTrue(pizza.price() == 12.99);
    }

    /**
     * Test method for {@link Deluxe#price()}.
     * Testing adding toppings then removing to a medium deluxe
     */
    @org.junit.Test
    public void test_Deluxe_addAndRemoveMedium() {
        Deluxe pizza = new Deluxe();
        pizza.setPizzaSize(Size.MEDIUM);
        pizza.addTopping(Topping.BEEF);
        pizza.addTopping(Topping.PINEAPPLE);
        assertTrue(pizza.price() == 17.97);
        pizza.removeTopping(Topping.BEEF);
        assertTrue(pizza.price() == 16.48);
    }

    /**
     * Test method for {@link Deluxe#price()}.
     * Testing adding toppings then removing to a medlargeium deluxe
     */
    @org.junit.Test
    public void test_Deluxe_addAndRemoveLarge() {
        Deluxe pizza = new Deluxe();
        pizza.setPizzaSize(Size.LARGE);
        pizza.addTopping(Topping.BEEF);
        assertTrue(pizza.price() == 18.48);
        pizza.removeTopping(Topping.BEEF);
        pizza.removeTopping(Topping.CHEESE);
        assertTrue(pizza.price() == 16.990000000000002);
    }
}