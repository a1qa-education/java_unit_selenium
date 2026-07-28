package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAuthTest extends BaseTest {
    private final By successAuth = By.xpath(String.format(PARTICULAR_TEXT_XPATH,
            "Congratulations! You must have the proper credentials"));

    public BasicAuthTest() {
        super();
    }

    @Test
    public void basicAuthTest() {
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Assert.assertTrue(driver.findElement(successAuth).isDisplayed(), "Message is not displayed");
    }
}
