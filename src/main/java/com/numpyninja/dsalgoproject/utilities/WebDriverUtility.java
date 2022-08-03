package com.numpyninja.dsalgoproject.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

public class WebDriverUtility
{
    public static void dropdown(WebElement ele, String text)
    {
        Select s = new Select(ele);
        s.selectByVisibleText(text);
    }
    public static String capture(WebDriver driver) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir")+"/ErrorScreenshots/"+ System.currentTimeMillis()+".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);
        return dest;
    }


}
