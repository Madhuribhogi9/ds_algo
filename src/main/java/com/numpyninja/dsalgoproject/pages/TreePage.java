package com.numpyninja.dsalgoproject.pages;

import com.numpyninja.dsalgoproject.tests.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * All WebElements are identified by @FindBy annotation
 */
public class TreePage extends BaseTest
{
    @FindBy(xpath="//a[text()='Overview of Trees']")
    private WebElement overviewOfTree;
    @FindBy(xpath="//a[text() ='Terminologies']")
    private WebElement terminologies;
    @FindBy(xpath="//a[text() ='Types of Trees']")
    private WebElement typesOfTrees;
    @FindBy(xpath="//a[text()='Tree Traversals']")
    private WebElement treeTraversals;
    @FindBy(xpath="//a[text() = 'Traversals-Illustration']")
    private WebElement travIllustartion;
    @FindBy(xpath="//a[text() = 'Binary Trees']")
    private WebElement binaryTrees;
    @FindBy(xpath="//a[text() = 'Practice Questions']")
    private WebElement pracQuestions;
    @FindBy(xpath = "//a[text() = 'Try here>>>']")
    private WebElement tryHere;

    /**
     * Constructor for StackPage
     */
    public  TreePage()
    {
        PageFactory.initElements(driver, this);
    }
    public void overviewOfTree()
    {
        overviewOfTree.click();
    }

    public void terminologies()
    {
        terminologies.click();
    }

    public void typesOfTrees()
    {
        typesOfTrees.click();
    }

    public void treeTraversals()
    {
        treeTraversals.click();
    }

    public void travIllustartion()
    {
        travIllustartion.click();
    }

    public void binaryTrees()
    {
        binaryTrees.click();
    }

    public void pracQuestions()
    {
        pracQuestions.click();
    }

    public void tryHere()
    {
        tryHere.click();
    }
}
