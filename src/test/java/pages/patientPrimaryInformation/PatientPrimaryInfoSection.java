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
    private By contact = By.id("contactTextView");

    @FindBy(id = "consentSwitch")
    private WebElement consentSwitch;

    @FindBy(id = "textinput_error")
    private WebElement ageRangeValidationErrorMsg;

    @FindBy(id = "streetAddressEditText")
    private MobileElement houseEditTextBox;

    @FindBy(id = "bangladeshNationalIdEditText")
    private MobileElement bangladeshNationalIdEditText;

    @FindBy(id = "zoneEditText")
    private MobileElement zoneEditText;

    public PatientPrimaryInfoSection(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }

    private void enterPhoneNumber(String number) {
        PhoneNumberTextBox.sendKeys(number + "\n");
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

    private void enterPatientInfoForIndia(String name, String phone, String value, String gender, String house, String colony, String consent) {
        if (name != null && !name.isEmpty()) {
            enterPatientName(name);
            ScenarioContext.putData("User", ScenarioContextKeys.PATIENT_NAME, name);
        }
        if (phone != null && !phone.isEmpty()) {
            enterPhoneNumber(phone);
            ScenarioContext.putData("User", ScenarioContextKeys.PATIENT_PHONE_NUMBER, phone);
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
            ScenarioContext.putData("User", ScenarioContextKeys.PATIENT_COLONY, colony);
        }
        if (house != null && !house.isEmpty()) {
            enterHouse(house);
            ScenarioContext.putData("User", ScenarioContextKeys.PATIENT_HOUSE, house);
        }
        Assert.assertTrue(districtTextBox.getText().equalsIgnoreCase("Bathinda"));
        Assert.assertTrue(stateTextBox.getText().equalsIgnoreCase("Punjab"));

        String strn = scrollToElement("WhatsApp / SMS Reminders");
        Assert.assertEquals(strn, "true", "reminder concent toggle shold be present");

        Assert.assertTrue(consentSwitch.getAttribute("checked").equals("true"));

        if (consent.equals("disabled")) {
            setRemainderConcentToggleFor(consent);
        }
        clickSaveButton();

    }

    private void enterHouse(String house) {
        houseEditTextBox.setValue(house);
        pressEnter();
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
        if (PhoneNumberTextBox.getText().length() < 6) {
            Assert.assertEquals(phoneNumberValidationErrorMsg.getText(), "Phone number cannot be less than 6 digits");
        } else if (ageTextBox.getText().isEmpty()) {
            Assert.assertEquals(ageValidationerrorMsg.getText().replaceAll("[^a-zA-Z\\s]", ""), "Enter patients age");
        } else if (!gender.get(0).isSelected() || !gender.get(1).isSelected() || !gender.get(2).isSelected()) {
            Assert.assertEquals(genderValidationErrorMsg.getText().replaceAll("[^a-zA-Z\\s]", ""), "Choose patients gender");
        } else if (colonyTextBox.getText().isEmpty()) {
            Assert.assertEquals(colonyValidationErrorMsg.getText(), "Enter colony / village / ward");
        }
    }

    private void setRemainderConcentToggleFor(String value) {
        consentSwitch.click();
    }


    public void verifyAgeValidationErrorMessage() {
        if (!ageTextBox.getText().isEmpty()) {
            if (Integer.parseInt(ageTextBox.getText()) > 120) {
                Assert.assertEquals(ageRangeValidationErrorMsg.getText(), "Age cannot be more than 120 years");
            } else if (Integer.parseInt(ageTextBox.getText()) == 0) {
                Assert.assertEquals(ageRangeValidationErrorMsg.getText(), "Age cannot be equal to 0 years");
            }
        }
    }

    public void verifyAddressModelForCountry() {
        String country = ScenarioContext.getData("User", ScenarioContextKeys.COUNTRY);
        if (country.equals("India")) {

            Assert.assertTrue(PhoneNumberTextBox.isDisplayed());
            Assert.assertTrue(houseEditTextBox.isDisplayed());
            Assert.assertTrue(colonyTextBox.isDisplayed());
        } else if (country.equals("Bangladesh")) {
            Assert.assertTrue(PhoneNumberTextBox.isDisplayed());
            Assert.assertTrue(houseEditTextBox.isDisplayed());
            Assert.assertTrue(colonyTextBox.isDisplayed());
            Assert.assertTrue(bangladeshNationalIdEditText.isDisplayed());
            scrollDown();
            Assert.assertTrue(zoneEditText.isDisplayed());
        } else {
            Assert.fail("No such country" + country);
        }
    }

    public void verifyAddressValues() {

        String country = ScenarioContext.getData("User", ScenarioContextKeys.COUNTRY);
        if (country.equals("India")) {
            String phoneNumber = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_PHONE_NUMBER);
            String house = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_HOUSE);
            String colony = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_COLONY);

            //WHen we read data from edit text box , we are getting extra character \n
            String text = getAllDigitsInString(PhoneNumberTextBox.getText());
            Assert.assertEquals(text, phoneNumber,"phoneNumber text field is either null or value is different");
            Assert.assertEquals(houseEditTextBox.getText(), house,"house text field is either null or value is different");
            Assert.assertEquals(colonyTextBox.getText(), colony,"colony text field is either null or value is different");

        } else if (country.equals("Bangladesh")) {
            String phoneNumber = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_PHONE_NUMBER);
            String house = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_HOUSE);
            String colony = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_COLONY);
            String nationalId = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NATIONALID);
            String zone = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_ZONE);

            String text = getAllDigitsInString(PhoneNumberTextBox.getText());
            Assert.assertEquals(text,phoneNumber,"phoneNumber text field is either null or value is different");
            Assert.assertEquals(houseEditTextBox.getText(),house,"house text field is either null or value is different");
            Assert.assertEquals(colonyTextBox.getText(),colony,"colony text field is either null or value is different");
            String expectedId = getAllDigitsInString(bangladeshNationalIdEditText.getText());
            Assert.assertEquals(expectedId,nationalId,"nationalId text field is either null or value is different");
            scrollDown();
            Assert.assertEquals(zoneEditText.getText(),zone,"Union text field is either null or value is different");
        } else {
            Assert.fail("No such country" + country);
        }
    }


    public void enterPatientInfoForBangladesh(String name, String phone, String age, String gender,String house, String colony,String consent,String nationalId, String zone) {
        if (name != null && !name.isEmpty()) {
            enterPatientName(name);
            ScenarioContext.putData("User", ScenarioContextKeys.PATIENT_NAME, name);
        }
        if (age != null && !age.isEmpty()) {
            enterAgeOrDateOfBirth(age);
        }
        if (phone != null && !phone.isEmpty()) {
            enterPhoneNumber(phone);
            ScenarioContext.putData("User", ScenarioContextKeys.PATIENT_PHONE_NUMBER, phone);
        }
        if (gender != null && !gender.isEmpty()) {
            enterGender(gender);
        }
        hideKeyboard();
        if (nationalId != null && !nationalId.isEmpty()) {
            enterNationalId(nationalId);
            ScenarioContext.putData("User", ScenarioContextKeys.PATIENT_NATIONALID, nationalId);
        }
        if (house != null && !house.isEmpty()) {
            enterHouse(house);
            ScenarioContext.putData("User", ScenarioContextKeys.PATIENT_HOUSE, house);
        }
        if (colony != null && !colony.isEmpty()) {
            enterColony(colony);
            ScenarioContext.putData("User", ScenarioContextKeys.PATIENT_COLONY, colony);
        }
        if (zone != null && !zone.isEmpty()) {
            enterZone(zone);
            ScenarioContext.putData("User", ScenarioContextKeys.PATIENT_ZONE, zone);
        }

        Assert.assertTrue(districtTextBox.getText().equalsIgnoreCase("Bathinda"));
        Assert.assertTrue(stateTextBox.getText().equalsIgnoreCase("Punjab"));

        String strn = scrollToElement("WhatsApp / SMS Reminders");
        Assert.assertEquals(strn, "true", "reminder concent toggle shold be present");

        Assert.assertTrue(consentSwitch.getAttribute("checked").equals("true"));

        if (consent.equals("disabled")) {
            setRemainderConcentToggleFor(consent);
        }
        clickSaveButton();
    }

    private void enterZone(String zone) {
        zoneEditText.setValue(zone);
        pressEnter();
    }

    private void enterNationalId(String nationalId) {
        bangladeshNationalIdEditText.setValue(nationalId);
        pressEnter();
    }

    public void enterPatientInfo(String name, String phone, String value, String gender, String house, String colony, String consent, String nationalId,String zone) {

        String country = ScenarioContext.getData("User", ScenarioContextKeys.COUNTRY);
        if (country.equals("India")) {
            enterPatientInfoForIndia(name, phone, value, gender, house, colony, consent);
        } else if (country.equals("Bangladesh")) {
            enterPatientInfoForBangladesh(name, phone, value, gender, house, colony, consent,nationalId,zone);
        } else {
            Assert.fail("No such country present");
        }

    }
}



