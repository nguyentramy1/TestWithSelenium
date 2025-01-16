package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PageLogin;
import pages.PageSearch;

public class TestLoginAndSearch {

    private static ExtentReports extent;
    private static ExtentSparkReporter spark;
    private WebDriver driver;
    private ExtentTest test;

    @BeforeAll
    public static void setupReport() {
        // Khởi tạo báo cáo
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent.attachReporter(spark);
    }

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void testLoginWithValidCredentials() {
        test = extent.createTest("Test Login With Valid Credentials");
        driver.get("https://www.saucedemo.com/");
        test.info("Navigated to saucedemo.com");

        PageLogin loginPage = new PageLogin(driver);
        loginPage.login("standard_user", "secret_sauce");
        test.info("Entered valid credentials");

        Assertions.assertTrue(loginPage.isUserLoggedIn(), "Login was not successful");
        test.pass("Login successful with valid credentials");
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        test = extent.createTest("Test Login With Invalid Credentials");
        driver.get("https://www.saucedemo.com/");
        test.info("Navigated to saucedemo.com");

        PageLogin loginPage = new PageLogin(driver);
        loginPage.login("locked_out_user", "secret_sauce");
        test.info("Entered invalid credentials");

        Assertions.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed");
        test.pass("Error message displayed successfully for invalid credentials");
    }

    @Test
    public void testProductListAfterLogin() {
        test = extent.createTest("Test Product List After Login");
        driver.get("https://www.saucedemo.com/");
        test.info("Navigated to saucedemo.com");

        PageLogin loginPage = new PageLogin(driver);
        loginPage.login("standard_user", "secret_sauce");
        test.info("Logged in with valid credentials");

        PageSearch searchPage = new PageSearch(driver);
        Assertions.assertTrue(searchPage.isProductListDisplayed(), "Product list not displayed");
        Assertions.assertTrue(searchPage.isProductDisplayed(), "No products displayed");
        test.pass("Product list displayed successfully after login");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterAll
    public static void tearDownReport() {
        // Kết thúc và ghi báo cáo
        extent.flush();
    }
}
