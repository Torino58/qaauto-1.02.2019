import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests {

    @Test
    public void negativeLoginTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SkillUP_Student\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        //LinkedIn: Войти или зарегистрироваться
        Assert.assertEquals(driver.getTitle(), "LinkedIn: Войти или зарегистрироватьсяx",
                "Login page title is wrong.");

    }

}
