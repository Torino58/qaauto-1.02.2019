import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    private WebDriver driver;

    private WebElement signInButton;
    private WebElement userEmailField;
    private WebElement userPasswordField;


    public LandingPage(WebDriver driver) {
        this.driver = driver;
        initElements();

    }

    private void initElements(){
        signInButton = driver.findElement(By.xpath("//input[@class='login submit-button']"));
        userEmailField = driver.findElement(By.xpath("//input[@class='login-email reg-field__input']"));
        userPasswordField = driver.findElement(By.xpath("//input[@class='login-password reg-field__input']"));

    }

    public void login(String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
    }
    public  boolean isPageLoaded(){

        return signInButton.isDisplayed()
                && driver.getCurrentUrl().contains("https://www.linkedin.com")
                && driver.getTitle().contains("LinkedIn: Войти или зарегистрироваться");


    }
}
