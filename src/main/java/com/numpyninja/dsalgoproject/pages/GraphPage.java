package com.numpyninja.dsalgoproject.pages;

import com.numpyninja.dsalgoproject.tests.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * All WebElements are identified by @FindBy annotation
 */
public class GraphPage extends BaseTest
{
    @FindBy(xpath="(//a[text()='Graph'])[2]")
    WebElement graphLinkOnGraphPage;
    @FindBy(xpath="//a[text()='Practice Questions']")
    WebElement practiceQuetions;
    @FindBy(xpath="//a[text()='Graph Representations']")
    WebElement graphRepreLink;

    /**
     * Constructor for StackPage
     */
    public  GraphPage()
    {
        PageFactory.initElements(driver, this);
    }

    public void graphLinkOnGraphPage()
    {
        graphLinkOnGraphPage.click();
    }

    public void graphRepreLink()
    {
        graphRepreLink.click();
    }

    public void practiceQuetions()
    {
        practiceQuetions.click();
    }

}
