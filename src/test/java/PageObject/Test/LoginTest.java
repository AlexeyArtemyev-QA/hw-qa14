package PageObject.Test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @Test (invocationCount = 4, threadPoolSize = 2) // (invocationCount) запуститься 4 раза; (threadPoolSize) количество потоков кол-во браузеров; итого запустит 4 раза на двух потоках
    public void loginWithEmptyUsername2() {
        String expectedErrorMessage = "Epic sadface: Username is required";
        loginPage.login("", PASSWORD);
        Assert.assertEquals(loginPage.getCurrentPageUrl(), LOGIN_PAGE_URL);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertEquals(loginPage.getErrorMessageText(), expectedErrorMessage);
    }


// Параметризованные тесты
    @Test (dataProvider = "Negative Login Test Data") // передача провайдера в тест
    public void loginNegativeTest (String username, String password, String expectedErrorMessage){
        loginPage.login(username, password);
        String actualErrorMessageText = loginPage.getErrorMessageText();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertEquals(actualErrorMessageText, expectedErrorMessage);
    }

    @DataProvider(name = "Negative Login Test Data")
    public Object[][] getNegativeLoginData() {
        return new Object[][]{
                {"", "secret_sauce","Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
        };
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

