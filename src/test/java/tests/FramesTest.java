package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest {
    private final By FRAMES_LINK_LOC = By.linkText("Frames");
    private final By NESTED_FRAMES_LINK_LOC = By.linkText("Nested Frames");

    @Test
    public void nestedFramesTest() {
        driver.findElement(FRAMES_LINK_LOC).click();
        driver.findElement(NESTED_FRAMES_LINK_LOC).click();

        // Switch to Left Frame

        // Check Left frame text

        // Switch to Right Frame

        // Check Right frame text

    }
}
