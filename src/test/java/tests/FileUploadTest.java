package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.io.File;

public class FileUploadTest extends BaseTest {
    private final String fileName = "file.json";
    private final String filePath =
        System.getProperty("user.dir")
        + File.separator
        + RELATIVE_RESOURCE_PATH
        + fileName;
    private final By fileUpload = By.xpath(String.format(PRECISE_TEXT_XPATH, "File Upload"));
    private final By fileInput = By.id("file-upload");
    private final By uploadButton = By.id("file-submit");
    private final By uploadedFile = By.xpath("//*[contains(text(),'Uploaded')]");

    public FileUploadTest() {
        super();
    }

    @Test
    public void fileUploadTest() {
        driver.findElement(fileUpload).click();
        File fileToUpload = new File(filePath);
        Assert.assertTrue(fileToUpload.exists(), "No file to upload");
        driver.findElement(fileInput).sendKeys(filePath);
        driver.findElement(uploadButton).click();
        Assert.assertTrue(driver.findElement(uploadedFile).isDisplayed(), "File is not uploaded");
    }
}
