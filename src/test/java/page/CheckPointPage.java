package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class CheckPointPage {

    private WebDriver driver;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    WebElement resetPasswordSubmitButton;

    public CheckPointPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {

        return resetPasswordSubmitButton.isDisplayed()
                && driver.getCurrentUrl().contains("/checkpoint/")
                && driver.getTitle().contains("Выберите, как вы хотите изменить пароль. | LinkedIn");


    }

    public AcceptEmailPage sendEmail() {
        resetPasswordSubmitButton.sendKeys(Keys.ENTER);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AcceptEmailPage(driver);
    }
}
