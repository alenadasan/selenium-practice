package pages.googlesearch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleResultsPage {

    @FindBy(xpath = "//*[@class='yuRUbf']//h3")
    private List<WebElement> resultsLinks;

    protected WebDriver driver;

    public GoogleResultsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<String> getTextFromResultsLinks(){
        List<String> linksTexts = new ArrayList<>();
        for(int i =0 ; i < resultsLinks.size() ; i++){
            linksTexts.add(resultsLinks.get(i).getText());
        }
        return  linksTexts;
    }

}
