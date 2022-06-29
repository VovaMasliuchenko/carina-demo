package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.demo.gui.pages.ForgotPasswordPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
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

    @FindBy(xpath = "//div[@class='normal-text res-success']/h3")
    private ExtendedWebElement loginSuccess;

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
    public boolean isLoginSuccessPresent(){return loginSuccess.isElementPresent();}

    public String getEmailFieldValidation() {
        return  emailTextField.getElement().getAttribute("validationMessage");
    }

    public String getPasswordFieldValidation() {
        return  passwordTextField.getElement().getAttribute("validationMessage");
    }

    public String getLoginButtonColor() {
        pause(1);
        String rgb = loginButton.getElement().getCssValue("background-color");
        return Color.fromString(rgb).asHex();
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

    public LoginComponent hoverLoginButton() {
        loginButton.hover();
        return this;
    }

    public ForgotPasswordPage clickForgotEmailButton() {
        forgotEmailButton.click();
        return new ForgotPasswordPage(driver);
    }

    public LoginComponent loginToAccount(String email, String password) {
        typeEmail(email);
        typePassword(password);
        clickLoginButton();
        return new LoginComponent(driver);
    }
}
