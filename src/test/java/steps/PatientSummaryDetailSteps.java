package steps;

import cucumber.api.PendingException;
import facility.FacilityClient;
import facility.FacilityResponse;
import protocol.ProtocolClient;
import protocol.ProtocolResponse;
import com.embibe.optimus.utils.ScenarioContext;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.PatientSummaryDetailPage;
import utils.Date;
import utils.RandomValue;
import utils.ScenarioContextKeys;

import java.util.HashSet;
import java.util.Map;

public class PatientSummaryDetailSteps extends BaseSteps {
    @And("^(\\w+) on Patient summary page enters new patient info$")
    public void userEntersNewPateintInfo(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).enterPatientInfo(RandomValue.getRandomPhoneNumber(), "44", "Male", "test");
    }

    @And("^(\\w+) on Patient summary page enters new Bp Info$")
    public void userEntersNewBpInfo(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).enterBpInfo(" ", "2001159");
    }

    @And("^(\\w+) on Patient summary page taps on next ArrowButton$")
    public void usersTapsOnNextArrowButton(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).tapsOnNextArrow();
    }

    @And("^(\\w+) on Patient summary page enters date$")
    public void userEntersDate(String User) throws Throwable {
        String date = Date.getCurrentDate();
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).entersDate(date);
    }

    @And("^(\\w+) on Patient summary page taps on save Button$")
    public void userTapsOnSaveButton(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).clickOnSaveButton();
    }

    @And("^(\\w+) on Patient summary page taps on appointment$")
    public void userTapsOnAppointment(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).clickOnAppointmentDoneButton();
    }

    @And("^(\\w+) on Patient summary page enters new patient info Without phone number$")
    public void userEntersNewPatientInfoWithoutPhoneNumber(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).enterPatientInfo("", "44", "Male", "testColony");
    }

    @And("^(\\w+) on Patient summary page navigates back$")
    public void userNavigatesBack(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).userNavigatesBack();
    }

    @And("^(\\w+) on Patient summary page verifies error message validation$")
    public void userVerifiesErrorMessageValidation(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).validateErrorMessage();
    }

    @And("^(\\w+) on Patient summary page enters invalid data for patients primary info$")
    public void userEntersInvalidDataForPatientsPrimaryInfo(String User, DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).enterPatientInvalidPatientInfo(map.get("phoneNumber"));
    }

    @And("^(\\w+) on Patient summary page enters invalid date$")
    public void userEntersInvalidDate(String User, DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).enterInvalidDate(map.get("Date"));
    }

    @And("^(\\w+) on Patient summary page taps on Add new Bp button$")
    public void userTapsOnAddNewBpButton(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).tapsOnAddNewBp();
    }


    @And("^(\\w+) on Patient summary page verifies update phone number pop up$")
    public void userVerifiesUpdatePhoneNumberPopUp(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).verifiesUpdatePopUp();
    }

    @And("^(\\w+) on Patient summary page enters phone number$")
    public void userEntersPhoneNumber(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).enterPhoneNumber();
    }

    @And("^(\\w+) on Patient summary page taps on skip button$")
    public void usertapsOnSkipButton(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).tapsOnSkipButton();
    }

    @And("^(\\w+) on Patient summary page enters past date$")
    public void userEntersPastDate(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).enterPastDate();
    }

    @And("^(\\w+) on Patient summary page verifies days information$")
    public void userVerifiesDaysInformation(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).verifiesDaysInformation();
    }

    @And("^(\\w+) on Patient summary page taps on Edit Bp Link$")
    public void userTapsOnEditBpLink(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).tapsOnEditBpLink();
    }

    @And("^(\\w+) on Patient summary page updates Bp Info$")
    public void userUpdatesBpInfo(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).enterBpInfo("250", "1159");
    }

    @And("^(\\w+) on Patient summary page taps on Remove Link$")
    public void userTapsOnRemoveLink(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).tapsOnRemoveLink();
    }

    @And("^(\\w+) on Patient summary page taps on cancel button$")
    public void userTapsOnCancelButton(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).tapsOnCancelButton();
    }


    @Then("^(\\w+) on Patient summary page verifies message$")
    public void userVerifiesMessage(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).verifiesMessage();
    }

    @Then("^(\\w+) on Patient summary page verifies list of bp info$")
    public void userVerifiesListOfBpInfo(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).verifiesBpList();
    }

    @And("^(\\w+) on Patient summary page removes all bp info$")
    public void userRemovesAllBpInfo(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).removeAllBpInfo();
    }

    @Then("^(\\w+) on Patient summary page taps on Add new medicine button$")
    public void userTapsOnAddNewMedicineButton(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).tapsOnAddNewMedicine();
    }

    @Then("(\\w+) on Patient summary page taps on Add another medicine button$")
    public void userTapsOnAddAnotherMedicineButton(String User) throws Throwable {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).tapsOnAddAnotherMedicine();
    }

    @And("^(\\w+) on Patient summary page add new customized medicine$")
    public void userAddNewCustomizedMedicine(String User) {
        String drugname = "Test";
        ScenarioContext.putData("User", ScenarioContextKeys.DRUG_NAME, drugname);
        String dosage = "10 mg";

        String drugInfo = dosage + "   " + drugname;
        ScenarioContext.putData("User", ScenarioContextKeys.DRUG_INFO, drugInfo);


        new PatientSummaryDetailPage(getDriverInstanceFor(User)).addCustomizeMedicine(drugname, dosage);
    }

    @And("^(\\w+) on Patient summary page taps on save bp medicine button$")
    public void userTapsOnSaveBpMediicneButton(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).tapsOnSaveBpMedicineButton();
    }

    @Then("^(\\w+) on Patient summary page verifies updated medicine info$")
    public void userVerifiesUpdatedMedicineInfo(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).verifiesUpdatedMedicineInfo();
    }

    @And("^(\\w+) on Patient summary page add new customized medicine with <drugName> and <dosage>$")
    public void userAddNewCustomizedMedicineAsDrugNameAndDosage(String User, String drugname, String dosage) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).addCustomizeMedicine(drugname, dosage);
    }

    @And("^(\\w+) on Patient summary page add new invalid customized medicine$")
    public void userAddNewInvalidCustomizedMedicine(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).addInvalidData();
    }

    @And("^(\\w+) on Patient summary page taps on Update Medicine info$")
    public void userTapsOnUpdateMedicineInfo(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).tapsOnUpdateMedicine();
    }

    @And("^(\\w+) on Patient summary page select customize medicine$")
    public void userSelectCustomizeMedicine(String User) {
        String drug_name = ScenarioContext.getData("User", ScenarioContextKeys.DRUG_NAME);
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).selectMedicineFromList(drug_name);
    }

    @And("^(\\w+) on Patient summary page verifies custum drug list$")
    public void userVerifiesCustumDrugList(String User) {
        String drug_name = ScenarioContext.getData("User", ScenarioContextKeys.DRUG_NAME);
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).verifyCustumDrugList(drug_name, "true", drug_name+"custum drug should be present in bp medicine page");
    }

    @And("^(\\w+) on Patient summary page update medicine info$")
    public void userUpdateMedicineInfo(String User) {
        String name = "checker";
        ScenarioContext.putData("User", ScenarioContextKeys.DRUG_NAME, name);

        new PatientSummaryDetailPage(getDriverInstanceFor(User)).modifyCustomizeMadicineName(name);
    }

    @Then("^(\\w+) on Patient summary page taps on remove custum prescription link$")
    public void userTapsOnRemoveCustumPrescriptionLink(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).tapsOnRemoveCustumPrescriptionLink();
    }

    @And("^(\\w+) on Patient summary page select prescribed medicine$")
    public void userSelectPrescribedMedicine(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).selectMedicine();
    }

    @Then("^(\\w+) on Patient summary page taps on \"([^\"]*)\"$")
    public void userTapsOn(String User, String name) throws Throwable {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).selectNoneAsDosage();
    }

    @And("^(\\w+) on Patient summary page verifies custum drug list for deleted customized drug$")
    public void userVerifiesCustumDrugListForDeletedCustomizedDrug(String User) {
        String drug_name = ScenarioContext.getData("User", ScenarioContextKeys.DRUG_NAME);

        new PatientSummaryDetailPage(getDriverInstanceFor(User)).verifyCustumDrugList(drug_name, "false", "cusromized drug name should not be displayed");
    }

    @Then("^(\\w+) on Patient summary page verifies add medicine button$")
    public void userVerifiesAddMedicineButton(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).verifiesAddMedicineButton();
    }

    @Then("^(\\w+) on Patient summary page validate medicine info at bp medicine page$")
    public void validateMedicineInfoAtBpMedicinePage(String User) {

        String facilityId = ScenarioContext.getData("User",ScenarioContextKeys.FACILTIYID);
        FacilityResponse allFacilityInfo = new FacilityClient().getAllFacilityInfo();
        String protocolId = allFacilityInfo.getProtocolId(facilityId);


        ProtocolResponse protocolResponse = new ProtocolClient().getAllProtocolInfo();
        HashSet<String> protocolDrugNameList = protocolResponse.getProtocolDrugNameList(protocolId);


        new PatientSummaryDetailPage(getDriverInstanceFor(User)).validateMedicineUI(protocolDrugNameList);
    }

    @And("^(\\w+) on Patient summary page taps on remove button$")
    public void userTapsOnRemoveButton(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).tapsOnRemoveButton();
    }

    @And("^(\\w+) create protocol drug from api$")
    public void userCreateProtocolDrugFromApi(String User) throws Throwable {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).createProtocolDrug();
    }

    @Then("^(\\w+) on patient summary detail page verifies medicine info$")
    public void userOnPatientSummaryDetailPageVerifiesMedicineInfo(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).verifiesMedicineInfo();
    }

    @And("^(\\w+) on Patient summary page updates phone number$")
    public void userOnPatientSummaryUpdatesPhoneNumber(String User) throws Throwable {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).updatePhoneNumber();
    }
}

