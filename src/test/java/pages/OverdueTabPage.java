package pages;

import org.testng.annotations.Test;
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
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

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

    private By result = By.xpath("//android.widget.TextView[contains(@text,'Result of call')]");
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


    public void tapsOnPatientName(String patientName) {
        WebElement webElement = patientDetail.stream().filter(element -> element.findElement(nameAndAge).getText().toUpperCase().contains(patientName.toUpperCase())).findFirst().get();
        webElement.click();
    }

    public void verifiesPatientDetailExpeandedView() {
        Assert.assertTrue(patientPhoneNumber.isDisplayed());
        Assert.assertTrue(overdueActionContainer.findElement(result).isDisplayed(), "result of call element should be displayed");
        Assert.assertTrue(overdueActionContainer.findElement(reasonAgreedToVisit).isDisplayed());
        Assert.assertTrue(overdueActionContainer.findElement(reasonReminderLater).isDisplayed());
        Assert.assertTrue(overdueActionContainer.findElement(reasonRemoveFromList).isDisplayed());
    }

    public void isPatientPresent(String patientName) {

        WebElement ele = patientDetail.stream().filter(element -> element.findElement(nameAndAge).getText().toUpperCase()
                .contains(patientName.toUpperCase()))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);

        Assert.assertTrue(ele.findElement(callIcon).isDisplayed(), "call Icon should be displayed");
        Assert.assertTrue(ele.findElement(patientbp).isDisplayed(), "patinet bp should be displayed");
        Assert.assertTrue(ele.findElement(overdueDays).isDisplayed(), "overDue days should be dispalyed");
    }

    public void tapsOnAgreeToVisit() {
        overdueActionContainer.findElement(reasonAgreedToVisit).click();
    }

    public void isPatientNotPresent(String patientName) {
        if (patientDetail.size() == 0) {
            Assert.assertTrue(noPatientsOverdueMessage.isDisplayed());
        } else {
            boolean b = patientDetail.stream().noneMatch(element -> element.findElement(nameAndAge).getText().toUpperCase()
                    .contains(patientName.toUpperCase()));
            Assert.assertEquals(b, true, "patient name should not be displayed in overdue section");
        }
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

    public void isPatientNotPresentInList(String patient) {
        isPatientNotPresent(patient);
    }

    public void createOverduePatientForTodayFromApi() {
        int dd = new Faker().random().nextInt(40, 90);
        new CreatePatients().createPatientWithBackDate(dd);
        new CreateBp().createBpWithBackDate(dd);

        new CreateAppointment().createAppointmentForOverduePatient(0);
    }

    public void tapsOnCallIcon(String patientName) {
        WebElement webElement = patientDetail.stream().filter(element -> element.findElement(nameAndAge)
                .getText().toUpperCase().contains(patientName.toUpperCase()))
                .findFirst().get();
        webElement.findElement(callIcon).click();
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
}
