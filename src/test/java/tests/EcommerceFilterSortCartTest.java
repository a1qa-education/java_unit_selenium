package tests;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EcommerceFilterSortCartTest extends BaseTest {

    private final By checkbox = By.xpath("//label[contains(., 'MightyCraft')]/input");
    private final By sort = By.xpath("//select[@class='form-select']");
    private final By card = By.cssSelector("a.card");
    private final By price = By.xpath(String.format(PARTICULAR_TEXT_XPATH, "$"));
    
    public EcommerceFilterSortCartTest() {
        super();
    }

    @Test
    public void testFilterSortCart() {
        wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
        Select sortDropdown = new Select(driver.findElement(sort));
        WebElement firstCard = driver.findElement(card);
        sortDropdown.selectByVisibleText("Price (Low - High)");
        wait.until(ExpectedConditions.stalenessOf(firstCard));
        List<WebElement> cards = driver.findElements(card);
        List<Double> actualPrices = cards.stream()
                .map(card -> {
                    String priceText = card.findElement(price).getText().replace("$", "").trim();
                    return Double.parseDouble(priceText);
                })
                .collect(Collectors.toList());
        List<Double> sortedPrices = actualPrices.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(actualPrices, sortedPrices, "The prices are not sorted correctly.");
    }
}
