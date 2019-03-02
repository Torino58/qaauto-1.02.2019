package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AcceptEmailPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[contains(@class, 'different__email--desktop')]")
    WebElement differentEmailButton;

    public AcceptEmailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {

        return differentEmailButton.isDisplayed()
                && driver.getCurrentUrl().contains("/checkpoint/rp/");
        // && driver.getTitle().contains("Проверьте, получили ли вы сообщение эл. почты со ссылкой для изменения пароля. | LinkedIn");


    }

}
