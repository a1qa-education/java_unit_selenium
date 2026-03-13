package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAuthTest extends BaseTest {
    // Credentials
    private final String username = "admin";
    private final String password = "admin";

    // Locators
    private final By successAuth = By.xpath(String.format(PARTICULAR_TEXT_XPATH,
            "Congratulations! You must have the proper credentials"));

    @Test
    public void basicAuthTest() {
        // Inject credentials into URL
        String authUrl = "https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth";
        driver.get(authUrl);

        // Assert success message
        Assert.assertTrue(driver.findElement(successAuth).isDisplayed(), "Success message is not displayed");
    }
}