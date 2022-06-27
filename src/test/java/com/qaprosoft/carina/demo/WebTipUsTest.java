package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.TipUsPage;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTipUsTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "Vova Masliuchenko")
    @TestLabel(name = "Write an review", value = {"web", "regression"})
    public void fillTipUsTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not open");

        TipUsPage tipUsPage = homePage.getNavbar().clickTipUsButton();
        Assert.assertTrue(tipUsPage.isSubjectFieldPresent(), "Subject field is not present!");
        Assert.assertTrue(tipUsPage.isShareFieldPresent(), "Share field is not present!");
        Assert.assertTrue(tipUsPage.isCaptchaFieldPresent(), "Captcha field is not present!");
        Assert.assertTrue(tipUsPage.isSubmitButtonPresent(), "Submit button is not present!");

        tipUsPage.fillTipUsPage("Lorem", "Lorem", "42");
        pause(1);
    }
}
