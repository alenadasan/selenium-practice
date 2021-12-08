package pages.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

    @FindBy(id = "FullName")
    private WebElement fullNameInput;
    @FindBy(id = "Email")
    private WebElement emailInput;
    @FindBy(id = "Enquiry")
    private WebElement enquiryTextArea;
    @FindBy(name = "send-email")
    private WebElement submitButton;

    @FindBy(className = "result")
    private WebElement confirmationMessage;
    @FindBy(id = "FullName-error")
    private WebElement fullNameErrorMessage;
    @FindBy(id = "Email-error")
    private WebElement emailErrorMessage;
    @FindBy(id = "Enquiry-error")
    private WebElement enquiryErrorMessage;

    private WebDriver driver;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillInContactForm(String fullName, String email, String enquiry) {
        fullNameInput.sendKeys(fullName);
        emailInput.sendKeys(email);
        enquiryTextArea.sendKeys(enquiry);

        submitButton.click();
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }

}
