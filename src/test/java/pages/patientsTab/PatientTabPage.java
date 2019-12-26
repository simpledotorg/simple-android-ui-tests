package pages.patientsTab;

import com.embibe.optimus.utils.ScenarioContext;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.BasePage;
import pages.ScanCardPage;
import pages.SearchPage;
import qaApiServices.patients.GetPatientInfo;
import qaApiServices.user.RegisterUser;
import utils.ScenarioContextKeys;

import java.util.List;

public class PatientTabPage extends BasePage {
    private AppiumDriver driver;

    private SearchPage searchSection;
    private RecentPatientSection recentPatientSection;
    private ScanCardPage scanCardSection;

    @FindBy(id = "scanSimpleCardButton")
    private WebElement scanBPPassportButton;

    @FindBy(id = "patients_user_awaitingapproval_title")
    private WebElement approvalMessage;

    @FindBy(id = "dismissApprovedStatusButton")
    private WebElement GotITButton;

    @FindBy(id = "sync_indicator_status_text")
    private WebElement syncLink;

    @FindBy(id = "sync_indicator_status_text")
    private WebElement syncPendingStatus;

    @FindBy(id = "android:id/message")
    private WebElement syncErrorMessage;

    @FindBy(id = "android:id/button1")
    private WebElement syncErrorMessageOkayButton;

    @FindBy(xpath = "//android.widget.Button[contains(@text,'ALLOW')]")
    private WebElement allow_button;


    public PatientTabPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        searchSection = new SearchPage(driver);
        recentPatientSection = new RecentPatientSection(driver);
    }

    public void verifyPatientTab() {
        hideKeyboard();
        waitForElementToBeVisible(GotITButton);
        GotITButton.click();
        waitForElementToBeVisible(scanBPPassportButton);
        Assert.assertEquals(scanBPPassportButton.getText(), "Scan BP Passport");
    }

    public void selectPatientFromSearchList() {
        String patientName = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        searchSection.selectsPatientFromSearchList(patientName);
    }

    public void tapsOnSyncLink() {
        syncLink.click();
        waitFor(1000);
    }

    public void verifiesSeeAllOption(int patinetCount) {
        recentPatientSection.verifiesSeeAllOption(patinetCount);
    }

    public void selectPatientFromRecentPatientList(String patientNAme) throws Exception {
        recentPatientSection.selectPatientFromRecentPatientList(patientNAme);
    }

    public void tapsOnSearchTextBox() {
        searchSection.tapsOnSearchTextBox();
    }

    public void isPatientPresent(String patientName) throws Exception {
        recentPatientSection.isPatientPresent(patientName);
    }

    public void selectAnyPatient() {
        recentPatientSection.selectAnyPatientFromRecentPatientSection();
    }

    public void shouldNotShowUpOnTopOfList() {
        recentPatientSection.shouldNotShowUpOnTopOfList();
    }

    public void shouldShowUpOnTopOfList() {
        recentPatientSection.shouldShowUpOnTopOfRecentPatinetList();
    }

    public void verifyNoRecentPatientText() {
        recentPatientSection.verifyNoRecentPatientText();
    }

    public void syncLinkShouldNotBePresent() {
        Assert.assertFalse(isElementPresent(By.id("sync_indicator_root_layout")));
    }

    public void verifiesSyncErrorMessage() {
        waitForElementToBeVisible(syncErrorMessageOkayButton);
        Assert.assertTrue(syncErrorMessage.isDisplayed(), "sync error message should be displayed as acces is denied");
        Assert.assertTrue(syncErrorMessageOkayButton.isDisplayed(), "syncErrorMessage Okay Button should be displayed as acces is denied");
    }

    public void tapsOnOkayButton() {
        syncErrorMessageOkayButton.click();
    }

    public void verifySyncPendingLinkShouldBePresent() {
        Assert.assertTrue(syncPendingStatus.getText().equals("Sync pending"));
    }

    public void verifyPatientInfoIsSyncedInServer() {
        new RegisterUser().registerNewUser();
        List<String> allPatientsName = new GetPatientInfo().getAllPatientsInfo();
        String PatientName = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        Assert.assertTrue(allPatientsName.contains(PatientName), " Patient data is not synced in server");
    }

    public void verifyPatientInfoshouldNotSyncedInServer() {
        new RegisterUser().registerNewUser();
        List<String> allPatientsName = new GetPatientInfo().getAllPatientsInfo();
        String PatientName = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        Assert.assertFalse(allPatientsName.contains(PatientName), " As access is denied for user,Patient data should not get synced in server");
    }

    public void tapsOnScanBpPassport() {
        waitForElementToBeVisible(scanBPPassportButton);
        scanBPPassportButton.click();
        //we are using this piece of code for high end devices as we get permission pop up
        try {
            allow_button.click();
        } catch (Exception e) {
            System.out.println("m here");
        }
    }

    public void tapsOnGotItLink() {
        waitForElementToBeVisible(GotITButton);
        GotITButton.click();
    }
}
