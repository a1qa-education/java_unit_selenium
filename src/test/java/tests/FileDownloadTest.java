package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileDownloadTest extends BaseTest {

    private final String fileName = "Test.txt";
    private final By fileDownload = By.xpath(String.format(PRECISE_TEXT_XPATH, "File Download"));
    private final By fileNameXpath = By.xpath(String.format(PRECISE_TEXT_XPATH, fileName));

    // Change this path to your browser's download folder
    private final String downloadPath = System.getProperty("user.home") + "/Downloads/";

    @Test
    public void fileDownloadTest() throws InterruptedException {
        driver.findElement(fileDownload).click();
        Assert.assertTrue(driver.findElement(fileNameXpath).isDisplayed(), "File link is not displayed");

        // Click to download
        driver.findElement(fileNameXpath).click();

        // Wait a few seconds for the file to download
        Thread.sleep(3000);

        // Assert file exists in download folder
        File downloadedFile = new File(downloadPath + fileName);
        Assert.assertTrue(downloadedFile.exists(), "File was not downloaded");

        // Delete file after test
        if (downloadedFile.exists()) {
            boolean deleted = downloadedFile.delete();
            System.out.println("File deleted after test: " + deleted);
        }
    }
}