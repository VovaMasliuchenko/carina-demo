package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.LoginComponent;
import com.qaprosoft.carina.demo.gui.components.Navbar;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class WebLoginTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "Vova Masliuchenko")
    @TestLabel(name = "LoginToAccount", value = {"web", "regression"})
    public void loginUserAccount() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        //Check is every element present on this page
        LoginComponent loginComponent =homePage.getNavbar().clickLoginButton();
        Assert.assertTrue(loginComponent.isLoginTitlePresent(), "Login Title is not present!");
        Assert.assertTrue(loginComponent.isPasswordFieldPresent(), "Password field Title is not present!");
        Assert.assertTrue(loginComponent.isLoginButtonPresent(), "Login button Title is not present!");
        Assert.assertTrue(loginComponent.isForgotEmailButtonPresent(), "ForgotEmail button Title is not present!");
        Assert.assertTrue(loginComponent.isEmailFieldPresent(), "Email field is not present!");

        //Check color background color of button
        loginComponent.hoverLoginButton();
        Assert.assertEquals(loginComponent.getLoginButtonColor(), "#d50000", "Background color of login button is not red!");

        //Check email text field
        loginComponent.loginToAccount("", RandomStringUtils.randomAlphabetic(5,10));
        Assert.assertEquals(loginComponent.getEmailFieldValidation(), "Заполните это поле.", "Email validation message is not valid!");

        //Check password text field
        loginComponent.loginToAccount(RandomStringUtils.randomAlphabetic(5, 10) + "@gmail.com", "");
        Assert.assertEquals(loginComponent.getPasswordFieldValidation(), "Заполните это поле.", "Password validation message is not valid!");

        //Check login success
        loginComponent.loginToAccount("bosiy33444@kahase.com", "Vm1243_");
        Assert.assertTrue(loginComponent.isLoginSuccessPresent(), "Success login");
    }
}
