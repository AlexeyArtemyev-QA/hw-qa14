package SauceDemoPageObject.Test;

import SauceDemoPageObject.utils.AllureUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(String.format("Test '%s' succeed", result.getName())); // напишет лог при успехе, прикручиваем аннотацией Listeners к КЛАССУ (после импортов) см класс BaseTest
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(String.format("Test '%s' failed", result.getName()));
        WebDriver driver = (WebDriver)(result.getTestContext().getAttribute("driver"));
        AllureUtils.attachScreenshot(driver);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
