package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.TableRowPage;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class TableRowTest {

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
    public void checkTableRow() {
        TableRowPage.navigate(driver);
        List<WebElement> elements = TableRowPage.getRowItems(driver);

        boolean endsWithZero = true;

        for (WebElement element: elements)
            if (element.getText().charAt(element.getText().length() - 1) != '0') {
                endsWithZero = false;
                break;
            }

        assertTrue(endsWithZero);
    }
}
