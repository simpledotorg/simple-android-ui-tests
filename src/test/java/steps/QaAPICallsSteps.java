package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pages.QaApiCallsPage;
import qaApiServices.appointments.CreateAppointment;
import utils.RandomValue;

public class QaAPICallsSteps extends BaseSteps {
    @Given("^(\\w+) registers new user from api$")
    public void userRegistersNewUser(String User) {
        new QaApiCallsPage(getDriverInstanceFor(User)).registerNewUser();
    }

    @And("^(\\w+) registers new patient without phonenumber from api$")
    public void userRegistersNewPatientWithoutPhonenumberThroughAPI(String User) {
        new QaApiCallsPage(getDriverInstanceFor(User)).registerNewPatientWithoutPhoneNumber();
    }

    @Given("^(\\w+) registers new patient with bp from api$")
    public void userRegisterNewPatientWithBp(String User) {
        new QaApiCallsPage(getDriverInstanceFor(User)).registerNewPatientWithBp();
    }

    @And("^(\\w+) registers new patient without bp from api$")
    public void userRegisterNewPatientWithoutBpFromApi(String User) {
        new QaApiCallsPage(getDriverInstanceFor(User)).registerNewPatientWithoutBp();
    }

    @And("^(\\w+) register new patient with list of bp through api$")
    public void userRegisterNewPatientWithMlistOfBpThroughApi(String User) {
        new QaApiCallsPage(getDriverInstanceFor(User)).registerNewPatientWithListOfBps(1, 2);
    }

    @And("^(\\w+) registers multiple patient with same phoneNumber from api$")
    public void userRegistersMultiplePatientWithSamePhoneNumberFromApi(String User) {
        String phoneNumber = RandomValue.getRandomPhoneNumber();
        new QaApiCallsPage(getDriverInstanceFor(User)).registerMultiplePatientWithDuplicatePhoneNumber(2, phoneNumber);
    }

    @And("^(\\w+) registers a patient with multiple Bps$")
    public void userRegistersAPatientWithMultipleBpS(String User) {
        new QaApiCallsPage(getDriverInstanceFor(User)).registerNewPatientWithListOfBps(1, 2);
    }

    @And("^(\\w+) registers new patient without phonenumber and bp from api$")
    public void userRegistersNewPatientWithoutPhonenumberAndBpFromApi(String User) {
        new QaApiCallsPage(getDriverInstanceFor(User)).registerNewPatientWithoutPhoneNumberAndBP();
    }

    @And("^(\\w+) get all patient info$")
    public void userGetAllPatientInfo(String User) {
        int allScheduledAppointment = new CreateAppointment().getAllScheduledAppointment();
    }

    @And("^(\\w+) registers new patient with bp passport from api$")
    public void userRegistersNewPatientWithBpPassportFromApi(String User) {
        new QaApiCallsPage(getDriverInstanceFor(User)).registerNewPatientWithBpPassportFromApi();
    }
}
