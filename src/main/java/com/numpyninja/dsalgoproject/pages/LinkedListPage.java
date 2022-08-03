package com.numpyninja.dsalgoproject.pages;

import com.numpyninja.dsalgoproject.tests.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * All WebElements are identified by @FindBy annotation
 */
public class LinkedListPage extends BaseTest
{
    @FindBy(xpath = "//a[contains(text(),'Introduction')]")
    private WebElement introduction;
    @FindBy(xpath = "//a[contains(text(),'Creating Linked LIst')]")
    private WebElement clickOnCreatingLinkedList;
    @FindBy(xpath = "//a[contains(text(),'Types of Linked List')]")
    private WebElement clickOnLinkedListType;
    @FindBy(xpath = "//a[contains(text(),'Implement Linked List in Python')]")
    private WebElement clickOnImplementLinkedListInPython;
    @FindBy(xpath = "//a[contains(text(),'Traversal')]")
    private WebElement clickOnTraversal;
    @FindBy(xpath = "//a[contains(text(),'Insertion')]")
    private WebElement clickOnInsertion;
    @FindBy(xpath = "//a[contains(text(),'Deletion')]")
    private WebElement clickOnDeletion;
    @FindBy(xpath = "//a[text()  = 'Try here>>>']")
    private WebElement tryHere;
    @FindBy(xpath = "//form/div/div/div/textarea")
    private WebElement enteringCode;
    @FindBy(xpath = "//button[text() = 'Run']")
    private WebElement runBtn;


    /**
     * Constructor for LinkedListPage
     */
    public  LinkedListPage()
    {
        PageFactory.initElements(driver, this);
    }

    public void introduction()
    {
        introduction.click();
    }

    public void clickOnCreatingLinkedList()
    {
        clickOnCreatingLinkedList.click();
    }

    public void clickOnLinkedListType()
    {
        clickOnLinkedListType.click();
    }

    public void clickOnImplementLinkedListInPython()
    {
        clickOnImplementLinkedListInPython.click();
    }

    public void clickOnTraversal()
    {
        clickOnTraversal.click();
    }

    public void clickOnDeletion()
    {
        clickOnDeletion.click();
    }

    public void tryHereClick()
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
