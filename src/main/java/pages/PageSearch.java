package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageSearch {
    WebDriver driver;

    private By inventoryContainer = By.className("inventory_container");
    private By productItem = By.className("inventory_item");
    private By logoutButton = By.id("logout_sidebar_link");
    private By cartItems = By.className("shopping_cart_badge");

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

    public void logout() {
        driver.findElement(logoutButton).click();
    }

    public boolean searchForProduct(String productName) {
        WebElement product = driver.findElement(By.xpath("//div[text()='" + productName + "']"));
        return product.isDisplayed();
    }

    public void addToCart(String productName) {
        WebElement addToCartButton = driver.findElement(By.xpath("//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button"));
        addToCartButton.click();
    }

    public boolean isProductInCart(String productName) {
        WebElement cartBadge = driver.findElement(cartItems);
        return cartBadge.isDisplayed();
    }
}
