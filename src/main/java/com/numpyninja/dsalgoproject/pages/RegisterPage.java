package com.numpyninja.dsalgoproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * All WebElements are identified by @FindBy annotation
 */
public class RegisterPage
{
    @FindBy(xpath = "//input[@value = 'Register']")
    private WebElement registerBtn;
    @FindBy(name = "username")
    private WebElement nameTextBox;
    @FindBy(id = "id_password1")
    private WebElement passwordTextBox;
    @FindBy(id = "id_password2")
    private WebElement confirmPasswordTab;
    @FindBy(xpath = "//a[text() = 'Sign in']")
    private WebElement signinBtn;

    /**
     * Constructor for RegisterPage
     */
    public RegisterPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void registerBtn()
    {
        registerBtn.click();
    }
    public WebElement getNameTextBox()
    {
        return nameTextBox;
    }
    public WebElement getPasswordTextBox()
    {
        return passwordTextBox;
    }
    public WebElement getConfirmpasswordtextbox()
    {
        return confirmPasswordTab;
    }
    public void signin()
    {
        signinBtn.click();
    }
}
