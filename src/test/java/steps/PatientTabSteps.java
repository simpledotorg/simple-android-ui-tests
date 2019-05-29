package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.PatientTabPage;
import pages.SearchSection;

public class PatientTabSteps extends BaseSteps {
    @Then("^(\\w+) verifies Patient tab$")
    public void userVerifiesPatientTab(String User) throws Throwable {
        new PatientTabPage(getDriverInstanceFor(User)).verifyPatientTab();
    }

    @And("^(\\w+) searches for unregistered Patient$")
    public void userPerformSearchForUnregisteredPatient(String User) {
        new PatientTabPage(getDriverInstanceFor(User)).searchForUnRegisteredPatient();
    }
}
