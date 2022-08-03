package com.numpyninja.dsalgoproject.pages;

import com.numpyninja.dsalgoproject.tests.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * All WebElements are identified by @FindBy annotation
 */
public class StackPage extends BaseTest
{
    @FindBy(xpath = "//a[contains(text(),'Operations in Stack')]")
    private WebElement clickOnOperationsInStackLink;
    @FindBy(xpath = "//a[contains(text(),'Implementation')]")
    private WebElement clickOnImplementation;
    @FindBy(xpath = "//a[contains(text(),'Applications')]")
    private WebElement clickOnApplicationsLink;

    /**
     * Constructor for StackPage
     */
    public StackPage()
    {
        PageFactory.initElements(driver, this);
    }

    public void clickOnOperationsInStackLink()
    {
        clickOnOperationsInStackLink.click();
    }

    public void clickOnImplementation()
    {
        clickOnImplementation.click();
    }

    public void clickOnApplicationsLink()
    {
        clickOnApplicationsLink.click();
    }

}
