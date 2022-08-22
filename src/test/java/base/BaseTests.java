package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import utils.WindowManager;
import utils.Data;

public class BaseTests extends Data{

    private WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        //System.setProperty("webdriver.safari.driver", "resources/safaridriver");
        //System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
        driver = new ChromeDriver();
        //driver = new SafariDriver();
        //driver = new FirefoxDriver();
        goHome();
        System.out.println(driver.getTitle());
        loginPage = new LoginPage(driver);
        System.out.println(username);
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://www.saucedemo.com");
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
