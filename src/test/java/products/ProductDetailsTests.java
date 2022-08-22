package products;

import base.BaseTests;
import login.LoginTests;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.ProductsPage;

import static org.testng.Assert.assertTrue;

public class ProductsTests extends BaseTests {

    private String productName = "Sauce Labs Fleece Jacket";
    private String productDescription = "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.";
    private String productPrice = "$49.99";
    private String userName = "standard_user";
    private String password = "secret_sauce";

    @Test
    public void testProductInformation(){
        ProductsPage productsPage = loginPage.completeLogin(userName, password);
        ProductDetailsPage productDetailsPage = productsPage.clickOnProductImage();
        assertTrue(productDetailsPage.getProductName().equals(productName), "Product Name is incorrect");
        assertTrue(productDetailsPage.getProductDescription().equals(productDescription), "Product Description is incorrect");
        assertTrue(productDetailsPage.getProductPrice().equals(productPrice), "Product Price is incorrect");
    }


}
