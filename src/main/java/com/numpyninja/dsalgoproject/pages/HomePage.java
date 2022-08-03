package com.numpyninja.dsalgoproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * All WebElements are identified by @FindBy annotation
 */
public class HomePage
{

    @FindBy(xpath = "//button[text() = 'Get Started']")
    private WebElement getStartedBtn;
    @FindBy(xpath = "//a[text() = 'Data Structures']")
    private WebElement getDropdown;
    @FindBy(xpath = "(//a[@class = 'dropdown-item'])[1]")
    private WebElement listBtnInDrpdwn;
    @FindBy(xpath = "(//a[text() = 'Get Started'])[2]")
    private WebElement array;
    @FindBy(xpath = "//a[text() = 'Sign in']")
    private WebElement signInBtn;
    @FindBy(xpath = "//a[text() = ' Register ']")
    private WebElement registerBtn;
    @FindBy(xpath = "(//a[text() = 'Get Started'])[1]")
    private WebElement intoductionDetails;
    @FindBy(xpath = "(//a[text() = 'Get Started'])[2]")
    private WebElement arrayDetails;
    @FindBy(xpath = "(//a[text() = 'Get Started'])[3]")
    private WebElement linkedList;
    @FindBy(xpath = "(//a[text() = 'Get Started'])[4]")
    private WebElement stack;
    @FindBy(xpath = "(//a[text() = 'Get Started'])[5]")
    private WebElement queue;
    @FindBy(xpath = "(//a[text() = 'Get Started'])[6]")
    private WebElement tree;
    @FindBy(xpath = "(//a[text() = 'Get Started'])[7]")
    private WebElement graph;
    @FindBy(xpath = "//a[text() = 'Sign out']")
    private WebElement signOut;

    /**
     * Constructor for HomePage
     */
    public HomePage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }


    public void getStartedBtn()
    {
        getStartedBtn.click();
    }

    public void getDropdown()
    {
         getDropdown.click();
    }

    public void dsIntroduction()
    {
        listBtnInDrpdwn.click();
    }

    public void array()
    {
        array.click();
    }

    public void signin()
    {
        signInBtn.click();
    }

    public void register()
    {
        registerBtn.click();
    }

    public void introductionDetails()
    {
        intoductionDetails.click();
    }

    public void linkedList()
    {
        linkedList.click();
    }

    public void stack()
    {
        stack.click();
    }

    public void queue()
    {
        queue.click();
    }

    public void tree()
    {
       tree.click();
    }

    public void graph()
    {
        graph.click();
    }

    public void arrayListDetails()
    {
        arrayDetails.click();
    }


    public void signOut()
    {
        signOut.click();
    }


}
