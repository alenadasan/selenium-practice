package tests.nopcommerce;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.nopcommerce.ContactPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ContactTest {
    @Test
    public void canSendContactRequestWithValidData() {
        System.setProperty("webdriver.chrome.driver", "C:\\Workspace\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/contactus");

        ContactPage contactPage = new ContactPage(driver);
        contactPage.fillInContactForm("peter pan", "peter@gmail.com", "Hey there");

        assertThat(contactPage.getConfirmationMessage(), is("Your enquiry has been successfully sent to the store owner."));

        driver.quit();
    }
}
