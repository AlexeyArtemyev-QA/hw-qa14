package herokuapp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Checkboxes {

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

    // (Failed)
    @Test
    public void checkboxesOneNotSelected() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id='content']/ul/li[6]/a")).click(); // //*[@id="content"]/ul/li[6]/a
        boolean checkBoxOne = driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected(); // <input type="checkbox">
        Assert.assertTrue(checkBoxOne, "ERROR: Checkbox 1 not selected");
    }

    // (Passed)
    @Test
    public void checkboxOneSelected() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id='content']/ul/li[6]/a")).click(); // //*[@id="content"]/ul/li[6]/a
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        boolean checkboxOne =   driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected();
        Assert.assertTrue(checkboxOne, "ERROR: Checkbox 1 does not select");

    }

    // (Passed)
    @Test
    public void checkboxTwoSelected() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id='content']/ul/li[6]/a")).click(); // //*[@id="content"]/ul/li[6]/a
        boolean checkBoxTwo = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]")).isSelected(); // //*[@id="checkboxes"]/input[2]
        Assert.assertTrue(checkBoxTwo, "ERROR: Checkbox 2 not selected");
    }

    // (Failed)
    @Test
    public void checkboxTwoNotSelected() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id='content']/ul/li[6]/a")).click(); // //*[@id="content"]/ul/li[6]/a
        driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]")).click();
        boolean checkboxTwo = driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected();
        Assert.assertTrue(checkboxTwo, "ERROR: Checkbox 2 selected");
    }
}


// //*[@id="checkboxes"]/input[1]
// //*[@id="checkboxes"]/input[2]