package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.UUID;

public class DynamicControlsTest extends BaseTest {

    private final By dynamicControls = By.xpath(String.format(PRECISE_TEXT_XPATH, "Dynamic Controls"));
    private final By enableButton = By.xpath(String.format(PRECISE_TEXT_XPATH, "Enable"));
    private final By inputField = By.cssSelector("input[type='text']"); // adjust if your locator is different

    @Test
    public void dynamicControlsTest() {
        driver.findElement(dynamicControls).click();
        driver.findElement(enableButton).click();

        // wait for input field to become enabled
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(inputField));

        WebElement input = driver.findElement(inputField);
        Assert.assertTrue(input.isEnabled(), "Input field is not enabled");

        // generate random text and input
        String randomText = UUID.randomUUID().toString();
        input.sendKeys(randomText);

        // assert inputted text
        Assert.assertEquals(input.getAttribute("value"), randomText, "Inputted text does not match");
    }
}