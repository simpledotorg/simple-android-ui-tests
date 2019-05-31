package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PatientTabPage extends BasePage {
    private AppiumDriver driver;
    private SearchSection searchSection;

    @FindBy(id = "patients_scan_simple_card")
    private WebElement scanBPPassportButton;

    @FindBy(id = "patients_user_awaitingapproval_title")
    private WebElement approvalMessage;

    @FindBy(id="patients_dismiss_user_approved_status")
    private WebElement GotITButton;


    public PatientTabPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        searchSection= new SearchSection(driver);
    }

    public void verifyPatientTab() {
        Assert.assertEquals(scanBPPassportButton.getText(), "Scan BP Passport");
        Assert.assertTrue(GotITButton.isDisplayed());
    }

    public void searchForUnRegisteredPatient() {
        searchSection.searchForUnRegisteredPatient();
    }

    public void searchForRegisteredPatient(String patientName) {
        searchSection.searchForRegisteredPatientWithBpInfo(patientName);
    }

    public void userSearchedForRegisteredPatientWithoutBPInfo(String patientName) {
        searchSection.searchForRegisteredPatientWithoutBPInfo(patientName);
    }
}
