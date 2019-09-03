package pages;

import com.embibe.optimus.utils.ScenarioContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.ScenarioContextKeys;

public class LoginPage extends BasePage {
    private AppiumDriver driver;


    @FindBy(id = "phoneNumberEditText")
    private MobileElement registrationPhoneNumber;

    @FindBy(id = "patients_enter_code")
    private WebElement enterCodeLink;

    @FindBy(id = "enterotp_otp")
    private MobileElement Otp;

    @FindBy(id = "android:id/button1")
    private WebElement gotItButton;

    @FindBy(id = "pinentry_pin")
    private MobileElement registeredUserPin;

    @FindBy(id = "patients_dismiss_user_approved_status")
    private WebElement GotItLink;

    @FindBy(id = "registrationconfirmpin_pin")
    private WebElement confirmPin;

    @FindBy(id = "registrationname_name")
    private MobileElement registrationNameTextBox;

    @FindBy(id = "onboarding_get_started")
    private WebElement getStartedButton;

    @FindBy(id = "registrationpin_pin")
    private MobileElement registrationPin;

    @FindBy(id = "registrationconfirmpin_reset_pin")
    private WebElement resetPin;

    @FindBy(id = "registrationpin_card_content")
    private WebElement registrationPinSection;

    @FindBy(id = "registrationlocation_skip")
    private WebElement skipLocationAccess;

    @FindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'registrationconfirmpin_error')]/android.widget.TextView")
    private WebElement confirmPinErrorMsg;

    @FindBy(id = "validationErrorTextView")
    private WebElement registrationPhoneNumberErrorMsg;

    @FindBy(id = "registrationfacilities_search")
    private MobileElement searchBar;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout")
    private WebElement searchResult;

    public LoginPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;

    }

    public void enterRegistrationPhoneNumber(String phoneNumber) {
        Assert.assertTrue(isElementPresent(By.id("phoneNumberEditText")));
        registrationPhoneNumber.setValue(phoneNumber);
        pressEnter();
    }

    private void enterPinForRegisteredUser(String pin) {
        Assert.assertTrue(isElementPresent(By.id("pinentry_pin")));
        registeredUserPin.setValue(pin);
        ScenarioContext.putData("User", ScenarioContextKeys.PIN, pin);
        pressEnter();
    }

    private void clickOnEnterCodeLink() {
        try {
            waitForElementToBeVisible(GotItLink);
            GotItLink.click();
        } catch (Exception e) {
        }

        waitForElementToBeVisible(enterCodeLink);
        enterCodeLink.click();
    }

    private void enterOtp() {
        Otp.setValue("000000");
        pressEnter();
    }

    private void clicksOnGotItButton() {
        waitForElementToBeVisible(gotItButton);
        gotItButton.click();
        try {
            GotItLink.click();
        } catch (Exception e) {
        }
    }

    public void enterNewRegistrationPin(String pin) {
        waitForElementToBeVisible(registrationPin);
        registrationPin.setValue(pin);
//        pressEnter();
    }

    public void clicksOnGetStartedButton() {
        waitForElementToBeVisible(getStartedButton);
        getStartedButton.click();
    }

    public void enterRegistrationName(String name) {
        registrationNameTextBox.setValue(name);
        ScenarioContext.putData("User",ScenarioContextKeys.USER_NAME,name);
        pressEnter();
    }

    public void reEnterPin(String pin) {
        waitForElementToBeVisible(confirmPin);
        if (pin != null && !pin.isEmpty()) {
            confirmPin.sendKeys(pin + "/n");
        } else {
            pressEnter();
        }
    }

    public void userLogsIn(String phoneNumber, String pin) {
        clicksOnGetStartedButton();
        enterRegistrationPhoneNumber(phoneNumber);
        enterPinForRegisteredUser(pin);
        clickOnEnterCodeLink();
        enterOtp();
        clicksOnGotItButton();
    }

    public void newUserRegisteration(String phoneNumber,String name, String pin) {
        clicksOnGetStartedButton();
        enterRegistrationPhoneNumber(phoneNumber);
        enterRegistrationName(name);
        enterNewRegistrationPin(pin);
        reEnterPin(pin);
    }

    public void tapsOnResetPin() {
        resetPin.click();
        Assert.assertTrue(registrationPinSection.isDisplayed());
        enterNewRegistrationPin("1234");
        reEnterPin("1234");
        Assert.assertTrue(skipLocationAccess.isDisplayed());
    }

    public void enterInvalidPin(String pin) {
        reEnterPin(pin);
        Assert.assertTrue(confirmPinErrorMsg.isDisplayed());
        System.out.println(confirmPinErrorMsg.getText() + "text");
        Assert.assertTrue(resetPin.isDisplayed());
    }

    private void skipLocationAccess() {
        skipLocationAccess.click();
    }

    public void searchFacility(String facility) {
        skipLocationAccess();
        searchBar.setValue(facility);
        searchResult.click();
    }

    public void enterInvalidPhoneNumber(String phone) {
        if(phone!=null && !phone.isEmpty()){
            registrationPhoneNumber.sendKeys(phone + "\n");}
        else{
            pressEnter();
        }
        waitForElementToBeVisible(registrationPhoneNumberErrorMsg);
        Assert.assertTrue(registrationPhoneNumberErrorMsg.getText().contains("Check phone number"));
    }

    public void searchInvalidFacility(String facility) {
        skipLocationAccess();
        searchBar.sendKeys(facility);
        Assert.fail("defect - no proper error message is displayed for invalid facility name");
    }
}
