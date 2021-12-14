package SauceDemoPageObject.Test;

import SauceDemoPageObject.Page.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public abstract class BaseTest {
    final static String USERNAME = "standard_user";
    final static String PASSWORD = "secret_sauce";

    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        // запуск браузера без UI(след 3 строчки) если хотим с UI то отсатвляем просто  driver = new ChromeDriver(options);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();  // открытие окна на весь экран
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver = new ChromeDriver(options);
        loginPage = new LoginPage(driver);

        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
