package products;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.ProductsPage;

import static org.testng.Assert.assertTrue;

public class ProductDetailsTests extends BaseTests {



    @Test
    public void testProductInformation(){
        ProductsPage productsPage = loginPage.completeLogin(username, password);
        ProductDetailsPage productDetailsPage = productsPage.clickOnProductImage();
        assertTrue(productDetailsPage.getProductName().equals(productName), "Product Name is incorrect");
        assertTrue(productDetailsPage.getProductDescription().equals(productDescription), "Product Description is incorrect");
        assertTrue(productDetailsPage.getProductPrice().equals(productPrice), "Product Price is incorrect");
    }


}
