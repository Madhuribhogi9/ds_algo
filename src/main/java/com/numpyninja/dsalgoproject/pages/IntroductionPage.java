package com.numpyninja.dsalgoproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * All WebElements are identified by @FindBy annotation
 */
public class IntroductionPage
{

    @FindBy(xpath = "//a[text() = 'Time Complexity']")
    private WebElement timeComplexity;

    /**
     * Constructor for IntroductionPage
     */
    public IntroductionPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }


    public void timecomplexityBtn()
    {
        timeComplexity.click();
    }
}
