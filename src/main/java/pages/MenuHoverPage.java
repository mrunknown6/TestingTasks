package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.MenuHoverTest;

public class MenuHoverPage {

    @Step("Navigate to menu page")
    public static void navigate(WebDriver driver) {
        driver.navigate().to(MenuHoverTest.URL);
        driver.findElement(By.linkText("Shifting Content")).click();
        driver.findElement(By.linkText("Example 1: Menu Element")).click();
    }

    @Step("Get \"Home\" anchor tag")
    public static WebElement getAnchorTag(WebDriver driver) {
        return driver.findElement(By.linkText("Home"));
    }
}
