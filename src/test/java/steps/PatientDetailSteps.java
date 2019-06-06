package steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import pages.PatientDetailPage;
import utils.Date;
import utils.RandomValue;

import java.util.Map;

public class PatientDetailSteps extends BaseSteps {
    @And("^(\\w+) enters new patient info$")
    public void userEntersNewPateintInfo(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).enterPatientInfo(RandomValue.getRandomPhoneNumber(), "44", "Male","test");
    }

    @And("^(\\w+) enters new Bp Info$")
    public void userEntersNewBpInfo(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).enterBpInfo(" ", "2001159");
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

    @And("^(\\w+) enters new patient info Without phone number$")
    public void userEntersNewPatientInfoWithoutPhoneNumber(String User){
        new PatientDetailPage(getDriverInstanceFor(User)).enterPatientInfo("","44","Male", "testColony");
    }

    @And("^(\\w+) navigates back$")
    public void userNavigatesBack(String User){
        new PatientDetailPage(getDriverInstanceFor(User)).userNavigatesBack();
    }

    @And("^(\\w+) verifies error message validation$")
    public void userVerifiesErrorMessageValidation(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).validateErrorMessage();
    }

    @And("^(\\w+) enters invalid data for patients primary info$")
    public void userEntersInvalidDataForPatientsPrimaryInfo(String User,DataTable dataTable ) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        new PatientDetailPage(getDriverInstanceFor(User)).enterPatientInvalidPatientInfo(map.get("phoneNumber"));
    }

    @And("^(\\w+) enters invalid date$")
    public void userEntersInvalidDate(String User,DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        new PatientDetailPage(getDriverInstanceFor(User)).enterInvalidDate(map.get("Date"));
    }
}
