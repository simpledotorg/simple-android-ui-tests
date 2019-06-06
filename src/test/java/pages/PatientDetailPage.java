package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientDetailPage extends BasePage {
    private AppiumDriver driver;
    PatientPrimaryInfoSection patientPrimaryInfoSection;
    BpSection bpSection;

    @FindBy(xpath = "//android.widget.Button[@text='Save']")
    private WebElement saveButton;

    @FindBy(id = "scheduleappointment_done")
    private WebElement scheduleAppointmentDoneButton;

    public PatientDetailPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        patientPrimaryInfoSection = new PatientPrimaryInfoSection(driver);
        bpSection = new BpSection(driver);
        this.driver = driver;
    }

    public void enterPatientInfo(String phone, String age, String male, String testColony) {
        patientPrimaryInfoSection.enterPatientInfo(phone, age, male, testColony);
    }

    public void enterBpInfo(String systollic, String diastolic) {
        bpSection.enterBpInfo(systollic, diastolic);
    }

    public void tapsOnNextArrow() {
        bpSection.tapsOnNextArrow();
    }

    public void entersDate(String date) {
        bpSection.entersDate(date);
    }

    public void clickOnSaveButton() {
        waitForElementToBeClickable(saveButton);
        saveButton.click();
    }

    public void clickOnAppointmentDoneButton() {
        scheduleAppointmentDoneButton.click();
    }

    public void userNavigatesBack() {
        driver.navigate().back();
    }

    public void validateErrorMessage() {
        patientPrimaryInfoSection.validateErrorMessage();
    }

    public void enterPatientInvalidPatientInfo(String phoneNumber) {
        patientPrimaryInfoSection.enterPatientInvalidPatientInfo(phoneNumber);
    }

    public void enterInvalidDate(String sDate) {
        patientPrimaryInfoSection.enterInvalidDate(sDate);
    }
}
