package com.numpyninja.dsalgoproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * All WebElements are identified by @FindBy annotation
 */
public class SigninPage
{
    @FindBy(id = "id_username")
    private WebElement usernameTxtBox;
    @FindBy(id = "id_password")
    private WebElement passwordTextBox;
    @FindBy(xpath = "//input[@value = 'Login']")
    private WebElement loginBtn;

    /**
     * Constructor for SigninPage
     */
    public SigninPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public WebElement getUsernameTxtBox()
    {
        return usernameTxtBox;
    }

    public WebElement getPasswordTextBox()
    {
        return passwordTextBox;
    }

    public void login()
    {
        loginBtn.click();
    }

}
