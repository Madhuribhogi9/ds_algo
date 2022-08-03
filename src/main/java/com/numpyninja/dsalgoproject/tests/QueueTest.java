package com.numpyninja.dsalgoproject.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.numpyninja.dsalgoproject.listeners.ExtentListener;
import com.numpyninja.dsalgoproject.pages.*;
import com.numpyninja.dsalgoproject.utilities.FileManager;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * This test case will login into https://dsportalapp.herokuapp.com/
 */
@Listeners({ExtentListener.class})
public class QueueTest extends BaseTest
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
    @Description("Verifying Queue page")
    @Epic("07")
    @Feature("Feature1:Queue page")
    @Story("Story:Checking Queue page")
    @Step("Queue page")
    @Severity(SeverityLevel.MINOR)
    public void queue()
    {
        ExtentTest extentTest = extent.createTest("Queue page").log(Status.PASS, "Queue page");
        extentTest.log(Status.PASS,"Queue test is passed");

        HomePage homePage = new HomePage(driver);
        logger.info("****************************Homepage is opened****************************");
        homePage.queue();

        LinkedListPage linkedListPage = new LinkedListPage();
        QueuePage queuePage = new QueuePage();
        logger.info("****************************Opening Queue page****************************");
        queuePage.implementationOfQueueinPython();
        queuePage.implementationOfQueueinPython();
        linkedListPage.tryHereClick();
        String pythonCode = FileManager.ReadCellData(3, 1);
        linkedListPage.getEnteringCode().sendKeys(pythonCode);
        linkedListPage.run();
        driver.navigate().back();
        queuePage.implementationUsingCollectionsDeque();
        linkedListPage.tryHereClick();
        linkedListPage.getEnteringCode().sendKeys(pythonCode);
        linkedListPage.run();
        driver.navigate().back();
        queuePage.implementationUsingArray();
        linkedListPage.tryHereClick();
        linkedListPage.getEnteringCode().sendKeys(pythonCode);
        linkedListPage.run();
        driver.navigate().back();
        queuePage.queueOperation();
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
