package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class MultipleWindowsTest extends BaseTest {
    private final By MULTIPLE_WINDOWS_LINK_LOC = By.linkText("Multiple Windows");
    private final By CLICK_HERE_LINK_LOC = By.linkText("Click Here");

    @Test
    public void multipleWindowsTest() {
        driver.findElement(MULTIPLE_WINDOWS_LINK_LOC).click();

        driver.findElement(CLICK_HERE_LINK_LOC).click();

        // Switch to New Window and check new window text
    }
}
