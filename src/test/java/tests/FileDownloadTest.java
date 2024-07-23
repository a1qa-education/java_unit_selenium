package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileDownloadTest extends BaseTest {
    private final String fileName = "Test.txt";
    private final By fileDownload = By.xpath(String.format(PRECISE_TEXT_XPATH, "File Download"));
    private final By fileNameXpath = By.xpath(String.format(PRECISE_TEXT_XPATH, fileName));

    @Test
    public void fileDownloadTest() {
        driver.findElement(fileDownload).click();
        Assert.assertTrue(driver.findElement(fileNameXpath).isDisplayed(), "File is not displayed");
        driver.findElement(fileNameXpath).click();
        // todo: assert file is downloaded
    }

    // todo: delete file
}
