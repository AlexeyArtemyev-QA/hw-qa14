package ShareLane;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ShareLaneTest1Homework {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        // open browser
        driver = new ChromeDriver();
        // открытие окна на всеь размер
        driver.manage().window().maximize();
        // ждет 1 секунд
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        // Закрытие браузера
        driver.quit();
    }

    // [ZIP code] Test_1 (Passed)
    @Test
    public void spaceTextSpecialCharactersZipCode() {
        driver.get("https://sharelane.com/");
        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")); // <a href="../cgi-bin/main.py"><b>ENTER</b></a>
        enterButton.click();
        WebElement signUpLink = driver.findElement(By.cssSelector("a[href='./register.py']"));       // <a href="./register.py">Sign up</a>
        signUpLink.click();
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));                           // <input type="text" name="zip_code" value="">
        WebElement spaceTextZipCodeInput = driver.findElement(By.name("zip_code"));                  // <input type="text" name="zip_code" value="">
        spaceTextZipCodeInput.sendKeys(" A-m Щк, (#?_&%/|@ ");
        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));   // <input type="submit" value="Continue">
        continueButton.click();
        WebElement errorMessage = driver.findElement(By.className("error_message"));                 // <span class="error_message">Oops, error on page. ZIP code should have 5 digits</span>
        Assert.assertEquals(
                errorMessage.getText(),
                "Oops, error on page. ZIP code should have 5 digits",
                "ERROR: User can input incorrect data(space bar, text characters and special characters) in the Zip code field");
    }

    // [ZIP code] Test_2 (Passed)
    @Test
    public void maxValueZipCode() {
        driver.get("https://sharelane.com/");
        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")); // <a href="../cgi-bin/main.py"><b>ENTER</b></a>
        enterButton.click();
        WebElement signUpLink = driver.findElement(By.cssSelector("a[href='./register.py']"));       // <a href="./register.py">Sign up</a>
        signUpLink.click();
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));                           // <input type="text" name="zip_code" value="">
        WebElement maxValueZipCodeInput = driver.findElement(By.name("zip_code"));                   // <input type="text" name="zip_code" value="">
        maxValueZipCodeInput.sendKeys("123456789012345678901234567890");
        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));   // <input type="submit" value="Continue">
        continueButton.click();
        WebElement registerButton = driver.findElement(By.cssSelector("input[value='Register']"));   // <input type="submit" value="Register">
        Assert.assertTrue(registerButton.isDisplayed(),
                "Register button should be displayed");
    }

    // [ZIP code] Test_3 (Passed)
    @Test
    public void enter4DigitsZipCode() {
        driver.get("https://sharelane.com/");
        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")); // <a href="../cgi-bin/main.py"><b>ENTER</b></a>
        enterButton.click();
        WebElement signUpLink = driver.findElement(By.cssSelector("a[href='./register.py']"));       // <a href="./register.py">Sign up</a>
        signUpLink.click();
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));                           // <input type="text" name="zip_code" value="">
        WebElement enter4DigitsZipCode = driver.findElement(By.name("zip_code"));                    // <input type="text" name="zip_code" value="">
        enter4DigitsZipCode.sendKeys("0941");
        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));   // <input type="submit" value="Continue">
        continueButton.click();
        WebElement errorMessage = driver.findElement(By.className("error_message"));                 // <span class="error_message">Oops, error on page. ZIP code should have 5 digits</span>
        Assert.assertEquals(
                errorMessage.getText(),
                "Oops, error on page. ZIP code should have 5 digits",
                "Error: the ZIP code field should have five or more digits");
    }

    // [ZIP code] Test_4 (Passed)
    @Test
    public void negativeFractionalDigitsZipCode() {
        driver.get("https://sharelane.com/");
        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")); // <a href="../cgi-bin/main.py"><b>ENTER</b></a>
        enterButton.click();
        WebElement signUpLink = driver.findElement(By.cssSelector("a[href='./register.py']"));       // <a href="./register.py">Sign up</a>
        signUpLink.click();
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));                           // <input type="text" name="zip_code" value="">
        WebElement negativeDigits = driver.findElement(By.name("zip_code"));                         // <input type="text" name="zip_code" value="">
        negativeDigits.sendKeys("-12575");
        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']")); // <input type="submit" value="Continue">
        continueButton.click();
        WebElement errorMessage = driver.findElement(By.className("error_message"));               // <span class="error_message">Oops, error on page. ZIP code should have 5 digits</span>
        Assert.assertEquals(errorMessage.getText(),
                "Oops, error on page. ZIP code should have 5 digits", "Error");
        WebElement fractionalDigits = driver.findElement(By.name("zip_code"));
        fractionalDigits.sendKeys("1,3978");
        WebElement continueButtonTwo = driver.findElement(By.cssSelector("input[value='Continue']")); // <input type="submit" value="Continue">
        continueButtonTwo.click();
        WebElement errorMessageTwo = driver.findElement(By.className("error_message"));               // <span class="error_message">Oops, error on page. ZIP code should have 5 digits</span>
        Assert.assertEquals(
                errorMessageTwo.getText(),
                "Oops, error on page. ZIP code should have 5 digits",
                "Error: the ZIP code field should have five or more integer positive digits");
    }

    // Sign Up
    // [Sign Up] Test_5 (Passed)
    // Вариант_записи_1
    @Test
    public void validDataZipCodeSignup() {
        driver.get("https://sharelane.com/");
        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")); // <a href="../cgi-bin/main.py"><b>ENTER</b></a>
        enterButton.click();
        WebElement signUpLink = driver.findElement(By.cssSelector("a[href='./register.py']"));       // <a href="./register.py">Sign up</a>
        signUpLink.click();
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));                           // <input type="text" name="zip_code" value="">
        WebElement enter4DigitsZipCode = driver.findElement(By.name("zip_code"));                    // <input type="text" name="zip_code" value="">
        enter4DigitsZipCode.sendKeys("12345");
        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));   // <input type="submit" value="Continue">
        continueButton.click();
        WebElement registerButton = driver.findElement(By.cssSelector("input[value='Register']"));
        WebElement firstName = driver.findElement(By.name("first_name"));                         // <input type="text" name="first_name" value="">
        firstName.sendKeys("Alex");
        WebElement lastName = driver.findElement(By.name("last_name"));                           // <input type="text" name="last_name" value="">
        lastName.sendKeys("Smith");
        WebElement email = driver.findElement(By.name("email"));                                  // <input type="text" name="email" value="">
        email.sendKeys("Test@mail.ru");
        WebElement password = driver.findElement(By.name("password1"));                           // <input type="text" name="password1">
        password.sendKeys("122333444455555");
        WebElement confirmPassword = driver.findElement(By.name("password2"));                          // <input type="password" name="password2">
        confirmPassword.sendKeys("122333444455555");
        WebElement registerButtonTwo = driver.findElement(By.cssSelector("input[value='Register']"));   // <input type="submit" value="Register">
        registerButtonTwo.click();
        boolean successful = driver.findElement(By.cssSelector("a[href='./main.py']")).isDisplayed(); // <a href="./main.py">here</a>
        Assert.assertTrue(successful,
                "ERROR: Data isn`t correct");
    }

    // [Sign Up] Test_5 (Passed)
    // Вариант_записи_2
    @Test
    public void validDataZipCodeSignUp() {
        driver.get("https://sharelane.com/");
        driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")).click();
        driver.findElement(By.cssSelector("a[href='./register.py']")).click();
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        driver.findElement(By.cssSelector("input[value='Register']"));
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Smith");
        driver.findElement(By.name("email")).sendKeys("Test@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("122333444455555");
        driver.findElement(By.name("password2")).sendKeys("122333444455555");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        boolean successful = driver.findElement(By.cssSelector("a[href='./main.py']")).isDisplayed();
        Assert.assertTrue(successful,
                "ERROR: Data isn`t correct");
    }

    // [Sign Up] Test_6 (Passed)
    // Вариант_записи_1
    @Test
    public void emptyFieldsSignup() {
        driver.get("https://sharelane.com/");
        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")); // <a href="../cgi-bin/main.py"><b>ENTER</b></a>
        enterButton.click();
        WebElement signUpLink = driver.findElement(By.cssSelector("a[href='./register.py']"));       // <a href="./register.py">Sign up</a>
        signUpLink.click();
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));                           // <input type="text" name="zip_code" value="">
        WebElement enter4DigitsZipCode = driver.findElement(By.name("zip_code"));                    // <input type="text" name="zip_code" value="">
        enter4DigitsZipCode.sendKeys("12345");
        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));   // <input type="submit" value="Continue">
        continueButton.click();
        WebElement firstName = driver.findElement(By.name("first_name"));                         // <input type="text" name="first_name" value="">
        firstName.sendKeys("");
        WebElement lastName = driver.findElement(By.name("last_name"));                           // <input type="text" name="last_name" value="">
        lastName.sendKeys("");
        WebElement email = driver.findElement(By.name("email"));                                  // <input type="text" name="email" value="">
        email.sendKeys("");
        WebElement password = driver.findElement(By.name("password1"));                           // <input type="text" name="password1">
        password.sendKeys("");
        WebElement password2 = driver.findElement(By.name("password2"));                          // <input type="password" name="password2">
        password2.sendKeys("");
        WebElement registerButtonTwo = driver.findElement(By.cssSelector("input[value='Register']"));  // <input type="submit" value="Register">
        registerButtonTwo.click();
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        Assert.assertEquals(
                errorMessage.getText(),
                "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Error: All fields should have data");
    }

    // [Sign Up] Test_6 (Passed)
    // Вариант_записи_2
    @Test
    public void emptyFieldsSignUp() {
        driver.get("https://sharelane.com/");
        driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")).click();
        driver.findElement(By.cssSelector("a[href='./register.py']")).click();
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        driver.findElement(By.cssSelector("input[value='Register']"));
        driver.findElement(By.name("first_name")).sendKeys("");
        driver.findElement(By.name("last_name")).sendKeys("");
        driver.findElement(By.name("email")).sendKeys("");
        driver.findElement(By.name("password1")).sendKeys("");
        driver.findElement(By.name("password2")).sendKeys("");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        boolean successful = driver.findElement(By.cssSelector("a[href='./main.py']")).isDisplayed();
        Assert.assertTrue(successful,
                "Error: All fields should have data");
    }

    // Дополнительно
    // [Sign Up] Test_7 (Passed)
    // The "Email" field has not the symbol "@"
    @Test
    public void emailHasNotSymbolATSignUp() {
        driver.get("https://sharelane.com/");
        driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")).click();
        driver.findElement(By.cssSelector("a[href='./register.py']")).click();
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        driver.findElement(By.cssSelector("input[value='Register']"));
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Smith");
        driver.findElement(By.name("email")).sendKeys("Testmail.ru");
        driver.findElement(By.name("password1")).sendKeys("122333444455555");
        driver.findElement(By.name("password2")).sendKeys("122333444455555");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        Assert.assertEquals(
                errorMessage.getText(),
                "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "ERROR: The Email field should has symbol AT");
    }

    // Дополнительно
    // [Sign Up] Test_8 (Failed) BUG
    // The "Password" field and the "ConfirmPassword" field are coincidence.
    @Test
    public void passwordConfirmPasswordCoincidenceSignUp() {
        driver.get("https://sharelane.com/");
        driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")).click();
        driver.findElement(By.cssSelector("a[href='./register.py']")).click();
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        driver.findElement(By.cssSelector("input[value='Register']"));
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Smith");
        driver.findElement(By.name("email")).sendKeys("Test@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("67890");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        Assert.assertEquals(
                errorMessage.getText(),
                "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "ERROR: the Password field and the Confirm Password field should coincidence");
    }

    // [Sign Up] Test_9 (Failed) BUG
    // The "First Name" field and the "Last Name" field should not coincidence
    @Test
    public void nameLastNameNotCoincidenceSignUp() {
        driver.get("https://sharelane.com/");
        driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")).click();
        driver.findElement(By.cssSelector("a[href='./register.py']")).click();
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        driver.findElement(By.cssSelector("input[value='Register']"));
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Alex");
        driver.findElement(By.name("email")).sendKeys("Test@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        Assert.assertEquals(
                errorMessage.getText(),
                "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "ERROR: the First Name field and the Last Name field should not coincidence");
    }

    // [Home Page] Test_10 (Passed)
    // Unknown user
    @Test
    public void logOnAsAnUnregisteredUser() {
        driver.get("https://sharelane.com/");
        driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")).click();
        driver.findElement(By.name("email")).sendKeys("TestUser2021@gmail.com"); // <input type="text" name="email">
        driver.findElement(By.name("password")).sendKeys("1111");                // <input type="password" name="password">
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        WebElement errorMessage = driver.findElement(By.className("error_message"));        // <span class="error_message">Oops, error. Email and/or password don't match our records</span>
        Assert.assertEquals(
                errorMessage.getText(),
                "Oops, error. Email and/or password don't match our records",
                "ERROR: An unregistered user can come in");
    }

    // [Search] Test_11 (Failed)
    // Search book by name work (This test should be fail)
    @Test
    public void lookForTheBookByNameOnHomePage() {
        driver.get("https://sharelane.com/");
        driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")).click();
        driver.findElement(By.name("keyword")).sendKeys("Gitanjali");
        driver.findElement(By.name("keyword")).sendKeys(Keys.ENTER);
        boolean verification = driver.findElement(By.name("email")).isDisplayed();
        Assert.assertTrue(verification,
                "ERROR: User can`t find the book by name");
    }

    // [Sign Up] Test_12 (Passed)
    // Performance testing (1 seconds)
    @Test
    public void allFieldsAreDisplayedOnSignUpFormAfterOneSecond() {
        driver.get("https://sharelane.com/");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        boolean checkOne = driver.findElement(By.cssSelector("a[href='./shopping_cart.py']")).isDisplayed();// <a href="./shopping_cart.py"><img src="../images/shopping_cart.gif" border="0">Shopping Cart</a>
        Assert.assertTrue(checkOne,
                "Web element didn`t load. Internet speed is low");
        boolean checkTwo = driver.findElement(By.name("keyword")).isDisplayed();                            // <input type="text" name="keyword" size="50">
        Assert.assertTrue(checkTwo,
                "Web element(keyword) didn`t load. Internet speed is low");
        driver.findElement(By.cssSelector("a[href='./register.py']")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        boolean checkThree = driver.findElement(By.name("zip_code")).isDisplayed();
        Assert.assertTrue(checkThree,
                "Web element(zip_code) didn`t load. Internet speed is low");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.name("zip_code")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input[value='Register']"));
        boolean checkFour = driver.findElement(By.cssSelector("input[value='Register']")).isDisplayed();
        Assert.assertTrue(checkFour,
                "Web element(Button SignUp) didn`t load. Internet speed is low");
        boolean checkFive = driver.findElement(By.name("first_name")).isDisplayed();  // The "First Name" field is displayed
        Assert.assertTrue(checkFive,
                "Web element(First Name) didn`t load. Internet speed is low");
        boolean checkSix = driver.findElement(By.name("last_name")).isDisplayed();   // The "Last Name" field is displayed
        Assert.assertTrue(checkSix,
                "Web element(Last Name) didn`t load. Internet speed is low");
        boolean checkSeven = driver.findElement(By.name("email")).isDisplayed();       // The "Email" field is displayed
        Assert.assertTrue(checkSeven,
                "Web element(Email) didn`t load. Internet speed is low");
        boolean checkEight = driver.findElement(By.name("password1")).isDisplayed();   // The "Password" field is displayed
        Assert.assertTrue(checkEight,
                "Web element(Password) didn`t load. Internet speed is low");
        boolean checkNine = driver.findElement(By.name("password2")).isDisplayed();   // The "Confirm Password" field is displayed
        Assert.assertTrue(checkNine,
                "Web element(Confirm Password) didn`t load. Internet speed is low");
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Smith");
        driver.findElement(By.name("email")).sendKeys("Test@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("122333444455555");
        driver.findElement(By.name("password2")).sendKeys("122333444455555");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        boolean successful = driver.findElement(By.cssSelector("a[href='./main.py']")).isDisplayed();
        Assert.assertTrue(successful,
                "ERROR: Web element(-s) is loaded slowly");
    }

    // [ZIP code] Test_13 (Passed) (Class Work)
    // There`s a valid data in the Zip code field
    @Test
    public void zipCodePozitivTest() {
        driver.get("https://sharelane.com/");
        driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")).click();
        driver.findElement(By.cssSelector("a[href='./register.py']")).click();
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        WebElement registerButton = driver.findElement(By.cssSelector("input[value='Register']"));
        Assert.assertTrue(registerButton.isDisplayed(),
                "Register button should be displayed");
    }

    // [ZIP code] Test_14 (Passed) (Class Work)
    // Zip code is empty
    @Test
    public void emptyZipCodeTest() {
        driver.get("https://sharelane.com/");
        driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")).click();
        driver.findElement(By.cssSelector("a[href='./register.py']")).click();
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        zipCodeInput = driver.findElement(By.name("zip_code"));
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        Assert.assertTrue(zipCodeInput.isDisplayed(),
                "Zip code input should be displayed");
        Assert.assertTrue(errorMessage.isDisplayed(),
                "Error message should appears");
        Assert.assertEquals(errorMessage.getText(),
                "Oops, error on page. ZIP code should have 5 digits",
                "ZIP code should have 5 or more digits");
    }

    // [Search] Test_15 (Passed)
    // Search (registered user) book (existing book) by title
    @Test
    public void searchBookExistingByTitle() {
        driver.get("https://sharelane.com/");
        driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")).click();
        driver.findElement(By.cssSelector("a[href='./register.py']")).click();
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        driver.findElement(By.cssSelector("input[value='Register']"));
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Alex");
        driver.findElement(By.name("email")).sendKeys("Test@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        String textEmail = driver.findElement(By.cssSelector("table[width='300'] > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2)")).getText();
        driver.findElement(By.cssSelector("a[href='./main.py']")).click();  // <a href="./main.py">here</a>
        driver.findElement(By.name("email")).sendKeys(textEmail);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        driver.findElement(By.name("keyword")).sendKeys("Gitanjali");// Gitanjali
        driver.findElement(By.name("keyword")).sendKeys(Keys.ENTER);
        String title = driver.findElement(By.cssSelector("body > center > table[width='700'] > tbody > tr:nth-child(5) > td > table[width='600'] > tbody > tr > td:nth-child(2) > p:nth-child(2)")).getText();
        Assert.assertEquals(title,
                "Gitanjali",
                "ERROR: The book didn`t found");
        driver.findElement(By.cssSelector("img[src='../images/product_9_large.jpg']"));                // <img src="../images/product_9_large.jpg">
    }

    // [Search] Test_16 (Passed)
    // Search (registered user) book (non-existent book) by title
    @Test
    public void searchBookNonExistingByTitle() {
        driver.get("https://sharelane.com/");
        driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")).click();
        driver.findElement(By.cssSelector("a[href='./register.py']")).click();
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        driver.findElement(By.cssSelector("input[value='Register']"));
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Alex");
        driver.findElement(By.name("email")).sendKeys("Test@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        String textEmail = driver.findElement(By.cssSelector("table[width='300'] > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2)")).getText();
        driver.findElement(By.cssSelector("a[href='./main.py']")).click();  // <a href="./main.py">here</a>
        driver.findElement(By.name("email")).sendKeys(textEmail);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        driver.findElement(By.name("keyword")).sendKeys("The Old Man and the Sea");// The Old Man and the Sea
        driver.findElement(By.name("keyword")).sendKeys(Keys.ENTER);
        String title = driver.findElement(By.cssSelector("html > body > center > table[width='700'] > tbody > tr:nth-child(4) > td")).getText();
        Assert.assertEquals(title,
                "Nothing is found :(",
                "ERROR: Search found the book which isn`t there");            // <span class="confirmation_message">Nothing is found :(</span>
    }

    // [Search] Test_17 (Failed) BUG книги не найдена
    // Search (registered user) book (existing book) by author
    @Test
    public void searchBookExistingByAuthor() {
        driver.get("https://sharelane.com/");
        driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")).click();
        driver.findElement(By.cssSelector("a[href='./register.py']")).click();
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        driver.findElement(By.cssSelector("input[value='Register']"));
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Alex");
        driver.findElement(By.name("email")).sendKeys("Test@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        String textEmail = driver.findElement(By.cssSelector("table[width='300'] > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2)")).getText();
        driver.findElement(By.cssSelector("a[href='./main.py']")).click();  // <a href="./main.py">here</a>
        driver.findElement(By.name("email")).sendKeys(textEmail);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.name("keyword")).sendKeys("Rabindranath Tagore");// Rabindranath Tagore
        driver.findElement(By.name("keyword")).sendKeys(Keys.ENTER);
        String title = driver.findElement(By.cssSelector("body > center > table[width='700'] > tbody > tr:nth-child(5) > td > table[width='600'] > tbody > tr > td:nth-child(2) > p")).getText();
        Assert.assertEquals(title,
                "Rabindranath Tagore",
                "ERROR: The book didn`t found");
        driver.findElement(By.cssSelector("img[src='../images/product_9_large.jpg']"));
    }

    // [Search] Test_18 (Passed)
    // Search (registered user) book (non-existent book) by author
    @Test
    public void searchBookNonExistingByAuthor() {
        driver.get("https://sharelane.com/");
        driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")).click();
        driver.findElement(By.cssSelector("a[href='./register.py']")).click();
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        driver.findElement(By.cssSelector("input[value='Register']"));
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Alex");
        driver.findElement(By.name("email")).sendKeys("Test@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        String textEmail = driver.findElement(By.cssSelector("table[width='300'] > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2)")).getText();
        driver.findElement(By.cssSelector("a[href='./main.py']")).click();  // <a href="./main.py">here</a>
        driver.findElement(By.name("email")).sendKeys(textEmail);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        driver.findElement(By.name("keyword")).sendKeys("Ernest Miller Hemingway");   // Ernest Miller Hemingway
        driver.findElement(By.name("keyword")).sendKeys(Keys.ENTER);
        String title = driver.findElement(By.cssSelector("html > body > center > table[width='700'] > tbody > tr:nth-child(4) > td")).getText();
        Assert.assertEquals(title,
                "Nothing is found :(",
                "ERROR: Search found the book which isn`t there");  // <span class="confirmation_message">Nothing is found :(</span>
    }

    // [Home page] Test_19 (Passed)
    // User(registered user) logout
    @Test
    public void logOut() {
        driver.get("https://sharelane.com/");
        driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")).click();
        driver.findElement(By.cssSelector("a[href='./register.py']")).click();
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        driver.findElement(By.cssSelector("input[value='Register']"));
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Alex");
        driver.findElement(By.name("email")).sendKeys("Test@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        String textEmail = driver.findElement(By.cssSelector("table[width='300'] > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2)")).getText();
        driver.findElement(By.cssSelector("a[href='./main.py']")).click();  // <a href="./main.py">here</a>
        driver.findElement(By.name("email")).sendKeys(textEmail);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("a[href='./log_out.py']")).click(); //   <a href="./log_out.py">Logout</a>
        String title = driver.findElement(By.cssSelector("html > body > center > table[width='700'] > tbody > tr:nth-child(4) > td")).getText(); // <span class="confirmation_message">You've been logged out</span>
        Assert.assertEquals(title,
                "You've been logged out",
                "ERROR: User can`t log out");
    }

    // Проверка ссылок
    // [Links] Test_20 (Passed)
    // Check link QATutor.com    Link №1 - QATutor.com  (<a href="https://www.qatutor.com" class="footer">QATutor.com</a>)
    @Test
    public void checkLink1QATutorcom() {
        driver.get("https://sharelane.com/");
        driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")).click();
        driver.findElement(By.cssSelector("a[href='./register.py']")).click();
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        driver.findElement(By.cssSelector("input[value='Register']"));
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Alex");
        driver.findElement(By.name("email")).sendKeys("Test@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        String textEmail = driver.findElement(By.cssSelector("table[width='300'] > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2)")).getText();
        driver.findElement(By.cssSelector("a[href='./main.py']")).click();  // <a href="./main.py">here</a>
        driver.findElement(By.name("email")).sendKeys(textEmail);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("a[href='https://www.qatutor.com']")).click();
        Boolean site = driver.findElement(By.cssSelector("html[lang='en-US']")).isDisplayed();
        Assert.assertTrue(site,
                "User can`t follow the link QATutor.com");
    }

    // [Links] Test_21 (Passed)
    // Check link Test Portal    Link №2 - Test Portal
    @Test
    public void checkLink2TestPortal() {
        driver.get("https://sharelane.com/");
        driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")).click();
        driver.findElement(By.cssSelector("a[href='./register.py']")).click();
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        driver.findElement(By.cssSelector("input[value='Register']"));
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Alex");
        driver.findElement(By.name("email")).sendKeys("Test@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        String textEmail = driver.findElement(By.cssSelector("table[width='300'] > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2)")).getText();
        driver.findElement(By.cssSelector("a[href='./main.py']")).click();  // <a href="./main.py">here</a>
        driver.findElement(By.name("email")).sendKeys(textEmail);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("a[href='../test_portal.html']")).click();   // <a href="../test_portal.html" class="footer">Test Portal</a>
        Boolean site = driver.findElement(By.cssSelector("html > body > center")).isDisplayed();
        Assert.assertTrue(site,
                "User can`t follow the link Test Portal");
    }

    // [Links] Test_22 (Passed)
    // Check link Python Source File    Link №3 - Python Source File
    @Test
    public void checkLink3PythonSourceFile() {
        driver.get("https://sharelane.com/");
        driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")).click();
        driver.findElement(By.cssSelector("a[href='./register.py']")).click();
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        driver.findElement(By.cssSelector("input[value='Register']"));
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Alex");
        driver.findElement(By.name("email")).sendKeys("Test@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        String textEmail = driver.findElement(By.cssSelector("table[width='300'] > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2)")).getText();
        driver.findElement(By.cssSelector("a[href='./main.py']")).click();  // <a href="./main.py">here</a>
        driver.findElement(By.name("email")).sendKeys(textEmail);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("a[href='../source_files/main_bright_normal.html']")).click();   // <a href="../source_files/main_bright_normal.html" class="footer">Python Source File</a>
        Boolean site = driver.findElement(By.cssSelector("html > body > pre > span:nth-child(2)")).isDisplayed();
        Assert.assertTrue(site,
                "User can`t follow the Python Source File");
    }

    /**
    // [Links] Test_23 ВОПРОС как проверить эту ссылку?
    // Check link Contact   Link №4 - Contact
    @Test
    public void checkLink4Contact() {
        driver.get("https://sharelane.com/");
        driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")).click();
        driver.findElement(By.cssSelector("a[href='./register.py']")).click();
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        driver.findElement(By.cssSelector("input[value='Register']"));
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Alex");
        driver.findElement(By.name("email")).sendKeys("Test@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        String textEmail = driver.findElement(By.cssSelector("table[width='300'] > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2)")).getText();
        driver.findElement(By.cssSelector("a[href='./main.py']")).click();  // <a href="./main.py">here</a>
        driver.findElement(By.name("email")).sendKeys(textEmail);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("a[href='../source_files/main_bright_normal.html']")).click();   // <a href="../source_files/main_bright_normal.html" class="footer">Python Source File</a>
        // Boolean site = driver.findElement(By.cssSelector("html > body > pre > span:nth-child(2)")).isDisplayed();
        // Assert.assertTrue(site, "User can`t follow the Mail");
    }
    */

    // [Logo] Test_24 (Passed)
    // User (registered user) chose and opened left book then click Logo (Book page to Home page)
    @Test
    public void logoClickBookPageToHomePageLeftBook() {
        driver.get("https://sharelane.com/");
        driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")).click();
        driver.findElement(By.cssSelector("a[href='./register.py']")).click();
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        driver.findElement(By.cssSelector("input[value='Register']"));
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Alex");
        driver.findElement(By.name("email")).sendKeys("Test@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        String textEmail = driver.findElement(By.cssSelector("table[width='300'] > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2)")).getText();
        driver.findElement(By.cssSelector("a[href='./main.py']")).click();  // <a href="./main.py">here</a>
        driver.findElement(By.name("email")).sendKeys(textEmail);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("html > body > center > table[width='700'] > tbody > tr:nth-child(5) > td > table[align='center'] > tbody > tr > td > table[width='300'] > tbody > tr:nth-child(3) > td")).click();
        boolean picture = driver.findElement(By.cssSelector("html > body > center > table[width='700'] > tbody > tr:nth-child(5) > td > table[width='600'] > tbody > tr > td")).isDisplayed();
        Assert.assertTrue(picture,
                "Book page which user chose should be open");
        driver.findElement(By.cssSelector("img[src='../images/logo.jpg']")).click();  // <img src="../images/logo.jpg" border="0">
        boolean logo = driver.findElement(By.cssSelector("html > body > center > table[width='700'] > tbody > tr:nth-child(5) > td > table[align='center'] > tbody > tr > td > table[width='300'] > tbody > tr:nth-child(3) > td")).isDisplayed();
        Assert.assertTrue(logo,
                "Logo doesn`t return the user to the home page");
    }

    // [Logo] Test_25 (Passed)
    // User (registered user) chose and opened right book then click Logo (Book page to Home page)
    @Test
    public void logoClickBookPageToHomePageRightBook() {
        driver.get("https://sharelane.com/");
        driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")).click();
        driver.findElement(By.cssSelector("a[href='./register.py']")).click();
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        driver.findElement(By.cssSelector("input[value='Register']"));
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Alex");
        driver.findElement(By.name("email")).sendKeys("Test@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        String textEmail = driver.findElement(By.cssSelector("table[width='300'] > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2)")).getText();
        driver.findElement(By.cssSelector("a[href='./main.py']")).click();  // <a href="./main.py">here</a>
        driver.findElement(By.name("email")).sendKeys(textEmail);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("html > body > center > table[width='700'] > tbody > tr:nth-child(5) > td > table[align='center'] > tbody > tr > td:nth-child(2) > table[width='300'] > tbody > tr:nth-child(3) > td")).click();
        boolean picture = driver.findElement(By.cssSelector("html > body > center > table[width='700'] > tbody > tr:nth-child(5) > td > table[width='600'] > tbody > tr > td")).isDisplayed();
        Assert.assertTrue(picture,
                "Book page which user chose should be open");
        driver.findElement(By.cssSelector("img[src='../images/logo.jpg']")).click();  // <img src="../images/logo.jpg" border="0">
        boolean logo = driver.findElement(By.cssSelector("html > body > center > table[width='700'] > tbody > tr:nth-child(5) > td > table[align='center'] > tbody > tr > td > table[width='300'] > tbody > tr:nth-child(3) > td")).isDisplayed();
        Assert.assertTrue(logo,
                "Logo doesn`t return the user to the home page");
    }

    // [Shopping Cart] Test_26 (Passed)
    // User (unregistered user) goes to Shopping Cart
    @Test
    public void unregisteredUserGoesToShoppingCart() {
        driver.get("https://sharelane.com/");
        driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")).click();
        driver.findElement(By.cssSelector("a[href='./shopping_cart.py']")).click();// <a href="./shopping_cart.py"><img src="../images/shopping_cart.gif" border="0">Shopping Cart</a>
        boolean errorMessage = driver.findElement(By.cssSelector("html > body > center > table[width='700'] > tbody > tr:nth-child(4) > td")).isDisplayed(); // <span class="error_message">Oops, error. You must log in</span>
        Assert.assertTrue(errorMessage,
                "An unregistered user can log into the Shopping cart");
    }

    // [Log In] Test_27 (Passed)
    // User (unregistered user) goes to log in
    @Test
    public void unregisteredUserGoesToLogIn() {
        driver.get("https://sharelane.com/");
        driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")).click();
        driver.findElement(By.name("email")).sendKeys("TestQA@gmail.com");
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        String errorMessage = driver.findElement(By.cssSelector("html > body > center > table[width='700'] > tbody > tr:nth-child(4) > td")).getText();
        Assert.assertEquals(errorMessage,
                "Oops, error. Email and/or password don't match our records",
                "An unregistered user can log into the shop");                   // <span class="error_message">Oops, error. Email and/or password don't match our records</span>
    }

    // [Shopping Cart] Test_28 (Passed)
    // Shopping cart should be empty (no book selected)
    @Test
    public void noBookSelectedShoppingCartEmpty() {
        driver.get("https://sharelane.com/");
        driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")).click();
        driver.findElement(By.cssSelector("a[href='./register.py']")).click();
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        driver.findElement(By.cssSelector("input[value='Register']"));
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Alex");
        driver.findElement(By.name("email")).sendKeys("Test@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        String textEmail = driver.findElement(By.cssSelector("table[width='300'] > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2)")).getText();
        driver.findElement(By.cssSelector("a[href='./main.py']")).click();  // <a href="./main.py">here</a>
        driver.findElement(By.name("email")).sendKeys(textEmail);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("a[href='./shopping_cart.py']")).click();  // <a href="./shopping_cart.py"><img src="../images/shopping_cart.gif" border="0">Shopping Cart</a>
        String errorMessage = driver.findElement(By.cssSelector("html > body > center > table[width='700'] > tbody > tr:nth-child(4) > td")).getText();
        Assert.assertEquals(errorMessage,
                "Cart is empty",
                "Shopping cart should be empty");               // <span class="confirmation_message">Cart is empty</span>
    }

    // [Shopping Cart] Test_29 (Passed)
    // User (registered user) adds one book and goes to Shopping Cart
    @Test
    public void addOneBook() {
        driver.get("https://sharelane.com/");
        driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")).click();
        driver.findElement(By.cssSelector("a[href='./register.py']")).click();
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        driver.findElement(By.cssSelector("input[value='Register']"));
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Alex");
        driver.findElement(By.name("email")).sendKeys("Test@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        String textEmail = driver.findElement(By.cssSelector("table[width='300'] > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2)")).getText();
        driver.findElement(By.cssSelector("a[href='./main.py']")).click();  // <a href="./main.py">here</a>
        driver.findElement(By.name("email")).sendKeys(textEmail);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("html > body > center > table[width='700'] > tbody > tr:nth-child(5) > td > table[align='center'] > tbody > tr > td > table[width='300'] > tbody > tr:nth-child(3) > td")).click();
        driver.findElement(By.cssSelector("img[src='../images/add_to_cart.gif']")).click();  // <img src="../images/add_to_cart.gif" border="0">
        String successMessage = driver.findElement(By.cssSelector("html > body > center > table[width='700'] > tbody > tr:nth-child(4) > td")).getText();
        Assert.assertEquals(successMessage,
                "Book was added to the Shopping Cart",
                "Book was not added to the Shopping Cart");   // <span class="confirmation_message">Book was added to the Shopping Cart</span>
        driver.findElement(By.cssSelector("a[href='./shopping_cart.py']")).click();
        boolean checkout = driver.findElement(By.cssSelector("html > body > center > table[width='700'] > tbody > tr:nth-child(5) > td > table[width='700'] > tbody > tr:nth-child(5) > td")).isDisplayed(); //
        Assert.assertTrue(checkout,
                "Shopping cart shouldn`t be empty");
    }
    /**
     * RESULT
     * Passed - 24
     * Failed - 4 (3 + 1(Test_11 should be fail))
     * Bugs - 3
     * Questions - 1 (Test_23)
     */
}
