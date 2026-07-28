package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

public abstract class BaseTest {
    protected static final String URL = "https://the-internet.herokuapp.com/";
    protected static final int MAX_WAIT = 10;
    protected static final String PRECISE_TEXT_XPATH = "//*[text()='%s']";
    protected static final String PARTICULAR_TEXT_XPATH = "//*[contains(text(),'%s')]";
    protected static final String RELATIVE_RESOURCE_PATH = "src/test/resources/";
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        String downloadPath = System.getProperty("user.dir") + File.separator +  RELATIVE_RESOURCE_PATH.replace("/", File.separator);
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadPath);
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_WAIT));
        driver.get(URL);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
