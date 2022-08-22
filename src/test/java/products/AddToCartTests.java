package products;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;

import static org.testng.Assert.assertTrue;

public class AddToCartTests extends BaseTests {

    @Test
    public void TestGoToCart(){
        ProductsPage productsPage = loginPage.completeLogin(username, password);
        productsPage.addToCart();

        String productsPageName = productsPage.getProductName();
        String productsPageDescription = productsPage.getProductDescription();

        CartPage cartPage = productsPage.goToCart();

        //Validates that the info from the products page is the same in the cart
        assertTrue(cartPage.getProductName().equals(productsPageName), "Product name does not match");
        assertTrue(cartPage.getProductDescription().equals(productsPageDescription), "Description does not match");
        assertTrue(cartPage.getQuantity().equals(quantity), "Quantity is not correct");

        System.out.println("Page Title: " + cartPage.getCartPageTitle());
        System.out.println("URL: " + cartPage.getCartPageURL());
        System.out.println("Product Name: " + cartPage.getProductName());
        System.out.println("Descripton: " + cartPage.getProductDescription());
        System.out.println("Price: " + cartPage.getProductPrice());
        System.out.println("Quantity: " + cartPage.getQuantity());

    }
}
