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
    private final By description = By.id("description");
    private final By addToCartButton = By.xpath("//button[@data-test='add-to-cart']");
    private final By successMessage = By.cssSelector("div.toast-success");
    private final By cartQuantity = By.xpath("//*[@data-test='cart-quantity']");
    private final By productPriceLocator = By.xpath("//*[@data-test='product-price']");
    private final By linePriceLocator = By.xpath("//*[@data-test='line-price']");
    private final By productQuantity = By.xpath("//*[@data-test='product-quantity']");
    
    public EcommerceFilterSortCartTest() {
        super();
    }

    @Test
    public void testFilterSortAddToCartAndCartCalculation() {
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

        driver.findElement(card).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(description));
        Assert.assertTrue(driver.findElement(description).isDisplayed(),"The product description is not visible.");

        boolean exists = !driver.findElements(cartQuantity).isEmpty();
        String initialQuantityText = exists ? driver.findElement(cartQuantity).getText() : "0";
        driver.findElement(addToCartButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(successMessage));
        Assert.assertTrue(driver.findElement(successMessage).getText() != null, "The success message is not visible.");

        int initialQuantity = Integer.parseInt(initialQuantityText);
        WebElement updatedCartQuantityElement = wait.until(ExpectedConditions.presenceOfElementLocated(cartQuantity));
        int updatedQuantity = Integer.parseInt(updatedCartQuantityElement.getText());
        Assert.assertTrue(updatedQuantity > initialQuantity, "The cart quantity did not increase after adding the product.");

        updatedCartQuantityElement.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(productPriceLocator));
        WebElement productQuantityElement = driver.findElement(productQuantity);
        double productPrice = Double.parseDouble(driver.findElement(productPriceLocator).getText().replace("$", "").trim());
        String oldLinePrice = driver.findElement(linePriceLocator).getText();
        productQuantityElement.clear();
        productQuantityElement.sendKeys("3");
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(linePriceLocator, oldLinePrice)));
        int count = Integer.parseInt(productQuantityElement.getAttribute("value"));
        double linePrice = Double.parseDouble(driver.findElement(linePriceLocator).getText().replace("$", "").trim());
        Assert.assertEquals(Math.round(linePrice * 100), Math.round(productPrice * 100 * count), "The line price does not match the expected value after updating the quantity.");
    }
}
