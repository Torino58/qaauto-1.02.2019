package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

import static java.lang.Thread.sleep;

public class ResetPasswordPage extends BasePage{


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


    public RequestPasswordResetSubmitPage findAccount(String userEmail) {
        inputUserName.sendKeys(userEmail);

        String messageSubject = "Илья, данное сообщение содержит ссылку для изменения пароля";
        String messageTo = userEmail;
        String messageFrom = "security-noreply@linkedin.com";

        GMailService gMailService = new GMailService();
        gMailService.connect();

        submitButton.click();
        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 90);
        System.out.println("Content: " + message);

        resetPasswordUrl = StringUtils.substringBetween(message,"href=\"",
                "\" style=\"cursor:pointer;color:#008CC9;-webkit-text-size-adjust:100%;display:inline-block;text-decoration:none;-ms-text-size-adjust:100%;\">Reset my password");// ToDo: find URL
        resetPasswordUrl.replace("amp","");

        return new RequestPasswordResetSubmitPage(driver);



    }
}
