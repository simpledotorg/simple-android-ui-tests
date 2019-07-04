package pages;

import qaApiServices.appointments.CreateAppointment;
import qaApiServices.bloodPressure.CreateBp;
import com.embibe.optimus.utils.ScenarioContext;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import qaApiServices.patients.CreatePatients;
import qaApiServices.user.RegisterUser;
import utils.ScenarioContextKeys;

public class RegisterUserPage extends BasePage {
    private AppiumDriver driver;

    @FindBy(id = "onboarding_get_started")
    private WebElement getStartedButton;

    @FindBy(id = "registrationphone_phone")
    private WebElement registrationPhoneNumber;

    @FindBy(className = "android.widget.TextView")
    private WebElement fullNameLabel;

    @FindBy(id = "registrationname_name")
    private WebElement registrationNameTextBox;

    @FindBy(className = "android.widget.TextView")
    private WebElement createPinLabel;

    @FindBy(className = "android.widget.TextView")
    private WebElement recreatePinLabel;

    @FindBy(id = "registrationpin_pin")
    private WebElement registrationPin;

    @FindBy(id = "registrationconfirmpin_pin")
    private WebElement confirmPin;

    @FindBy(id = "registrationlocation_skip")
    private WebElement skipLocationAccess;

    @FindBy(id = "registrationfacilities_search")
    private WebElement searchBar;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout")
    private WebElement searchResult;

    @FindBy(id = "pinentry_pin")
    private WebElement registeredUserPin;

    @FindBy(id = "patients_enter_code")
    private WebElement enterCodeLink;

    @FindBy(id = "enterotp_otp")
    private WebElement Otp;

    @FindBy(id = "android:id/button1")
    private WebElement gotItButton;

    @FindBy(id = "registrationphone_error")
    private WebElement registrationPhoneNumberErrorMsg;

    @FindBy(id = "registrationconfirmpin_reset_pin")
    private WebElement resetPin;

    @FindBy(id = "permission_deny_button")
    private WebElement permissionDenyButton;

    @FindBy(id = "permission_allow_button")
    private WebElement permissionAllowButton;

    @FindBy(xpath = "//android.widget.LinearLayout[@id='registrationconfirmpin_error']/android.widget.TextView")
    private WebElement confirmPinErrorMsg;

    @FindBy(id = "registrationpin_card_content")
    private WebElement registrationPinSection;

    public RegisterUserPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void reEnterPin(String pin) {
        confirmPin.sendKeys(pin);
    }

    public void enterPin(String pin) {
        registrationPin.sendKeys(pin);
    }

    public void clicksOnGetStartedButton() {
        getStartedButton.click();
    }

    public void enterRegistrationPhoneNumber(String phoneNumber) {
        registrationPhoneNumber.sendKeys(phoneNumber + "\n");
    }

    public void enterRegistrationName(String name) {
        registrationNameTextBox.sendKeys(name +"\n");
    }

    private void skipLocationAccess() {
         skipLocationAccess.click();
    }

    public void searchFacility(String facility) {
        skipLocationAccess();
        searchBar.sendKeys(facility);
        searchResult.click();
    }

    public void enterPinForRegisteredUser(String pin) {
        waitForElementToBeVisible(registeredUserPin);
        registeredUserPin.sendKeys(pin);
    }

    public void clickOnEnterCodeLink() {
        enterCodeLink.click();
    }

    public void enterOtp() {
        Otp.sendKeys("000000" + "\n");
    }

    public void clicksOnGotItButton() {
        waitForElementToBeVisible(gotItButton);
        gotItButton.click();
    }

    public void enterInvalidPhoneNumber(String phone) {
        registrationPhoneNumber.sendKeys(phone + "\n");
        Assert.assertTrue(registrationPhoneNumberErrorMsg.getText().contains("Check phone number"));
    }

    public void enterInvalidPin(String pin) {
        reEnterPin(pin);
        Assert.assertTrue(confirmPinErrorMsg.isDisplayed());
        System.out.println(confirmPinErrorMsg.getText() + "text");
        Assert.assertTrue(resetPin.isDisplayed());
    }

    public void tapsOnResetPin() {
        resetPin.click();
        Assert.assertTrue(registrationPinSection.isDisplayed());
        enterPin("1234");


        Assert.assertTrue(skipLocationAccess.isDisplayed());
    }

    public void verifyErorMessageForInvalidFacilitySearch() {
//        Assertion pending becuase of defect - no proper error message is displayed for invalid qaApiServices.facility name
        System.out.println("assertion pending");
    }

    public void denyAccess() {
        permissionDenyButton.click();
        Assert.assertTrue(skipLocationAccess.isDisplayed());
    }

    public void allowAccess() {
        permissionAllowButton.click();
    }

    public void registerNewPatient() {
        new CreatePatients().createPatient();
    }


    public void registerNewPatientWithoutPhoneNumber() {
       new CreatePatients().createPatientWithoutPhoneNumber();
    }

    public void registerNewUser() {
        new RegisterUser().registerNewUser();
    }

    public void registerNewPatientWithBp() {
        new CreatePatients().createPatient();
        new CreateBp().registerNewBp();
        new CreateAppointment().createAppointment();
    }

    public void registerNewPatientWithoutBp() {
        new CreatePatients().createPatient();
    }

    public void registerNewPatientWithListOfBps(int patientCount,int bpcount) {
        createPatientWithListOfBP(1,2);
    }


    private void createPatientWithListOfBP(int patientcount, int bpcount) {

        while (patientcount > 0) {
            new CreatePatients().createPatient();
            String patientId=ScenarioContext.getData("User",ScenarioContextKeys.PATIENT_ID);
            new CreateBp().createBpList(patientId, bpcount);
            patientcount--;
        }
    }
}
