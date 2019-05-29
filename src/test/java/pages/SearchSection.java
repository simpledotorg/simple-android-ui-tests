package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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

    @FindBy(id = "patientsearch_header")
    private WebElement HasVisitedLabel;

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


    public void SearchPatient() {
        searchPatientTextBox.click();
        searchPatientName.sendKeys("Testuser 1");
        NextButton.click();
        Assert.assertTrue(HasVisitedLabel.getText().contains("Has visited"));
        Assert.assertTrue(searchResult.size() > 0);

        Assert.assertTrue(registerAsNewPatientButton.isDisplayed());
    }

    //invalid search
    public void searchForUnRegisteredPatient() {
        searchPatientTextBox.click();
        searchPatientName.sendKeys("Testuser 1");
        NextButton.click();
        Assert.assertEquals(resultInfoForInvalidSearch.getText(), "No patients match");
        Assert.assertEquals(registerPatientLabel.getText(), "Patient is not registered");
        Assert.assertTrue(registerAsNewPatientButton.isDisplayed());
    }
}
