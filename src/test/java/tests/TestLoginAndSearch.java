package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PageLogin;
import pages.PageSearch;
import org.junit.jupiter.api.Assertions;

public class TestLoginAndSearch {
    @Test
    public void testLoginWithValidCredentials() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        PageLogin loginPage = new PageLogin(driver);
        loginPage.login("standard_user", "secret_sauce");

        Assertions.assertTrue(loginPage.isUserLoggedIn(), "Đăng nhập không thành công");

        driver.quit();
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        PageLogin loginPage = new PageLogin(driver);
        loginPage.login("locked_out_user", "secret_sauce");

        Assertions.assertTrue(loginPage.isErrorMessageDisplayed(), "Thông báo lỗi không hiển thị");

        driver.quit();
    }

    @Test
    public void testProductListAfterLogin() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        PageLogin loginPage = new PageLogin(driver);
        loginPage.login("standard_user", "secret_sauce");

        PageSearch searchPage = new PageSearch(driver);
        Assertions.assertTrue(searchPage.isProductListDisplayed(), "Danh sách sản phẩm không hiển thị");
        Assertions.assertTrue(searchPage.isProductDisplayed(), "Không có sản phẩm hiển thị");

        driver.quit();
    }
}
