package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage{


    @FindBy(xpath = "//h3[contains(@class, 'search-results__total')]")
    private WebElement searchResultsTotal;


    //li[contains(@class, "search-result ")]
    @FindBy(xpath = "//li[contains(@class, 'search-result ')]")
    public
    List<WebElement> searchResultElements;

    /**
     * Constructor for Landing page.
     *
     * @param driver - WebDriver instance from BaseTest.
     */
    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementIsClickable(searchResultsTotal);

    }

    public boolean isPageLoaded() {

        return searchResultsTotal.isDisplayed()
                && driver.getCurrentUrl().contains("/search/results/");
        //&& driver.getTitle().contains("| Поиск | LinkedIn");
    }

    public int getSearchResultsCount() {
        return searchResultElements.size();
    }


    public List<String> getSearchResultsList() {
        List<String> searchResultStringsList = new ArrayList<String>();
        for (WebElement searchResultElement : searchResultElements) {
            ((JavascriptExecutor) driver).
                    executeScript("arguments[0].scrollIntoView(true);", searchResultElement);

            String searchResultString = searchResultElement.getText();
            searchResultStringsList.add(searchResultString);
        }
        return searchResultStringsList;
    }


}



