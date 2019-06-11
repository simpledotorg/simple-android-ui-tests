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
    private SearchSection searchSection;

    @FindBy(id = "patients_scan_simple_card")
    private WebElement scanBPPassportButton;

    @FindBy(id = "patients_user_awaitingapproval_title")
    private WebElement approvalMessage;

    @FindBy(id = "patients_dismiss_user_approved_status")
    private WebElement GotITButton;

    @FindBys({@FindBy(id = "recentpatient_item_title")})
    private List<WebElement> recentPatientNameList;

    @FindBy(id = "seeall_button")
    private WebElement seeAllButton;

    public PatientTabPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        searchSection = new SearchSection(driver);
    }

    public void verifyPatientTab() {
        Assert.assertEquals(scanBPPassportButton.getText(), "Scan BP Passport");
        Assert.assertTrue(GotITButton.isDisplayed());
    }

    public void searchForUnRegisteredPatient(String patientName) {
        searchSection.searchForPatientName(patientName);
    }

    public void searchForRegisteredPatient(String patientName) {
        searchSection.searchForRegisteredPatientWithBpInfo(patientName.toUpperCase());
    }

    public void userSearchedForRegisteredPatientWithoutBPInfo(String patientName) {
        searchSection.searchForRegisteredPatientWithoutBPInfo(patientName);
    }

    public void searchForPatientName(String patientName) {
        searchSection.searchForPatientName(patientName);
    }

    public void tapsOnRegisteredPatientTab() {
        searchSection.tapsOnRegisteredPatientTab();
    }

    public void verifiesRecentPatientList(String patientName) {

        waitForElementToBeVisible(recentPatientNameList.get(0));
        String status = "false";

        String actualValue = patientName.replaceAll("\\s", "");


        for (WebElement ele : recentPatientNameList) {

            String[] str = ele.getText().split(",");

            String expectedValue = str[0].replaceAll("\\s", "");

            if (expectedValue.contains(actualValue)) {
                status = "true";
            }
        }
        Assert.assertEquals(status, "true", "patient Name is  not present in recent patient list");
    }


    public void verifiesRecentPatientListForWithoutBpInfo(String patientName) {

        String status = "true";

        String actualValue = patientName.replaceAll("\\s", "");

        for (WebElement ele : recentPatientNameList) {

            String[] str = ele.getText().split(",");

            String expectedValue = str[0].replaceAll("\\s", "");

            if (expectedValue.contains(actualValue)) {
                status = "false";
            }
        }
        Assert.assertEquals(status, "true", "patient without bp info is present in recent patient list");
    }

    public void verifiesSeeAllOption() {

//        scroll and record size for recent patient list
        System.out.println(recentPatientNameList.size()+"size");
        if (recentPatientNameList.size() >= 10) {
            Assert.assertTrue(seeAllButton.isDisplayed());
        } else {
            Assert.assertEquals(seeAllButton.isDisplayed(), false);
        }
    }

    public void selectPatientFromSearchList() {
        String patientName = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        searchSection.selectPatientFromSearchList(patientName);
    }

}
