package steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.PatientDetailPage;
import pages.PatientTabPage;
import utils.Date;
import utils.RandomValue;

import java.util.Map;

public class PatientDetailSteps extends BaseSteps {
    @And("^(\\w+) enters new patient info$")
    public void userEntersNewPateintInfo(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).enterPatientInfo(RandomValue.getRandomPhoneNumber(), "44", "Male", "test");
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
    public void userEntersNewPatientInfoWithoutPhoneNumber(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).enterPatientInfo("", "44", "Male", "testColony");
    }

    @And("^(\\w+) navigates back$")
    public void userNavigatesBack(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).userNavigatesBack();
    }

    @And("^(\\w+) verifies error message validation$")
    public void userVerifiesErrorMessageValidation(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).validateErrorMessage();
    }

    @And("^(\\w+) enters invalid data for patients primary info$")
    public void userEntersInvalidDataForPatientsPrimaryInfo(String User, DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        new PatientDetailPage(getDriverInstanceFor(User)).enterPatientInvalidPatientInfo(map.get("phoneNumber"));
    }

    @And("^(\\w+) enters invalid date$")
    public void userEntersInvalidDate(String User, DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        new PatientDetailPage(getDriverInstanceFor(User)).enterInvalidDate(map.get("Date"));
    }

    @And("^(\\w+) taps on Add new Bp button$")
    public void userTapsOnAddNewBpButton(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).tapsOnAddNewBp();
    }


    @And("^(\\w+) verifies update phone number pop up$")
    public void userVerifiesUpdatePhoneNumberPopUp(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).verifiesUpdatePopUp();
    }

    @And("^(\\w+) enters phone number$")
    public void userEntersPhoneNumber(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).enterPhoneNumber();
    }

    @And("^(\\w+) taps on skip button$")
    public void usertapsOnSkipButton(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).tapsOnSkipButton();
    }

    @And("^(\\w+) enters past date$")
    public void userEntersPastDate(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).enterPastDate();
    }

    @And("^(\\w+) verifies days information$")
    public void userVerifiesDaysInformation(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).verifiesDaysInformation();
    }

    @And("^(\\w+) taps on Edit Bp Link$")
    public void userTapsOnEditBpLink(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).tapsOnEditBpLink();
    }

    @And("^(\\w+) updates Bp Info$")
    public void userUpdatesBpInfo(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).enterBpInfo("250", "1159");
    }

    @And("^(\\w+) taps on Remove Link$")
    public void userTapsOnRemoveLink(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).tapsOnRemoveLink();
    }

    @And("^(\\w+) taps on cancel button$")
    public void userTapsOnCancelButton(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).tapsOnCancelButton();
    }

    @And("^(\\w+) taps on Remove button$")
    public void userTapsOnRemoveButton(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).tapsOnRemoveButton();
    }

    @Then("^(\\w+) verifies message$")
    public void userVerifiesMessage(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).verifiesMessage();
    }

    @Then("^(\\w+) verifies list of bp info$")
    public void userVerifiesListOfBpInfo(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).verifiesBpList();
    }

    @And("^(\\w+) removes all bp info$")
    public void userRemovesAllBpInfo(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).removeAllBpInfo();
    }

    @Then("^(\\w+) taps on Add new medicine button$")
    public void userTapsOnAddNewMedicineButton(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).addNewMedicine();
    }
}

