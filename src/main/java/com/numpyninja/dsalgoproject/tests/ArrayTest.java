package com.numpyninja.dsalgoproject.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.numpyninja.dsalgoproject.listeners.ExtentListener;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.numpyninja.dsalgoproject.pages.Arraypage;
import com.numpyninja.dsalgoproject.pages.HomePage;
import com.numpyninja.dsalgoproject.pages.SigninPage;
import com.numpyninja.dsalgoproject.utilities.FileManager;

import java.io.IOException;

/**
 * This test case will login into https://dsportalapp.herokuapp.com/
 */
@Listeners({ExtentListener.class})
public class ArrayTest extends BaseTest
{
    /**
     * Doing data-driven testing.
     */
    @BeforeMethod
    public void signin() throws IOException
    {
        homePageActions();
        signinPageActions();
    }

    /**
     * Writing python code.
     * @throws InterruptedException
     */
    @Test
    @Description("Verifying Array page")
    @Epic("04")
    @Feature("Feature1:Array page")
    @Story("Story:Checking array page")
    @Step("Array page")
    @Severity(SeverityLevel.MINOR)
    public void arraypage()
    {
        ExtentTest extentTest = extent.createTest("Array page").log(Status.PASS, "Array page");
        extentTest.log(Status.PASS,"Array test is passed");

        HomePage homePage = new HomePage(driver);
        logger.info("****************************Homepage is opened****************************");
        homePage.arrayListDetails();

        Arraypage arraypage = new Arraypage();
        logger.info("****************************Opening Array page****************************");
        arraypage.arraysInPython();
        arraypage.tryHereClick();
        String pythonCode = FileManager.ReadCellData(3, 1);
        arraypage.getEnteringCode().sendKeys(pythonCode);
        arraypage.run();
        driver.navigate().back();
        arraypage.arrayUsingList();
        arraypage.tryHereClick();
        arraypage.getEnteringCode().sendKeys(pythonCode);
        arraypage.run();
        driver.navigate().back();
        arraypage.basicInList();
        arraypage.tryHereClick();
        arraypage.getEnteringCode().sendKeys(pythonCode);
        arraypage.run();
        driver.navigate().back();
        arraypage.appsInArray();
        arraypage.tryHereClick();
        arraypage.getEnteringCode().sendKeys(pythonCode);
        arraypage.run();
        driver.navigate().back();
        arraypage.practiceQtns();

    }

    /**
     * And then closing the browser.
     */
    @AfterMethod
    public void closeapp()
    {
        driver.close();
        logger.info("****************************driver is closed****************************");
    }
    private void signinPageActions()
    {
        logger.info("Clicked on signin button");
        SigninPage signinPage = new SigninPage(driver);
        logger.info("****************************Data driven testing is started****************************");
        String userName = FileManager.ReadCellData(0, 1);
        signinPage.getUsernameTxtBox().sendKeys(userName);
        logger.info("username is provided");
        String password = FileManager.ReadCellData(1, 1);
        signinPage.getPasswordTextBox().sendKeys(password);
        logger.info("password is provided");
        signinPage.login();
        logger.info("Login is completed successfully");
    }

    private void homePageActions()
    {
        HomePage homePage = new HomePage(driver);
        logger.info("****************************Homepage is opened****************************");
        homePage.getStartedBtn();
        logger.info("Clicked on get started button");
        homePage.signin();
    }
}
