package pages.patientPrimaryInformation;

import com.embibe.optimus.utils.ScenarioContext;
import io.appium.java_client.AppiumDriver;
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
import java.util.stream.Collectors;

@Getter
@Setter
public class PatientPrimaryInfoSection extends BasePage {

    private AppiumDriver driver;
    //    patiententry_phone_number
    @FindBy(id = "phoneNumberEditText")
    private WebElement PhoneNumberTextBox;

    @FindBy(id = "patiententry_age")
    private WebElement ageTextBox;

    @FindBys({
            @FindBy(className = "android.widget.RadioButton")
    })
    private List<WebElement> gender;

    @FindBy(id = "patiententry_colony_or_village")
    private WebElement colonyTextBox;

    @FindBy(id = "districtEditText")
    private WebElement districtTextBox;

    @FindBy(id = "stateEditText")
    private WebElement stateTextBox;

    @FindBy(className = "android.widget.Button")
    private WebElement saveButton;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Phone number cannot be less than 6 digits')]")
    private WebElement phoneNumberErrorMsg;

    @FindBy(id = "patiententry_gender_validation_error")
    private WebElement genderValidationerrorMsg;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Enter colony / village / ward')]")
    private WebElement colonyValidationerrorMsg;

//    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Enter patient’s age')]")
//    private WebElement AgeValidationerrorMsg;

    @FindBy(id = "patiententry_date_of_birth")
    private WebElement enterDateOfBirth;

    @FindBy(id = "fullNameEditText")
    private WebElement fullNameEditText;

    @FindBy(id = "patientsummary_header")
    private WebElement patientsummary_header;
    private By contact = By.id("patientsummary_contact");

    public PatientPrimaryInfoSection(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private void enterPhoneNumber(String number) {
        PhoneNumberTextBox.sendKeys(number + "\n");
    }

    private void enterAge(String age) {
        ageTextBox.sendKeys(age + "\n");
    }

    private void enterGender(String value) {
        WebElement webElement = gender.stream().filter(e -> e.getText().equals(value)).findFirst().get();
        webElement.click();
    }

    private void enterColony(String value) {
        colonyTextBox.sendKeys(value + "\n");
    }

    public void enterDistrict(String value) {
        districtTextBox.sendKeys(value + "\n");
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

    public void enterPatientInfo(String name, String phone, String age, String gender, String colony) {
        if (name != null && !name.isEmpty()) {
            enterPatientName(name);
        }
        if (phone != null && !phone.isEmpty()) {
            enterPhoneNumber(phone);
        }
        enterAge(age);
        enterGender(gender);
        enterColony(colony);
        Assert.assertTrue(districtTextBox.getText().equalsIgnoreCase("Bathinda"));
        Assert.assertTrue(stateTextBox.getText().equalsIgnoreCase("Punjab"));
        clickSaveButton();
    }

    public void validateErrorMessage() {
        Assert.assertTrue(phoneNumberErrorMsg.isDisplayed());
//        Assert.assertTrue(genderValidationerrorMsg.getText().contains("Choose gender"));
        Assert.assertTrue(colonyValidationerrorMsg.isDisplayed());
//        Assert.assertTrue(AgeValidationerrorMsg.isDisplayed());
    }

    public void enterPatientInvalidPatientInfo(String phonenumber) {
        enterPhoneNumber(phonenumber);
        clickSaveButton();
        driver.hideKeyboard();
    }

    public void enterInvalidDate(String sDate) {
        enterDateOfBirth.sendKeys(sDate);
        clickSaveButton();
        Assert.fail(" need to add ASSERTION when defect will get fixed");
    }

    public void verifyPhoneNumber(String phoneNumber) {
        patientsummary_header.findElement(contact).getText().equals(phoneNumber);
    }

    public void verifiesPhoneNumberPrefill() {
        String expectedValue = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_PHONE_NUMBER);
        Assert.assertEquals(PhoneNumberTextBox.getText(), expectedValue, "phone number value should be prefill");
    }
}



