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

    @And("^(\\w+) on patient tab verifies SEE ALL option$")
    public void userVerifiesSEEALLOption(String User){
        new PatientTabPage(getDriverInstanceFor(User)).verifiesSeeAllOption();
    }

    @Then("^(\\w+) on Patient tab select patient from recent patient list$")
    public void userSelectPatientFromRecentPatientList(String User) throws Exception {
        String patientName = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        new PatientTabPage(getDriverInstanceFor(User)).selectPatientFromRecentPatientList(patientName);
    }

    @And("^(\\w+) on Patient tab taps on search text box$")
    public void userOnPatientTabTapsOnSearchTextBox(String User) {
        new PatientTabPage(getDriverInstanceFor(User)).tapsOnSearchTextBox();
    }

    @Then("^(\\w+) on Patient tab verifies patient info present in recent patients list$")
    public void userOnPatientTabVerifiesPatientInfoPresentInRecentPatientsList(String User) throws Exception {
        String patientName = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        new PatientTabPage(getDriverInstanceFor(User)).isPatientPresent(patientName);
    }

    @And("^(\\w+) on Patient tab taps on sync link$")
    public void userTapsOnSyncLink(String User) {
        new PatientTabPage(getDriverInstanceFor(User)).tapsOnSyncLink();
    }

    @Then("^(\\w+) on Patient tab verifies patient info should not be present in recent patients list$")
    public void userOnPatientTabVerifiesPatientInfoNotPresentInRecentPatientsList(String User){
        String patientName = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        new PatientTabPage(getDriverInstanceFor(User)).isPatientNotPresent(patientName);
    }

    @And("^(\\w+) on Patient tab verifies SEEALL button$")
    public void userOnPatientTabVerifiesSEEALLButton(String User) {
        new PatientTabPage(getDriverInstanceFor(User)).verifiesSeeAllOption();
    }


    @And("^(\\w+) on Patient tab any patient from recent patient list$")
    public void userOnPatientTabAnyPatientFromRecentPatientList(String User) throws Throwable {
        new PatientTabPage(getDriverInstanceFor(User)).selectAnyPatient();
    }

    @And("^(\\w+) on Patient tab verifies patient info should not show up on top of recent patient section$")
    public void userOnPatientTabVerifiesPatientInfoShouldNotShowUpOnTopOfRecentPatientSection(String User)  {
        new PatientTabPage(getDriverInstanceFor(User)).shouldNotShowUpOnTopOfList();
    }

    @And("^(\\w+) on Patient tab verifies patient info should show up on top of recent patient section$")
    public void userOnPatientTabVerifiesPatientInfoShouldShowUpOnTopOfRecentPatientSection(String User) {
        new PatientTabPage(getDriverInstanceFor(User)).shouldShowUpOnTopOfList();
    }

    @And("^(\\w+) on Patient tab verifies no recent patient text$")
    public void userOnPatientTabVerifiesNoRecentPatientText(String User)  {
        new PatientTabPage(getDriverInstanceFor(User)).verifyNoRecentPatientText();
    }
}
