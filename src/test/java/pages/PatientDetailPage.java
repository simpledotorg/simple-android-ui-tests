package pages;

import protocolDrug.CreateDrug;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashSet;

public class PatientDetailPage extends BasePage {
    private AppiumDriver driver;
    PatientPrimaryInfoSection patientPrimaryInfoSection;
    BpSection bpSection;
    MedicineSection medicineSection;


    @FindBy(xpath = "//android.widget.Button[@text='Save']")
    private WebElement saveButton;

    @FindBy(id = "scheduleappointment_done")
    private WebElement scheduleAppointmentDoneButton;

    public PatientDetailPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        patientPrimaryInfoSection = new PatientPrimaryInfoSection(driver);
        bpSection = new BpSection(driver);
        medicineSection = new MedicineSection(driver);
        this.driver = driver;
    }

    public void enterPatientInfo(String phone, String age, String male, String testColony) {
        patientPrimaryInfoSection.enterPatientInfo(phone, age, male, testColony);
    }

    public void enterBpInfo(String systollic, String diastolic) {
        bpSection.enterBpInfo(systollic, diastolic);
    }

    public void tapsOnNextArrow() {
        bpSection.tapsOnNextArrow();
    }

    public void entersDate(String date) {
        bpSection.entersDate(date);
    }

    public void clickOnSaveButton() {
        waitForElementToBeClickable(saveButton);
        saveButton.click();
    }

    public void clickOnAppointmentDoneButton() {
        scheduleAppointmentDoneButton.click();
    }

    public void userNavigatesBack() {
        driver.navigate().back();
    }

    public void validateErrorMessage() {
        patientPrimaryInfoSection.validateErrorMessage();
    }

    public void enterPatientInvalidPatientInfo(String phoneNumber) {
        patientPrimaryInfoSection.enterPatientInvalidPatientInfo(phoneNumber);
    }

    public void enterInvalidDate(String sDate) {
        patientPrimaryInfoSection.enterInvalidDate(sDate);
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

    public void enterPastDate() {

        bpSection.enterPastDate();
    }

    public void verifiesDaysInformation() {
        bpSection.verifiesDaysInformation();
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
        medicineSection.addInvalidData("Test");
    }

    public void tapsOnUpdateMedicine() {
        medicineSection.tapsOnUpdateMedicine();
    }

    public void selectMedicineFromList(String drug_name) {
        medicineSection.selectMedicineFromList(drug_name);
    }

    public void verifyCustumDrugList(String name,String status,String message) {
        medicineSection.verifyCustumDrugList(name,status,message);
    }

    public void modifyCustomizeMadicineName(String name) {
        medicineSection.modifyCustomizeMadicineName(name);
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
}
