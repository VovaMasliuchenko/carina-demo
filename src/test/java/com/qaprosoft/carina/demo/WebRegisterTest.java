package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.Navbar;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.SignUpPage;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebRegisterTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "Vova Masliuchenko")
    @TestLabel(name = "registerAccount", value = {"web", "regression"})
    public void testRegisterUser() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        SignUpPage signUpPage = homePage.getNavbar().clickRegisterButton();
        Assert.assertTrue(signUpPage.isUsernameTextFieldPresent(), "Username text field is not present!");
        Assert.assertTrue(signUpPage.isEmailTextFieldPresent(), "Email text field is not present!");
        Assert.assertTrue(signUpPage.isPasswordTextFieldPresent(), "Password text field is not present!");
        Assert.assertTrue(signUpPage.isRegisterButtonPresent(), "Register button is not present!");
        Assert.assertTrue(signUpPage.isCheckBoxAgreeRulePresent(), "Checkbox rule button is not present!");
        Assert.assertTrue(signUpPage.isCheckBoxAgreeOldPresent(), "Checkbox old button is not present!");

        signUpPage.registerNewAccount("pfkssdf", "tanegim389@qqhow.com","Vm1243_");
        pause(1);
    }
}
