package products;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ProductsPage;

import static org.testng.Assert.assertTrue;

public class ProductsPageTest extends BaseTests {

    @Test
    public void testAddToCart(){
        ProductsPage productsPage = loginPage.completeLogin(username, password);
        System.out.println(productsPage.getProductName());
        System.out.println(productsPage.getProductDescription());
    }

    @Test
    public void validateProductsPageInfo(){
        ProductsPage productsPage = loginPage.completeLogin(username, password);
        System.out.println("Page Title: " + productsPage.getProductsPageTitle());
        System.out.println("URL: " + productsPage.getProductsPageURL());
    }

    @Test
    public void sortProductsByPriceAscending()  {
        ProductsPage productsPage = loginPage.completeLogin(username, password);
        //productsPage.getPricesArray();
        productsPage.sortByPriceAscending();
        //productsPage.getPricesArray();
        double[] arrayNo$sign = productsPage.remove$sign();
        assertTrue(productsPage.validateOrder(arrayNo$sign));

    }
}
