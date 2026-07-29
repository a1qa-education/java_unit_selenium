package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class EcommerceFilterSortCartTest extends BaseTest {

    private final By checkbox = By.xpath("//label[contains(text(), 'MightyCraft')]/input");
    private final By sort = By.xpath("//select[@class='form-select']");
    
    public EcommerceFilterSortCartTest() {
        super();
    }

    @Test
    public void testFilterSortCart() {
        wait.until(ExpectedConditions.elementToBeClickable(checkbox));
        driver.findElement(checkbox).click();
        Select sortDropdown = new Select(driver.findElement(sort));
        sortDropdown.selectByVisibleText("Price (Low - High)");
    }
}
