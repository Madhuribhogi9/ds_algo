package com.numpyninja.dsalgoproject.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.numpyninja.dsalgoproject.listeners.ExtentListener;
import com.numpyninja.dsalgoproject.pages.HomePage;
import com.numpyninja.dsalgoproject.pages.LinkedListPage;
import com.numpyninja.dsalgoproject.pages.SigninPage;
import com.numpyninja.dsalgoproject.pages.StackPage;
import com.numpyninja.dsalgoproject.utilities.FileManager;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Stack;

/**
 * This test case will login into https://dsportalapp.herokuapp.com/
 */
@Listeners({ExtentListener.class})
public class StackTest extends BaseTest
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
    @Description("Verifying Stack page")
    @Epic("06")
    @Feature("Feature1:Stack page")
    @Story("Story:Checking Stack page")
    @Step("Stack page")
    @Severity(SeverityLevel.MINOR)
    public void stack()
    {
        ExtentTest extentTest = extent.createTest("Stack page").log(Status.PASS, "Stack page");
        extentTest.log(Status.PASS,"Stack test is passed");

        HomePage homePage = new HomePage(driver);
        logger.info("****************************Homepage is opened****************************");
        homePage.stack();

        LinkedListPage linkedListPage = new LinkedListPage();
        StackPage stackPage = new StackPage();
        logger.info("****************************Opening Stack page****************************");
        stackPage.clickOnOperationsInStackLink();
        linkedListPage.tryHereClick();
        String pythonCode = FileManager.ReadCellData(3, 1);
        linkedListPage.getEnteringCode().sendKeys(pythonCode);
        linkedListPage.run();
        driver.navigate().back();
       stackPage.clickOnImplementation();
        linkedListPage.tryHereClick();
        linkedListPage.getEnteringCode().sendKeys(pythonCode);
        linkedListPage.run();
        driver.navigate().back();
        stackPage.clickOnApplicationsLink();
        linkedListPage.tryHereClick();
        linkedListPage.getEnteringCode().sendKeys(pythonCode);
        linkedListPage.run();

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



