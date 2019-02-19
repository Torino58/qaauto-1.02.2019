import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IncorrectLoginPasswordPage {

    private WebDriver driver;

    private WebElement passwordVisibilityButton;



    public IncorrectLoginPasswordPage(WebDriver driver) {
        this.driver = driver;
        initElements();

    }

    private void initElements(){
        passwordVisibilityButton = driver.findElement(By.xpath("//span[@class ='button__password-visibility']"));


    }


    public  boolean isPageLoaded(){

        return passwordVisibilityButton.isDisplayed()
                && driver.getCurrentUrl().contains("https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME")
                && driver.getTitle().contains("LinkedIn");


    }
}
