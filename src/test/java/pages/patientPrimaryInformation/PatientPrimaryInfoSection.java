package pages.patientPrimaryInformation;

import com.embibe.optimus.utils.ScenarioContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.BasePage;
import utils.ScenarioContextKeys;

import java.util.List;

@Getter
@Setter
public class PatientPrimaryInfoSection extends BasePage {

    private AppiumDriver driver;
    @FindBy(id = "phoneNumberEditText")
    private WebElement PhoneNumberTextBox;

    @FindBy(id = "ageEditText")
    private MobileElement ageTextBox;

    @FindBys({@FindBy(className = "android.widget.RadioButton")})
    private List<WebElement> gender;

    @FindBy(id = "colonyOrVillageEditText")
    private MobileElement colonyTextBox;

    @FindBy(id = "districtEditText")
    private MobileElement districtTextBox;

    @FindBy(id = "stateEditText")
    private WebElement stateTextBox;

    @FindBy(className = "android.widget.Button")
    private WebElement saveButton;

    @FindBy(id = "//android.widget.TextView[contains(@text,'Enter patient/’s full name')]")
    private WebElement patientsNameValidationErrorMsg;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Phone number cannot be less than 6 digits')]")
    private WebElement phoneNumberValidationErrorMsg;

    @FindBy(id = "genderErrorTextView")
    private WebElement genderValidationErrorMsg;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Enter colony / village / ward')]")
    private WebElement colonyValidationErrorMsg;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Enter patient/’s age')]")
    private WebElement ageValidationerrorMsg;

    @FindBy(id = "dateOfBirthEditText")
    private MobileElement dateOfBirthEditTextBox;

    @FindBy(id = "fullNameEditText")
    private WebElement fullNameEditText;

    @FindBy(id = "patientsummary_header")
    private WebElement patientsummary_header;
    private By contact = By.id("patientsummary_contact");

    public PatientPrimaryInfoSection(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }

    private void enterPhoneNumber(String number) {
        PhoneNumberTextBox.sendKeys(number+"\n");
    }

    private void enterAgeOrDateOfBirth(String value) {
        if (value.contains("/")) {
            waitForElementToBeVisible(dateOfBirthEditTextBox);
            dateOfBirthEditTextBox.setValue(value);
        } else {
            ageTextBox.setValue(value);
            pressEnter();
        }
    }

    private void enterGender(String value) {
        WebElement webElement = gender.stream().filter(e -> e.getText().equals(value)).findFirst().get();
        webElement.click();
    }

    private void enterColony(String value) {
        colonyTextBox.setValue(value);
        pressEnter();
    }

    public void enterDistrict(String value) {
        districtTextBox.setValue(value);
        pressEnter();
    }

    public void enterState(String value) {
        stateTextBox.sendKeys(value + "\n");
    }

    public void enterPatientName(String value) {
        fullNameEditText.sendKeys(value + "\n");
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public void enterPatientInfo(String name, String phone, String value, String gender, String colony) {
        if (name != null && !name.isEmpty()) {
            enterPatientName(name);
            ScenarioContext.putData("User", ScenarioContextKeys.PATIENT_NAME,name);
        }
        if (phone != null && !phone.isEmpty()) {
            enterPhoneNumber(phone);
            ScenarioContext.putData("User", ScenarioContextKeys.PATIENT_PHONE_NUMBER,name);
        }
        if (value != null && !value.isEmpty()) {
            enterAgeOrDateOfBirth(value);
        }
        if (gender != null && !gender.isEmpty()) {
            enterGender(gender);
        }
        hideKeyboard();
        if (colony != null && !colony.isEmpty()) {
            enterColony(colony);
        }
        Assert.assertTrue(districtTextBox.getText().equalsIgnoreCase("Bathinda"));
        Assert.assertTrue(stateTextBox.getText().equalsIgnoreCase("Punjab"));
        clickSaveButton();
    }

    public void enterPatientInvalidPatientInfo(String phonenumber) {
        enterPhoneNumber(phonenumber);
        clickSaveButton();
        driver.hideKeyboard();
    }

    public void verifyPhoneNumber(String phoneNumber) {
        patientsummary_header.findElement(contact).getText().equals(phoneNumber);
    }

    public void verifiesPhoneNumberPrefill() {
        String expectedValue = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_PHONE_NUMBER);
        Assert.assertEquals(PhoneNumberTextBox.getText(), expectedValue, "phone number value should be prefill");
    }

    public void verifyValidationErrorMessages() {
        hideKeyboard();
//        if (fullNameEditText.getText().isEmpty()) {
////            Assert.assertEquals(patientsNameValidationErrorMsg.getText().replaceAll("[^a-zA-Z\\s]", ""), "Enter patients full name");
////        }
        if (PhoneNumberTextBox.getText().length() < 6) {
            Assert.assertEquals(phoneNumberValidationErrorMsg.getText(), "Phone number cannot be less than 6 digits");
        }
        if (ageTextBox.getText().isEmpty()) {
            Assert.assertEquals(ageValidationerrorMsg.getText().replaceAll("[^a-zA-Z\\s]", ""), "Enter patients age");
        }
        if (!gender.get(0).isSelected() || !gender.get(1).isSelected() || !gender.get(2).isSelected()) {
            Assert.assertEquals(genderValidationErrorMsg.getText().replaceAll("[^a-zA-Z\\s]", ""), "Choose patients gender");
        }
        if (colonyTextBox.getText().isEmpty()) {
            Assert.assertEquals(colonyValidationErrorMsg.getText(), "Enter colony / village / ward");
        }
    }

    public void verifyValidaitonErrorMessagesForInvalidDate() {
//        need to add check for invalid datE
            Assert.fail("no proper error message is present for invalid date");
    }
}



