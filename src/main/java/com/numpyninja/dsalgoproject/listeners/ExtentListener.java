package com.numpyninja.dsalgoproject.listeners;


import com.aventstack.extentreports.MediaEntityBuilder;
import com.numpyninja.dsalgoproject.tests.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.numpyninja.dsalgoproject.utilities.WebDriverUtility;

import java.io.IOException;

import static com.numpyninja.dsalgoproject.tests.BaseTest.extentTest;

/**
 * Custom listener for reporting.
 * @author madhuri
 */

public class ExtentListener implements ITestListener
{
    private String getTestMethodName(ITestResult iTestResult)
    {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment
    public byte[] saveFailureScreenshot(WebDriver driver)
    {
            byte[] screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            return screenshotAs;
    }

    @Attachment(value = "{0}",type = "text/plain")
    public String saveTextLog(String message)
    {
        return message;
    }

    @Override
    public void onTestStart(ITestResult result)
    {
        System.out.println("I am onteststart method"+getTestMethodName(result)+ "start");
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {

       System.out.println("I am ontestsuccess method" +getTestMethodName(result)+ "success");
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        System.out.println("I am ontestfailure method" +getTestMethodName(result)+ "failure");
        /*Object testResult = result.getInstance();
      WebDriver driver = BaseTest.getDriver();
        if(driver instanceof WebDriver)
        {
           System.out.println("Screenshot Captured :"+getTestMethodName(result));
           saveFailureScreenshot(driver);
        }
        saveTextLog(getTestMethodName(result)+"failed and screenshot is taken");*/
        try
        {
            String fail = WebDriverUtility.capture(BaseTest.getDriver());
            extentTest.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(fail).build());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        System.out.println("I am ontestskipped method"+getTestMethodName(result)+ "skipped");
    }

    @Override
    public void onStart(ITestContext context)
    {
        System.out.println("I am on onstart method"+context.getName());
        context.setAttribute("WebDriver",BaseTest.getDriver());
    }

    @Override
    public void onFinish(ITestContext context)
    {
        System.out.println("I am onFinish method"+context.getName());
    }
}
