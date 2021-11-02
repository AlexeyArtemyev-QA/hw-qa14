package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Inputs {
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
        driver.close();
        driver.quit();
    }

    @Test
    private void InputsUp() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id='content']/ul/li[27]/a")).click();     // //*[@id="content"]/ul/li[27]/a
        driver.findElement(By.xpath("//*[@id='content']/div/div/div/input")).sendKeys(Keys.ARROW_UP);   // //*[@id="content"]/div/div/div/input
        String one = driver.findElement(By.xpath("//*[@id='content']/div/div/div/input")).getAttribute("value"); // //*[@id="content"]/div/div/div/input
        Assert.assertEquals(one, "1", "ERROR");
    }

    @Test
    private void InputsDown() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id='content']/ul/li[27]/a")).click();
        driver.findElement(By.xpath("//*[@id='content']/div/div/div/input")).sendKeys(Keys.ARROW_DOWN); // //*[@id="content"]/div/div/div/input
        String one = driver.findElement(By.xpath("//*[@id='content']/div/div/div/input")).getAttribute("value"); // //*[@id="content"]/div/div/div/input
        Assert.assertEquals(one, "-1", "ERROR");
    }
}

