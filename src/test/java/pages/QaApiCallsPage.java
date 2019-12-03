package pages;

import com.embibe.optimus.utils.ScenarioContext;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import qaApiServices.appointments.CreateAppointment;
import qaApiServices.bloodPressure.CreateBp;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;
import qaApiServices.patients.CreatePatients;
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
        ScenarioContext.putData("User",ScenarioContextKeys.BPCOUNT,bpcount);
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


        String bpPassportUuid= ScenarioContext.getData("User",ScenarioContextKeys.BPPASSPORTUUID);
        String allDigitsInString = getAllDigitsInString(bpPassportUuid);

        // this is to fetch 7 digit short code from bp passport uuid
        String varStr = allDigitsInString.substring(0, 7);
        // setting a global var bpshortcode
        ScenarioContext.putData("User",ScenarioContextKeys.BPSHORTCODE,varStr);

    }
}
