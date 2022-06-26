package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.LoginComponent;
import com.qaprosoft.carina.demo.gui.components.Navbar;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebLoginTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "Vova Masliuchenko")
    @TestLabel(name = "LoginToAccountSuccess", value = {"web", "regression"})
    public void loginUserAccount() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        LoginComponent loginComponent =homePage.getNavbar().clickLoginButton();
        Assert.assertTrue(loginComponent.isLoginTitlePresent(), "Login Title is not present!");
        Assert.assertTrue(loginComponent.isPasswordFieldPresent(), "Password field Title is not present!");
        Assert.assertTrue(loginComponent.isLoginButtonPresent(), "Login button Title is not present!");
        Assert.assertTrue(loginComponent.isForgotEmailButtonPresent(), "ForgotEmail button Title is not present!");
        Assert.assertTrue(loginComponent.isEmailFieldPresent(), "Email field is not present!");

        loginComponent.loginToAccount("fail", "1");
        pause(1);
        loginComponent.loginToAccount("vovamasl39@gmail.com", "");
        pause(1);
        loginComponent.loginToAccount("tanegim389@qqhow.com", "Vm1243_");
        pause(1);
    }
}
