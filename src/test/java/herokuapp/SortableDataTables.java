package herokuapp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortableDataTables {
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
    private void SortableDataTables (){
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id='content']/ul/li[41]/a")).click(); // //*[@id="content"]/ul/li[41]/a
        String textOne = driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[1]/td[1]")).getText(); // //*[@id="table1"]/tbody/tr[1]/td[1]
        Assert.assertEquals(textOne, "Smith", "ERROR: incorrect data (Last Name, cell [1][1])"); // <td>Smith</td>

        String textTwo = driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[2]/td[2]")).getText(); // //*[@id="table1"]/tbody/tr[2]/td[2]
        Assert.assertEquals(textTwo, "Frank", "ERROR: incorrect data (First Name, cell [2][2])"); // <td>Frank</td>

        String textThree = driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[4]/td[3]")).getText(); // //*[@id="table1"]/tbody/tr[4]/td[3]
        Assert.assertEquals(textThree, "tconway@earthlink.net", "ERROR: incorrect data (Email, cell [4][3])"); // <td>tconway@earthlink.net</td>

        String textFour = driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[3]/td[5]")).getText(); // //*[@id="table1"]/tbody/tr[3]/td[5]
        Assert.assertEquals(textFour, "http://www.jdoe.com", "ERROR: incorrect data (Web Site, cell [3][5])"); // <td>http://www.jdoe.com</td>
    }

}
