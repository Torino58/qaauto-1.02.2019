import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests {

    @Test
    public void negativeEmptyPasswordTest() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\SkillUP_Student\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");

        landingPage.login("a@b.c", "");
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");


    }

    @Test
    public void negativeIncorrectPasswordTest() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\SkillUP_Student\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");


        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        landingPage.login("irvold66@ukr.net", "123");

        IncorrectLoginPasswordPage incorrectLoginPasswordPage = new IncorrectLoginPasswordPage(driver);
        Assert.assertTrue(incorrectLoginPasswordPage.isPageLoaded(), "Incorrect Login?Password Page is not loaded");


    }

    @Test
    public void negativeIncorrectLoginTest() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\SkillUP_Student\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");


        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        landingPage.login("irvold66@ukr.nes", "pbkbycrbq555");

        IncorrectLoginPasswordPage incorrectLoginPasswordPage = new IncorrectLoginPasswordPage(driver);
        Assert.assertTrue(incorrectLoginPasswordPage.isPageLoaded(), "Incorrect Login?Password Page is not loaded");


    }



    @Test
    public void negativeInvalidLoginTest() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\SkillUP_Student\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");


        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        landingPage.login("irvold66#ukr.net", "pbkbycrbq555");

        IncorrectLoginPasswordPage incorrectLoginPasswordPage = new IncorrectLoginPasswordPage(driver);
        Assert.assertTrue(incorrectLoginPasswordPage.isPageLoaded(), "Incorrect Login?Password Page is not loaded");


    }


    @Test
    public void successfulLoginTest() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\SkillUP_Student\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");


        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        landingPage.login("irvold66@ukr.net", "pbkbycrbq555");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page did not load after Login");


    }

}
