package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By failedLoginMessage = By.cssSelector("h3[data-test=\"error\"]");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public ProductsPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new ProductsPage(driver);
    }

    public ProductsPage completeLogin(String username, String password){
        enterUsername(username);
        enterPassword(password);
        return clickLoginButton();
    }

    public String getLoginErrorMessage(){
        return driver.findElement(failedLoginMessage).getText();
    }

    public String getLoginPageTitle(){
        return driver.findElement(loginButton).getAttribute("value");
    }

    public String getLoginPageURL(){
        return driver.getCurrentUrl();
    }

}
