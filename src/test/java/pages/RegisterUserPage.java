package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class RegisterUserPage extends BasePage {
    private AppiumDriver driver;

    @FindBys({
            @FindBy(xpath = "//android.widget.ImageView")
    })
    private List<WebElement> getStartedButton;

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
    private WebElement ConfirmPin;

    @FindBy(id = "registrationlocation_skip")
    private WebElement skipLocationAccess;

    @FindBy(id = "registrationfacilities_search")
    private WebElement searchBar;

    @FindBy(className = "facility_item_name")
    private WebElement searchResult;

    @FindBy(id="pinentry_pin")
    private WebElement registeredUserPin;

    @FindBy(id="patients_enter_code")
    private WebElement enterCodeLink;

    @FindBy(id="enterotp_otp")
    private WebElement Otp;

    @FindBy(id="android:id/button1")
    private WebElement gotItButton;



    public RegisterUserPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private void reEnterPin(String pin) {
        ConfirmPin.sendKeys(pin);
    }

    public void enterPin(String pin ) {
        registrationPin.sendKeys(pin);
        reEnterPin(pin);
    }

    public void clicksOnGetStartedButton() {
        getStartedButton.get(1).click();
    }

    public void enterRegistrationPhoneNumber(String phoneNumber) {
        registrationPhoneNumber.sendKeys(phoneNumber + "\n");
    }

    public void enterRegistrationName(String name) {
        registrationNameTextBox.sendKeys(name+"\n");
    }

    private void skipLocationAccess() {
        skipLocationAccess.click();
    }

    public void searchFacility() {
        skipLocationAccess();
        searchBar.sendKeys("CHC Bagta");
//        searchResult.click();
    }

    public void enterPinForRegisteredUser(String pin){
        registeredUserPin.sendKeys(pin);
    }

    public void clickOnEnterCodeLink(){
        enterCodeLink.click();
    }

    public void enterOtp(){
        Otp.sendKeys("000000"+"/n");
    }

    public void clicksOnGotItButton(){
        gotItButton.click();
    }
}
