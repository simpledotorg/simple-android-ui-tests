package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import pages.DiagnosisPage;

public class DiagnosisSteps extends BaseSteps {
    @And("^(\\w+) on Diagnosis page taps on next Button$")
    public void userOnDiagnosisPageTapsOnNextButton(String User) throws Throwable {
        new DiagnosisPage(getDriverInstanceFor(User)).tapsOnNextButton();

    }

    @And("^(\\w+) on Diagnosis page select diagnosis$")
    public void userOnDiagnosisPageSelectDiagnosis(String User) throws Throwable {
        new DiagnosisPage(getDriverInstanceFor(User)).selectDiagnosis();
    }
}
