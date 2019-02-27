package test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchPage;

public class SearchTests extends BaseTest {


    @Test()
    public void basicSearchTest()   {
        String userEmail = "irvold66@ukr.net";
        String userPassword = "pbkbycrbq555";
        String searchTerm = "HR";

        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");

        HomePage homePage = landingPage.login(userEmail, userPassword);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page did not load after Login");

        SearchPage searchPage = homePage.search(searchTerm);

        Assert.assertTrue(searchPage.isPageLoaded(), "Search page did not load");

        JavascriptExecutor js = (JavascriptExecutor)driver;

        driver.manage().window().maximize();
        js.executeScript("scroll(0,1348)","");

        for (WebElement searchResultsList : searchResultsList) {
            String searchResultElementText = searchResultsList.getText();
            if (searchResultElementText.toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println("searchTerm found");
            } else {
                System.out.println("searchTerm not found");
            }
        }
    }
}
