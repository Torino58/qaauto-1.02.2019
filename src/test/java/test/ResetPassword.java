package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.RequestPasswordResetSubmitPage;
import page.ResetPasswordPage;

public class ResetPassword extends BaseTest {

    @Test
    public void resetPasswordTest() {
        String userEmail = "zilinskiy555@gmail.com";
       // String newPassword = "pbkbycrbq666";
       // String confirmNewPassword = "pbkbycrbq666";

        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");

        ResetPasswordPage resetPasswordPage = landingPage.reset();
        Assert.assertTrue(resetPasswordPage.isPageLoaded(), "ResetPasswordPage page did not load");

        //resetPasswordPage.findAccount(userEmail);

        RequestPasswordResetSubmitPage requestPasswordResetSubmitPage = resetPasswordPage.findAccount(userEmail);


    }
}
