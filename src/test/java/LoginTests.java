import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SkillUP_Student\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @DataProvider
    public Object[][] validData() {
        return new Object[][]{
                {"irvold66@ukr.net", "pbkbycrbq555"},
                {"irvold66@ukr.NET", "pbkbycrbq555"},
                {" irvold66@ukr.net ", "pbkbycrbq555"}

        };
    }

    @Test(dataProvider = "validData")
    public void successfulLoginTest(String userEmail, String userPassword) {
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        landingPage.login(userEmail, userPassword);

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page did not load after Login");


    }

    @DataProvider
    public Object[][] validData1() {
        return new Object[][]{
                {"irvold66@ukr.net", ""},
                {"", "pbkbycrbq555"}

        };
    }

    @Test(dataProvider = "validData1")
    public void negativeEmptyPasswordTest(String userEmail, String userPassword) {
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");

        landingPage.login(userEmail, userPassword);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");

    }

    @DataProvider
    public Object[][] validData2() {
        return new Object[][]{
                {"irvold666@ukr.net", "pbkbycrbq555",
                        "Этот адрес эл. почты не зарегистрирован в LinkedIn. Повторите попытку.", ""},
                {"irvold66@ukr.nes", "pbkbycrbq555","Этот адрес эл. почты не зарегистрирован в LinkedIn. \n" +
                        "Возможно, вы имели в виду @ukr.net?" ,""},
                {" irvold66@ukr.net ", "pbycrbq555",
                        "", "Это неверный пароль" +
                        " Повторите попытку или измените пароль."}

        };
    }

    @Test(dataProvider = "validData2")
    public void negativeLoginReturnedToLoginSubmitTest(String userEmail, String userPassword,
                                                       String emailValidation, String passwordValidation) {
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        landingPage.login(userEmail, userPassword);

        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(driver);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "Home page did not load after Login");
        Assert.assertEquals(loginSubmitPage.getPasswordValidationMessageText(), passwordValidation,
                "Wrong validation message for password field");
        Assert.assertEquals(loginSubmitPage.getEmailValidationMessage(), emailValidation,
                "Wrong validation message for password field");


    }

}
