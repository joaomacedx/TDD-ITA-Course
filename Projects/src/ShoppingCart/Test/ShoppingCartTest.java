package ShoppingCart.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ShoppingCart.Implementations.Product;
import ShoppingCart.Implementations.ShoppingCart;
import ShoppingCart.Interfaces.ICartObserver;
import ShoppingCart.Mocks.MockCartObserver;
import ShoppingCart.Mocks.MockCartObserverWithProblem;

public class ShoppingCartTest {

    @Test
    public void checkTotalValue_suceeds_WHEN_valid_products_are_registered_THEN_returns_total_value_of_Products_in_the_Cart() {
        //Arrange
        Product productOne = new Product("tennis", 100);
        Product productTwo = new Product("T-shirt", 50);
        Product productThree = new Product("shorts", 70);
        List<Product> listProducts = new ArrayList<Product>();
        listProducts.add(productOne);
        listProducts.add(productTwo);
        listProducts.add(productThree);
        ShoppingCart cart = new ShoppingCart(listProducts);
        int expectedTotalValue = 220;

        //Act
        int actualTotalValue = cart.totalValueOfProductsInTheCart();

        //Assert
        assertEquals(expectedTotalValue, actualTotalValue);
    }
    @Test
    public void checkListenProductAddition_suceedes_WHEN_valid_products_are_registered_THEN_the_products_are_registered() {
        //Arrange
        List<Product> listProducts = new ArrayList<Product>();
        Product productToAdd= new Product("tennis", 100);
        ShoppingCart cart = new ShoppingCart(listProducts);
        MockCartObserver mock = new MockCartObserver();
        cart.addObserver(mock);
        cart.addProduct(productToAdd);

        //Act
        Boolean productIsAddedCorrectly = mock.checkProductAddition("tennis", 100);

        //Assert
        assertEquals(true, productIsAddedCorrectly);
    }
    @Test
    public void checkAddTwoObservers_suceedes_WHEN_valid_products_are_registered_THEN_two_observers_must_listen_product_was_added_correctly() {
         //Arrange
         List<Product> listProducts = new ArrayList<Product>();
         Product productToAdd= new Product("tennis", 100);
         ShoppingCart cart = new ShoppingCart(listProducts);
         MockCartObserver mockOne = new MockCartObserver();
         MockCartObserver mockTwo = new MockCartObserver();
         cart.addObserver(mockOne);
         cart.addObserver(mockTwo);
         cart.addProduct(productToAdd);
 
         //Act
         Boolean productIsAddedCorrectlyMockOneVerification = mockOne.checkProductAddition("tennis", 100);
         Boolean productIsAddedCorrectlyMockTwoVerification = mockTwo.checkProductAddition("tennis", 100);

         //Assert
         assertEquals(true, productIsAddedCorrectlyMockOneVerification);
         assertEquals(true, productIsAddedCorrectlyMockTwoVerification);
    }
    @Test
    public void checkObserverkeepsnotifying_WHEN_an_error_occurs_THEN_all_other_observers_must_continue_to_notify_product_was_added_correctly() {
         //Arrange
         List<Product> listProducts = new ArrayList<Product>();
         Product productToAdd= new Product("tennis", 100);
         ShoppingCart cart = new ShoppingCart(listProducts);
         MockCartObserver mockOne = new MockCartObserver();
         ICartObserver mockTwo = new MockCartObserverWithProblem();
         MockCartObserver mockThree = new MockCartObserver();
         cart.addObserver(mockOne);
         cart.addObserver(mockTwo);
         cart.addObserver(mockThree);
         cart.addProduct(productToAdd);
 
         //Act
         Boolean productIsAddedCorrectlyMockOneVerification = mockOne.checkProductAddition("tennis", 100);
         Boolean productIsAddedCorrectlyMockThreeVerification = mockThree.checkProductAddition("tennis", 100);

         //Assert
         assertEquals(true, productIsAddedCorrectlyMockOneVerification);
         assertEquals(true, productIsAddedCorrectlyMockThreeVerification);
    }
}
