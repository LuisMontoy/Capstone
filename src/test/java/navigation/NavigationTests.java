package navigation;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;

public class NavigationTests extends BaseTests {

    @Test
    public void testNavigator(){
        System.out.println("Page Title: " + loginPage.getLoginPageTitle());
        System.out.println("URL: " + loginPage.getLoginPageURL());
        ProductsPage productsPage = loginPage.completeLogin(username, password);
        System.out.println("Page Title: " + productsPage.getProductsPageTitle());
        System.out.println("URL: " + productsPage.getProductsPageURL());
        CartPage cartPage = productsPage.goToCart();
        System.out.println("Page Title: " + cartPage.getCartPageTitle());
        System.out.println("URL: " + cartPage.getCartPageURL());
        getWindowManager().goBack();
        getWindowManager().goBack();
    }
}
