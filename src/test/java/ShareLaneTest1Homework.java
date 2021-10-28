import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ShareLaneTest1Homework {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        // open browser
        driver = new ChromeDriver();
        // открытие окна на всеь размер
        driver.manage().window().maximize();
        // ждет 1 секунд
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        // Закрытие браузера
        driver.quit();
    }

    // ДЗ (4 теста на ZIP code (3 - passed, 1 - failed), 2 теста на Sign Up (2 - passed))
    // ZIP code
    // Test_1 (Passed)
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

    // Test_2 (Passed)
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
        Assert.assertTrue(registerButton.isDisplayed(), "Register button should be displayed");
    }

    // Test_3 (Passed)
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

    // Test_4 (Passed)
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
        Assert.assertEquals(errorMessage.getText(), "Oops, error on page. ZIP code should have 5 digits", "Error");
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
    // Test_5 (Passed)
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
        Assert.assertTrue(successful, "ERROR: Data isn`t correct");
    }

    // Test_5 (Passed)
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
        Assert.assertTrue(successful, "ERROR: Data isn`t correct");
    }

    // Test_6 (Passed)
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

    // Test_6 (Passed)
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
        Assert.assertTrue(successful, "Error: All fields should have data");
    }

    // Дополнительно
    // Test_7 (Passed)
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
    // Test_8 (Failed) BUG
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

    // Test_9 (Failed) BUG
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

    // Test_10 (Passed)
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

    // Test_11 (Failed)
    // Search book by name work (This test should be fail)
    @Test
    public void lookForTheBookByNameOnHomePage() {
        driver.get("https://sharelane.com/");
        driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")).click();
        driver.findElement(By.name("keyword")).sendKeys("Gitanjali");
        driver.findElement(By.name("keyword")).sendKeys(Keys.ENTER);
        boolean verification = driver.findElement(By.name("email")).isDisplayed();
        Assert.assertTrue(verification, "ERROR: User can`t find the book by name");
    }

    // Test_12 (Passed)
    // Performance testing (1 seconds)
    @Test
    public void allFieldsAreDisplayedOnSignUpFormAfterOneSecond() {
        driver.get("https://sharelane.com/");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        boolean checkOne = driver.findElement(By.cssSelector("a[href='./shopping_cart.py']")).isDisplayed();// <a href="./shopping_cart.py"><img src="../images/shopping_cart.gif" border="0">Shopping Cart</a>
        Assert.assertTrue(checkOne, "Web element didn`t load. Internet speed is low");
        boolean checkTwo = driver.findElement(By.name("keyword")).isDisplayed();                            // <input type="text" name="keyword" size="50">
        Assert.assertTrue(checkTwo, "Web element(keyword) didn`t load. Internet speed is low");
        driver.findElement(By.cssSelector("a[href='./register.py']")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        boolean checkThree = driver.findElement(By.name("zip_code")).isDisplayed();
        Assert.assertTrue(checkThree, "Web element(zip_code) didn`t load. Internet speed is low");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.name("zip_code")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input[value='Register']"));
        boolean checkFour = driver.findElement(By.cssSelector("input[value='Register']")).isDisplayed();
        Assert.assertTrue(checkFour, "Web element(Button SignUp) didn`t load. Internet speed is low");
        boolean checkFive = driver.findElement(By.name("first_name")).isDisplayed();  // The "First Name" field is displayed
        Assert.assertTrue(checkFive, "Web element(First Name) didn`t load. Internet speed is low");
        boolean checkSix = driver.findElement(By.name("last_name")).isDisplayed();   // The "Last Name" field is displayed
        Assert.assertTrue(checkSix, "Web element(Last Name) didn`t load. Internet speed is low");
        boolean checkSeven = driver.findElement(By.name("email")).isDisplayed();       // The "Email" field is displayed
        Assert.assertTrue(checkSeven, "Web element(Email) didn`t load. Internet speed is low");
        boolean checkEight = driver.findElement(By.name("password1")).isDisplayed();   // The "Password" field is displayed
        Assert.assertTrue(checkEight, "Web element(Password) didn`t load. Internet speed is low");
        boolean checkNine = driver.findElement(By.name("password2")).isDisplayed();   // The "Confirm Password" field is displayed
        Assert.assertTrue(checkNine, "Web element(Confirm Password) didn`t load. Internet speed is low");
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Smith");
        driver.findElement(By.name("email")).sendKeys("Test@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("122333444455555");
        driver.findElement(By.name("password2")).sendKeys("122333444455555");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        boolean successful = driver.findElement(By.cssSelector("a[href='./main.py']")).isDisplayed();
        Assert.assertTrue(successful, "ERROR: Web element(-s) is loaded slowly");
    }
    /** RESULT
     Passed - 9
     Failed - 3 (2 + 1(Test_11 should be fail))
     Bugs - 2
     */
}
