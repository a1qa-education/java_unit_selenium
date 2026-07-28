package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import org.testng.Assert;

public class AlertTest extends BaseTest {
    private final By jsAlert = By.xpath(String.format(PRECISE_TEXT_XPATH, "JavaScript Alerts"));
    private final By clickForJsAlertButton = By.xpath("//button[@onclick='jsAlert()']");
    private final By locatorToSuccessMessage = By.id("result");

    public AlertTest() {
        super();
    }

    @Test
    public void alertTest() {
        driver.findElement(jsAlert).click();
        driver.findElement(clickForJsAlertButton).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String message = driver.findElement(locatorToSuccessMessage).getText();
        Assert.assertEquals(message, "You successfully clicked an alert", "Alert message is not as expected");
    }
}
