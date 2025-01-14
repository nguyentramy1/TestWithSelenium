package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageSearch {
    WebDriver driver;

    private By inventoryContainer = By.className("inventory_container");
    private By productItem = By.className("inventory_item");

    public PageSearch(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductListDisplayed() {
        WebElement inventory = driver.findElement(inventoryContainer);
        return inventory.isDisplayed();
    }

    public boolean isProductDisplayed() {
        WebElement product = driver.findElement(productItem);
        return product.isDisplayed();
    }
}
