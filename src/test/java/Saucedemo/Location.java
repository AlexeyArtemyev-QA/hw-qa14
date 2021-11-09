package Saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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

    // №1
    // Xpath поиск по тексту
    // <span class="title">Products</span>
    @Test
    public void successfulRegistration() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//*[@id='root']/div/div[1]")); // //*[@id="root"]/div/div[1]
        driver.findElement(By.id("user-name")).sendKeys("standard_user");// standard_user  <input class="input_error form_input" placeholder="Username" type="text" data-test="username" id="user-name" name="user-name" autocorrect="off" autocapitalize="none" value="">
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); // <input class="input_error form_input" placeholder="Password" type="password" data-test="password" id="password" name="password" autocorrect="off" autocapitalize="none" value="">
        driver.findElement(By.id("login-button")).click();  // <input type="submit" class="submit-button btn_action" data-test="login-button" id="login-button" name="login-button" value="Login">
        boolean products = driver.findElement(By.xpath("//span[text()='Products']")).isDisplayed(); // <span class="title">Products</span> // By.xpath("//tag[text()='text']
        Assert.assertTrue(products, "ERROR: incorrect data entered");
    }

    // №2
    // Xpath по частичному совпадению текста
    // By.xpath("//tag[contains(text(),'text')]")
    @Test
    public void addOneProduct() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//*[@id='root']/div/div[1]")); // //*[@id="root"]/div/div[1]
        driver.findElement(By.id("user-name")).sendKeys("standard_user");// standard_user  <input class="input_error form_input" placeholder="Username" type="text" data-test="username" id="user-name" name="user-name" autocorrect="off" autocapitalize="none" value="">
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); // <input class="input_error form_input" placeholder="Password" type="password" data-test="password" id="password" name="password" autocorrect="off" autocapitalize="none" value="">
        driver.findElement(By.id("login-button")).click();  // <input type="submit" class="submit-button btn_action" data-test="login-button" id="login-button" name="login-button" value="Login">
        driver.findElement(By.xpath("//span[text()='Products']"));
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click(); // <button class="btn btn_primary btn_small btn_inventory" data-test="add-to-cart-sauce-labs-backpack" id="add-to-cart-sauce-labs-backpack" name="add-to-cart-sauce-labs-backpack">Add to cart</button>
        String firstProduct = driver.findElement(By.xpath("//div[contains(text(),'carry.allTheThings() with the sleek')]")).getText(); // carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.
        driver.findElement(By.xpath("//button[text()='Remove']"));// <button class="btn btn_secondary btn_small btn_inventory" data-test="remove-sauce-labs-backpack" id="remove-sauce-labs-backpack" name="remove-sauce-labs-backpack">Remove</button>
        driver.findElement(By.cssSelector("a[class='shopping_cart_link']")).click(); // <a class="shopping_cart_link"><span class="shopping_cart_badge">1</span></a>
        String secondProduct = driver.findElement(By.xpath("//div[contains(text(),'carry.allTheThings() with the sleek')]")).getText(); // By.xpath("//tag[contains(text(),'text')]")  <div class="inventory_item_desc">carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.</div>
        Assert.assertEquals(secondProduct, firstProduct, "ERROR There`s a different product in the shopping cart");
    }

    // №3
    // Xpath ancestor
    @Test
    public void attribute() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//*[@id='root']/div/div[1]")); // //*[@id="root"]/div/div[1]
        driver.findElement(By.id("user-name")).sendKeys("standard_user");// standard_user  <input class="input_error form_input" placeholder="Username" type="text" data-test="username" id="user-name" name="user-name" autocorrect="off" autocapitalize="none" value="">
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); // <input class="input_error form_input" placeholder="Password" type="password" data-test="password" id="password" name="password" autocorrect="off" autocapitalize="none" value="">
        driver.findElement(By.id("login-button")).click();  // <input type="submit" class="submit-button btn_action" data-test="login-button" id="login-button" name="login-button" value="Login">
        driver.findElement(By.xpath("//span[text()='Products']"));
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']//ancestor::a//ancestor::div//ancestor::div"));
    }

    // №4
    // CSS (.class) поиск по одному классу
    @Test
    public void cssClass() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//*[@id='root']/div/div[1]")); // //*[@id="root"]/div/div[1]
        driver.findElement(By.id("user-name")).sendKeys("standard_user");// standard_user  <input class="input_error form_input" placeholder="Username" type="text" data-test="username" id="user-name" name="user-name" autocorrect="off" autocapitalize="none" value="">
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); // <input class="input_error form_input" placeholder="Password" type="password" data-test="password" id="password" name="password" autocorrect="off" autocapitalize="none" value="">
        driver.findElement(By.id("login-button")).click();  // <input type="submit" class="submit-button btn_action" data-test="login-button" id="login-button" name="login-button" value="Login">
        driver.findElement(By.xpath("//span[text()='Products']"));
        driver.findElement(By.cssSelector(".app_logo")); // .app_logo
    }

    // №5
    // CSS (.class.class2) два класса ОДНОГО тега
    @Test
    public void cssClassClass2Sisters() {
        driver.get("https://catalog.onliner.by/acs_photo");
        driver.findElement(By.cssSelector(".schema-product__part.schema-product__part_2"));// .schema-product__part.schema-product__part_2
    }

    // №6
    // CSS (.class .class2) первый класс - класс родительского атрибута, второй класс - класс дочернего атрибума (идем на один шаг вглубь дерева)
    @Test
    public void cssClassClass2Parent() {
        driver.get("https://catalog.onliner.by/acs_photo");
        driver.findElement(By.cssSelector(".schema-product__group .schema-product"));// .schema-product__group .schema-product
    }

    // №7 (7.1, 7.2, 7.3)
    // CSS (#id) + 3 вида
    // 1 тест (#id); 2 тест ("tag[attribute='value']"); 3 тест("#value").
    @Test
    public void idTestOne() {
        driver.get("https://catalog.onliner.by/acs_photo");
        driver.findElement(By.cssSelector("#schema-scroll-to"));// <div id="schema-scroll-to"></div>
    }

    @Test
    public void cssSelecrotTestTwo() {
        driver.get("https://catalog.onliner.by/acs_photo");
        driver.findElement(By.cssSelector("div[id='schema-scroll-to']"));// <div id="schema-scroll-to"></div>
    }

    @Test
    public void cssSelecrotTestThree() {
        driver.get("https://catalog.onliner.by/acs_photo");
        driver.findElement(By.cssSelector("#schema-scroll-to"));// <div id="schema-scroll-to"></div>
    }

    // №8 (8.1, 8.2)
    // *любой элемент (если мы не знаем какой тег нужен, но знает атрибут и его значение) *[attribute='value']
    // Варианты записи равнозначны (на личное усмотрение)
    // Вариант записи 1 (со звездочкой)
    @Test
    public void cssSelecrotAnyTegWithStar() {
        driver.get("https://catalog.onliner.by/acs_photo");
        driver.findElement(By.cssSelector("*[id='schema-scroll-to']"));// <div id="schema-scroll-to"></div>
    }

    // Вариант записи 2 (БЕЗ звездочки)
    @Test
    public void cssSelecrotAnyTegWithoutStar() {
        driver.get("https://catalog.onliner.by/acs_photo");
        driver.findElement(By.cssSelector("[id='schema-scroll-to']"));// <div id="schema-scroll-to"></div>
    }

    // см пример 7.2
    // tag[attribute="value"]
    @Test
    public void cssSelectorTagSimple() {
        driver.get("https://catalog.onliner.by/acs_photo");
        driver.findElement(By.cssSelector("div[id='schema-scroll-to']"));// <div id="schema-scroll-to"></div>
    }

    // Test 9 (9.1, 9.2) [attribute*=value] ищет значение атрибута СОДЕРЖАЩЕГО  подстроку
    // Варианты записи равнозначны (на личное усмотрение)
    // Вариант записи 1 (без кавычек)[id*=schema-scroll]
    @Test
    public void cssSelectorBeginAttributeWithoutQuotes() {
        driver.get("https://catalog.onliner.by/acs_photo");
        driver.findElement(By.cssSelector("[id*=schema-scroll]"));// <div id="schema-scroll-to"></div>
    }

    // Вариант записи 2 (C кавычками)[id*="schema-scroll"]
    // [attribute*="value"]
    @Test
    public void cssSelectorBeginAttributeWithQuotes() {
        driver.get("https://catalog.onliner.by/acs_photo");
        driver.findElement(By.cssSelector("[id*='schema-scroll']"));// <div id="schema-scroll-to"></div>
    }


    // Test 10 (10.1, 10.2)  [attribute$=value] ищет значение атрибута заканчивающегося подстрокой
    // Варианты записи равнозначны (на личное усмотрение)
    // Вариант записи 1 (без кавычек)[id$=-to]
    @Test
    public void cssSelectorEndAttributeWithoutQuotes() {
        driver.get("https://catalog.onliner.by/acs_photo");
        driver.findElement(By.cssSelector("[id$=-to]"));// <div id="schema-scroll-to"></div>
    }

    // Вариант записи 2 (C кавычками)[id$="-to"]
    // [attribute$="value"]
    @Test
    public void cssSelectorEndAttributeWithQuotes() {
        driver.get("https://catalog.onliner.by/acs_photo");
        driver.findElement(By.cssSelector("[id$='-to']"));// <div id="schema-scroll-to"></div>
    }

    // Test 11 (11.1, 11.2) [attribute|="value"] находит элемент начинающийся с подстроки или полностью подстрока является значкнием атрибута
    // Варианты записи равнозначны (на личное усмотрение)
    // Вариант записи 1 (C кавычками) [id|="schema-scroll-to"]
    @Test
    public void cssSelectoreqaulAttributeOrStartAttributeWithoutQuotes() {
        driver.get("https://catalog.onliner.by/acs_photo");
        driver.findElement(By.cssSelector("[id|='schema-scroll']"));// <div id="schema-scroll-to"></div>
    }

    // Вариант записи 2 (БЕЗ кавычек )[id|=schema-scroll-to]
    // [attribute|=value]
    @Test
    public void cssSelectoreqaulAttributeOrStartAttributeWithQuotes() {
        driver.get("https://catalog.onliner.by/acs_photo");
        driver.findElement(By.cssSelector("[id|=schema]"));// <div id="schema-scroll-to"></div>
    }
}
