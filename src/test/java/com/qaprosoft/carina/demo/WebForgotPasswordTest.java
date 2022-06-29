package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.pages.ForgotPasswordPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WebForgotPasswordTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "Vova Masliuchenko")
    @TestLabel(name = "Forgot password test", value = {"web", "regression"})
    public void forgotPasswordTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not open!");

        ForgotPasswordPage forgotPasswordPage = homePage.getNavbar().clickLoginButton().clickForgotEmailButton();

        Assert.assertTrue(forgotPasswordPage.isForgotPasswordTitlePresent(), "Forgot password title is not present!");
        Assert.assertTrue(forgotPasswordPage.isEmailTextFieldPresent(), "Email text field is not present!");
        Assert.assertTrue(forgotPasswordPage.isSubmitButtonPresent(), "Submit button is not present!");

        forgotPasswordPage.forgotPasswordForm("bosiy33444@kahase.com");
        Assert.assertTrue(forgotPasswordPage.isForgotPasswordSuccessTitlePresent(), "Cannot get the forgot password success title!");

    }
}
