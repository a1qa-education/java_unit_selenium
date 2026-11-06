package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest {
    private final By DYNAMIC_CONTROL = By.linkText("Dynamic Controls");
    private final By ENABLE = By.xpath("//form[@id='input-example']/button");

    @Test
    public void dynamicControlsTest() {
        driver.findElement(DYNAMIC_CONTROL).click();
        driver.findElement(ENABLE).click();
        // todo: assert input is enabled
        // todo: input random generated text
        // todo: assert inputted text
    }
}
