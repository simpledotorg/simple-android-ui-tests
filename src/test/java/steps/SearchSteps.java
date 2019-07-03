package steps;

import com.embibe.optimus.utils.ScenarioContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.PatientTabPage;
import pages.SearchPage;
import utils.RandomValue;
import utils.ScenarioContextKeys;

public class SearchSteps extends BaseSteps {
    @Then("^(\\w+) on Search page searches for unregistered Patient as (.*)$")
    public void userOnSearchPageSearchesForUnregisteredPatientAsInvalid(String User, String name) {
        new SearchPage(getDriverInstanceFor(User)).searchForPatientName(name);
    }

    @Then("^(\\w+) on Search page searched for Registered Patient without BP info$")
    public void userOnSearchPageSearchedForRegisteredPatientWithoutBPInfo(String User)  {
        String patientName = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        new SearchPage(getDriverInstanceFor(User)).searchForRegisteredPatientWithoutBPInfo(patientName);
    }

    @Then("^(\\w+) on Search page searched for Registered Patient$")
    public void userOnSearchPageSearchedForRegisteredPatient(String User)  {
        String patientName = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        new SearchPage(getDriverInstanceFor(User)).searchForRegisteredPatientWithBpInfo(patientName);
    }

    @And("^(\\w+) on search page searches for Patient name$")
    public void userOnSearchPageSearchesForPatientName(String User) {
        String patientName = RandomValue.getRandomPatientName();
        new SearchPage(getDriverInstanceFor(User)).searchForPatientName(patientName);
    }

    @And("^(\\w+) on search page taps on registered patient button$")
    public void userClicksOnRegisteredPatientButton(String User) {
        new SearchPage(getDriverInstanceFor(User)).tapsOnRegisteredPatientTab();
    }

    @And("^(\\w+) on Search page selects patient form search list$")
    public void userOnSearchPageSelectsPatientFormSearchList(String User)  {
        String patientName=ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        new SearchPage(getDriverInstanceFor(User)).selectsPatientFromSearchList(patientName);
    }

    @Then("^(\\w+) on Search page searched for Registered Patient with BP info$")
    public void userOnSearchPageSearchedForRegisteredPatientWithBPInfo(String User)  {
        String patientName=ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        new SearchPage(getDriverInstanceFor(User)).searchForRegisteredPatientWithBpInfo(patientName);
    }

    @And("^(\\w+) on Search page verfies patient name should not be displayed$")
    public void userOnSearchPageVerfiesPatientNameShouldNotBeDisplayed(String User) {
        String name=ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        new SearchPage(getDriverInstanceFor(User)).searchForPatientName(name);
    }
}

