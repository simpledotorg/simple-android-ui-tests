package steps;

import qaApiServices.facility.FacilityClient;
import qaApiServices.facility.response.FacilityResponse;
import qaApiServices.protocol.ProtocolClient;
import qaApiServices.protocol.response.ProtocolResponse;
import com.embibe.optimus.utils.ScenarioContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.patientPrimaryInformation.PatientSummaryDetailPage;
import utils.CreateFaker;
import utils.Date;
import utils.RandomValue;
import utils.ScenarioContextKeys;

import java.util.HashSet;

public class PatientSummaryDetailSteps extends BaseSteps {
    @And("^(\\w+) on Patient summary page enters new patient info$")
    public void userEntersNewPateintInfo(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).enterPatientInfo("",RandomValue.getRandomPhoneNumber(), CreateFaker.getRandomAge(), CreateFaker.getGender(), "testcolony");
    }

    @And("^(\\w+) on Patient summary page enters new Bp Info$")
    public void userEntersNewBpInfo(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).enterBpInfo("200", "159");
    }

    @And("^(\\w+) on Patient summary page enters date$")
    public void userEntersDate(String User) {
        String date = Date.getCurrentDate_IN_DD_MM_YY();
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).entersDate(date);
    }

    @And("^(\\w+) on Patient summary page taps on save Button$")
    public void userTapsOnSaveButton(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).clickOnSaveButton();
    }

    @And("^(\\w+) on Patient summary page taps on appointment done button$")
    public void userTapsOnAppointment(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).clickOnAppointmentDoneButton();
    }

    @And("^(\\w+) on Patient summary page enters new patient info Without phone number$")
    public void userEntersNewPatientInfoWithoutPhoneNumber(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).enterPatientInfo("", "", CreateFaker.getRandomAge(),CreateFaker.getGender(),"testcolony");
    }

    @And("^(\\w+) on Patient summary page navigates back$")
    public void userNavigatesBack(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).userNavigatesBack();
    }

    @And("^(\\w+) on Patient summary page enters invalid data for patients primary info$")
    public void userEntersInvalidDataForPatientsPrimaryInfo(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).enterPatientInfo("","19208","", "", "");
    }

    @And("^(\\w+) on Patient summary page enters invalid date$")
    public void userEntersInvalidDate(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).enterPatientInfo("",RandomValue.getRandomPhoneNumber(),"31 / 02 /2019", CreateFaker.getGender(), "test");
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

    @And("^(\\w+) on Patient summary page enters back date$")
    public void userEntersPastDate(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).enterBackDate();
    }

    @And("^(\\w+) on Patient summary page verifies days information for back date$")
    public void userVerifiesDaysInformationForBackDate(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).verifiesDaysInformationForBackDate();
    }

    @And("^(\\w+) on Patient summary page taps on Edit Bp Link$")
    public void userTapsOnEditBpLink(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).tapsOnEditBpLink();
    }

    @And("^(\\w+) on Patient summary page updates Bp Info$")
    public void userUpdatesBpInfo(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).enterBpInfo("250", "90");
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
        String drugname = "Customize Medicine";
        String dosage = "10";
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
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).isCutumDrugPresent(drug_name);
    }

    @And("^(\\w+) on Patient summary page update medicine info$")
    public void userUpdateMedicineInfo(String User) {
        String name = "CHECKER";
        String dosage = "15";

        new PatientSummaryDetailPage(getDriverInstanceFor(User)).modifyCustomizeMedicine(name, dosage);
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

        new PatientSummaryDetailPage(getDriverInstanceFor(User)).isCutumDrugRemoved(drug_name);
    }

    @Then("^(\\w+) on Patient summary page verifies add medicine button$")
    public void userVerifiesAddMedicineButton(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).verifiesAddMedicineButton();
    }

    @Then("^(\\w+) on Patient summary page validate medicine info at bp medicine page$")
    public void validateMedicineInfoAtBpMedicinePage(String User) {

        String facilityId = ScenarioContext.getData("User", ScenarioContextKeys.FACILTIYID);
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

    @And("^(\\w+) on Patient summary page verifies days information$")
    public void userOnPatientSummaryPageVerifiesDaysInformation(String User) {
        String bpreading = ScenarioContext.getData("User", ScenarioContextKeys.READING);
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).verifiesDaysInfo(bpreading);
    }

    @And("^(\\w+) on Patient summary page taps on appointment not now button$")
    public void userOnPatientSummaryPageTapsOnAppointmentNotNowButton(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).clickOnAppointmentNotNowButton();
    }

    @And("^(\\w+) on Patient summary page taps on Edit patient info link$")
    public void userOnPatientSummaryPageTapsOnEditPatientInfoLink(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).clickOnPatientSummaryEditLink();
    }

    @And("^(\\w+) on Patient summary page update patient info$")
    public void userOnPatientSummaryPageUpdatePatientInfo(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).updatePatientInfo();
    }

    @And("^(\\w+) on Patient summary page selects done button$")
    public void userOnPatientSummaryPageSelectsDoneButton(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).pressKeyboardDoneButton();
    }

    @Then("^(\\w+) on Patient summary page verifies phone number$")
    public void userOnPatientSummaryPageVerifiesPhoneNumber(String User) {
        String phoneNumber = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_PHONE_NUMBER);
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).verifyPhoneNumber(phoneNumber);
    }

    @And("^(\\w+) on patient summary page verifies phoneNumber prefill$")
    public void userOnPatientSummaryPageVerifiesPhoneNumberPrefill(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).verifiesPhoneNumberPrefill();
    }

    @And("^(\\w+) on Patient summary page add new phone number$")
    public void userOnPatientSummaryPageAddNewPhoneNumber(String User) {
        String phoneNumber = RandomValue.getRandomPhoneNumber();
        ScenarioContext.putData("User", ScenarioContextKeys.PATIENT_PHONE_NUMBER, phoneNumber);
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).addNewPhoneNumber(phoneNumber);
    }

    @And("^(\\w+) on Patient summary page enters new patient primary information$")
    public void userOnPatientSummaryPageEntersNewPatientPrimaryInformation(String User) {
        String name= new CreateFaker().faker.name().firstName();
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).enterPatientInfo(name,"","44","Male","testcolony");
    }

    @And("^(\\w+) on Patient summary page verifies error message for invalid data entry$")
    public void userOnPatientSummaryPageVerifiesErrorMessageForInvalidDataEntry(String User) {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).verifyValidaitonErrorMessages();
    }

    @And("^(\\w+) on Patient summary page verifies error message for invalid date entry$")
    public void userOnPatientSummaryPageVerifiesErrorMessageForInvalidDateEntry(String User)  {
        new PatientSummaryDetailPage(getDriverInstanceFor(User)).verifyValidaitonErrorMessagesForInvalidDate();
    }
}

