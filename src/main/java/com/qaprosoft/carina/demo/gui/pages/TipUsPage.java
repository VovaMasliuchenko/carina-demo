package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TipUsPage extends AbstractUIObject {

    @FindBy(id = "usubject")
    private ExtendedWebElement subjectField;

    @FindBy(id = "ucomment")
    private ExtendedWebElement shareField;

    @FindBy(id = "ucaptcha")
    private ExtendedWebElement captchaField;

    @FindBy(xpath = "//input[@class='submit right button']")
    private ExtendedWebElement submitButton;

    public TipUsPage(WebDriver driver) {
        super(driver);
    }

    public TipUsPage(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isSubjectFieldPresent() {
        return subjectField.isElementPresent();
    }

    public boolean isShareFieldPresent() {
        return shareField.isElementPresent();
    }

    public boolean isCaptchaFieldPresent() {
        return captchaField.isElementPresent();
    }

    public boolean isSubmitButtonPresent() {
        return submitButton.isElementPresent();
    }

    public TipUsPage typeSubjectField(String subject) {
        subjectField.type(subject);
        return this;
    }

    public TipUsPage typeShareField(String share) {
        shareField.type(share);
        return this;
    }

    public TipUsPage typeCaptchaField(String captcha) {
        captchaField.type(captcha);
        return this;
    }

    public TipUsPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public TipUsPage fillTipUsPage(String subject, String share, String captcha) {
        typeSubjectField(subject);
        typeShareField(share);
        typeCaptchaField(captcha);
        clickSubmitButton();
        return new TipUsPage(driver);
    }

}
