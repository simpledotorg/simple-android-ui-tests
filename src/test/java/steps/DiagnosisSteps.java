package steps;

import cucumber.api.java.en.And;
import pages.DiagnosisPage;

public class DiagnosisSteps extends BaseSteps {
    @And("^(\\w+) clicks on next Button at diagnosis screen$")
    public void userClicksOnNextButtonAtDiagnosisScreen(String User) {
        new DiagnosisPage(getDriverInstanceFor(User)).tapsOnNextButton();
    }
}
