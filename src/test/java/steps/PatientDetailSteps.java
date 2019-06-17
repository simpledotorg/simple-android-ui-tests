package steps;

import getFacility.FacilityClient;
import getFacility.FacilityResponse;
import getProtocol.ProtocolClient;
import getProtocol.ProtocolResponse;
import com.embibe.optimus.utils.ScenarioContext;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.PatientDetailPage;
import utils.Date;
import utils.RandomValue;
import utils.ScenarioContextKeys;

import java.util.HashSet;
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
        new PatientDetailPage(getDriverInstanceFor(User)).tapsOnAddNewMedicine();
    }

    @Then("(\\w+) taps on Add another medicine button$")
    public void userTapsOnAddAnotherMedicineButton(String User) throws Throwable {
        new PatientDetailPage(getDriverInstanceFor(User)).tapsOnAddAnotherMedicine();
    }

    @And("^(\\w+) add new customized medicine$")
    public void userAddNewCustomizedMedicine(String User) {
        String drugname = "Test";
        ScenarioContext.putData("User", ScenarioContextKeys.DRUG_NAME, drugname);
        String dosage = "10 mg";

        String drugInfo = dosage + "   " + drugname;
        ScenarioContext.putData("User", ScenarioContextKeys.DRUG_INFO, drugInfo);


        new PatientDetailPage(getDriverInstanceFor(User)).addCustomizeMedicine(drugname, dosage);
    }

    @And("^(\\w+) taps on save bp medicine button$")
    public void userTapsOnSaveBpMediicneButton(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).tapsOnSaveBpMedicineButton();
    }

    @Then("^(\\w+) verifies updated medicine info$")
    public void userVerifiesUpdatedMedicineInfo(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).verifiesUpdatedMedicineInfo();
    }

    @And("^(\\w+) add new customized medicine with <drugName> and <dosage>$")
    public void userAddNewCustomizedMedicineAsDrugNameAndDosage(String User, String drugname, String dosage) {
        new PatientDetailPage(getDriverInstanceFor(User)).addCustomizeMedicine(drugname, dosage);
    }

    @And("^(\\w+) add new invalid customized medicine$")
    public void userAddNewInvalidCustomizedMedicine(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).addInvalidData();
    }

    @And("^(\\w+) taps on Update Medicine info$")
    public void userTapsOnUpdateMedicineInfo(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).tapsOnUpdateMedicine();
    }

    @And("^(\\w+) select customize medicine$")
    public void userSelectCustomizeMedicine(String User) {
        String drug_name = ScenarioContext.getData("User", ScenarioContextKeys.DRUG_NAME);
        new PatientDetailPage(getDriverInstanceFor(User)).selectMedicineFromList(drug_name);
    }

    @And("^(\\w+) verifies custum drug list$")
    public void userVerifiesCustumDrugList(String User) {
        String drug_name = ScenarioContext.getData("User", ScenarioContextKeys.DRUG_NAME);
        new PatientDetailPage(getDriverInstanceFor(User)).verifyCustumDrugList(drug_name, "true", drug_name+"custum drug should be present in bp medicine page");
    }

    @And("^(\\w+) update medicine info$")
    public void userUpdateMedicineInfo(String User) {
        String name = "checker";
        ScenarioContext.putData("User", ScenarioContextKeys.DRUG_NAME, name);

        new PatientDetailPage(getDriverInstanceFor(User)).modifyCustomizeMadicineName(name);
    }

    @Then("^(\\w+) taps on remove custum prescription link$")
    public void userTapsOnRemoveCustumPrescriptionLink(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).tapsOnRemoveCustumPrescriptionLink();
    }

    @And("^(\\w+) select prescribed medicine$")
    public void userSelectPrescribedMedicine(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).selectMedicine();
    }

    @Then("^(\\w+) taps on \"([^\"]*)\"$")
    public void userTapsOn(String User, String name) throws Throwable {
        new PatientDetailPage(getDriverInstanceFor(User)).selectNoneAsDosage();
    }

    @And("^(\\w+) verifies custum drug list for deleted customized drug$")
    public void userVerifiesCustumDrugListForDeletedCustomizedDrug(String User) {
        String drug_name = ScenarioContext.getData("User", ScenarioContextKeys.DRUG_NAME);

        new PatientDetailPage(getDriverInstanceFor(User)).verifyCustumDrugList(drug_name, "false", "cusromized drug name should not be displayed");
    }

    @Then("^(\\w+) verifies add medicine button$")
    public void userVerifiesAddMedicineButton(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).verifiesAddMedicineButton();
    }

    @Then("^(\\w+) validate medicine info at bp medicine page$")
    public void validateMedicineInfoAtBpMedicinePage(String User) {

        String facilityId = ScenarioContext.getData("User",ScenarioContextKeys.FACILTIYID);
        FacilityResponse allFacilityInfo = new FacilityClient().getAllFacilityInfo();
        String protocolId = allFacilityInfo.getProtocolId(facilityId);


        ProtocolResponse protocolResponse = new ProtocolClient().getAllProtocolInfo();
        HashSet<String> protocolDrugNameList = protocolResponse.getProtocolDrugNameList(protocolId);


        new PatientDetailPage(getDriverInstanceFor(User)).validateMedicineUI(protocolDrugNameList);
    }

    @And("^(\\w+) taps on remove button$")
    public void userTapsOnRemoveButton(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).tapsOnRemoveButton();
    }

    @And("^(\\w+) create protocol drug from api$")
    public void userCreateProtocolDrugFromApi(String User) throws Throwable {
        new PatientDetailPage(getDriverInstanceFor(User)).createProtocolDrug();
    }

    @Then("^(\\w+) on patient summary detail page verifies medicine info$")
    public void userOnPatientSummaryDetailPageVerifiesMedicineInfo(String User) {
        new PatientDetailPage(getDriverInstanceFor(User)).verifiesMedicineInfo();
    }

}

