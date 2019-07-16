package pages;

import com.embibe.optimus.utils.ScenarioContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
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
        dosageName.clear();
        dosageName.sendKeys(dosage);

    }

    public void tapsOnSavePrescriptionButton() {
        savePrescriptionButton.click();
    }

    public void addCustomizeMedicine(String name, String dosage) {
        enterDrugName(name);
        enterDosageInfo(dosage);
        tapsOnSavePrescriptionButton();

        //setting global value for drug info
        setDrugInfo(name,dosage);
    }

    public void tapsOnSaveBpMedicineButton() {
        saveMedicineButton.click();
    }

    public void verifiesUpdatedMedicineInfo() {
        Assert.assertTrue(updateMedicine.isDisplayed());

        List<WebElement> elements = updatedInfo.findElements(By.className("android.widget.TextView"));
        List<String> actualmedicineInfo = new ArrayList<>();
        for (WebElement ele : elements) {
            actualmedicineInfo.add(ele.getText());
        }

        List<String> expectedMedicineInfo = new ArrayList<>();
        String name = ScenarioContext.getData("User", ScenarioContextKeys.DRUG_INFO);

        expectedMedicineInfo.add(name);
        expectedMedicineInfo.add("Updated");
        expectedMedicineInfo.add("Today");

        Assert.assertTrue(expectedMedicineInfo.containsAll(actualmedicineInfo), "updated medicine info is not displayed");
    }

    public void addInvalidData(String value) {
        enterDosageInfo(value);
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

    public void isCutumDrugPresent(String name) {
        if (customDrugNameList.size() == 0) {
            Assert.fail("custum drug list is not present");
        }

        String status = "false";
        for (WebElement ele : customDrugNameList) {
            if (ele.getText().toUpperCase().equals(name.toUpperCase())) {
                status = "true";
                break;
            }
        }
        Assert.assertEquals(status, "true", "Custum drug is not present in bp medicine page" + name);
    }

    public void isCutumDrugRemoved(String name) {
        String status = "true";
        for (WebElement ele : customDrugNameList) {
            if (ele.getText().toUpperCase().equals(name.toUpperCase())) {
                status = "false";
                break;
            }
        }
        Assert.assertEquals(status, "true", "Custum drug should get removed from bp medicine page" + name);
    }

    public void modifyCustomizeMedicine(String name, String dosage) {
        enterDrugName(name);
        enterDosageInfo(dosage);
        tapsOnSavePrescriptionButton();

        //updatin global value
        setDrugInfo(name,dosage);
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


    private void setDrugInfo(String name, String dosage){
        ScenarioContext.putData("User", ScenarioContextKeys.DRUG_NAME, name);
        String drugInfo = dosage + "   " + name;
        ScenarioContext.putData("User", ScenarioContextKeys.DRUG_INFO, drugInfo);
    }
}
