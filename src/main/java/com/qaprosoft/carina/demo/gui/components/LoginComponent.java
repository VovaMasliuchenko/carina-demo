package com.qaprosoft.carina.demo.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;


public class LoginComponent extends AbstractUIObject {

    @FindBy(xpath = "//p[text()='Login']")
    private ExtendedWebElement loginTitle;

    @FindBy(id = "email")
    private ExtendedWebElement emailTextField;

    @FindBy(id = "upass")
    private ExtendedWebElement passwordTextField;

    @FindBy(id = "nick-submit")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//a[@class='forgot']")
    private ExtendedWebElement forgotEmailButton;

    public LoginComponent(WebDriver driver) {
        super(driver);
    }

    public LoginComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isLoginTitlePresent() {
        return loginTitle.isElementPresent();
    }
    public boolean isEmailFieldPresent() {
        return emailTextField.isElementPresent();
    }
    public boolean isPasswordFieldPresent() {
        return passwordTextField.isElementPresent();
    }
    public boolean isLoginButtonPresent() {
        return loginButton.isElementPresent();
    }
    public boolean isForgotEmailButtonPresent() {
        return forgotEmailButton.isElementPresent();
    }

    public LoginComponent typeEmail(String email) {
        emailTextField.type(email);
        return this;
    }

    public LoginComponent typePassword(String password) {
        passwordTextField.type(password);
        return this;
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void hoverLoginButton() {
        loginButton.hover();
    }

    public void clickForgotEmailButton() {
        forgotEmailButton.click();
    }

    public void loginToAccount(String email, String password) {
        typeEmail(email);
        typePassword(password);
        clickLoginButton();
    }
}
