package steps;

import com.embibe.optimus.utils.ScenarioContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.SearchPage;
import utils.CreateFaker;
import utils.ScenarioContextKeys;

public class SearchSteps extends BaseSteps {

    @Then("^(\\w+) on Search page searched for Registered Patient$")
    public void userOnSearchPageSearchedForRegisteredPatient(String User) {
        String patientName = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        System.out.println(patientName+  "patientName");
        new SearchPage(getDriverInstanceFor(User)).searchForRegisteredPatientWithBpInfo(patientName);
    }

    @And("^(\\w+) on search page searches for Patient name$")
    public void userOnSearchPageSearchesForPatientName(String User) {
        String patientName = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        new SearchPage(getDriverInstanceFor(User)).searchForPatientName(patientName);
    }

    @And("^(\\w+) on search page taps on registered patient button$")
    public void userClicksOnRegisteredPatientButton(String User) {
        new SearchPage(getDriverInstanceFor(User)).tapsOnRegisteredPatientTab();
    }

    @And("^(\\w+) on Search page selects patient form search list$")
    public void userOnSearchPageSelectsPatientFormSearchList(String User) {
        String patientName = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        new SearchPage(getDriverInstanceFor(User)).selectsPatientFromSearchList(patientName);
    }

    @And("^(\\w+) on Search page verfies patient name should not be displayed$")
    public void userOnSearchPageVerfiesPatientNameShouldNotBeDisplayed(String User) {
        String name = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        new SearchPage(getDriverInstanceFor(User)).searchForPatientName(name);
    }

    @And("^(\\w+) on search page searches for new Patient name$")
    public void userOnSearchPageSearchesForNewPatientName(String User) throws Throwable {
        String name = new CreateFaker().getRandomPatientName();
        new SearchPage(getDriverInstanceFor(User)).searchForPatientName(name);
    }

    @Then("^(\\w+) on search page searched for Registered Patient without BP info$")
    public void userOnSearchPageSearchedForRegisteredPatientWithoutBPInfo(String User) {
        String patientName = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        new SearchPage(getDriverInstanceFor(User)).searchForRegisteredPatientWithoutBPInfo(patientName);
    }

    @Then("^(\\w+) on Search page verifies alphabetical patient logs$")
    public void userOnSearchPageVerifiesAlphabeticalPatientLogs(String User) throws Throwable {
        new SearchPage(getDriverInstanceFor(User)).verifiesAlphabeticalLog();
    }

    @And("^(\\w+) on search page searched for Registered Patient by phone Number$")
    public void userOnSearchPageSearchedForRegisteredPatientByPhoneNumber(String User){
        String phoneNumber=ScenarioContext.getData("User",ScenarioContextKeys.PATIENT_PHONE_NUMBER);
        new SearchPage(getDriverInstanceFor(User)).searchForRegisteredPatientByPhoneNumber(phoneNumber);
    }

    @And("^(\\w+) on search page verifies search result for duplicate phoneNumber$")
    public void userOnSearchPageVerifiesSearchResultForDuplicatePhoneNumber(String User) {
        String phoneNumber=ScenarioContext.getData("User",ScenarioContextKeys.PATIENT_PHONE_NUMBER);
        new SearchPage(getDriverInstanceFor(User)).searchForRegisteredPatientByDuplicatePhoneNumber(phoneNumber);
    }

    @Then("^(\\w+) on Search page searches for new Patient as (.*)$")
    public void userOnSearchPageSearchesForNewPatientAsName(String User,String name) {
        new SearchPage(getDriverInstanceFor(User)).searchForPatientName(name);
    }

    @Then("^(\\w+) on Search page searches for new Patient Phonenumber as (.*)$")
    public void userOnSearchPageSearchesForNewPatientPhonenumberAsPhoneNumber(String User,String phoneNumber)  {
        new SearchPage(getDriverInstanceFor(User)).searchForPatientNumber(phoneNumber);
        ScenarioContext.putData("User",ScenarioContextKeys.PATIENT_PHONE_NUMBER,phoneNumber);
    }
}

