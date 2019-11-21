package pages;

import com.github.javafaker.Faker;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import qaApiServices.appointments.CreateAppointment;
import qaApiServices.bloodPressure.CreateBp;
import qaApiServices.patients.CreatePatients;
import qaApiServices.user.RegisterUser;

import java.util.List;

public class OverdueTabPage extends BasePage {

    private AppiumDriver driver;

    public OverdueTabPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBys({@FindBy(id = "patient_details")})
    private List<WebElement> patientDetail;

    private By callIcon = By.id("callButton");
    private By nameAndAge = By.id("patientNameTextView");
    private By patientbp = By.id("patientBPTextView");
    private By overdueDays = By.id("overdueDaysTextView");

    @FindBy(id = "phoneNumberTextView")
    private WebElement patientPhoneNumber;

    @FindBy(id = "actionsContainer")
    private WebElement overdueActionContainer;
    private By result = By.xpath("//android.widget.TextView[contains(@text,'RESULT OF CALL')]");
    private By reasonAgreedToVisit = By.id("agreedToVisitTextView");
    private By reasonReminderLater = By.id("remindLaterTextView");
    private By reasonRemoveFromList = By.id("removeFromListTextView");


    @FindBy(xpath = "//android.widget.TextView[contains(@text,'No patients overdue')]")
    private WebElement noPatientsOverdueMessage;

    @FindBy(id = "appointmentreminder_done")
    private WebElement appointmentReminderDoneButton;


    @FindBys({@FindBy(className = "android.widget.RadioButton")})
    private List<WebElement> otherReason;

    @FindBy(id = "removeappointment_done_button")
    private WebElement doneButton;

    @FindBy(id = "removeappointment_toolbar")
    private WebElement removeAppointmentToolbar;
    private By reasonText = By.xpath("//android.widget.TextView[contains(@text,'Select a Reason')]");
    private By crossButton = By.className("android.widget.ImageButton");

    @FindBy(id = "phonemask_name")
    private WebElement phoneMaskName;

    @FindBy(id = "phonemask_phone_number")
    private WebElement phoneMaskphoneNumber;
    @FindBy(id = "phonemask_normal_call_button")
    private WebElement normalCallButton;

    @FindBy(id = "phonemask_secure_call_button")
    private WebElement secureCallButton;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Secure calls hide your number and are toll free')]")
    private WebElement phoneMaskText;

    @FindBys({@FindBy(xpath = "//android.widget.RadioButton")})
    private List<WebElement> overdueReasonList;


    public void tapsOnPatientName(String patientName) throws Exception {
        WebElement webElement = isPatientPresent(patientName);
        webElement.click();
    }

    public void verifiesPatientDetailExpeandedView() {
        Assert.assertTrue(patientPhoneNumber.isDisplayed());
        Assert.assertTrue(overdueActionContainer.findElement(result).isDisplayed(), "result of call element should be displayed");
        Assert.assertTrue(overdueActionContainer.findElement(reasonAgreedToVisit).isDisplayed());
        Assert.assertTrue(overdueActionContainer.findElement(reasonReminderLater).isDisplayed());
        Assert.assertTrue(overdueActionContainer.findElement(reasonRemoveFromList).isDisplayed());
    }

    private WebElement isPatientPresent(String patientName) throws Exception {
        new RegisterUser().registerNewUser();
        int allScheduledAppointment = new CreateAppointment().getAllScheduledAppointment();
        int count = 0;
        while (count < allScheduledAppointment) {
            for (WebElement element : patientDetail) {
                String text = element.findElement(nameAndAge).getText().replace("^[a-z,A-Z]", " ");
                if (text.toUpperCase().contains(patientName.toUpperCase()))
                    return element;
            }
            scrollDown();
            count++;
        }
        String message = String.format(patientName + " :is not present in overdue list");
        throw new Exception(message);
    }

    public void tapsOnAgreeToVisit() {
        overdueActionContainer.findElement(reasonAgreedToVisit).click();
    }

    private boolean isPatientNotPresent(String patientName) throws Exception {
        if (patientDetail.size() == 0) {
            Assert.assertTrue(noPatientsOverdueMessage.isDisplayed());
        } else {
            new RegisterUser().registerNewUser();
            int allScheduledAppointment = new CreateAppointment().getAllScheduledAppointment();
            int count = 1;
            while (count < allScheduledAppointment) {
                List<WebElement> elements = driver.findElements(nameAndAge);
                for (WebElement element : elements) {
                    String text = element.getText().replace("^[a-z,A-Z]", " ");
                    if (text.toUpperCase().contains(patientName.toUpperCase()))
                        return false;
                    count++;
                }
                scrollDown();
            }
        }
        return true;
    }

    public void tapsOnRemindToCallLater() {
        overdueActionContainer.findElement(reasonReminderLater).click();
    }

    public void tapsOnDoneButton() {
        appointmentReminderDoneButton.click();
    }

    public void tapsOnRemoveFormOverdueList() {
        overdueActionContainer.findElement(reasonRemoveFromList).click();
    }

    public void verifyReasonScreen() {
        Assert.assertTrue(removeAppointmentToolbar.findElement(reasonText).isDisplayed());
        Assert.assertTrue(removeAppointmentToolbar.findElement(crossButton).isDisplayed());
        Assert.assertTrue(doneButton.isDisplayed());
        Assert.assertEquals(otherReason.size(), 7);
    }

    public void selectReason(String reason) {
        waitForElementToBeVisible(appointmentReminderDoneButton);
        driver.findElement(By.xpath("//android.widget.RadioButton[contains(@text,'" + reason + "')]")).click();
    }

    public void shouldNotPresentInOverdueList(String patient) throws Exception {
        Assert.assertTrue(isPatientNotPresent(patient), patient + " : should not be present in overdue list");
    }

    public void createOverduePatientForTodayFromApi() {
        int dd = new Faker().random().nextInt(40, 90);
        new CreatePatients().createPatientWithBackDate(dd);
        new CreateBp().createBpWithBackDate(dd);

        new CreateAppointment().createAppointmentForOverduePatient(0);
    }

    public void tapsOnCallIcon(String patientName) throws Exception {
        WebElement patient = isPatientPresent(patientName);
        patient.findElement(callIcon).click();
    }

    public void verifiesPopup() {
        Assert.assertTrue(phoneMaskName.isDisplayed(), "phonemask name should be displayed");
        Assert.assertTrue(phoneMaskphoneNumber.isDisplayed(), "phoneMaskphoneNumber should be displayed");
        Assert.assertTrue(normalCallButton.isDisplayed(), "normalCallButton should be displayed");
        Assert.assertTrue(secureCallButton.isDisplayed(), "secureCallButton should be displayed");
        Assert.assertTrue(phoneMaskText.isDisplayed(), "phoneMaskText should be displayed");
    }

    public void createOverduePatient() {
        int dd = new Faker().random().nextInt(40, 90);
        new CreatePatients().createPatientWithBackDate(dd);
        new CreateBp().createBpWithBackDate(dd);
        new CreateAppointment().createAppointmentForOverduePatient(dd);
    }

    public void shouldPresentInOverdueList(String patientName) throws Exception {

        WebElement patientPresent = isPatientPresent(patientName);
        Assert.assertTrue(patientPresent.findElement(callIcon).isDisplayed(), "call Icon should be displayed");
        Assert.assertTrue(patientPresent.findElement(patientbp).isDisplayed(), "patinet bp should be displayed");
        Assert.assertTrue(patientPresent.findElement(overdueDays).isDisplayed(), "overDue days should be dispalyed");
    }
}
