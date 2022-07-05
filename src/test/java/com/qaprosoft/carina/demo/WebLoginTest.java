package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.LoginComponent;
import com.qaprosoft.carina.demo.gui.components.Navbar;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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

        //Check password text field
        loginComponent.loginToAccount(RandomStringUtils.randomAlphabetic(5, 10) + "@gmail.com", "");
        Assert.assertEquals(loginComponent.getPasswordFieldValidation(), "Заполните это поле.", "Password validation message is not valid!");

        //Check login success
        loginComponent.loginToAccount("bosiy33444@kahase.com", "Vm1243_");
        Assert.assertTrue(loginComponent.isLoginSuccessPresent(), "Success login");
    }

    @Test(dataProvider = "DP1")
    @MethodOwner(owner = "Masliuchenko Volodymyr")
    public void testEmailValidation(String email, String validationMessage) {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        Navbar navbar = homePage.getNavbar();
        Assert.assertTrue(navbar.isUIObjectPresent(2), "Navbar wasn't found!");

        Assert.assertTrue(navbar.isLoginButtonPresent(), "Login button wasn't found!");

        LoginComponent loginComponent = navbar.clickLoginButton();

        // Check validation message on empty email field
        loginComponent.typeEmail(email);
        loginComponent.clickLoginButton();
        Assert.assertEquals(loginComponent.getEmailFieldValidation(), validationMessage,
                "Email field validation message incorrect!");
    }

    @DataProvider(parallel = false, name = "DP1")
    public static Object[][] dataprovider()
    {
        return new Object[][] {
                { "", "Заполните это поле." },
                { "aaa", "Адрес электронной почты должен содержать символ \"@\". В адресе \"aaa\" отсутствует символ \"@\"." },
                { "aaa@", "Введите часть адреса после символа \"@\". Адрес \"aaa@\" неполный." }
        };
    }
}
