package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest {
    private final By dynamicControls = By.xpath(String.format(PRECISE_TEXT_XPATH, "Dynamic Controls"));
    private final By enable = By.xpath(String.format(PRECISE_TEXT_XPATH, "Enable"));

    @Test
    public void dynamicControlsTest() {
        driver.findElement(dynamicControls).click();
        driver.findElement(enable).click();
        // todo: assert input is enabled
        // todo: input random generated text
        // todo: assert inputted text
    }
}
