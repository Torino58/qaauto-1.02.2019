import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@class='login submit-button']")
    private WebElement signInButton;

    @FindBy(xpath = "//input[@class='login-email reg-field__input']")
    private WebElement userEmailField;

    @FindBy(xpath = "//input[@class='login-password reg-field__input']")
    private WebElement userPasswordField;


    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public HomePage loginToHomePage(String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        return new HomePage(driver);
    }

    public LoginSubmitPage loginToLoginSubmitPage(String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        return new LoginSubmitPage(driver);
    }

    public LandingPage loginToLandingPage(String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        return new LandingPage(driver);
    }

    public boolean isPageLoaded() {

        return signInButton.isDisplayed()
                && driver.getCurrentUrl().contains("https://www.linkedin.com")
                && driver.getTitle().contains("LinkedIn: Войти или зарегистрироваться");


    }
}
