package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicAuth {

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
    public void BasicAuth(){
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id='content']/ul/li[3]")).click(); // //*[@id="content"]/ul/li[3]
        sendKeys("admin");
        sendKeys("admin");
        sendKeys(Keys.ENTER);
        WebElement finish = driver.findElement(By.xpath("//*[@id='page-footer']/div/div/a")); // //*[@id="page-footer"]/div/div/a
        Assert.assertTrue(finish.isDisplayed(), "ERROR");
    }
    private void sendKeys(Keys Enter){
    }
    private void sendKeys(String admin) {
    }
}
