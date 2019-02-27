package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {

    WebDriver driver;


    @FindBy(xpath = "//h3[contains(@class, 'search-results__total')]")
    private WebElement searchResultsTotal;

    @FindBy(xpath = "//ul[contains(@class, 'search-results__list')]//li" )
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


}
