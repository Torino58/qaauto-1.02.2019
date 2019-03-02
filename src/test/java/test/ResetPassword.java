package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ResetPasswordPage;

public class ResetPassword extends BaseTest {

    @Test
    public void resetPasswordTest(){
        String userEmail = "irvold66@ukr.net";

        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");

        ResetPasswordPage resetPasswordPage = landingPage.reset();

        Assert.assertTrue(resetPasswordPage.isPageLoaded(), "Search page did not load");
    }
}
