package com.numpyninja.dsalgoproject.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.numpyninja.dsalgoproject.listeners.ExtentListener;
import io.qameta.allure.*;
import org.testng.annotations.*;
import com.numpyninja.dsalgoproject.pages.HomePage;
import com.numpyninja.dsalgoproject.pages.IntroductionPage;
import com.numpyninja.dsalgoproject.pages.SigninPage;
import com.numpyninja.dsalgoproject.pages.TimecomplexityPage;
import com.numpyninja.dsalgoproject.utilities.FileManager;

import org.apache.logging.log4j.*;

/**
 * This test case will login into https://dsportalapp.herokuapp.com/
 */
@Listeners({ExtentListener.class})
public class IntroductionTest extends BaseTest
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
     * * Writing python code.
     */
    @Test
    @Description("Verifying introduction page")
    @Epic("03")
    @Feature("Feature1:Data Structures-Introduction")
    @Story("Story:Checking introduction page")
    @Step("Introduction page")
    @Severity(SeverityLevel.MINOR)
    public void introductionpage()
    {

        ExtentTest test = extent.createTest("Introduction").log(Status.PASS,"Introduction page");
        test.log(Status.PASS,"Introduction test is passed");
        homepageTestActions();
        introductionPage();
        timeComplexityPage();
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
        logger = LogManager.getLogger(IntroductionTest.class);
        HomePage homePage = new HomePage(driver);
        logger.info("****************************Homepage is opened****************************");
        homePage.getStartedBtn();
        logger.info("Clicked on get started button");
        homePage.signin();
        logger.info("Clicked on signin button");
    }

    private void homepageTestActions()
    {
        HomePage homePage = new HomePage(driver);
        logger.info("****************************Opening Data Structures-Introduction****************************");
        homePage.introductionDetails();
    }

    private void introductionPage()
    {
        IntroductionPage introductionPage = new IntroductionPage(driver);
        logger.info("Redirecting to time complexity page");
        introductionPage.timecomplexityBtn();
    }

    private void timeComplexityPage()
    {
        TimecomplexityPage timecomplexityPage = new TimecomplexityPage(driver);
        logger.info("Redirecting to practice questions page");
        timecomplexityPage.practiceQuestionClick();
        driver.navigate().back();
        timecomplexityPage.tryhereClick();
        logger.info("Entering python code");
        String pythonCode = FileManager.ReadCellData(2, 1);
        timecomplexityPage.getEnteringCode().sendKeys(pythonCode);
        timecomplexityPage.run();
        logger.info("python code is running sucessfully");
    }
}