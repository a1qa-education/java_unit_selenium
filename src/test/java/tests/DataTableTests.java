package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DataTableTests extends BaseTest {
    private final By SORTABLE_DATA_TABLES = By.linkText("Sortable Data Tables");

    @Test
    public void dataTableTest() {
        driver.findElement(SORTABLE_DATA_TABLES).click();
        // todo: assert due sum
    }
}
