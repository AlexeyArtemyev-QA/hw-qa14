import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class APast3 {
    //    http://the-internet.herokuapp.com/dropdown

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("headless");     // headless - проводит тест но не открывает UI
        driver = new ChromeDriver(options);
        //driver.manage().window().setSize(new Dimension(1280,768));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // ждет 10 сек

    }

    @AfterMethod
    public void teamDown() {
        driver.quit();
    }
    @Test
    public void select (){
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement element = driver.findElement(By.id("dropdown"));
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        assertEquals(options.get(0).getText(),"Please select an option");
        assertEquals(options.get(1).getText(),"Option 1");
        assertEquals(options.get(2).getText(),"Option 2");
        select.selectByVisibleText("Option 1");
        assertTrue(select.getFirstSelectedOption().isSelected());
        select.selectByVisibleText("Option 2");
        assertTrue(select.getFirstSelectedOption().isSelected());
        assertFalse(options.get(0).isEnabled());
    }


}
