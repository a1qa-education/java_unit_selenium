package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest extends BaseTest {

    private final By fileUpload = By.xpath(String.format(PRECISE_TEXT_XPATH, "File Upload"));

    @Test
    public void fileUploadTest() {
        driver.findElement(fileUpload).click();

        String filePath = System.getProperty("user.dir") + "/src/test/resources/file.json";
        File fileToUpload = new File(filePath);

        if (!fileToUpload.exists()) {
            throw new RuntimeException("File not found: " + filePath);
        }

        WebElement uploadInput = driver.findElement(By.cssSelector("input[type='file']"));
        uploadInput.sendKeys(fileToUpload.getAbsolutePath());

        // assert the uploaded file name appears
        WebElement uploadedFile = driver.findElement(By.id("uploaded-files")); // adjust locator
        Assert.assertTrue(uploadedFile.getText().contains(fileToUpload.getName()), "File is not uploaded");
    }
}