package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class AlertTest extends BaseTest {

    private final By jsAlert = By.xpath("//*[text()='JavaScript Alerts']");
    private final By clickForJsAlertButton = By.xpath("//button[@onclick='jsAlert()']");
    private final By resultText = By.id("result");   // <- must be here, class scope

    @Test
    public void alertTest() {
        driver.findElement(jsAlert).click();
        driver.findElement(clickForJsAlertButton).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();

        String message = driver.findElement(resultText).getText(); // ✅ now recognized
        Assert.assertTrue(message.contains("successfully clicked"), "Alert message mismatch");
    }
}