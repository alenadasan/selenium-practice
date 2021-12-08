package pages.googlesearch;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    @FindBy(xpath = "//div[text()='Sunt de acord']")
    private WebElement agreeButton;

    @FindBy(name = "q")
    private WebElement searchInput;
    @FindBy(xpath = "(//*[@value='Google Search'])[1]")
    private WebElement searchButton;

    protected WebDriver driver;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoogleResultsPage searchFor(String query) {
        searchInput.sendKeys(query);
        searchInput.sendKeys(Keys.RETURN);

        return new GoogleResultsPage(driver);
    }

    public void agreeWithTnC() {
        agreeButton.click();
    }

}
