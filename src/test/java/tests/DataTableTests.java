package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class DataTableTests extends BaseTest {

    private final By sortableDataTables = By.xpath("//*[text()='Sortable Data Tables']");
    private final By tableRows = By.cssSelector("#table1 tbody tr"); // adjust selector for your table
    private final double expectedSum = 100.0; // replace with actual expected sum

    @Test
    public void dataTableTest() {
        driver.findElement(sortableDataTables).click();

        List<WebElement> rows = driver.findElements(tableRows);
        double sum = 0;

        for (WebElement row : rows) {
            String dueText = row.findElement(By.xpath("td[4]")).getText(); // 4th column = Due
            dueText = dueText.replace("$", "").trim();
            sum += Double.parseDouble(dueText);
        }

        Assert.assertEquals(sum, expectedSum, 0.01, "Sum of due column is incorrect");
    }
}