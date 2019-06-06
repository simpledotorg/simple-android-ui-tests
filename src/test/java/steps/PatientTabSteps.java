package steps;

import com.embibe.optimus.utils.ScenarioContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.PatientTabPage;
import utils.RandomValue;
import utils.ScenarioContextKeys;

public class PatientTabSteps extends BaseSteps {
    @Then("^(\\w+) verifies Patient tab$")
    public void userVerifiesPatientTab(String User) throws Throwable {
        new PatientTabPage(getDriverInstanceFor(User)).verifyPatientTab();
    }

    @Then("(\\w+) searches for unregistered Patient as (.*)$")
    public void userPerformSearchForUnregisteredPatient(String User,String str) {
        new PatientTabPage(getDriverInstanceFor(User)).searchForPatientName(str);
    }

    @Then("^(\\w+) searched for Registered Patient$")
    public void userSearchedForRegisteredPatient(String User) {
        String patientName = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        new PatientTabPage(getDriverInstanceFor(User)).searchForRegisteredPatient(patientName);
    }

    @Then("^(\\w+) searched for Registered Patient without BP info$")
    public void userSearchedForRegisteredPatientWithoutBPInfo(String User) {
        String patientName = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        new PatientTabPage(getDriverInstanceFor(User)).userSearchedForRegisteredPatientWithoutBPInfo(patientName);
    }

    @Then("^(\\w+) searches for Patient name$")
    public void userSearchesForUnregisteredPatientName(String User) {
        String patientName = RandomValue.getRandomPatientName();
        ScenarioContext.putData("User", ScenarioContextKeys.PATIENT_NAME, patientName);

        new PatientTabPage(getDriverInstanceFor(User)).searchForPatientName(patientName);
    }

    @And("^(\\w+) taps on registered patient$")
    public void userClicksOnRegisteredPatient(String User) {
        new PatientTabPage(getDriverInstanceFor(User)).tapsOnRegisteredPatientTab();
    }

    @Then("^(\\w+) verifies recent patients list$")
    public void userVerifiesRecentPatientsList(String User) {
        String patientName = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        new PatientTabPage(getDriverInstanceFor(User)).verifiesRecentPatientList(patientName);
    }

    @Then("^(\\w+) verifies recent patients list for patient without bp info$")
    public void userVerifiesRecentPatientsListForPatientWithoutBpInfo(String User){
        String patientName = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        new PatientTabPage(getDriverInstanceFor(User)).verifiesRecentPatientListForWithoutBpInfo(patientName);
    }

    @And("^(\\w+) verifies SEE ALL option$")
    public void userVerifiesSEEALLOption(String User){
        new PatientTabPage(getDriverInstanceFor(User)).verifiesSeeAllOption();
    }

}
