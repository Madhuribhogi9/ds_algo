package com.numpyninja.dsalgoproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.numpyninja.dsalgoproject.tests.BaseTest;

/**
 * All WebElements are identified by @FindBy annotation
 */
public class Arraypage extends BaseTest
{

    @FindBy(xpath = "//a[text() = 'Arrays in Python']")
    private WebElement arraysInPython;
    @FindBy(xpath = "//a[text()  = 'Try here>>>']")
    private WebElement tryHere;
    @FindBy(xpath = "//a[text() = 'Arrays Using List']")
    private WebElement arraysUsingList;
    @FindBy(xpath = "//a[text() = 'Basic Operations in Lists']")
    private WebElement basicOperations;
    @FindBy(xpath = "//a[text() = 'Applications of Array']")
    private WebElement appsInArray;
    @FindBy(xpath = "//a[text() = 'Practice Questions']")
    private WebElement practiceQuestion;
    @FindBy(xpath = "//form/div/div/div/textarea")
    private WebElement enteringCode;
    @FindBy(xpath = "//button[text() = 'Run']")
    private WebElement runBtn;

    /**
     * Constructor for ArrayPage
     */
    public Arraypage()
    {
        PageFactory.initElements(driver,this);
    }

    public void arraysInPython()
    {
        arraysInPython.click();
    }

    public void tryHereClick()
    {
        tryHere.click();
    }

    public void arrayUsingList()
    {
        arraysUsingList.click();
    }

    public void basicInList()
    {
        basicOperations.click();
    }

    public void appsInArray()
    {
        appsInArray.click();
    }

    public void practiceQtns()
    {
        practiceQuestion.click();
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
