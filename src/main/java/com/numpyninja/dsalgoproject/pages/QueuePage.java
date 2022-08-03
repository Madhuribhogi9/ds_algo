package com.numpyninja.dsalgoproject.pages;

import com.numpyninja.dsalgoproject.tests.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * All WebElements are identified by @FindBy annotation
 */
public class QueuePage extends BaseTest
{

    @FindBy(xpath = "//a[text()='Implementation of Queue in Python']")
    WebElement implementationOfQueueinPython;
    @FindBy(xpath = "//a[text()='Implementation using collections.deque']")
    WebElement implementationUsingCollectionsDeque;
    @FindBy(xpath = "//a[text()='Implementation using array']")
    WebElement implementationUsingArray;
    @FindBy(xpath = "//a[text()='Queue Operations']")
    WebElement queueOperation;

    /**
     * Constructor for StackPage
     */
    public  QueuePage()
    {
        PageFactory.initElements(driver,this);
    }
    public void implementationOfQueueinPython()
    {
       implementationOfQueueinPython.click();
    }

    public void implementationUsingCollectionsDeque()
    {
        implementationUsingCollectionsDeque.click();
    }

    public void implementationUsingArray()
    {
        implementationUsingArray.click();
    }

    public void queueOperation()
    {
        queueOperation.click();
    }


}
