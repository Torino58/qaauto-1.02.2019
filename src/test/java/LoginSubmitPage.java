import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSubmitPage {

    private WebDriver driver;


    private WebElement loginForm;
    private WebElement passwordValidationMessage;
    private WebElement emailValidationMessage;


    public LoginSubmitPage(WebDriver driver) {
        this.driver = driver;
        initElements();

    }

    private void initElements() {


        loginForm = driver.findElement(By.xpath("//form[@class='login__form']"));
        passwordValidationMessage = driver.findElement(By.xpath("//div[@id='error-for-password']"));
        emailValidationMessage = driver.findElement(By.xpath("//div[@id='error-for-username']"));


    }


    public boolean isPageLoaded() {

        return loginForm.isDisplayed()
                && driver.getCurrentUrl().contains("/login-submit")
                && driver.getTitle().equals("Войти в LinkedIn");


    }

    public String getPasswordValidationMessageText() {

        return passwordValidationMessage.getText();
    }

    public String getEmailValidationMessage() {

        return emailValidationMessage.getText();
    }
}
