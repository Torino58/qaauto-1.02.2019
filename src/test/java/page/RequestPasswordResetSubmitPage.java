package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestPasswordResetSubmitPage extends BasePage{

    @FindBy(xpath = "//button[@id = 'resend-url']")
    WebElement resendLinkButton;

    /**
     * Constructor for Landing page.
     *
     * @param driver - WebDriver instance from BaseTest.
     */
    public RequestPasswordResetSubmitPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public boolean isPageLoaded() {

        return resendLinkButton.isDisplayed()
                && driver.getCurrentUrl().contains("https://www.linkedin.com/checkpoint/rp/");
        //&& driver.getTitle().contains("LinkedIn: Войти или зарегистрироваться");


    }

    public ChooseNewPasswordPage navigateToLinkFromEmail() {
        driver.get(resetPasswordUrl);
        return new ChooseNewPasswordPage(driver);
    }
}
