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
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        ProductsPage productsPage = loginPage.clickLoginButton();
        assertTrue(productsPage.getProductsPageTitle().equals("PRODUCTS"), "Text is incorrect");
    }

    @Test
    public void unsuccessfulLogin(){
        loginPage.enterUsername(incorrectUsername);
        loginPage.enterPassword(incorrectPassword);
        loginPage.clickLoginButton();
        System.out.println(loginPage.getLoginErrorMessage());
        assertTrue(loginPage.getLoginErrorMessage().equals("Epic sadface: Username and password do not match any user in this service"), "Error Message is incorrect");
    }


}
