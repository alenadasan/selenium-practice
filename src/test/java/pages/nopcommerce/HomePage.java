package pages.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage {

    @FindBy(xpath = "//button[contains(@class, 'product-box-add-to-cart-button')]")
    private List<WebElement> addToCartButtons;
    @FindBy(className = "close")
    private WebElement closeNotificationButton;

    @FindBy(className = "cart-label")
    private WebElement shoppingCartLabel;
    @FindBy(className = "name")
    private List<WebElement> productsInCart;

    private WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    public void addToCartProductWithIndex(int index) {
        addToCartButtons.get(index).click();
    }

    public void closeAddToCartNotification() {
        wait.until(ExpectedConditions.visibilityOf(closeNotificationButton));
        closeNotificationButton.click();
        wait.until(ExpectedConditions.invisibilityOf(closeNotificationButton));
    }

    public List<String> getProductsFromCart() {
        Actions actions = new Actions(driver);
        actions.moveToElement(shoppingCartLabel).perform();
        wait.until(ExpectedConditions.visibilityOfAllElements(productsInCart));

        List<String> productNames = new ArrayList<>();
        for(int i = 0; i < productsInCart.size(); i++) {
            productNames.add(productsInCart.get(i).getText());
        }

        return productNames;
    }
}







