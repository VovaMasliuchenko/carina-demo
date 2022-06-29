package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends AbstractUIObject {

    @FindBy(xpath = "//h1[@class='article-info-name']")
    private ExtendedWebElement forgotPasswordTitle;

    @FindBy(xpath = "//fieldset[@id='udata-f']/input[@type='email']")
    private ExtendedWebElement emailTextField;

    @FindBy(xpath = "//form[@id='frmForgot']//input[@id='nick-submit']")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "//div[@class='normal-text res-success']/h3")
    private ExtendedWebElement forgotPasswordSuccess;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public ForgotPasswordPage(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isForgotPasswordTitlePresent() {
        return forgotPasswordTitle.isElementPresent();
    }

    public boolean isEmailTextFieldPresent() {
        return emailTextField.isElementPresent();
    }

    public boolean isSubmitButtonPresent() {
        return submitButton.isElementPresent();
    }

    public boolean isForgotPasswordSuccessTitlePresent() {
        return forgotPasswordSuccess.isElementPresent();
    }

    public ForgotPasswordPage typeEmail(String email) {
        pause(1);
        emailTextField.type(email);
        return this;
    }

    public ForgotPasswordPage clickSubmitButton() {
        pause(1);
        submitButton.click();
        return this;
    }

    public ForgotPasswordPage forgotPasswordForm(String email) {
        emailTextField.type(email);
        submitButton.click();
        return new ForgotPasswordPage(driver);
    }
}
