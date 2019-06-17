package steps;

import user.UserClient;
import user.UserRequestBody;
import user.UserResponse;
import com.embibe.optimus.utils.ScenarioContext;
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
        new RegisterUserPage(getDriverInstanceFor(User)).registerNewUser();
    }

    @And("^(\\w+) Registers New Patient through API$")
    public void userRegistersNewPatientThroughAPI(String User) {
        String facilityId = "2f086ff7-83dc-4758-bd31-9d9109df9a09";
        String number=RandomValue.getRandomPhoneNumber();
        new RegisterUserPage(getDriverInstanceFor(User)).createNewPatient(facilityId,"mobile",number);
    }

    @And("^(\\w+) Registers New Bp record through API$")
    public void userRegistersNewBpRecordThroughAPI(String User) {
        String facilityId = "2f086ff7-83dc-4758-bd31-9d9109df9a09";
        new RegisterUserPage(getDriverInstanceFor(User)).createNewBP(facilityId);
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
        String facility="invalid getFacility";
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

    @And("^(\\w+) Registers list of new Bp record through API$")
    public void userRegistersListOfNewBpRecordThroughAPI(String User){
        String facilityId = "2f086ff7-83dc-4758-bd31-9d9109df9a09";
        new RegisterUserPage(getDriverInstanceFor(User)).createListOfBpForOnePatient(facilityId);
    }

    @And("^(\\w+) Registers New Patient without phonenumber through API$")
    public void userRegistersNewPatientWithoutPhonenumberThroughAPI(String User) {
        String facilityId = "2f086ff7-83dc-4758-bd31-9d9109df9a09";
        new RegisterUserPage(getDriverInstanceFor(User)).createNewPatientWithoutPhoneNumber(facilityId,"mobile");
    }
}
