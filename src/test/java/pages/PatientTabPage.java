package pages;

import com.embibe.optimus.utils.ScenarioContext;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.ScenarioContextKeys;

import java.util.List;

public class PatientTabPage extends BasePage {
    private AppiumDriver driver;

    private SearchPage searchSection;
    private RecentPatientPage recentPatientSection;

    @FindBy(id = "patients_scan_simple_card")
    private WebElement scanBPPassportButton;

    @FindBy(id = "patients_user_awaitingapproval_title")
    private WebElement approvalMessage;

    @FindBy(id = "patients_dismiss_user_approved_status")
    private WebElement GotITButton;


    @FindBy(id = "sync_indicator_root_layout")
    private WebElement syncLink;

    public PatientTabPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        searchSection = new SearchPage(driver);
        recentPatientSection = new RecentPatientPage(driver);
    }

    public void verifyPatientTab() {
        Assert.assertEquals(scanBPPassportButton.getText(), "Scan BP Passport");
        Assert.assertTrue(GotITButton.isDisplayed());
    }

    public void selectPatientFromSearchList() {
        String patientName = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        searchSection.selectsPatientFromSearchList(patientName);
    }

    public void tapsOnSyncLink() {
        syncLink.click();
    }

    public void verifiesSeeAllOption() {
        recentPatientSection.verifiesSeeAllOption();
    }

    public void selectPatientFromRecentPatientList() {
        recentPatientSection.selectPatientFromRecentPatientList();
    }

    public void tapsOnSearchTextBox() {
        searchSection.tapsOnSearchTextBox();
    }

    public void isPatientPresent(String patientName) {
        recentPatientSection.isPatientPresent(patientName);
    }

    public void isPatientNotPresent(String patientName) {
        recentPatientSection.isPatientNotPresent(patientName);
    }
}
