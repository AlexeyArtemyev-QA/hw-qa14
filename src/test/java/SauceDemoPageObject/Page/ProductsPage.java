package SauceDemoPageObject.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {
    private final static By PRICE_LOCATOR = By.cssSelector(".inventory_item_price");
    private final static By ADD_TO_CART_BUTTON = By.cssSelector("button[id^=add-to-cart-]");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void openProductDetails(String productName) {

    }

    public String getProductPrice(String productName) {
        WebElement itemContainer = getItemContainer(productName);
        return itemContainer.findElement(PRICE_LOCATOR).getText();
    }

    public void clickAddToCartButton(String productName) {
        WebElement itemContainer = getItemContainer(productName);
        itemContainer.findElement(ADD_TO_CART_BUTTON).click();
    }

    public String getProductDescription(String productName) {
        return null;

    }

    public int getProductsCount() {
        return 1;
    }

    private WebElement getItemContainer(String productName) {
        return driver.findElement(By.xpath("//div[contains(text(), '" + productName + "')]/ancestor::div[@class='inventory_item']"));
    }
}