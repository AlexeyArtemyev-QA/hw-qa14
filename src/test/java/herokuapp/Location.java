package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Location {

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

    // <span class="title">Products</span>
    @Test
    public void buttonLogin () {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//*[@id='root']/div/div[1]")); // //*[@id="root"]/div/div[1]
        driver.findElement(By.id("user-name")).sendKeys("standard_user");// standard_user  <input class="input_error form_input" placeholder="Username" type="text" data-test="username" id="user-name" name="user-name" autocorrect="off" autocapitalize="none" value="">
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); // <input class="input_error form_input" placeholder="Password" type="password" data-test="password" id="password" name="password" autocorrect="off" autocapitalize="none" value="">
        driver.findElement(By.id("login-button")).click();  // <input type="submit" class="submit-button btn_action" data-test="login-button" id="login-button" name="login-button" value="Login">
        driver.findElement(By.xpath("//span[text()='Products']")); // <span class="title">Products</span> // By.xpath("//tag[text()='text']
    }

    // By.xpath("//tag[contains(text(),'text')]")
    @Test
    public void dbdf() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//*[@id='root']/div/div[1]")); // //*[@id="root"]/div/div[1]
        driver.findElement(By.id("user-name")).sendKeys("standard_user");// standard_user  <input class="input_error form_input" placeholder="Username" type="text" data-test="username" id="user-name" name="user-name" autocorrect="off" autocapitalize="none" value="">
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); // <input class="input_error form_input" placeholder="Password" type="password" data-test="password" id="password" name="password" autocorrect="off" autocapitalize="none" value="">
        driver.findElement(By.id("login-button")).click();  // <input type="submit" class="submit-button btn_action" data-test="login-button" id="login-button" name="login-button" value="Login">
        driver.findElement(By.xpath("//span[text()='Products']"));
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click(); // <button class="btn btn_primary btn_small btn_inventory" data-test="add-to-cart-sauce-labs-backpack" id="add-to-cart-sauce-labs-backpack" name="add-to-cart-sauce-labs-backpack">Add to cart</button>
        driver.findElement(By.xpath("//button[text()='Remove']"));// <button class="btn btn_secondary btn_small btn_inventory" data-test="remove-sauce-labs-backpack" id="remove-sauce-labs-backpack" name="remove-sauce-labs-backpack">Remove</button>
        driver.findElement(By.cssSelector("a[class='shopping_cart_link']")).click(); // <a class="shopping_cart_link"><span class="shopping_cart_badge">1</span></a>
        driver.findElement(By.xpath("//div[contains(text(),'with the sleek, streamlined')]")); // By.xpath("//tag[contains(text(),'text')]")  <div class="inventory_item_desc">carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.</div>
    }


}
