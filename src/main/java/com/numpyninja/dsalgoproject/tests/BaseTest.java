package com.numpyninja.dsalgoproject.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.numpyninja.dsalgoproject.Constants;
import com.numpyninja.dsalgoproject.listeners.ExtentListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import com.numpyninja.dsalgoproject.utilities.FileManager;
import java.io.IOException;
import java.time.Duration;

@Listeners(ExtentListener.class)
public class BaseTest
{
    private FileManager input = new FileManager();

    public static ExtentReports extent;
    public static ExtentSparkReporter sparkreport = new ExtentSparkReporter("Extentreport.html");
    public static ExtentTest extentTest;

    protected static WebDriver driver;
    protected Logger logger;

    public static WebDriver getDriver()
    {
        return driver;
    }


    /**
     * Initializes log4j2 configuration file and extent report object instances.
     */
    @BeforeSuite
    public void extentreportmethod()
    {
        System.setProperty(Constants.LOG4J2_CONFIG_PROPERTY, Constants.LOG4J2_CONFILE_FILE_PATH);
        extent = new ExtentReports();
        extent.attachReporter(sparkreport);
        extentTest = extent.createTest("Launching browser test").log(Status.INFO, "Launching browser test");
        extentTest.log(Status.INFO, "Launching browser");
    }

    /**
     * Launches browser depending upon parameter type passed-in.
     * @param browsername is the type of browser
     * @throws IOException is thrown when any problem occurs
     */
    @BeforeClass
    @Parameters("browsers")
    public void launchingbrowser(String browsername) throws IOException
    {
        logger = LogManager.getLogger(BaseTest.class);

        if(browsername.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        if(browsername.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        logger.info("****************************Launching my browser****************************");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.manage().window().maximize();
        driver.get(input.getPropertyValue("url"));
    }

    @AfterSuite
    public void afterclass()
    {
        extent.flush();
    }
}
