package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import tests.FileUploadTest;

import java.io.File;

public class FileUploadPage {

    @Step("Navigate to file upload page")
    public static void navigate(WebDriver driver) {
        driver.navigate().to(FileUploadTest.URL);
        driver.findElement(By.linkText("File Upload")).click();
    }


    @Step("Upload a file")
    public static void uploadFile(WebDriver driver) {
        driver.findElement(By.id("file-upload")).sendKeys(new File("").getAbsolutePath() + "\\src\\main\\java\\files\\empty.txt");
        driver.findElement(By.id("file-submit")).submit();
    }

    @Step("Get the response h3 tag")
    public static String getH3TagText(WebDriver driver) {
        return driver.findElement(By.tagName("h3")).getText();
    }
}
