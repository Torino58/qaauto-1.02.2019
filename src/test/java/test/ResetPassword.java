package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.AcceptEmailPage;
import page.CheckPointPage;
import page.ResetPasswordPage;

public class ResetPassword extends BaseTest {

    @Test
    public void resetPasswordTest(){
        String userEmail = "irvold66@ukr.net";

        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");

        ResetPasswordPage resetPasswordPage = landingPage.reset();

        Assert.assertTrue(resetPasswordPage.isPageLoaded(), "Search page did not load");

        CheckPointPage checkPointPage = resetPasswordPage.addEmail(userEmail);

        Assert.assertTrue(checkPointPage.isPageLoaded(),"Search page did not load");

        AcceptEmailPage acceptEmailPage = checkPointPage.sendEmail();

        Assert.assertTrue(acceptEmailPage.isPageLoaded(),"Search page did not load");
    }
}
