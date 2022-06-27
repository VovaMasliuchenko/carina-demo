package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.SignUpPage;
import com.qaprosoft.carina.demo.gui.pages.TipUsPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Navbar extends AbstractUIObject {

    @FindBy(xpath = "//a[@id='login-active']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//a[@class='signup-icon no-margin-right']")
    private ExtendedWebElement registerButton;

    @FindBy(xpath = "//div[@id='social-connect']/a[1]")
    private ExtendedWebElement tipUsButton;

    public Navbar(WebDriver driver) {
        super(driver);
    }

    public Navbar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isLoginButtonPresent(){
        return loginButton.isElementPresent();
    }

    public boolean isRegisterButtonPresent(){
        return  registerButton.isElementPresent();
    }

    public boolean isTipUsButtonPresent(){
        return  tipUsButton.isElementPresent();
    }

    public LoginComponent clickLoginButton(){
        loginButton.click();
        return new LoginComponent(driver);
    }

    public SignUpPage clickRegisterButton() {
        registerButton.click();
        return new SignUpPage(driver);
    }

    public TipUsPage clickTipUsButton() {
        tipUsButton.click();
        return new TipUsPage(driver);
    }

}
