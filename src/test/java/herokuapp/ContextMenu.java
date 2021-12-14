package herokuapp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContextMenu {
    private WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }

    @Test
    public void ContextMenu() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.cssSelector("a[href='/context_menu']")).click(); // a[href="/context_menu"]
        Actions actions1 = new Actions(driver);
        actions1.contextClick(driver.findElement(By.id("hot-spot"))).perform(); // contextClick - клик правой кнопкой мыши
        driver.switchTo().alert().accept();


    }
}
