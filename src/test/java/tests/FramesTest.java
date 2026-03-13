package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FramesTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private final String URL = "https://the-internet.herokuapp.com/frames";
    private final int MAX_WAIT = 10;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_WAIT));
        driver.get(URL);
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void iFrameTest() {
        // Click on iFrame link
        WebElement iFrameLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("iFrame")));
        iFrameLink.click();

        // Wait for iframe to be present and switch to it
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mce_0_ifr")));
        driver.switchTo().frame(iframe);

        // Wait for body inside TinyMCE to be clickable
        WebElement body = wait.until(ExpectedConditions.elementToBeClickable(By.id("tinymce")));

        // Focus and type
        body.click(); // make sure it's focused
        body.clear(); // clear any existing text
        String text = "Hello Selenium!";
        body.sendKeys(text);

        // Assert text
        Assert.assertEquals(body.getText(), text, "Text inside TinyMCE did not match");

        // Switch back to main content
        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.findElement(By.tagName("h3")).isDisplayed(), "Main page header not visible");
    }
}