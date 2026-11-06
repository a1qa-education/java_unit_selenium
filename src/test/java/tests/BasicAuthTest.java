package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAuthTest extends BaseTest {
    private final By BASIC_AUTH = By.linkText("Basic Auth");
    private final By SUCCESS_AUTH = By.xpath("//p[contains(text(), 'Congratulations')]");

    //todo: add basic auth

    @Test
    public void basicAuthTest() {
        driver.findElement(BASIC_AUTH).click();
        Assert.assertTrue(driver.findElement(SUCCESS_AUTH).isDisplayed(), "Message is not displayed");
    }
}
