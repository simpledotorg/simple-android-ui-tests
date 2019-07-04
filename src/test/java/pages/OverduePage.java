package pages;

import qaApiServices.appointments.CreateAppointment;
import qaApiServices.bloodPressure.CreateBp;
import com.github.javafaker.Faker;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import qaApiServices.patients.CreatePatients;
import utils.Date;

import java.util.List;

public class OverduePage extends BasePage {

    private AppiumDriver driver;

    public OverduePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBys({@FindBy(id = "patient_details")})
    private List<WebElement> patientDetail;

    private By callIcon = By.id("overdue_patient_call");
    private By nameAndAge = By.id("overdue_patient_name_age");
    private By patientbp = By.id("overdue_patient_bp");
    private By overdueDays = By.id("overdue_days");

    @FindBy(id = "overdue_patient_phone_number")
    private WebElement patientPhoneNumber;

    @FindBy(id = "overdue_actions_container")
    private WebElement overdueActionContainer;

    private By result = By.xpath("//android.widget.TextView[contains(@text,'Result of call')]");
    private By reasonAgreedToVisit = By.id("overdue_agreed_to_visit");
    private By reasonReminderLater = By.id("overdue_reminder_later");
    private By reasonRemoveFromList = By.id("overdue_remove_from_list");


    @FindBy(xpath = "//android.widget.TextView[contains(@text,'No qaApiServices.patients overdue')]")
    private WebElement noPatientsOverdueMessage;

    @FindBy(id = "appointmentreminder_done")
    private WebElement appointmentReminderDoneButton;


    @FindBys({
            @FindBy(className = "android.widget.RadioButton")
    })
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


    public void tapsOnPatientName(String patientName) {
        for (WebElement ele : patientDetail) {
            String[] split = ele.findElement(nameAndAge).getText().split(",");

            System.out.println("name" + split[0]);
            if (split[0].toUpperCase().contains(patientName.toUpperCase())) {
                ele.click();
                break;
            }
        }
    }

    public void verifiesPatientDetailExpeandedView() {
        Assert.assertTrue(patientPhoneNumber.isDisplayed());
        Assert.assertTrue(overdueActionContainer.findElement(result).isDisplayed());
        Assert.assertTrue(overdueActionContainer.findElement(reasonAgreedToVisit).isDisplayed());
        Assert.assertTrue(overdueActionContainer.findElement(reasonReminderLater).isDisplayed());
        Assert.assertTrue(overdueActionContainer.findElement(reasonRemoveFromList).isDisplayed());
    }

    public void isPatientPresent(String patientName) {
        String status = "false";

        for (WebElement ele : patientDetail) {
            String[] split = ele.findElement(nameAndAge).getText().split(",");
            if (split[0].toUpperCase().contains(patientName.toUpperCase())) {
                status = "true";
                Assert.assertTrue(ele.findElement(callIcon).isDisplayed());
                Assert.assertTrue(ele.findElement(patientbp).isDisplayed());
                Assert.assertTrue(ele.findElement(overdueDays).isDisplayed());
                break;
            }
        }
        Assert.assertEquals(status, "true", "patient name should be present in overdue list");

    }

    public void tapsOnAgreeToVisit() {
        overdueActionContainer.findElement(reasonAgreedToVisit).click();
    }

    public void isPatientNotPresent(String patientName) {
        if (patientDetail.size() == 0) {
            Assert.assertTrue(noPatientsOverdueMessage.isDisplayed());
        }

        String status = "true";
        for (WebElement ele : patientDetail) {
            String[] split = ele.findElement(nameAndAge).getText().split(",");
            if (split[0].contains(patientName)) {
                status = "false";
            }
        }
        Assert.assertEquals(status, "true", "upon selecting reason,patient name should be removed from overdue list");
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

    public void verfiyReasonScreen() {
        Assert.assertTrue(removeAppointmentToolbar.findElement(reasonText).isDisplayed());
        Assert.assertTrue(removeAppointmentToolbar.findElement(crossButton).isDisplayed());
        Assert.assertTrue(doneButton.isDisplayed());
        Assert.assertTrue(otherReason.size() == 7);
    }

    public void selectReason(String reason) {
        waitForElementToBeVisible(appointmentReminderDoneButton);
        driver.findElement(By.xpath("//android.widget.RadioButton[contains(@text,'"+reason+"')]")).click();
    }

    public void isPatientNotPresentInList(String patient) {
        isPatientNotPresent(patient);
    }

    public void createOverduePatientForTodayFromApi() {
        new CreateAppointment().createAppointment(Date.getCurrentDate_In_YYYY_MM_DD());
    }

    public void tapsOnCallIcon(String patientName) {
        for (WebElement ele : patientDetail) {
            String[] split = ele.findElement(nameAndAge).getText().split(",");

            if (split[0].toUpperCase().contains(patientName.toUpperCase())) {
                ele.findElement(callIcon).click();
                break;
            }
        }
    }

    public void verifiesPopup() {
        Assert.assertTrue(phoneMaskName.isDisplayed());
        Assert.assertTrue(phoneMaskphoneNumber.isDisplayed());
        Assert.assertTrue(normalCallButton.isDisplayed());
        Assert.assertTrue(secureCallButton.isDisplayed());
        Assert.assertTrue(phoneMaskText.isDisplayed());
    }

    public void createAppointmentForOverduePatient() {
        int dd = new Faker().random().nextInt(40,90);
        new CreatePatients().createPatientWithBackDate(dd);
        new CreateBp().createBpWithBackDate(dd);
        new CreateAppointment().createAppointmentForOverduePatient(dd);
    }
}
