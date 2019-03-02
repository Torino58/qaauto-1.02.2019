package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class ResetPasswordPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@id='username']")
    WebElement inputUserName;

    @FindBy(xpath = "//button[@class='form__submit']")
    WebElement submitButton;

    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {

        return submitButton.isDisplayed()
                && driver.getCurrentUrl().contains("/request-password")
                && driver.getTitle().contains("Изменить пароль | LinkedIn");


    }

    public CheckPointPage addEmail(String userEmail) {

        inputUserName.sendKeys(userEmail);
        submitButton.sendKeys(Keys.ENTER);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CheckPointPage(driver);

    }
}
