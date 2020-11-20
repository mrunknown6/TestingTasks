package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.ImageClickPage;

import static org.junit.Assert.assertNotEquals;

public class ImageClickTest {

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
    public void checkImageClick() {
        ImageClickPage.navigate(driver);
        String marginLeft = ImageClickPage.getImageMargin(driver);
        ImageClickPage.clickAnchorTag(driver);

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String newMarginLeft = ImageClickPage.getImageMargin(driver);

        assertNotEquals(marginLeft, newMarginLeft);
    }
}
