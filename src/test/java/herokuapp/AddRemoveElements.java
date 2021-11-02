package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddRemoveElements {


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
    public void AddElements() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id='content']/ul/li[2]/a")).click();      //*[@id="content"]/ul/li[2]/a
        driver.findElement(By.cssSelector("#content > div > button")).click();       //*[@id="content"]/div/button // #content > div > button
        driver.findElement(By.cssSelector("#content > div > button")).click();       //*[@id="content"]/div/button // #content > div > button
        driver.findElement(By.cssSelector("#content > div > button")).click();
        WebElement elementOne = driver.findElement(By.xpath("//*[@id='elements']/button[1]"));   //*[@id="elements"]/button[1] //*[@id="elements"]/button[1]
        Assert.assertTrue(elementOne.isDisplayed(),"ERROR");
        WebElement elementTwo = driver.findElement(By.xpath("//*[@id='elements']/button[2]"));   //*[@id="elements"]/button[2]
        Assert.assertTrue(elementTwo.isDisplayed(),"ERROR");
        WebElement elementThree = driver.findElement(By.xpath("//*[@id='elements']/button[3]"));   //*[@id="elements"]/button[3]
        Assert.assertTrue(elementThree.isDisplayed(),"ERROR");
    }
    @Test
    public void RemoveElements() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id='content']/ul/li[2]/a")).click();      //*[@id="content"]/ul/li[2]/a
        driver.findElement(By.cssSelector("#content > div > button")).click();       //*[@id="content"]/div/button // #content > div > button
        driver.findElement(By.cssSelector("#content > div > button")).click();
        driver.findElement(By.cssSelector("#content > div > button")).click();
        WebElement elementOne = driver.findElement(By.xpath("//*[@id='elements']/button[1]"));   //*[@id="elements"]/button[1] //*[@id="elements"]/button[1]
        Assert.assertTrue(elementOne.isDisplayed(),"ERROR");
        WebElement elementTwo = driver.findElement(By.xpath("//*[@id='elements']/button[2]"));   //*[@id="elements"]/button[2]
        Assert.assertTrue(elementTwo.isDisplayed(),"ERROR");
        WebElement elementThree = driver.findElement(By.xpath("//*[@id='elements']/button[3]"));   //*[@id="elements"]/button[3]
        Assert.assertTrue(elementThree.isDisplayed(),"ERROR");
        driver.findElement(By.xpath("//*[@id='elements']/button[3]")).click();
        WebElement checkElementOne = driver.findElement(By.xpath("//*[@id='elements']/button[1]"));   //*[@id="elements"]/button[1] //*[@id="elements"]/button[1]
        Assert.assertTrue(checkElementOne.isDisplayed(),"ERROR");
        WebElement checkElementTwo = driver.findElement(By.xpath("//*[@id='elements']/button[2]"));   //*[@id="elements"]/button[2]
        Assert.assertTrue(checkElementTwo.isDisplayed(),"ERROR");
        driver.findElement(By.xpath("//*[@id='elements']/button[2]")).click();
        WebElement checkElementOneAgain = driver.findElement(By.xpath("//*[@id='elements']/button[1]"));   //*[@id="elements"]/button[1] //*[@id="elements"]/button[1]
        Assert.assertTrue(checkElementOneAgain.isDisplayed(),"ERROR");
    }

}
