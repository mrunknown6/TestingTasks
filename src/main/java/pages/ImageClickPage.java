package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.ImageClickTest;

public class ImageClickPage {

    @Step("Navigate to image page")
    public static void navigate(WebDriver driver) {
        driver.navigate().to(ImageClickTest.URL);
        driver.findElement(By.linkText("Shifting Content")).click();
        driver.findElement(By.linkText("Example 2: An image")).click();
    }

    @Step("Get image margin")
    public static String getImageMargin(WebDriver driver) {
        return driver.findElement(By.className("shift")).getCssValue("left");
    }

    @Step("Click on \"click here\" anchor tag")
    public static void clickAnchorTag(WebDriver driver) {
        driver.findElements(By.linkText("click here")).get(1).click();
    }
}
