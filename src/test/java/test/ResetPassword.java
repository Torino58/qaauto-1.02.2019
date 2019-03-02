package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.AcceptEmailPage;
import page.CheckPointPage;
import page.ResetPasswordPage;
import page.SetNewPassword;

public class ResetPassword extends BaseTest {

    @Test
    public void resetPasswordTest() {
        String userEmail = "irvold66@ukr.net";
        String newPassword = "pbkbycrbq666";
        String confirmNewPassword = "pbkbycrbq666";

        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");

        ResetPasswordPage resetPasswordPage = landingPage.reset();

        Assert.assertTrue(resetPasswordPage.isPageLoaded(), "ResetPasswordPage page did not load");

        CheckPointPage checkPointPage = resetPasswordPage.addEmail(userEmail);

        Assert.assertTrue(checkPointPage.isPageLoaded(), "CheckPointPage page did not load");

        AcceptEmailPage acceptEmailPage = checkPointPage.sendEmail();

        Assert.assertTrue(acceptEmailPage.isPageLoaded(), "AcceptEmailPage page did not load");

        SetNewPassword setNewPassword = acceptEmailPage.setNewPassword();

        Assert.assertTrue(setNewPassword.isPageLoaded(), "AcceptEmailPage page did not load");

    }
}
