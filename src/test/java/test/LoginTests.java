package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginSubmitPage;

public class LoginTests extends BaseTest{

    @DataProvider
    public Object[][] validData() {
        return new Object[][]{
                {"irvold66@ukr.net", "pbkbycrbq555"},
                // {"irvold66@ukr.NET", "pbkbycrbq555"},
                // {" irvold66@ukr.net ", "pbkbycrbq555"}

        };
    }

    @Test(dataProvider = "validData")
    public void successfulLoginTest(String userEmail, String userPassword) {
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");

        HomePage homePage = landingPage.login(userEmail, userPassword);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page did not load after Login");


    }

    @DataProvider
    public Object[][] validData1() {
        return new Object[][]{
                {"irvold66@ukr.net", ""},
                // {"", "pbkbycrbq555"}

        };
    }

    @Test(dataProvider = "validData1")
    public void negativeEmptyPasswordTest(String userEmail, String userPassword) {
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");

        landingPage.login(userEmail, userPassword);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");

    }

    @DataProvider
    public Object[][] invalidData() {
        return new Object[][]{
                {"irvold666@ukr.net", "pbkbycrbq555",
                        "Этот адрес эл. почты не зарегистрирован в LinkedIn. Повторите попытку.", ""},
                //{"irvold66@ukr.nes", "pbkbycrbq555","Этот адрес эл. почты не зарегистрирован в LinkedIn.\n" +
                //  "Возможно, вы имели в виду @ukr.net?" ,""},
                //{" irvold66@ukr.net ", "pbycrbq555",
                //  "", "Это неверный пароль." +
                //  " Повторите попытку или измените пароль."}

        };
    }

    @Test(dataProvider = "invalidData")
    public void negativeLoginReturnedToLoginSubmitTest(String userEmail,
                                                       String userPassword,
                                                       String emailValidationMessage,
                                                       String passwordValidationMessage) {
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        LoginSubmitPage loginSubmitPage = landingPage.login(userEmail, userPassword);

        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "Home page did not load after Login");
        Assert.assertEquals(loginSubmitPage.getPasswordValidationMessageText(), passwordValidationMessage,
                "Wrong validation message for password field");
        Assert.assertEquals(loginSubmitPage.getEmailValidationMessage(), emailValidationMessage,
                "Wrong validation message for email field");


    }

}
