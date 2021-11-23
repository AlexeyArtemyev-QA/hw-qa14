package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Expectations {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    //№1 (WebDriverWait) ожидание по локатору
    // visibilityOfElementLocated (элемент виден)
    @Test
    public void dynamicControlsvisibilityOfElementLocated() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(3, SECONDS);
        driver.findElement(By.cssSelector("a[href='/dynamic_controls']")).click(); // <a href="/dynamic_controls">Dynamic Controls</a>
        driver.findElement(By.cssSelector("[onclick='swapCheckbox()']")).click();
        WebDriverWait wait4 = new WebDriverWait(driver, 10);
        wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
    }

    // №2 (WebDriverWait) ожидание по веб элементу (веб элемент задается ПЕРЕД ожиданием)
    // visibilityOf (элемент виден)
    @Test
    public void dynamicControlsvisibilityOf() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(3, SECONDS);
        driver.findElement(By.cssSelector("a[href='/dynamic_controls']")).click(); // <a href="/dynamic_controls">Dynamic Controls</a>
        driver.findElement(By.cssSelector("[type=checkbox]")).click();
        driver.findElement(By.cssSelector("[onclick='swapInput()']")).click();
        WebElement element = driver.findElement(By.id("message"));
        WebDriverWait wait5 = new WebDriverWait(driver, 10);
        wait5.until(ExpectedConditions.visibilityOf(element)); // <p id="message">It's enabled!</p>
    }

    // №3 (WebDriverWait) ожидание кликабельности по локатору
    // elementToBeClickable (элемент кликается)
    @Test
    public void dynamicControlselementToBeClickableCss() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(3, SECONDS);
        driver.findElement(By.cssSelector("a[href='/dynamic_controls']")).click(); // <a href="/dynamic_controls">Dynamic Controls</a>
        driver.findElement(By.cssSelector("[type=checkbox]")).click();
        driver.findElement(By.cssSelector("[onclick='swapCheckbox()']")).click();
        WebDriverWait wait6 = new WebDriverWait(driver, 10);
        wait6.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[onclick='swapCheckbox()']")));
    }

    // №4 (WebDriverWait) ожидание кликабельности по веб элементу
    // elementToBeClickable (элемент кликается)
    @Test
    public void dynamicControlselementToBeClickableWebElement() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(3, SECONDS);
        driver.findElement(By.cssSelector("a[href='/dynamic_controls']")).click(); // <a href="/dynamic_controls">Dynamic Controls</a>
        driver.findElement(By.cssSelector("[onclick='swapCheckbox()']")).click();
        WebElement element = driver.findElement(By.cssSelector("[onclick='swapCheckbox()']"));
        WebDriverWait wait7 = new WebDriverWait(driver, 10);
        wait7.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Test 5
    @Test
    public void dynamicControlselementToBeClickable() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(3, SECONDS);
        driver.findElement(By.cssSelector("a[href='/dynamic_controls']")).click(); // <a href="/dynamic_controls">Dynamic Controls</a>
        driver.findElement(By.cssSelector("[type=checkbox]")).click();
        driver.findElement(By.cssSelector("[onclick='swapCheckbox()']")).click();
        WebDriverWait wait8 = new WebDriverWait(driver, 10);
        wait8.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[src='/img/ajax-loader.gif']"))); // [src='/img/ajax-loader.gif']
    }

    // Test 6 (WebDriverWait) ожидание по локатору
    // invisibilityOfElementLocated (элемент НЕ виден)
    @Test
    public void onliner1() {
        driver.get("https://www.onliner.by/");
        driver.findElement(By.xpath("//a[@href='https://catalog.onliner.by/']//ancestor::span")).click();  // <span class="b-main-navigation__text">Каталог</span>
        WebDriverWait wait9 = new WebDriverWait(driver, 10);
        wait9.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class='project-navigation__samsung']")));
    }

    // Test 7 (WebDriverWait) ожидание по веб элементу
    // invisibilityOf (элемент НЕ виден)
    @Test
    public void onliner2() {
        driver.get("https://www.onliner.by/");
        WebElement element = driver.findElement(By.cssSelector("[class='project-navigation__samsung']"));
        driver.findElement(By.xpath("//a[@href='https://catalog.onliner.by/']//ancestor::span")).click();
        WebDriverWait wait9 = new WebDriverWait(driver, 10);
        wait9.until(ExpectedConditions.invisibilityOf(element));

    }

    // Test 8 FluentWait
    @Test
    public void onliner3() {
        driver.get("https://www.onliner.by/");
        Wait<WebDriver> fluent1 = new FluentWait<>(driver)
                .withTimeout(2, SECONDS)
                .pollingEvery(1, SECONDS);
        ignoring(NoSuchElementException.class);
        WebElement element2 = fluent1.until(driver -> driver.findElement(By.id("adfox_154331780165273237")));
    }

    private void ignoring(Class<NoSuchElementException> noSuchElementExceptionClass) {
    }
// ExpectedConditions.not(ExpectedConditions...)   // отрицыние того чего ищем

    // driver.switchTo().frame(1) // переключение на фрейм с основного
    // driver.switchTo().defaultContent   // переключение с фрейма на основной

    // allert.accsept
    //allert.dismiss

    //File Uploader, см фото
}
