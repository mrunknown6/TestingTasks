package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.TableRowTest;

import java.util.List;

public class TableRowPage {

    @Step("Navigate to challenging DOM page")
    public static void navigate(WebDriver driver) {
        driver.navigate().to(TableRowTest.URL);
        driver.findElement(By.linkText("Challenging DOM")).click();
    }

    @Step("Get table row items")
    public static List<WebElement> getRowItems(WebDriver driver) {
        List<WebElement> elements = driver.findElements(By.tagName("tr")).get(1).findElements(By.tagName("td"));
        elements.remove(elements.size() - 1);
        return elements;
    }
}
