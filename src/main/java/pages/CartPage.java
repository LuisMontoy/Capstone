package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    private By productName = By.id("item_1_title_link");
    private By productDescription = By.cssSelector("#item_1_title_link + .inventory_item_desc");
    private By productPrice = By.cssSelector("#item_1_title_link + .inventory_item_desc + .item_pricebar > .inventory_item_price");
    private By productQuantity = By.className("cart_quantity");
    private By cartTitle = By.cssSelector("#header_container  span[class=\"title\"] ");


    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }

    public String getProductDescription(){
        return driver.findElement(productDescription).getText();
    }

    public String getProductPrice(){
        return driver.findElement(productPrice).getText();
    }

    public String getQuantity(){
        return driver.findElement(productQuantity).getText();
    }

    public String getCartPageTitle(){
        return driver.findElement(cartTitle).getText();
    }

    public String getCartPageURL(){
        return driver.getCurrentUrl();
    }

}
