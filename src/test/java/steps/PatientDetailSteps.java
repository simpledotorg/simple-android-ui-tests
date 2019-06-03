package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import pages.DiagnosisPage;
import pages.PatientDetailPage;
import pages.PatientPrimaryInfoSection;
import utils.Date;

public class PatientDetailSteps extends BaseSteps {
    @And("^(\\w+) enters new patient info$")
    public void userEntersNewPateintInfo(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).enterPatientInfo("9878988988", "44", "Male", "testColony");
    }

    @And("^(\\w+) enters new Bp Info$")
    public void userEntersNewBpInfo(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).enterBpInfo("", "200159");
    }

    @And("^(\\w+) taps on next ArrowButton$")
    public void usersTapsOnNextArrowButton(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).tapsOnNextArrow();
    }

    @And("^(\\w+) enters date$")
    public void userEntersDate(String User) throws Throwable {
        String date = Date.getCurrentDate();
        new PatientDetailPage(getDriverInstanceFor(User)).entersDate(date);
    }

    @And("^(\\w+) taps on save Button$")
    public void userTapsOnSaveButton(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).clickOnSaveButton();
    }

    @And("^(\\w+) taps on appointment$")
    public void userTapsOnAppointment(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).clickOnAppointmentDoneButton();
    }
}
