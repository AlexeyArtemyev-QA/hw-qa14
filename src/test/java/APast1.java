import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

// <input type="text" name="zip_code" value="">
// <span class="error_message">Oops, error on page. ZIP code should have 5 digits</span>
// <input type="submit" value="Register">
public class APast1 {
    @Test
    public void validZipCodeShouldBeAccepted() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        // WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("11111");
        // находить поле zip code и заполняет поле 11111
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        // находит кнопку Continue и кликает на нее
        boolean isPageOpened = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        // находит элемента Register и записывает ее в boolean переменную и проверяет отображется ли она
        Assert.assertTrue(isPageOpened, "Sign Up page was not opened");
        // Проверка сравнивает значение переменной с true
        driver.quit();
        // закрывает браузер
    }

    @Test
    public void zipCodeShouldBeRequired() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        // находит кнопку Continue и нажимет на нее
        String error = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        // находит сообщение об ошибке и получает его текст и записывает его в переменную типа String
        assertEquals(error, "Oops, error on page. ZIP code should have 5 digits", "Error text is not correct");
        // проверка сравнивает error с ожадаемым результатом (expected)
        driver.quit(); // закрывет браузер
    }

    @Test
    public void zipCodeWithMorethan6CharsShouldBeRejected1() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("111111");
        // находить поле zip code и заполняет поле 111111
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        // находит кнопку Continue и кликает на нее
        boolean register = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        // находит элемент Register проверяет отображается ли он и результат записывает в bolean переменную
        assertTrue(register, "Bad");
        // Проверка сравнивает значение переменной register с true
        driver.quit(); // закрывет браузер
    }

    @Test
    public void zipCodeWithMorethan6CharsShouldBeRejected() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("111111");
        // находить поле zip code и заполняет поле 111111
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        // находит кнопку Continue и кликает на нее
        String error = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        // находит элемент error_message и записывает в переменную типа String
        Assert.assertEquals(error, "Oops, error on page. ZIP code should have 5 digits", "Bad");
        // проверка сравнивает error с ожадаемым результатом (expected)
        driver.quit(); // закрывет браузер
    }
}