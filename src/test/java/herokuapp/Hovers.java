package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Hovers {
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
    private void Hovers() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id='content']/ul/li[25]/a")).click(); // //*[@id="content"]/ul/li[25]/a
        WebElement img = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/img")); // //*[@id="content"]/div/div[1]/img
        String nameUserOne = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div/h5")).getAttribute("name");
        Assert.assertEquals(nameUserOne, "user1", "ERROR");
        String nameUser = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div/h5")).getText();  // //*[@id="content"]/div/div[1]/div/h5
        WebElement linkOne = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div/a")); // //*[@id="content"]/div/div[1]/div/a
        Actions builder = new Actions(driver);
        builder.moveToElement(img).click(linkOne).doubleClick().build().perform();


    }
}
