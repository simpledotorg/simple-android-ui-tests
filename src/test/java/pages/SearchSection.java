package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SearchSection extends BasePage {
    AppiumDriver driver;

    public SearchSection(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "patientsearch_fullname")
    private WebElement searchPatientName;

    @FindBy(id = "patientsearch_search")
    private WebElement NextButton;

    @FindBys({@FindBy(id = "patientsearch_header")})
    private List<WebElement> searchHeaderList;

    @FindBy(id = "patients_search_patients")
    private WebElement searchPatientTextBox;

    @FindBy(id = "searchresults_new_patient")
    private WebElement registerAsNewPatientButton;

    @FindBys
            ({@FindBy(id = "patientsearchresult_item_title")})
    private List<WebElement> searchResult;

    @FindBy(id = "searchresults_new_patient_rationale")
    private WebElement registerPatientLabel;

    @FindBy(id = "searchresults_empty_state_text")
    private WebElement resultInfoForInvalidSearch;

    private void searchPatient(String patientName) {
        searchPatientTextBox.click();
        searchPatientName.sendKeys(patientName);
        NextButton.click();
    }

    public void searchForRegisteredPatientWithBpInfo(String patientName) {
        searchPatient(patientName);
        Assert.assertTrue(registerAsNewPatientButton.isDisplayed());
    }

    //invalid search
    public void searchForUnRegisteredPatient() {
        searchPatient("unRegisteredPatient");
        Assert.assertEquals(resultInfoForInvalidSearch.getText(), "No patients match");
        Assert.assertEquals(registerPatientLabel.getText(), "Patient is not registered");
        Assert.assertTrue(registerAsNewPatientButton.isDisplayed());
    }

    public void searchForRegisteredPatientWithoutBPInfo(String patientName) {
        searchPatient(patientName);
        Assert.assertTrue(registerAsNewPatientButton.isDisplayed());
    }

    //This method is used when user search for patient name
    // and some related search is present
    public void searchForPatientName(String patientName) {
        searchPatient(patientName);
//        Assert.assertEquals(registerPatientLabel.getText(), "Can’t find the patient in this list?");
        Assert.assertTrue(registerAsNewPatientButton.isDisplayed());
    }

    public void tapsOnRegisteredPatientTab() {
        registerAsNewPatientButton.click();
    }
}
