package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends AbstractUIObject {

    @FindBy(id = "uname")
    private ExtendedWebElement usernameTextField;

    @FindBy(xpath = "//fieldset[@id='udata-f']/input[@id='email']")
    private ExtendedWebElement emailTextField;

    @FindBy(xpath = "//form[@id='frmOpin']/input[@id='upass']")
    private ExtendedWebElement passwordTextField;

    @FindBy(xpath = "//div[@id='ucsubmit-f']/input")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "//form[@id='frmOpin']//label[@for='iagree1']")
    private ExtendedWebElement checkBoxAgreeRule;

    @FindBy(xpath = "//form[@id='frmOpin']//label[@for='iagree2']")
    private ExtendedWebElement checkBoxAgreeOld;

    @FindBy(xpath = "//div[@class='normal-text res-success']/h3")
    private ExtendedWebElement registerSuccess;

    public SignUpPage(WebDriver driver) {
        super(driver);
        setPageURL("/register.php3");
    }

    public SignUpPage(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isUsernameTextFieldPresent() {
        return usernameTextField.isElementPresent();
    }

    public boolean isEmailTextFieldPresent() {
        return emailTextField.isElementPresent();
    }

    public boolean isPasswordTextFieldPresent() {
        return passwordTextField.isElementPresent();
    }

    public boolean isRegisterButtonPresent() {
        return submitButton.isElementPresent();
    }

    public boolean isRegisterSuccessPresent() {return registerSuccess.isElementPresent();}

    public boolean isCheckBoxAgreeRulePresent() {
        return checkBoxAgreeRule.isElementPresent();
    }

    public boolean isCheckBoxAgreeOldPresent() {
        return checkBoxAgreeOld.isElementPresent();
    }
    public SignUpPage typeUsername(String username) {
        usernameTextField.type(username);
        return this;
    }

    public SignUpPage typeEmail(String email) {
        emailTextField.type(email);
        return this;
    }

    public SignUpPage typePassword(String password) {
        passwordTextField.type(password);
        return this;
    }

    public SignUpPage clickSubmitButton() {
        pause(2);
        submitButton.click();
        return this;
    }

    public void clickCheckBoxAgreeRule() {
        checkBoxAgreeRule.click();
    }

    public void clickCheckBoxAgreeOld() {
        checkBoxAgreeOld.click();
    }

    public SignUpPage registerNewAccount(String username, String email, String password) {
        typeUsername(username);
        typeEmail(email);
        typePassword(password);
        clickCheckBoxAgreeRule();
        clickCheckBoxAgreeOld();
        clickSubmitButton();
        return new SignUpPage(driver);
    }
}
