package pages;

import com.embibe.optimus.utils.ScenarioContext;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.testng.Assert;
import qaApiServices.appointments.CreateAppointment;
import qaApiServices.bloodPressure.CreateBp;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;
import qaApiServices.patients.CreatePatients;
import qaApiServices.patients.GetPatientInfo;
import qaApiServices.patients.PatientClient;
import qaApiServices.patients.response.PatientGetRequestResponse;
import qaApiServices.user.RegisterUser;
import utils.ScenarioContextKeys;

public class QaApiCallsPage extends BasePage {
    private AppiumDriver driver;

    public QaApiCallsPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }

    public void registerNewPatient() {
        new CreatePatients().createPatient();
    }

    public void registerNewPatientWithoutPhoneNumber() {
        new CreatePatients().createPatientWithoutPhoneNumber();
        new CreateBp().registerNewBp();
        new CreateAppointment().createAppointment();
    }

    public void registerNewUser() {
        new RegisterUser().registerNewUser();
    }

    public void registerNewPatientWithBp() {
        new CreatePatients().createPatient();
        new CreateBp().registerNewBp();
        new CreateAppointment().createAppointment();
    }

    public void registerNewPatientWithoutBp() {
        new CreatePatients().createPatient();
    }

    public void registerNewPatientWithListOfBps(int patientCount, int bpcount) {
        createPatientWithListOfBP(1, 2);
        ScenarioContext.putData("User", ScenarioContextKeys.BPCOUNT, String.valueOf(bpcount));
    }

    private void createPatientWithListOfBP(int patientcount, int bpcount) {
        while (patientcount > 0) {
            new CreatePatients().createPatient();
            new CreateBp().createBpList(bpcount);
            patientcount--;
        }
    }

    public void registerMultiplePatientWithDuplicatePhoneNumber(int patientcount, String phoneNumber) {
        while (patientcount > 0) {
            new CreatePatients().createPatient(phoneNumber);
            patientcount--;
        }
    }

    public void registerNewPatientWithoutPhoneNumberAndBP() {
        new CreatePatients().createPatientWithoutPhoneNumber();
    }

    public void registerNewPatientWithBpPassportFromApi() {
        new CreatePatients().createPatientWithBpPassport();
        new CreateBp().registerNewBp();
        new CreateAppointment().createAppointment();


        String bpPassportUuid = ScenarioContext.getData("User", ScenarioContextKeys.BPPASSPORTUUID);
        String allDigitsInString = getAllDigitsInString(bpPassportUuid);

        // this is to fetch 7 digit short code from bp passport uuid
        String varStr = allDigitsInString.substring(0, 7);
        // setting a global var bpshortcode
        ScenarioContext.putData("User", ScenarioContextKeys.BPSHORTCODE, varStr);

    }

    public void verifyReminderConsentAttribute(String value) {
        new RegisterUser().registerNewUser();
        String patientName = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        String actualString = new GetPatientInfo().getReminderConcentValueForPatient(patientName);

        if (value.equals("enabled")) {
            Assert.assertEquals(actualString, "granted");
        } else {
            Assert.assertEquals(actualString, "denied");
        }
    }

    public void registerMultiplePatients(int count) {
        while (count > 0) {
            new CreatePatients().createPatient();
            new CreateBp().registerNewBp();
            new CreateAppointment().createAppointment();
            count--;
        }
    }

    public void isPatientInfoSyncToServer() {
        new RegisterUser().registerNewUser();

        String facilityId = ScenarioContext.getData("User", ScenarioContextKeys.FACILTIYID);
        String userId = ScenarioContext.getData("User", ScenarioContextKeys.USER_ID);
        String token = ScenarioContext.getData("User", ScenarioContextKeys.ACCESS_TOKEN);

        PatientGetRequestResponse patientGetRequestResponse = new PatientClient().get(facilityId, userId, token);

        String patientName=ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);

        boolean result = patientGetRequestResponse.isPatientNamePresentInResponse(patientName);
        Assert.assertEquals(result,true);

    }
}
