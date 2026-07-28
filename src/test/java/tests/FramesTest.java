package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.Assert;

public class FramesTest extends BaseTest {
    private final By FRAMES_LINK_LOC = By.xpath(String.format(PRECISE_TEXT_XPATH, "Frames"));
    private final By NESTED_FRAMES_LINK_LOC = By.xpath(String.format(PRECISE_TEXT_XPATH, "Nested Frames"));

    public FramesTest() {
        super();
    }

    @Test
    public void nestedFramesTest() {
        driver.findElement(FRAMES_LINK_LOC).click();
        driver.findElement(NESTED_FRAMES_LINK_LOC).click();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        Assert.assertEquals(driver.findElement(By.tagName("body")).getText(), "LEFT", "Left frame text is not as expected");
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        Assert.assertEquals(driver.findElement(By.tagName("body")).getText(), "RIGHT", "Right frame text is not as expected");
    }
}
