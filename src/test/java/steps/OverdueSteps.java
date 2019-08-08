package steps;

import com.embibe.optimus.utils.ScenarioContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.OverdueTabPage;
import utils.ScenarioContextKeys;

public class OverdueSteps extends BaseSteps {
    @And("^(\\w+) registers overdue patient$")
    public void userRegistersOverduePatient(String User) {
        new OverdueTabPage(getDriverInstanceFor(User)).createOverduePatient();
    }

    @And("^(\\w+) on Overdue tab taps on patient detail$")
    public void userTapsOnPatientDetail(String User) {
        String patientName = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        new OverdueTabPage(getDriverInstanceFor(User)).tapsOnPatientName(patientName);
    }

    @Then("^(\\w+) on Overdue tab verifies expanded view of patient information$")
    public void userVerifiesExpandedViewOfOverduePatinetInformation(String User) {
        new OverdueTabPage(getDriverInstanceFor(User)).verifiesPatientDetailExpeandedView();
    }

    @And("^(\\w+) on Overdue tab taps on agreed to visit reason$")
    public void userTapsOnAgreedToVisitReason(String User) {
        new OverdueTabPage(getDriverInstanceFor(User)).tapsOnAgreeToVisit();
    }

    @Then("^(\\w+) on Overdue Tab verifies patient info present in overdue list$")
    public void userVerifiesPatientInfoPresentInOverdueList(String User) {
        String patientName = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        new OverdueTabPage(getDriverInstanceFor(User)).isPatientPresent(patientName);
    }

    @Then("^(\\w+) on Overdue tab verifies patient info removed from overdue list$")
    public void userVerifiesPatientInfoIsRemovedFromOverdueList(String User) {
        String patientName = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        new OverdueTabPage(getDriverInstanceFor(User)).isPatientNotPresent(patientName);

    }

    @And("^(\\w+) on Overdue tab taps on remind to call later$")
    public void userTapsOnRemindToCallLater(String User) {
        new OverdueTabPage(getDriverInstanceFor(User)).tapsOnRemindToCallLater();
    }

    @And("^(\\w+) on Overdue tab taps on done button$")
    public void userTapsOnDoneButton(String User) {
        new OverdueTabPage(getDriverInstanceFor(User)).tapsOnDoneButton();
    }

    @And("^(\\w+) on Overdue tab taps on remove from overdue list$")
    public void userTapsOnRemoveFormOverdueList(String User) {
        new OverdueTabPage(getDriverInstanceFor(User)).tapsOnRemoveFormOverdueList();
    }

    @Then("^(\\w+) on Overdue tab Verifies reason screen$")
    public void userVerifiesReasonScreen(String User) {
        new OverdueTabPage(getDriverInstanceFor(User)).verfiyReasonScreen();
    }

    @And("^(\\w+) on Overdue tab selects invalid phone number as reason$")
    public void userSelectsInvalidPhoneNumberAsReason(String User) {
        String reason = "Phone number does not work";
        new OverdueTabPage(getDriverInstanceFor(User)).selectReason(reason);
    }

    @And("^(\\w+) on Overdue tab selects (.*)$")
    public void userSelectsReasons(String User,String reason)  {
        new OverdueTabPage(getDriverInstanceFor(User)).selectReason(reason);
    }

    @And("^(\\w+) on Overdue reason page selects done button$")
    public void userOnOverdueReasonPageSelectsDoneButton(String  User)  {
        new OverdueTabPage(getDriverInstanceFor(User)).tapsOnDoneButton();
    }

    @Then("^(\\w+) on Overdue tab verifies patient info is not present in list$")
    public void userVerfiesInfoIsNotPresentInList(String User){
        String patientname=ScenarioContext.getData("User",ScenarioContextKeys.PATIENT_NAME);
        new OverdueTabPage(getDriverInstanceFor(User)).isPatientNotPresentInList(patientname);
    }

    @Given("^(\\w+) creates overdue patient with appointment as of today$")
    public void userCreatesOverduePatientWithAppointmentAsOfToday(String User) {
        new OverdueTabPage(getDriverInstanceFor(User)).createOverduePatientForTodayFromApi();
    }

    @And("^(\\w+) on Overdue tab taps on call Icon$")
    public void userTapsOnCallIcon(String User){
        String patientname=ScenarioContext.getData("User",ScenarioContextKeys.PATIENT_NAME);
        new OverdueTabPage(getDriverInstanceFor(User)).tapsOnCallIcon(patientname);
    }

    @Then("^(\\w+) on Overdue tab verifies popup$")
    public void userVerifiesPopup(String User) {
        new OverdueTabPage(getDriverInstanceFor(User)).verifiesPopup();
    }

}
