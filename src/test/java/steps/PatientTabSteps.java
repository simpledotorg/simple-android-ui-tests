package steps;

import com.embibe.optimus.utils.ScenarioContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.patientsTab.PatientTabPage;
import utils.ScenarioContextKeys;

public class PatientTabSteps extends BaseSteps {
    @Then("^(\\w+) verifies Patient tab$")
    public void userVerifiesPatientTab(String User) throws Throwable {
        new PatientTabPage(getDriverInstanceFor(User)).verifyPatientTab();
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

//    @Then("^(\\w+) on Patient tab verifies patient info present in recent patients list$")
//    public void userOnPatientTabVerifiesPatientInfoPresentInRecentPatientsList(String User) throws Exception {
//        String patientName = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
//        new PatientTabPage(getDriverInstanceFor(User)).isPatientPresent(patientName);
//    }

    @And("^(\\w+) on Patient tab taps on sync link$")
    public void userTapsOnSyncLink(String User)  {
        new PatientTabPage(getDriverInstanceFor(User)).tapsOnSyncLink();
    }

    @And("^(\\w+) on Patient tab verifies SEEALL button for patient (.*)$")
    public void userOnPatientTabVerifiesSEEALLButton(String User,int patinetCount) {
        new PatientTabPage(getDriverInstanceFor(User)).verifiesSeeAllOption(patinetCount);
    }

    @And("^(\\w+) on Patient tab select any patient from recent patient list$")
    public void userOnPatientTabSelectAnyPatientFromRecentPatientList(String User) throws Throwable {
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


    @Then("^(\\w+) on patient tab verifies sync link should not be present$")
    public void userOnPatientTabVerifiesSyncLinkShouldNotBePresent(String User){
        new PatientTabPage(getDriverInstanceFor(User)).syncLinkShouldNotBePresent();
    }

    @Then("^(\\w+) on patient tab verifies sync error message$")
    public void userOnPatientTabVerifiesSyncErrorMessage(String User) {
        new PatientTabPage(getDriverInstanceFor(User)).verifiesSyncErrorMessage();
    }

    @And("^(\\w+) on Patient tab taps on okay button$")
    public void userOnPatientTabTapsOnOpkayButton(String User) {
        new PatientTabPage(getDriverInstanceFor(User)).tapsOnOkayButton();
    }

    @Then("^(\\w+) on patient tab verifies sync pending status should be present$")
    public void userOnPatientTabVerifiesSyncPendingLinkShouldBePresent(String User) {
        new PatientTabPage(getDriverInstanceFor(User)).verifySyncPendingLinkShouldBePresent();
    }

    @Then("^(\\w+) on Patient tab verify patient data got synced in server$")
    public void userOnPatientTabVerifyPatientDataGotSyncedInServer(String User) {
        new PatientTabPage(getDriverInstanceFor(User)).verifyPatientInfoIsSyncedInServer();
    }

    @Then("^(\\w+) on Patient tab verify patient data should not get synced in server$")
    public void userOnPatientTabVerifyPatientDataShouldNotGetSyncedInServer(String User) {
        new PatientTabPage(getDriverInstanceFor(User)).verifyPatientInfoshouldNotSyncedInServer();
    }

    @And("^(\\w+) on Patient tab taps on Scan Bp passport$")
    public void userOnPatientTabTapsOnScanBpPassport(String User) {
        new PatientTabPage(getDriverInstanceFor(User)).tapsOnScanBpPassport();
    }

    @And("^(\\w+) on patient tab taps on got it link$")
    public void userOnPatientTabTapsOnGotItLink(String User) {
        new PatientTabPage(getDriverInstanceFor(User)).tapsOnGotItLink();
    }
}
