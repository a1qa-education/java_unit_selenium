package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DataTableTests extends BaseTest {
    private final By sortableDataTables = By.xpath(String.format(PRECISE_TEXT_XPATH, "Sortable Data Tables"));

    @Test
    public void dataTableTest() {
        driver.findElement(sortableDataTables).click();
        // todo: assert due sum
    }
}
