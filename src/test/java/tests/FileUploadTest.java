package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest extends BaseTest {
    private final String fileName = "file.json";
    private final String filePath = RELATIVE_RESOURCE_PATH + fileName;
    private final By fileUpload = By.xpath(String.format(PRECISE_TEXT_XPATH, "File Upload"));

    @Test
    public void fileUploadTest() {
        driver.findElement(fileUpload).click();
        File fileToUpload = new File(filePath);
        // todo: upload the file
        // todo: assert file is uploaded
    }
}
