package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchPage;

import java.util.List;

public class SearchTests extends BaseTest {
    String searchTerm = "Human Resources";

    @Test()
    public void basicSearchTest() {
        String userEmail = "irvold66@ukr.net";
        String userPassword = "pbkbycrbq555";
        int elementCount = 10;


        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");

        HomePage homePage = landingPage.login(userEmail, userPassword);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page did not load after Login");

        SearchPage searchPage = homePage.search(searchTerm);

        Assert.assertTrue(searchPage.isPageLoaded(), "Search page did not load");

       Assert.assertEquals(searchPage.getSearchResultsCount(), elementCount, "Search results count is wrong");

        List<String> searchResultsList = searchPage.getSearchResultsList();

        for (String searchResult:searchResultsList) {

            Assert.assertTrue(searchResult.contains(searchTerm),
                    "SearchTerm Human Resources" + searchTerm + "not found in:\n" + searchResult);
        }


    }
}

