package steps;

import CreateUser.UserClient;
import CreateUser.UserRequestBody;
import CreateUser.UserRequestBodyBuilder;
import CreateUser.UserResponse;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pages.RegisterUserPage;
import utils.AdbUtils;
import utils.RandomValue;

public class RegisterUserSteps extends BaseSteps {

    UserResponse userResponse;

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
        int pin=RandomValue.getRandomPinValue();
        new RegisterUserPage(getDriverInstanceFor(User)).enterPin(Integer.toString(pin));
    }

    @And("^(\\w+) search for facility$")
    public void userSearchForFacility(String User) {
        new RegisterUserPage(getDriverInstanceFor(User)).searchFacility();
    }

    @And("^(\\w+) enters registered phone number$")
    public void userEntersRegisteredPhoneNumber(String User) {
        String phoneNumber = userResponse.getUser().getPhone_number();
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
        userResponse = new UserClient().registerNewUser(userRequestBody);
    }
}
