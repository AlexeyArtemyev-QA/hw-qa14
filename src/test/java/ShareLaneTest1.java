import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ShareLaneTest1 {

    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        // open browser
        driver = new ChromeDriver();
        // открытие окна на всеь размер
        driver.manage().window().maximize();
        // ждет 5 секунд
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        // Закрытие браузера
        driver.quit();
    }

    // Классная работа
    @Test
    public void zipCodePozitivTest() throws InterruptedException {
        // navigate to ShareLane (https://www.sharelane.com/cgi-bin/main.py)
        driver.get("https://sharelane.com/");
        //Thread.sleep(10000);

        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']"));
        enterButton.click();

        // Click "Sige up" link
        WebElement signUpLink = driver.findElement(By.cssSelector("a[href='./register.py']"));
        signUpLink.click();
        //<a href="./register.py">Sign up</a>

        // Enter 5 digits
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");

        // Click "Continue" botton
        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        continueButton.click();

        WebElement registerButton = driver.findElement(By.cssSelector("input[value='Register']"));

        // assert проверки
        // Assert.assertFalse(zipCodeInput.isDisplayed(), "Zip code input should be hidden");
        Assert.assertTrue(registerButton.isDisplayed(), "Register button should be displayed");
    }

    @Test
    public void emptyZipCodeTest() {
        // Navigate to ShareLane (https://sharelane.com/)
        driver.get("https://sharelane.com/");
        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']"));
        enterButton.click();

        // Click "Sign Up" link
        WebElement signUpLink = driver.findElement(By.cssSelector("a[href='./register.py']"));
        signUpLink.click();

        // Пустой ввод
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));

        // Click "Continue" button
        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        continueButton.click();

        // Verify that user is redirected to "Sign Up" page
        // Asserts
        zipCodeInput = driver.findElement(By.name("zip_code"));
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        Assert.assertTrue(zipCodeInput.isDisplayed(), "Zip code input should be displayed");
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message should appears");
        Assert.assertEquals(errorMessage.getText(), "Oops, error on page. ZIP code should have 5 digits", "Error");
    }


}
