package pages.nopcommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegistrationPage {

    @FindBy(name = "Gender")
    private List<WebElement> genderRadioButtons;
    @FindBy(name = "DateOfBirthDay")
    private WebElement dayOfBirthDropdown;
    @FindBy(id = "Newsletter")
    private WebElement newsletterCheckbox;

    public void selectGender(String gender) {
        if(gender.equalsIgnoreCase("male"))
            genderRadioButtons.get(0).click();
        else if(gender.equalsIgnoreCase("female"))
            genderRadioButtons.get(1).click();
    }

    public void selectDayOfBirth(String day) {
        Select dobDropdown = new Select(dayOfBirthDropdown);
        dobDropdown.selectByVisibleText(day);
    }

    public void selectNewsletterCheckbox() {
        if (!newsletterCheckbox.isSelected())
            newsletterCheckbox.click();
    }
}
