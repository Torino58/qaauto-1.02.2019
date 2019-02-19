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
                { "irvold66@ukr.net", "pbkbycrbq555" },
                { "irvold66@ukr.NET", "pbkbycrbq555" },
                { " irvold66@ukr.net ", "pbkbycrbq555" }

        };
    }

    @Test(dataProvider = "validData")
    public void successfulLoginTest() {
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        landingPage.login("irvold66@ukr.net", "pbkbycrbq555");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page did not load after Login");


    }

    @Test
    public void negativeEmptyPasswordTest() {
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");

        landingPage.login("a@b.c", "");
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loadeds");


    }

    @Test
    public void negativeIncorrectPasswordTest() {
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        landingPage.login("irvold66@ukr.net", "123");

        LoginSubmitPage incorrectLoginPasswordPage = new LoginSubmitPage(driver);
        Assert.assertTrue(incorrectLoginPasswordPage.isPageLoaded(), "Incorrect Login?Password Page is not loaded");


    }

    @Test
    public void negativeIncorrectLoginTest() {
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        landingPage.login("irvold66@ukr.nes", "pbkbycrbq555");

        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(driver);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "Incorrect Login?Password Page is not loaded");


    }

    @Test
    public void negativeInvalidLoginTest() {
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        landingPage.login("irvold66#ukr.net", "pbkbycrbq555");

        LoginSubmitPage incorrectLoginPasswordPage = new LoginSubmitPage(driver);
        Assert.assertTrue(incorrectLoginPasswordPage.isPageLoaded(), "Incorrect Login?Password Page is not loaded");


    }

    @Test
    public void negativePasswordReturnedToLoginSubmitTest() {
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        landingPage.login("irvoldd66@ukr.net", "pb2bycrbq555");

        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(driver);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "Home page did not load after Login");
        Assert.assertEquals(loginSubmitPage.getPasswordValidationMessageText(),
                "Это неверный пароль. Повторите попытку или измените пароль.",
                "Wrong validation message for password field");


    }

    @Test
    public void negativeLoginReturnedToLoginSubmitTest() {
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        landingPage.login("irvoldd66@ukr.net", "pbkbycrbq555");

        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(driver);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "Home page did not load after Login");
        Assert.assertEquals(loginSubmitPage.getEmailValidationMessage(),
                "Этот адрес эл. почты не зарегистрирован в LinkedIn. Повторите попытку.",
                "Wrong validation message for password field");


    }
}
