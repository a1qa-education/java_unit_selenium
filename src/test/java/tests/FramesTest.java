package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class FramesTest extends BaseTest {
    private final String initText = "Your content goes here.";
    private final String textIsNotDisplayedMsg = "Text is not displayed";
    private final By frames = By.xpath(String.format(PRECISE_TEXT_XPATH, "Frames"));
    private final By iframe = By.xpath(String.format(PRECISE_TEXT_XPATH, "iFrame"));
    private final By edit = By.xpath(String.format(PRECISE_TEXT_XPATH, "Edit"));
    private final By undo = By.xpath(String.format(PRECISE_TEXT_XPATH, "Undo"));
    private final String randomText = UUID.randomUUID().toString();

    @Test
    public void iFrameTest() {
        driver.findElement(frames).click();
        driver.findElement(iframe).click();
        //todo: input text to the text field
        Assert.assertTrue(driver.findElement(By.xpath(String.format(PRECISE_TEXT_XPATH, initText + randomText))).isDisplayed(),
                textIsNotDisplayedMsg);
        driver.findElement(edit).click();
        driver.findElement(undo).click();
        // todo: assert text is not displayed
    }
}
