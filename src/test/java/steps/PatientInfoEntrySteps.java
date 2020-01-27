package steps;

import cucumber.api.java.en.Then;
import pages.patientPrimaryInformation.PatientPrimaryInfoSection;

public class PatientInfoEntrySteps extends BaseSteps {

    @Then("^(\\w+) on Patient info entry page verifies address model for given country$")
    public void UserOnPatientInfoEntryPageVerifiesAddressModelForGivenCountry(String User) {

        new PatientPrimaryInfoSection(getDriverInstanceFor(User)).verifyAddressModelForCountry();
    }

}
