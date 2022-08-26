package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage {

    private WebDriver driver;
    private By productsPageTitle = By.className("title");
    private By productImage = By.cssSelector("#item_5_img_link > img");
    private By productName = By.cssSelector("#item_1_title_link > .inventory_item_name");
    private By productDescription = By.cssSelector("#item_1_title_link + .inventory_item_desc");
    private By cart = By.className("shopping_cart_link");
    private By addToCartButton = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By sortButton = By.className("product_sort_container");
    private By priceLowToHigh = By.cssSelector(".product_sort_container option[value=\"lohi\"]");
    private By priceArray = By.className("inventory_item_price");



    public ProductsPage(WebDriver driver){
        this.driver = driver;
    }

    public String getProductsPageTitle() { return driver.findElement(productsPageTitle).getText();}

    public ProductDetailsPage clickOnProductImage(){
        driver.findElement(productImage).click();
        return new ProductDetailsPage(driver);
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }

    public String getProductDescription(){
        return driver.findElement(productDescription).getText();
    }

    public void addToCart(){
            driver.findElement(addToCartButton).click();
    }

    public CartPage goToCart(){
        driver.findElement(cart).click();
        return new CartPage(driver);
    }

    public String getProductsPageURL(){
        return driver.getCurrentUrl();
    }

    public void sortByPriceAscending(){
        driver.findElement(sortButton).click();
        driver.findElement(priceLowToHigh).click();
    }

    public void getPricesArray(){
        List<WebElement> prices = driver.findElements(priceArray);
        System.out.println(prices.size());
        for(int i=0;i<prices.size();i++){
            System.out.println(prices.get(i).getText());
        }
    }

    public double[] remove$sign() {
        List<WebElement> prices = driver.findElements(priceArray);
        String numberString;
        double[] newArray = new double[prices.size()];
        for(int i=0;i<prices.size();i++){
            numberString = prices.get(i).getText();
            String output = numberString.replace("$", "").replace(",", "");
            System.out.println(output);
            double stringToDouble = Double.parseDouble(output);
            newArray[i] = stringToDouble;
        }
        return newArray;

    }

    public boolean validateOrder(double[] amountsArray){
        double current;
        double previous;
        boolean ordered = false;
        for(int i=1;i<amountsArray.length;i++){
            current = amountsArray[i];
            previous = amountsArray[i-1];
            if (current >= previous){
                ordered = true;
            }
            else {
                ordered = false;
                break;
            }
        }
        return ordered;
    }

}
