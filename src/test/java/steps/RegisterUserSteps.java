package steps;

import CreateUser.UserClient;
import CreateUser.UserRequestBody;
import CreateUser.UserRequestBodyBuilder;
import CreateUser.UserResponse;
import com.embibe.optimus.utils.ScenarioContext;
import createBp.BpClient;
import createBp.BpRequestBody;
import createBp.BpRequestBuilder;
import createBp.BpResponse;
import createPatients.PatientClient;
import createPatients.PatientResponse;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.RegisterUserPage;
import utils.AdbUtils;
import utils.RandomValue;
import utils.ScenarioContextKeys;

public class RegisterUserSteps extends BaseSteps {


    @And("^(\\w+) taps on GetStarted button$")
    public void userClicksOnGetStartedButton(String User) {
        new RegisterUserPage(getDriverInstanceFor(User)).clicksOnGetStartedButton();
    }

    @And("^(\\w+) enters registration phone number$")
    public void userEntersRegistrationPhoneNumber(String User) {
        String phoneNumber = RandomValue.getRandomPhoneNumber();
        new RegisterUserPage(getDriverInstanceFor(User)).enterRegistrationPhoneNumber(phoneNumber);
    }

    @And("^(\\w+) enters registration name$")
    public void userEntersRegistrationName(String User) {
        String name = RandomValue.getRandomUserName();
        new RegisterUserPage(getDriverInstanceFor(User)).enterRegistrationName(name);
    }

    @And("^(\\w+) enters security pin number$")
    public void userEnterSecurityPinNumber(String User) {
        int pin = RandomValue.getRandomPinValue();
         ScenarioContext.putData("User",ScenarioContextKeys.PIN,pin);
        new RegisterUserPage(getDriverInstanceFor(User)).enterPin(Integer.toString(pin));
    }

    @And("^(\\w+) search for facility$")
    public void userSearchForFacility(String User) {
        String facility="CHC Bagta";
        new RegisterUserPage(getDriverInstanceFor(User)).searchFacility(facility);
    }

    @And("^(\\w+) enters registered phone number$")
    public void userEntersRegisteredPhoneNumber(String User) {
        String phoneNumber = ScenarioContext.getData("User", ScenarioContextKeys.USER_PHONENUMBER);
        new RegisterUserPage(getDriverInstanceFor(User)).enterRegistrationPhoneNumber(phoneNumber);
    }

    @And("^(\\w+) enters registered security pin$")
    public void userEntersRegisteredSecurityPin(String User) {
        new RegisterUserPage(getDriverInstanceFor(User)).enterPinForRegisteredUser("1234");
    }

    @And("^(\\w+) relaunch app$")
    public void userRelaunchApp(String user) {
        new AdbUtils().relaunchApp();
    }

    @And("^(\\w+) taps on Enter code link$")
    public void userTapsOnEnterCodeLink(String User) {
        new RegisterUserPage(getDriverInstanceFor(User)).clickOnEnterCodeLink();
    }

    @And("^(\\w+) enters otp$")
    public void userEntersOtp(String User) throws Throwable {
        new RegisterUserPage(getDriverInstanceFor(User)).enterOtp();
    }

    @And("^(\\w+) taps on Got It Button$")
    public void userTapsOnGotItButton(String User) {
        new RegisterUserPage((getDriverInstanceFor(User))).clicksOnGotItButton();
    }

    @Given("^(\\w+) Registers New User through API$")
    public void userRegistersNewUser(String User) {
        UserRequestBody userRequestBody = new UserRequestBodyBuilder().build();
        UserResponse userResponse = new UserClient().registerNewUser(userRequestBody);

        ScenarioContext.putData("User", ScenarioContextKeys.USER_ID, userResponse.getUser().getId());
        ScenarioContext.putData("User", ScenarioContextKeys.USER_PHONENUMBER, userResponse.getUser().getPhone_number());
        ScenarioContext.putData("User", ScenarioContextKeys.ACCESS_TOKEN, userResponse.getAccess_token());
    }

    @And("^(\\w+) Registers New Patient through API$")
    public void userRegistersNewPatientThroughAPI(String User) {
        String userId = ScenarioContext.getData("User", ScenarioContextKeys.USER_ID);
        String facilityId = "2f086ff7-83dc-4758-bd31-9d9109df9a09";

        String patientId = RandomValue.getRandomPatientId();
        ScenarioContext.putData("User", ScenarioContextKeys.PATIENT_ID, patientId);
        String patientName = RandomValue.getRandomPatientName();
        ScenarioContext.putData("User", ScenarioContextKeys.PATIENT_NAME, patientName);

        String token = ScenarioContext.getData("User", ScenarioContextKeys.ACCESS_TOKEN);
        PatientResponse response = new PatientClient().createPatient(patientId, patientName, facilityId, userId, token);
    }

    @And("^(\\w+) Registers New Bp record through API$")
    public void userRegistersNewBpRecordThroughAPI(String User) {

        String bpId = RandomValue.getRandomBpId();
        String patientId = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_ID);
        String facilityId = "2f086ff7-83dc-4758-bd31-9d9109df9a09";
        String userId = ScenarioContext.getData("User", ScenarioContextKeys.USER_ID);
        String token = ScenarioContext.getData("User", ScenarioContextKeys.ACCESS_TOKEN);

        BpRequestBody builder = new BpRequestBuilder()
                                .withUserId(userId)
                                .withBpId(bpId)
                                .withPatientId(patientId)
                                .withFacilityId(facilityId).build();
        BpResponse response = new BpClient().createNewBp(builder, facilityId, userId, token);

    }

    @And("^(\\w+) enters invalid registration phone number as (.*)$")
    public void userEntersInvalidRegistrationPhoneNumber(String User,String phone) {
        new RegisterUserPage(getDriverInstanceFor(User)).enterInvalidPhoneNumber(phone);
    }


    @And("^(\\w+) enters invalid security pin as (.*)$")
    public void userEntersInvalidSecurityPin(String User,String pin) {
        new RegisterUserPage(getDriverInstanceFor(User)).enterInvalidPin( pin);
    }

    @And("^(\\w+) taps on reset pin$")
    public void userTapsOnResetPin(String User){
        new RegisterUserPage(getDriverInstanceFor(User)).tapsOnResetPin();
    }

    @Then("^(\\w+) search for invalid facility$")
    public void userSearchForInvalidFacility(String User) {
        String facility="invalid facility";
        new RegisterUserPage(getDriverInstanceFor(User)).searchFacility(facility);

    }

    @And("^(\\w+) verifies error message$")
    public void userVerifiesErrorMessage(String User){
        new RegisterUserPage(getDriverInstanceFor(User)).verifyErorMessageForInvalidFacilitySearch();
    }

    @And("^(\\w+) enters confirm pin number$")
    public void userEntersConfirmPinNumber(String User){
        String pin=ScenarioContext.getData("User",ScenarioContextKeys.PIN);
        new RegisterUserPage(getDriverInstanceFor(User)).reEnterPin(pin);
    }
}
