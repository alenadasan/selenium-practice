package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.googlesearch.GoogleResultsPage;
import pages.googlesearch.GoogleSearchPage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;

public class GoogleSearchTest {

    @Test
    public void checkValidSearchOnGoogle() {
        System.setProperty("webdriver.chrome.driver", "C:\\Workspace\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        searchPage.agreeWithTnC();
        GoogleResultsPage resultsPage = searchPage.searchFor("endava");
        List<String> results = resultsPage.getTextFromResultsLinks();

        for (int i = 0; i < results.size(); i++) {
            assertThat(results.get(i).toLowerCase(), containsString("endava"));
        }

        driver.quit();
    }
}
