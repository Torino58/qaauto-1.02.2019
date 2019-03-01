package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static java.lang.Thread.sleep;

public class SearchPage {

    WebDriver driver;
    boolean isMatch = false;

    @FindBy(xpath = "//h3[contains(@class, 'search-results__total')]")
    private WebElement searchResultsTotal;

    @FindBy(xpath = "//div[@class='search-result__wrapper']//h3")
    public
    List<WebElement> searchResultsList;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public boolean isPageLoaded() {

        return searchResultsTotal.isDisplayed()
                && driver.getCurrentUrl().contains("/search/results/");
        //&& driver.getTitle().contains("| Поиск | LinkedIn");
    }

    public int getSize() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        js.executeScript("scroll(0,1348)", "");
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return searchResultsList.size();
    }


    public boolean isElementInPage(String searchTerm) {


        for (WebElement searchResultList : searchResultsList) {

            if (searchResultList.getText().toLowerCase().contains(searchTerm.toLowerCase())) {

                isMatch = true;
            } else {

                isMatch = false;
                break;
            }

        }

        return isMatch;
    }


}



