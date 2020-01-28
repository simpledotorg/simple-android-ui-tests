package steps;

import com.embibe.optimus.utils.ScenarioContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.patientPrimaryInformation.PatientPrimaryInfoSection;
import utils.CreateFaker;
import utils.RandomValue;
import utils.ScenarioContextKeys;

public class PatientPrimaryInfoEntrySteps extends BaseSteps {

    @Then("^(\\w+) on Patient entry page verifies address model for given countries$")
    public void UserOnPatientInfoEntryPageVerifiesAddressModelForGivenCountry(String User) {
        new PatientPrimaryInfoSection(getDriverInstanceFor(User)).verifyAddressModelForCountry();
    }

    @Then("^(\\w+) on Patient entry page verifies address values for given countries$")
    public void userOnPatientInfoEntryPageVerifiesAddressValuesForGivenCountries(String User) {
        new PatientPrimaryInfoSection(getDriverInstanceFor(User)).verifyAddressValues();
    }

    @And("^(\\w+) on Patient entry page enters new patient info$")
    public void userEntersNewPateintInfo(String User) {
        String country = ScenarioContext.getData("User", ScenarioContextKeys.COUNTRY);
        if (country.equals("India")) {
            new PatientPrimaryInfoSection(getDriverInstanceFor(User)).enterPatientInfo("", RandomValue.getRandomPhoneNumber(), CreateFaker.getRandomAge(), CreateFaker.getGender(), "testhouse", "testcolony", "enabled", "", "");
        } else {
            new PatientPrimaryInfoSection(getDriverInstanceFor(User)).enterPatientInfo("", RandomValue.getRandomPhoneNumber(), CreateFaker.getRandomAge(), CreateFaker.getGender(), "testhouse", "testcolony", "enabled", "123456788766666", "testzone");
        }
    }

    @Then("^(\\w+) on Patient entry edit page verifies address values for given countries$")
    public void userOnPatientEntryEditPageVerifiesAddressValuesForGivenCountries(String User)  {
        new PatientPrimaryInfoSection(getDriverInstanceFor(User)).verifyAddressValues();
    }

    @And("^(\\w+) on Patient entry page enters new patient info Without phone number$")
    public void userEntersNewPatientInfoWithoutPhoneNumber(String User) {
        new PatientPrimaryInfoSection(getDriverInstanceFor(User)).enterPatientInfo("", "", CreateFaker.getRandomAge(),CreateFaker.getGender(),"testhouse","testcolony","enabled","","");
    }


    @And("^(\\w+) on Patient entry page enters invalid data for patients primary info$")
    public void userEntersInvalidDataForPatientsPrimaryInfo(String User) {
        new PatientPrimaryInfoSection(getDriverInstanceFor(User)).enterPatientInfo("","19208","", "", "","","enabled","","");
    }

    @And("^(\\w+) on Patient entry page enters new patient info by disabling consent reminder toggle$")
    public void userOnPatientSummaryPageEntersNewPatientInfoByDisablingConsentReminderToggle(String User) {
        String name = new CreateFaker().faker.name().firstName();
        new PatientPrimaryInfoSection(getDriverInstanceFor(User)).enterPatientInfo(name,"","44","Male","testhouse","testcolony","disabled","","");
    }

    @And("^(\\w+) on Patient entry page enters new patient info with age as (.*)$")
    public void userOnPatientSummaryPageEntersNewPatientInfoWithAgeAs(String User, String arg0) {
        new PatientPrimaryInfoSection(getDriverInstanceFor(User)).enterPatientInfo("","",arg0,"Male","testhouse","testcolony","enabled","","");
    }

    @And("^(\\w+) on Patient summary page enters new patient primary information$")
    public void userOnPatientSummaryPageEntersNewPatientPrimaryInformation(String User) {
        String name = new CreateFaker().faker.name().firstName();
        new PatientPrimaryInfoSection(getDriverInstanceFor(User)).enterPatientInfo(name,"","44","Male","testhouse","testcolony","enabled","","");
    }

}
