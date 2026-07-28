package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import org.testng.Assert;

public class DataTableTests extends BaseTest {
    private final By sortableDataTables = By.xpath(String.format(PRECISE_TEXT_XPATH, "Sortable Data Tables"));
    private final By table1 = By.id("table1");

    public DataTableTests() {
        super();
    }

    @Test
    public void dataTableTest() {
        driver.findElement(sortableDataTables).click();
        WebElement table = driver.findElement(table1);
        List<WebElement> rows = table.findElements(By.cssSelector("tbody tr"));
        double sum = rows.stream()
                .mapToDouble(row -> {
                    String text = row.findElement(By.cssSelector("td:nth-child(4)")).getText();
                    return Double.parseDouble(text.replace("$", "").trim());
                })
                .sum();
        Assert.assertEquals(sum, 251.00, "Sum of due amounts is not as expected");
    }
}
