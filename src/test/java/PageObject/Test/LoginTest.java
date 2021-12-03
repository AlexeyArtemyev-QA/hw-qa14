package PageObject.Test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class LoginTest extends BaseTest {

    @AfterMethod
    public void clearCookies() {
        driver.manage().deleteAllCookies();
    }

    @BeforeMethod
    public void navigateToLoginPage() {
        loginPage.open();
    }

    private final static String LOGIN_PAGE_URL = "https://www.saucedemo.com/";

    @Test(retryAnalyzer = Retry.class) // перезапуск теста см класс Retry
    public void loginPositiveTest() throws IOException {
        loginPage.login(USERNAME, PASSWORD);
        // Сделать и сохранить (следующие три строчки) скриншот (принимает абсолютный путь)
         File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
         File disFile = new File("C:/dev/hw-qa14/target.jpg"); // можно разные форматы jpg, png
         FileUtils.copyFile(file, disFile);
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(loginPage.getCurrentPageUrl(), expectedUrl);
    }
// ДОДЕЛАТЬ
//    @Test
//    public void loginWithEmptyUsername() {
//        String expectedErrorMessage = "Epic sadface: Username is required";
//        loginPage.login("", PASSWORD);
//        Assert.assertEquals(loginPage.getCurrentPageUrl(), LOGIN_PAGE_URL);
//        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
//        Assert.assertEquals(loginPage.getErrorMessageText(), expectedErrorMessage);
//    }
//    @DataProvider (name = "Negative Login Test Data")
//    public Object[][] getNegativeLoginData;
//    return new Object[][]{
//        {"", "", ""},
//        {"standard_user", "", ""},
//        {"", "", ""},
//    }

    @Test
    public void loginWithEmptyUsername2(String username, String password,String expestedErrorMessage) {
        String expectedErrorMessage = "Epic sadface: Username is required";
        loginPage.login("", PASSWORD);
        Assert.assertEquals(loginPage.getCurrentPageUrl(), LOGIN_PAGE_URL);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertEquals(loginPage.getErrorMessageText(), expectedErrorMessage);
    }



    @Test
    public void loginWithEmptyPassword() {
        String expectedErrorMessage = "Epic sadface: Password is required";
        String currentPageUrl = loginPage.getCurrentPageUrl();
        loginPage.login(USERNAME, "");
        Assert.assertEquals(loginPage.getCurrentPageUrl(), currentPageUrl);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertEquals(loginPage.getErrorMessageText(), expectedErrorMessage);
    }
}

