package pages.patientsTab;

import com.embibe.optimus.utils.ScenarioContext;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.BasePage;
import pages.patientPrimaryInformation.PatientSummaryDetailPage;
import qaApiServices.patients.GetPatientInfo;
import qaApiServices.patients.response.PatientGetRequestResponse;
import qaApiServices.user.RegisterUser;
import utils.ScenarioContextKeys;

import java.util.List;

public class RecentPatientSection extends BasePage {

    AppiumDriver driver;

    public RecentPatientSection(AppiumDriver driver) {
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

    //    public void verifiesSeeAllOption() {
//        new RegisterUser().registerNewUser();
//        PatientGetRequestResponse allPatient = new GetPatientInfo().getAllPatient();
//        int size = allPatient.getPatients().size();
//        String status = "false";
//        if (size > 10) {
//            int count = 0;
//            while (count <= 3) {
//                try {
//                    seeAllButton.isDisplayed();
//                    status = "true";
//                } catch (Exception e) {
//                    scrollDown();
//                }
//                count++;
//            }
//            Assert.assertTrue(status.equals("true"), "SEE ALL BUTTON should be present");
//        } else {
//            Assert.assertEquals(status,"false", "SEE ALL BUTTON should not be present");
//        }
//    }
    public void verifiesSeeAllOption(int patinetCount) {
        String status = "false";
        if (patinetCount > 10) {
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
            seeAllButton.click();
        } else {
            Assert.assertEquals(status, "false", "SEE ALL BUTTON should not be present");
        }

    }

    public void selectPatientFromRecentPatientList(String patientName) throws Exception {
        WebElement patient = getPatient(patientName);
        patient.click();
    }


    public WebElement getPatient(String patientName) throws Exception {

        new RegisterUser().registerNewUser();
        String expectedValue = patientName.replaceAll("\\s", "").toUpperCase();

        PatientGetRequestResponse allPatient = new GetPatientInfo().getAllPatient();
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
        waitFor(1000);

        if (recentPatientViewLst.size() == 0) {
            Assert.fail("api fail - not able to generate multiple patient");
        } else {
//            scrollDown();
            String name = recentPatientViewLst.get(recentPatientViewLst.size() - 1).getText();
            ScenarioContext.putData("User", ScenarioContextKeys.PATIENT_NAME, name);
            recentPatientViewLst.get(recentPatientViewLst.size() - 1).click();
        }
    }

    public void shouldNotShowUpOnTopOfList() {
        String actualValue = recentPatientViewLst.get(0).getText();
        String expected = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        Assert.assertNotEquals(actualValue, expected, expected + "should not be displayed on top of recent patient section");
    }

    public void shouldShowUpOnTopOfRecentPatinetList() {
        String actualValue = recentPatientViewLst.get(0).getText();
        String expected = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        Assert.assertTrue(actualValue.contains(expected), expected + "should be displayed on top of recent patient list");
    }

    public void verifyNoRecentPatientText() {
        Assert.assertEquals(noRecentPatientText.getText(), "No recent patients", "No recent patient message should be displayed");
    }
}
