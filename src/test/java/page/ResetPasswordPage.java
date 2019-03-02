package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
}
