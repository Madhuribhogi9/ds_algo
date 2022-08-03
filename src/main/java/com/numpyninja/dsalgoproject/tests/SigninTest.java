package com.numpyninja.dsalgoproject.tests;

import com.aventstack.extentreports.Status;
import com.numpyninja.dsalgoproject.listeners.ExtentListener;
import io.qameta.allure.*;
import org.apache.logging.log4j.*;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.numpyninja.dsalgoproject.pages.HomePage;
import com.numpyninja.dsalgoproject.pages.SigninPage;
import com.numpyninja.dsalgoproject.utilities.FileManager;

import java.io.IOException;

/**
 * This test case will login into https://dsportalapp.herokuapp.com/
 */

@Listeners({ExtentListener.class})
public class SigninTest extends BaseTest
{
    /**
     * Doing data-driven testing.
     */
    @BeforeMethod
    public void signin()
    {
        homePageActions();
        signinPageActions();
    }

    /**
     * Verifying that title contains Numpy Ninja.
     */
    @Test
    @Description("Signin process")
    @Epic("02")
    @Feature("Feature1:Signin")
    @Story("Story:Signin by giving invalid details")
    @Step("Signin")
    @Severity(SeverityLevel.CRITICAL)
    public void signinbyinvalidcredentials()
    {
        extentTest = extent.createTest("Invalid login details test").log(Status.FAIL, "Failed test");
        extentTest.log(Status.FAIL, "Failed test case");

        logger.warn("!!!!!!!!!!!!!!Given Invalid credentials!!!!!!!!!!!!!");
        String title = driver.getTitle();
        Assert.assertTrue(Boolean.parseBoolean(title), "Numpy Ninja");
    }

    /**
     * And then closing the browser.
     * @param result
     */
    @AfterMethod
    public void closeapp(ITestResult result)
    {
        if(result.getStatus() ==ITestResult.FAILURE)
        {
            driver.close();
            logger.info("****************************driver is closed****************************");
        }
    }

    private void signinPageActions()
    {
        SigninPage signinPage = new SigninPage(driver);
        logger.info("****************************Data driven testing is started****************************");
        signinPage.getUsernameTxtBox().sendKeys(FileManager.ReadCellData(4, 1));
        logger.info("username is provided");
        signinPage.getPasswordTextBox().sendKeys(FileManager.ReadCellData(5, 1));
        logger.info("password is provided");
        signinPage.login();
        logger.info("Clicking on login button");
    }

    private void homePageActions()
    {
        logger = LogManager.getLogger(SigninTest.class);
        HomePage homePage = new HomePage(driver);
        logger.info("****************************Homepage is opened****************************");
        homePage.getStartedBtn();
        logger.info("Clicked on get started button");
        homePage.signin();
        logger.info("Clicked on signin button");
    }
}

