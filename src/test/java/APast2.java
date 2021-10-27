import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class APast2 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("headless");     // headless - проводит тест но не открывает UI
        driver = new ChromeDriver(options);
        //driver.manage().window().setSize(new Dimension(1280,768));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // ждет 10 сек

    }

    @AfterMethod
    public void teamDown() {
        driver.quit();
    }


    @Test
    public void validZipCodeShouldBeAccepted() {

        // открыть https://www.sharelane.com/cgi-bin/register.py (ходить по прямой ссылке)
        // Enter 11111 into ZIP code
        // Click Continue
        // Находим редкий уникальный элемент который говорт что мы однозначно перешли на новую страницу (Register)
        // открытие браузера (след 3 строчки)
        // <input type="text" name="zip_code" value="">
        // <input type="submit" value="Continue">
        // <input type="submit" value="Register">


        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        driver.findElement(By.name("zip_code")).sendKeys("11111"); // находить поле zip code и заполняет поле 11111

        driver.findElement(By.cssSelector("[value=Continue]")).click(); // кликает на кнопку Continue

        boolean isPageOpened = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed(); // находит элемента Register и записывает ее в переменную

        Assert.assertTrue(isPageOpened, "Sign Up page was not opened");


        /// написать тесты для все формы

    }

}
