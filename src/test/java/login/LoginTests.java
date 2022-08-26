package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ProductsPage;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test(groups = { "smoke" })
    public void testSuccessfulLogin(){
        System.out.println("Page Title: " + loginPage.getLoginPageTitle());
        System.out.println("URL: " + loginPage.getLoginPageURL());
        ProductsPage productsPage = loginPage.completeLogin(username, password);
        assertTrue(productsPage.getProductsPageTitle().equals("PRODUCTS"), "Text is incorrect");
    }

    @Test
    public void incorrectPasswordLogin(){
        loginPage.completeLogin(username, incorrectPassword);
        assertTrue(loginPage.getLoginErrorMessage().equals("Epic sadface: Username and password do not match any user in this service"), "Error Message is incorrect");
    }

    @Test
    public void incorrectUsernameLogin(){
        loginPage.completeLogin(incorrectUsername, password);
        assertTrue(loginPage.getLoginErrorMessage().equals("Epic sadface: Username and password do not match any user in this service"), "Error Message is incorrect");
    }

    @Test
    public void incorrectCredentials(){
        loginPage.completeLogin(incorrectUsername, incorrectPassword);
        assertTrue(loginPage.getLoginErrorMessage().equals("Epic sadface: Username and password do not match any user in this service"), "Error Message is incorrect");
    }



}
