package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUploadTest extends BaseTest {
    private final By FILE_UPLOAD = By.linkText("File Upload");
    private final String FILE_NAME = "file.json";
    private final Path fileToUpload = Paths.get(ABSOLUTE_RESOURCE_PATH, FILE_NAME);

    @Test
    public void fileUploadTest() {
        driver.findElement(FILE_UPLOAD).click();
        // todo: upload the file
        // todo: assert file is uploaded
    }
}
