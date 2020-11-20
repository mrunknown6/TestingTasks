package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import pages.MenuHoverPage;

import static org.junit.Assert.assertNotEquals;

public class MenuHoverTest {

    private static WebDriver driver;
    public final static String URL = "http://the-internet.herokuapp.com/";

    @BeforeClass
    public static void initDriver() {
        System.setProperty("webdriver.gecko.driver", "src\\main\\java\\files\\geckodriver.exe");
        FirefoxOptions capabilities = new FirefoxOptions();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);
    }

    @AfterClass
    public static void closeDriver() {
        driver.close();
    }

    @Test
    public void checkMenuHover() {
        MenuHoverPage.navigate(driver);
        WebElement element = MenuHoverPage.getAnchorTag(driver);

        int width = element.getSize().getWidth();

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

        int newWidth = MenuHoverPage.getAnchorTag(driver).getSize().getWidth();

        assertNotEquals(width, newWidth);
    }
}
