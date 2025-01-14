package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageLogin {
    WebDriver driver;

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.className("error-message-container");

    public PageLogin(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    public boolean isUserLoggedIn() {
        WebElement inventoryContainer = driver.findElement(By.className("inventory_container"));
        return inventoryContainer.isDisplayed();
    }
}
