package herokuapp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ABTesting {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
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
    public void ABTesting() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id='content']/ul/li[1]/a")).click(); // //*[@id="content"]/ul/li[1]/a
        String text = driver.getCurrentUrl();
        Assert.assertEquals(text, "https://the-internet.herokuapp.com/abtest", "ERROR");  // https://the-internet.herokuapp.com/abtest
        driver.findElement(By.xpath("//*[@id='page-footer']/div/div/a")).click();
    }
}
