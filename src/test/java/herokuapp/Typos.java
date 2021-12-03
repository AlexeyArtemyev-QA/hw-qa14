package herokuapp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Typos {
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
    private void Typos (){
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id='content']/ul/li[43]/a")).click(); // //*[@id="content"]/ul/li[43]/a
        String textOne = driver.findElement(By.xpath("//*[@id='content']/div/p[1]")).getText();// //*[@id="content"]/div/p[1]/text()
        Assert.assertEquals(textOne, "This example demonstrates a typo being introduced. It does it randomly on each page load.", "ERROR: There is an error in the sentence");
        String textTwo = driver.findElement(By.xpath("//*[@id='content']/div/p[2]")).getText(); // //*[@id="content"]/div/p[2]
        Assert.assertEquals(textTwo, "Sometimes you'll see a typo, other times you won't.", "ERROR: There is an error in the sentence");

    }
}
