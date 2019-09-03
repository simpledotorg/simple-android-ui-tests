package steps;

import com.embibe.optimus.utils.ScenarioContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.LoginPage;
import utils.CreateFaker;
import utils.RandomValue;
import utils.ScenarioContextKeys;

public class LoginStep extends BaseSteps{
    @And("^(\\w+) LogsIn in app$")
    public void userLogsInInApp(String User)  {
        String phoneNumber = ScenarioContext.getData("User", ScenarioContextKeys.USER_PHONENUMBER);
        String pin="1234";
        new LoginPage((getDriverInstanceFor(User))).userLogsIn(phoneNumber,pin);
    }

    @And("^New (\\w+) registers on app$")
    public void newUserRegistersOnApp(String User)  {
        String phoneNumber = RandomValue.getRandomPhoneNumber();
        String name = new CreateFaker().faker.name().firstName().toUpperCase();
        int pin = new CreateFaker().faker.random().nextInt(1111, 10000);
        new LoginPage((getDriverInstanceFor(User))).newUserRegisteration(phoneNumber,name,Integer.toString(pin));
    }

    @And("^(\\w+) taps on GetStarted button$")
    public void userClicksOnGetStartedButton(String User) {
        new LoginPage(getDriverInstanceFor(User)).clicksOnGetStartedButton();
    }

    @And("^(\\w+) enters registration phone number$")
    public void userEntersRegistrationPhoneNumber(String User) {
        String phoneNumber = RandomValue.getRandomPhoneNumber();
        new LoginPage(getDriverInstanceFor(User)).enterRegistrationPhoneNumber(phoneNumber);
    }

    @And("^(\\w+) enters registration name$")
    public void userEntersRegistrationName(String User) {
        String name = new CreateFaker().faker.name().firstName();
        new LoginPage(getDriverInstanceFor(User)).enterRegistrationName(name.toUpperCase());
    }

    @And("^(\\w+) enters security pin number$")
    public void userEnterSecurityPinNumber(String User) {
        int pin = new CreateFaker().faker.random().nextInt(1111, 10000);
        ScenarioContext.putData("User", ScenarioContextKeys.PIN, pin);
        new LoginPage(getDriverInstanceFor(User)).enterNewRegistrationPin(Integer.toString(pin));
    }

    @And("^(\\w+) search for facility as (.*)$")
    public void userSearchForFacilityAsFacilityName(String User,String name) throws Throwable {
        new LoginPage(getDriverInstanceFor(User)).searchFacility(name);
    }

    @And("^(\\w+) enters invalid security pin as (.*)$")
    public void userEntersInvalidSecurityPinAs(String User,String pin)  {
        new LoginPage(getDriverInstanceFor(User)).enterInvalidPin(pin);
    }

    @And("^(\\w+) taps on reset pin$")
    public void userTapsOnResetPin(String User) {
        new LoginPage(getDriverInstanceFor(User)).tapsOnResetPin();
    }

    @Then("^(\\w+) search for invalid facility$")
    public void userSearchForInvalidFacility(String User) {
        new LoginPage(getDriverInstanceFor(User)).searchInvalidFacility("Invalid");
    }

    @And("^(\\w+) enters invalid registration phone number as (.*)$")
    public void userEntersInvalidRegistrationPhoneNumberAsPhoneNumber(String User,String phoneNumber) {
        new LoginPage(getDriverInstanceFor(User)).enterInvalidPhoneNumber(phoneNumber);
    }

    @And("^(\\w+) enters registered security pin$")
    public void userEntersRegisteredSecurityPin(String User) {
        new LoginPage(getDriverInstanceFor(User)).enterNewRegistrationPin("1234");
    }
}
