package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.Assert;

public class DynamicControlsTest extends BaseTest {
    private final By dynamicControls = By.xpath(String.format(PRECISE_TEXT_XPATH, "Dynamic Controls"));
    private final By enable = By.xpath(String.format(PRECISE_TEXT_XPATH, "Enable"));
    private final By message = By.id("message");
    private final By inputField = By.cssSelector("input[type='text']");

    public DynamicControlsTest() {
        super();
    }

    @Test
    public void dynamicControlsTest() {
        driver.findElement(dynamicControls).click();
        driver.findElement(enable).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(message));
        Assert.assertEquals(driver.findElement(message).getText(), "It's enabled!", "Input is not enabled");
        WebElement input = driver.findElement(inputField);
        Assert.assertTrue(input.isEnabled(), "Input is not enabled");
        input.sendKeys("Random generated text");
        Assert.assertEquals(input.getAttribute("value"), "Random generated text", "Inputted text is not as expected");
    }
}
