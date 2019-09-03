package pages.patientPrimaryInformation;

import com.embibe.optimus.utils.ScenarioContext;
import pages.BasePage;
import qaApiServices.protocolDrug.CreateDrug;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CreateFaker;
import utils.RandomValue;
import utils.ScenarioContextKeys;

import java.util.HashSet;

public class PatientSummaryDetailPage extends BasePage {
    private AppiumDriver driver;
    PatientPrimaryInfoSection patientPrimaryInfoSection;
    PatientPrimaryInformationEditPage patientPrimaryInformationEditPage;
    BpSection bpSection;
    MedicineSection medicineSection;

    @FindBy(xpath = "//android.widget.Button[@text='Save']")
    private WebElement saveButton;

    @FindBy(id = "scheduleappointment_done")
    private WebElement scheduleAppointmentDoneButton;

    @FindBy(id = "scheduleappointment_not_now")
    private WebElement scheduleAppointmentNotNowButton;

    @FindBy(id="patientsummary_fullname")
    private WebElement patientSummaryFullname;

    @FindBy(id="patientsummary_edit")
    private WebElement patientSummaryEditLink;

    public PatientSummaryDetailPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        patientPrimaryInfoSection = new PatientPrimaryInfoSection(driver);
        patientPrimaryInformationEditPage = new PatientPrimaryInformationEditPage(driver);
        bpSection = new BpSection(driver);
        medicineSection = new MedicineSection(driver);
        this.driver = driver;
    }

    public void enterPatientInfo(String name,String phone, String age, String male, String testColony) {
        patientPrimaryInfoSection.enterPatientInfo(name,phone, age, male, testColony);
    }

    public void enterBpInfo(String systollic, String diastolic) {
        bpSection.enterBpInfo(systollic, diastolic);
    }

    public void entersDate(String date) {
        bpSection.entersDate(date);
    }

    public void clickOnSaveButton() {
        waitForElementToBeVisible(saveButton);
        saveButton.click();
    }

    public void clickOnAppointmentDoneButton() {
        scheduleAppointmentDoneButton.click();
    }

    public void userNavigatesBack() {
        navigateBack();
    }

    public void enterPatientInvalidPatientInfo(String phoneNumber) {
        patientPrimaryInfoSection.enterPatientInvalidPatientInfo(phoneNumber);
    }

    public void tapsOnAddNewBp() {
        bpSection.tapsOnAddNewBpButton();
    }

    public void verifiesUpdatePopUp() {
        bpSection.verifiesUpdatePopUp();
    }

    public void enterPhoneNumber() {
        bpSection.addPhoneNumber();
    }

    public void tapsOnSkipButton() {
        bpSection.tapsOnSkipButton();
    }

    public void enterBackDate() {
        bpSection.enterBackDate();
    }

    public void verifiesDaysInformationForBackDate() {
        String reading=ScenarioContext.getData("User",ScenarioContextKeys.READING);
        bpSection.verifiesDaysInformationForBackDate(reading);
    }

    public void tapsOnEditBpLink() {
        bpSection.tapsOnEditBpLink();
    }

    public void tapsOnRemoveLink() {
        bpSection.tapsOnRemoveLink();
    }

    public void tapsOnCancelButton() {
        bpSection.tapsOnCancelButton();
    }

    public void tapsOnRemoveButton() {
        bpSection.tapsOnRemoveButton();
    }

    public void verifiesMessage() {
        bpSection.verifiesBpSummary();
    }

    public void verifiesBpList() {
        bpSection.verfiesBpList();
    }

    public void removeAllBpInfo() {
        bpSection.removeAllBpInfo();
    }

    public void tapsOnAddNewMedicine() {
        medicineSection.tapsOnAddNewMedicineButton();
    }

    public void tapsOnAddAnotherMedicine() {
        medicineSection.tapsOnAddAnotherMedicineButton();
    }

    public void addCustomizeMedicine(String drugname,String  dosage) {
        medicineSection.addCustomizeMedicine(drugname,dosage);
    }

    public void tapsOnSaveBpMedicineButton() {
        medicineSection.tapsOnSaveBpMedicineButton();
    }

    public void verifiesUpdatedMedicineInfo() {
        medicineSection.verifiesUpdatedMedicineInfo();
    }

    public void addInvalidData() {
        medicineSection.addInvalidData("25");
    }

    public void tapsOnUpdateMedicine() {
        medicineSection.tapsOnUpdateMedicine();
    }

    public void selectMedicineFromList(String drug_name) {
        medicineSection.selectMedicineFromList(drug_name);
    }

    public void isCutumDrugPresent(String name) {
        medicineSection.isCutumDrugPresent(name);
    }

    public void modifyCustomizeMedicine(String name, String dosage) {
        medicineSection.modifyCustomizeMedicine(name,dosage);
    }

    public void tapsOnRemoveCustumPrescriptionLink() {
        medicineSection.tapsOnRemoveCustumPrescriptionLink();
    }

    public void selectMedicine() {
        medicineSection.selectMedicine();
    }

    public void selectNoneAsDosage() {
        medicineSection.selectNoneAsDosage();
    }

    public void verifiesAddMedicineButton() {
        medicineSection.verifiesAddMedicineButton();
    }

    public void validateMedicineUI(HashSet<String> protocolDrugNameList) {
        medicineSection.validateMedicineUI(protocolDrugNameList);
    }

    public void createProtocolDrug() {
      new CreateDrug().createProtocolDrugFromAPI();
    }

    public void verifiesMedicineInfo() {
        medicineSection.verifiesUpdatedMedicineInfo();
    }

    public void updatePhoneNumber() {
        bpSection.updatePhonenumber();
    }

    public void isCutumDrugRemoved(String drug_name) {
        medicineSection.isCutumDrugRemoved(drug_name);
    }

    public void verifiesDaysInfo(String bpReading) {
        bpSection.verifiesDaysInfo(bpReading);
    }

    public void clickOnAppointmentNotNowButton() {
        scheduleAppointmentNotNowButton.click();
    }

    public String getFullName(){ return patientSummaryFullname.getText();}

    public void clickOnPatientSummaryEditLink(){
        patientSummaryEditLink.click();
    }

    public void updatePatientInfo() {
        String phone=RandomValue.getRandomPhoneNumber();
        String age= CreateFaker.getRandomAge();
        String colony=new CreateFaker().faker.address().streetName();
        patientPrimaryInformationEditPage.updatePatientInfo( phone, age,colony);
    }

    public void pressKeyboardDoneButton() {
        pressEnter();
    }

    public void verifyPhoneNumber(String phoneNumber) {
        patientPrimaryInfoSection.verifyPhoneNumber(phoneNumber);}

    public void verifiesPhoneNumberPrefill() {
        patientPrimaryInfoSection.verifiesPhoneNumberPrefill();
    }

    public void addNewPhoneNumber(String phone) {
        patientPrimaryInformationEditPage.addNewPhoneNumber(phone);
    }

    public void verifyValidaitonErrorMessages() {
        patientPrimaryInfoSection.verifyValidationErrorMessages();
    }

    public void verifyValidaitonErrorMessagesForInvalidDate() {
        patientPrimaryInfoSection.verifyValidaitonErrorMessagesForInvalidDate();
    }
}
