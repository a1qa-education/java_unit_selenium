package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.Assert;

public class MultipleWindowsTest extends BaseTest {
    private final By MULTIPLE_WINDOWS_LINK_LOC = By.xpath(String.format(PRECISE_TEXT_XPATH, "Multiple Windows"));
    private final By CLICK_HERE_LINK_LOC = By.xpath(String.format(PRECISE_TEXT_XPATH, "Click Here"));
    private final By NEW_WINDOW_TEXT = By.xpath("//h3[text()='New Window']");

    public MultipleWindowsTest() {
        super();
    }

    @Test
    public void multipleWindowsTest() {
        driver.findElement(MULTIPLE_WINDOWS_LINK_LOC).click();

        String originalWindowHandle = driver.getWindowHandle();

        driver.findElement(CLICK_HERE_LINK_LOC).click();

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(NEW_WINDOW_TEXT));
        Assert.assertTrue(driver.findElement(NEW_WINDOW_TEXT).isDisplayed(), "New window text is not displayed");
    }
}
