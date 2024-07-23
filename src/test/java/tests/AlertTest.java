package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {
    private final By jsAlert = By.xpath(String.format(PRECISE_TEXT_XPATH, "JavaScript Alerts"));
    private final By clickForJsAlertButton = By.xpath("//button[@onclick='jsAlert()']");

    @Test
    public void alertTest() {
        driver.findElement(jsAlert).click();
        driver.findElement(clickForJsAlertButton).click();
        // todo: accept alert
        // todo: assert success message
    }
}
