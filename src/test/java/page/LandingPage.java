package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

/**
 * Page Object class for Landing page.
 */
public class LandingPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@class='login submit-button']")
    private WebElement signInButton;

    @FindBy(xpath = "//input[@class='login-email reg-field__input']")
    private WebElement userEmailField;

    @FindBy(xpath = "//input[@class='login-password reg-field__input']")
    private WebElement userPasswordField;

    @FindBy(xpath = "//a[@class='link-forgot-password']")
    private WebElement resetPassword;


    /**
     * Constructor for Landing page.
     *
     * @param driver - WebDriver instance from BaseTest.
     */
    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public <T> T login(String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        if (driver.getCurrentUrl().contains("/feed/")) {
            return (T) new HomePage(driver);
        }
        if (driver.getCurrentUrl().contains("/login-submit")) {
            return (T) new LoginSubmitPage(driver);
        } else {
            return (T) new LandingPage(driver);
        }

    }


    /**
     * Method that check if page is loaded
     *
     * @return true/false
     */
    public boolean isPageLoaded() {

        return signInButton.isDisplayed()
                && driver.getCurrentUrl().contains("https://www.linkedin.com");
        //&& driver.getTitle().contains("LinkedIn: Войти или зарегистрироваться");


    }


    public ResetPasswordPage reset() {
        resetPassword.sendKeys(Keys.ENTER);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ResetPasswordPage(driver);
    }
}
