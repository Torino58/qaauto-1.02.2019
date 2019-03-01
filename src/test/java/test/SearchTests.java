package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchPage;

public class SearchTests extends BaseTest {
    String searchTerm = "Human Resources";

    @Test()
    public void basicSearchTest() {
        String userEmail = "irvold66@ukr.net";
        String userPassword = "pbkbycrbq555";
        int elementcount = 10;


        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");

        HomePage homePage = landingPage.login(userEmail, userPassword);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page did not load after Login");

        SearchPage searchPage = homePage.search(searchTerm);

        Assert.assertTrue(searchPage.isPageLoaded(), "Search page did not load");

        Assert.assertEquals(searchPage.getSize(), elementcount, "Result count is wrong");

        Assert.assertTrue(searchPage.isElementInPage(searchTerm), "Result does not contain HR.");

    }
}

