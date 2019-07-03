package pages;

import com.embibe.optimus.utils.ScenarioContext;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import patients.CreatePatients;
import patients.PatientGetRequestResponse;
import user.RegisterUser;
import utils.ScenarioContextKeys;

import java.util.List;

public class RecentPatientPage extends BasePage {

    AppiumDriver driver;

    public RecentPatientPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "recentpatient_item_title")
    private List<WebElement> recentPatientViewLst;

    @FindBy(id = "seeall_button")
    private WebElement seeAllButton;

    @FindBy(id = "recentpatients_no_recent_patients")
    private WebElement noRecentPatientText;

    public void isPatientPresent(String patientName) throws Exception {
        new RegisterUser().registerNewUser();
        getPatient(patientName);
    }

    public void isPatientNotPresent(String patientName) {
        new RegisterUser().registerNewUser();
        String expectedValue = patientName.replaceAll("\\s", "").toUpperCase();

        PatientGetRequestResponse allPatient = new CreatePatients().getAllPatient();
        int size = allPatient.getPatients().size();
        int count = 0;
        String status = "true";

        while (count <= size) {

            for (WebElement ele : recentPatientViewLst) {
                count++;
                String text = ele.getText().split(",")[0].replaceAll("\\s", "").toUpperCase();
                if (text.equals(expectedValue)) {
                    status = "false";
                }
            }
            scrollDown();
        }

        Assert.assertTrue(status.equals("true"), "Patient name should not be present in recent patient list" + patientName);
    }

    public void verifiesSeeAllOption() {
        PatientGetRequestResponse allPatient = new CreatePatients().getAllPatient();
        int size = allPatient.getPatients().size();

        String status = "false";
        if (size > 10) {
            int count = 0;
            while (count <= 3) {
                try {
                    seeAllButton.isDisplayed();
                    status = "true";
                } catch (Exception e) {
                    scrollDown();
                }
                count++;
            }
            Assert.assertTrue(status.equals("true"), "SEE ALL BUTTON should be present");
        }
    }

    public void selectPatientFromRecentPatientList(String patientName) throws Exception {
        WebElement patient = getPatient(patientName);
        patient.click();
    }


    public WebElement getPatient(String patientName) throws Exception {

        String expectedValue = patientName.replaceAll("\\s", "").toUpperCase();

        PatientGetRequestResponse allPatient = new CreatePatients().getAllPatient();
        int size = allPatient.getPatients().size();
        int count = 0;

        while (count <= size) {

            for (WebElement ele : recentPatientViewLst) {
                count++;
                String text = ele.getText().split(",")[0].replaceAll("\\s", "").toUpperCase();
                if (text.equals(expectedValue)) {
                    return ele;
                }
            }
            scrollDown();
        }
        String message = String.format("Patient name is not present in recent patient list", patientName);
        throw new Exception(message);
    }

    public void selectAnyPatientFromRecentPatientSection() {
        scrollDown();
        int size = recentPatientViewLst.size();
        System.out.println(size + "size");
        recentPatientViewLst.get(size - 1).click();

        PatientSummaryDetailPage patientSummaryDetailPage = new PatientSummaryDetailPage(driver);
        String selectedPatient = patientSummaryDetailPage.getFullName();

        ScenarioContext.putData("User", ScenarioContextKeys.PATIENT_NAME, selectedPatient);

    }

    public void shouldNotShowUpOnTopOfList() {
        String actualValue = recentPatientViewLst.get(0).getText();
        String expected = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        Assert.assertNotEquals(actualValue, expected, expected + "should not be displayed on top of recent patient section");
    }

    public void shouldShowUpOnTopOfRecentPatinetList() {
        String actualValue = recentPatientViewLst.get(0).getText().split(",")[0].replaceAll("\\s", "").toUpperCase();
        String expected = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        expected = expected.split(",")[0].replaceAll("\\s", "").toUpperCase();

        System.out.println("actual" + actualValue);
        System.out.println("expected" + expected);

        Assert.assertTrue(actualValue.equals(expected), expected + "should be displayed on top of recent patient list");
    }

    public void verifyNoRecentPatientText() {
        Assert.assertTrue(noRecentPatientText.getText().equals("No recent patients"),"No recent patient message should be displayed");
    }
}
