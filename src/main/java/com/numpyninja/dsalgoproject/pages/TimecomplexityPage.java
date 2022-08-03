package com.numpyninja.dsalgoproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * All WebElements are identified by @FindBy annotation
 */
public class TimecomplexityPage
{

    @FindBy(xpath = "//a[text() ='Practice Questions']")
    private WebElement practiceQuestions;
    @FindBy(xpath = "//a[text()  = 'Try here>>>']")
    private WebElement tryHere;
    @FindBy(xpath = "//form/div/div/div/textarea")
    private WebElement enteringCode;
    @FindBy(xpath = "//button[text() = 'Run']")
    private WebElement runBtn;

    /**
     * Constructor for TimeComplexityPage
     */
    public TimecomplexityPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public void practiceQuestionClick()
    {
        practiceQuestions.click();
    }

    public void tryhereClick()
    {
        tryHere.click();
    }

    public WebElement getEnteringCode()
    {
        return enteringCode;
    }

    public void run()
    {
        runBtn.click();
    }

}
