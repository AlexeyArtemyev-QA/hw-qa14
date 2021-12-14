package herokuapp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTest {

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
    public void Dropdown() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id='content']/ul/li[11]/a")).click(); // //*[@id="content"]/ul/li[11]/a
        driver.findElement(By.xpath("//*[@id='dropdown']")).click(); // //*[@id="dropdown"]
        boolean dropDownOne = driver.findElement(By.xpath("//*[@id='dropdown']/option[2]")).isDisplayed();
        Assert.assertTrue(dropDownOne, "Option 1 not displayed");
        boolean dropDownTwo = driver.findElement(By.xpath("//*[@id='dropdown']/option[3]")).isDisplayed();
        Assert.assertTrue(dropDownTwo, "Option 2 not displayed");
    }

    @Test
    public void DropdownOne() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id='content']/ul/li[11]/a")).click();
        driver.findElement(By.xpath("//*[@id='dropdown']/option[2]")).click(); // //*[@id="dropdown"]/option[2]
        boolean dropdownOne = driver.findElement(By.xpath("//*[@id='dropdown']/option[2]")).isSelected();
        Assert.assertTrue(dropdownOne, "Option 1 not selected");
    }

    @Test
    public void DropdownTwo() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id='content']/ul/li[11]/a")).click();
        driver.findElement(By.xpath("//*[@id='dropdown']/option[3]")).click(); // //*[@id="dropdown"]/option[3]
        boolean dropdownTwo = driver.findElement(By.xpath("//*[@id='dropdown']/option[3]")).isSelected();
        Assert.assertTrue(dropdownTwo, "Option 2 not selected");
    }
}
