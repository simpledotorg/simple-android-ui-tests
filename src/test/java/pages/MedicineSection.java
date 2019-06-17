package pages;

import com.embibe.optimus.utils.ScenarioContext;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.ScenarioContextKeys;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MedicineSection extends BasePage {
    private AppiumDriver driver;

    public MedicineSection(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "patientsummary_prescriptions_update")
    private WebElement addNewMedicineButton;

    @FindBy(id = "prescribeddrug_item_addnewprescription_rootlayout")
    private WebElement addAnotherMedicineButton;

    @FindBy(id = "customprescription_drug_name")
    private WebElement drugNameEditBox;

    @FindBy(id = "customprescription_drug_dosage")
    private WebElement dosageName;

    @FindBy(id = "customprescription_save")
    private WebElement savePrescriptionButton;

    @FindBy(xpath = "//android.widget.Button[contains(@text,'Save')]")
    private WebElement saveMedicineButton;

    @FindBy(id = "patientsummary_prescriptions_update")
    private WebElement updateMedicine;

    @FindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'patientsummary_prescriptions_summary_container')]")
    private WebElement updatedInfo;

    @FindBys({
            @FindBy(id = "protocoldrug_item_name")
    })
    private List<WebElement> drugNameList;


    @FindBys({
            @FindBy(id = "prescribeddrug_item_customdrug_name")
    })
    private List<WebElement> customDrugNameList;

    @FindBy(id = "customprescription_remove_button")
    private WebElement removeLink;

    @FindBys({
            @FindBy(id = "prescribed_drug_list_item_dosage_name")
    })
    private List<WebElement> prescribedDosageName;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'None')]")
    private WebElement noneDosage;


    public void tapsOnAddNewMedicineButton() {
        addNewMedicineButton.click();
    }

    public void tapsOnAddAnotherMedicineButton() {
        addAnotherMedicineButton.click();
    }

    public void enterDrugName(String name) {
        drugNameEditBox.sendKeys(name);
    }

    public void enterDosageInfo(String dosage) {
        dosageName.sendKeys(dosage);
    }

    public void tapsOnSavePrescriptionButton() {
        savePrescriptionButton.click();
    }

    public void addCustomizeMedicine(String name, String dosage) {

        enterDrugName(name);
        enterDosageInfo(dosage);
        tapsOnSavePrescriptionButton();
    }

    public void tapsOnSaveBpMedicineButton() {
        waitForElementToBeVisible(saveMedicineButton);
        saveMedicineButton.click();
    }

    public void verifiesUpdatedMedicineInfo() {
        Assert.assertTrue(updateMedicine.isDisplayed());

        List<WebElement> elements = updatedInfo.findElements(By.className("android.widget.TextView"));
        List<String> actualmedicineInfo = new ArrayList<>();
        for (WebElement ele : elements) {
            System.out.println(ele.getText());
            actualmedicineInfo.add(ele.getText());
        }

        List<String> expectedMedicineInfo = new ArrayList<>();
        String name = ScenarioContext.getData("User", ScenarioContextKeys.DRUG_INFO);

        System.out.println(name + "exp");
        expectedMedicineInfo.add(name);
        expectedMedicineInfo.add("Updated");
        expectedMedicineInfo.add("Today");


        Assert.assertTrue(expectedMedicineInfo.containsAll(actualmedicineInfo));
    }

    public void addInvalidData(String name) {
        enterDrugName(name);
        tapsOnSavePrescriptionButton();
        Assert.fail("failed because of defect id -166605165 ");
    }

    public void tapsOnUpdateMedicine() {
        updateMedicine.click();
    }

    public void selectMedicineFromList(String name) {
        for (WebElement ele : customDrugNameList) {
            System.out.println(ele.getText().toUpperCase());
            if (ele.getText().toUpperCase().equals(name.toUpperCase())) {
                ele.click();
            } else {
                Assert.fail("custum drug is not present in list");
            }
        }
    }

    public void verifyCustumDrugList(String name, String expectedStatus, String failureMessage) {

        if(customDrugNameList.size()==0){
            Assert.fail("custun drug list is not present");
        }

        String status = "false";
        for (WebElement ele : customDrugNameList) {
            if (ele.getText().toUpperCase().equals(name.toUpperCase())) {
                status = "true";
            }
        }
        Assert.assertEquals(status, expectedStatus, failureMessage);

    }

    public void modifyCustomizeMadicineName(String name) {
        enterDrugName(name);
        tapsOnSavePrescriptionButton();
    }

    public void tapsOnRemoveCustumPrescriptionLink() {
        removeLink.click();
    }

    public void selectMedicine() {
        String name = drugNameList.get(0).getText();
        drugNameList.get(0).click();
        String dosage = prescribedDosageName.get(0).getText();
        prescribedDosageName.get(0).click();
        String drug_info = dosage + "   " + name;

        ScenarioContext.putData("User", ScenarioContextKeys.DRUG_INFO, drug_info);
    }

    public void selectNoneAsDosage() {
        drugNameList.get(0).click();
        noneDosage.click();
    }

    public void verifiesAddMedicineButton() {
        Assert.assertTrue(addNewMedicineButton.isDisplayed());
    }

    public void validateMedicineUI(HashSet<String> protocolDrugNameList) {

        List<String> nameList = new ArrayList<>();
        for (WebElement ele : drugNameList) {
            nameList.add(ele.getText());
        }
        Assert.assertTrue(protocolDrugNameList.containsAll(nameList));
    }


}
