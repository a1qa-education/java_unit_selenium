package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileDownloadTest extends BaseTest {
    // Make sure that the name of the file is present on the page before running the test
    private final String FILE_NAME = "some-file.txt";
    private final By FILE_DOWNLOAD = By.linkText("File Download");
    private final By FILE_NAME_XPATH = By.linkText(FILE_NAME);

    @Test
    public void fileDownloadTest() {
        driver.findElement(FILE_DOWNLOAD).click();
        Assert.assertTrue(driver.findElement(FILE_NAME_XPATH).isDisplayed(), "File is not displayed");
        driver.findElement(FILE_NAME_XPATH).click();
        // todo: assert file is downloaded
    }

    // todo: delete file
}
