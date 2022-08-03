package com.numpyninja.dsalgoproject.tests;

import com.numpyninja.dsalgoproject.listeners.ExtentListener;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.*;
import com.numpyninja.dsalgoproject.pages.HomePage;
import com.numpyninja.dsalgoproject.pages.RegisterPage;
import com.numpyninja.dsalgoproject.utilities.FileManager;

import java.io.IOException;

/**
 * This test case will login into https://dsportalapp.herokuapp.com/
 */

@Listeners({ExtentListener.class})
public class RegistrationTest extends BaseTest
{
    @BeforeMethod
    public void homepage()
    {
        logger = LogManager.getLogger(RegistrationTest.class);
        HomePage homePage = new HomePage(driver);
        logger.info("**********My homepage is started*********");
        homePage.getStartedBtn();
        logger.info("clicking on get started button");
        homePage.getDropdown();
        logger.info("clicking on dropdown button");
        homePage.dsIntroduction();
        homePage.array();
        logger.info("clicking on register button");
        homePage.register();
    }

    /**
     * Doing data-driven testing.
     * Creating an account.
     * @throws IOException
     */
    @Test
    @Description("Registration process")
    @Epic("01")
    @Feature("Feature1:Registration")
    @Story("Story:Registering by giving valid details")
    @Step("Registering")
    @Severity(SeverityLevel.BLOCKER)
    public void Registration() throws IOException
    {

    RegisterPage registerPage = new RegisterPage(driver);
    logger.info("Register page is opened");
    registerPage.registerBtn();
    logger.info("Registration is started");
    logger.info("**********DataDriven testing is started*********");
    String userName = FileManager.ReadCellData(0,1);
    registerPage.getNameTextBox().sendKeys(userName);
    logger.info("username is given");
    String password = FileManager.ReadCellData(1,1);
    registerPage.getPasswordTextBox().sendKeys(password);
    logger.info("password is given");
    registerPage.getConfirmpasswordtextbox().sendKeys(password);
    logger.info("Reconfirming the password is successfull");
    registerPage.registerBtn();
    logger.info("**********registration process is done*********");
}

    /**
     *And then closing the browser.
     */
    @AfterMethod
    public void closeapp()
    {
        driver.close();
        logger.info("****************************driver is closed****************************");
    }
}
