package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import qaApiServices.patients.GetPatientInfo;
import qaApiServices.user.RegisterUser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends BasePage {
    AppiumDriver driver;

    public SearchPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }

    @FindBy(id = "searchQueryEditText")
    private MobileElement searchPatientName;

    @FindBy(id = "searchPatientsButton")
    private WebElement searchPatientTextBox;

    @FindBy(id = "newPatientButton")
    private WebElement registerAsNewPatientButton;

    @FindBy(id = "newPatientRationaleTextView")
    private WebElement registerPatientLabel;

    @FindBy(id = "searchresults_empty_state_text")
    private WebElement emptySearchResult;

    @FindBys({@FindBy(id = "patientsearch_header")})
    private List<WebElement> header;

    @FindBys({@FindBy(id = "patientNameAgeGenderLabel")})
    private List<WebElement> patientList;

    @FindBy(id = "facilityLabel")
    private WebElement facilityLabel;

    @FindBy(id = "patientsearch_search")
    private WebElement nextButton;

    // value could be name or phonenumber
    private void searchPatient(String value) {
        waitForElementToBeVisible(searchPatientName);
        searchPatientName.setValue(value);
        nextButton.click();
    }

    public void searchForRegisteredPatientWithBpInfo(String patientName) {
        searchPatient(patientName);

        String status = "false";
        for (WebElement ele : header) {
            if (ele.getText().toUpperCase().contains("HAS VISITED")) {
                status = "true";
                break;
            }
        }
        Assert.assertEquals(status, "true", "has visited section isn't displayed");
        Assert.assertTrue(registerAsNewPatientButton.isDisplayed());
    }

  // This method should be used to perform search or for new patient
    public void searchForPatientName(String patientName) {
        searchPatient(patientName);
        Assert.assertEquals(emptySearchResult.getText(), "No patients match");
        Assert.assertEquals(registerPatientLabel.getText(), "Patient is not registered");
        Assert.assertTrue(registerAsNewPatientButton.isDisplayed());
    }

    public void searchForRegisteredPatientWithoutBPInfo(String patientName) {
        searchPatient(patientName);

        String status = "false";
        for (WebElement ele : header) {
            if (ele.getText().equals("Other Results")) {
                status = "true";
            }
        }
        Assert.assertEquals(status, "true", "other result section isn't displayed");
        Assert.assertTrue(registerAsNewPatientButton.isDisplayed());
    }

    public void tapsOnRegisteredPatientTab() {
        registerAsNewPatientButton.click();
    }

    public void selectsPatientFromSearchList(String patientName) {
        for (WebElement ele : patientList) {

            String[] str = ele.getText().split(",");
            String name = str[0].toUpperCase();

            if (name.contains(patientName.toUpperCase())) {
                ele.click();
            } else {
                Assert.fail("Patient Name is not displayed in search list");
            }
        }
    }

    public void tapsOnSearchTextBox() {
        searchPatientTextBox.click();
    }

    public void verifiesAlphabeticalLog() {
        Assert.assertTrue(facilityLabel.getText().toUpperCase().contains("ALL PATIENTS"), "All Patient label is not displayed");

        new RegisterUser().registerNewUser();
        List<String> allPatientsName = new GetPatientInfo().getAllPatientsInfo();
        List<String> expectedPatientNameSortedList = allPatientsName.stream().sorted().collect(Collectors.toList());

        List<String> actualpatientName = new ArrayList<>();
        int count = 0;

        hideKeyboard();

        while (count <= allPatientsName.size()) {
            for (WebElement p : patientList) {
                actualpatientName.add(p.getText().split(",")[0].toUpperCase());
                count++;
            }
            scrollDown();
        }
        expectedPatientNameSortedList.equals(actualpatientName);
    }

    public void searchForRegisteredPatientByPhoneNumber(String phoneNumber) {
        searchPatient(phoneNumber);
        Assert.assertTrue(patientList.size()==1," only one result should be displayed for unique phonennumber");
    }

    public void searchForRegisteredPatientByDuplicatePhoneNumber(String phoneNumber) {
        searchPatient(phoneNumber);
        Assert.assertTrue(patientList.size()==2,"only 2 patient should be forduplicate phonenNumber");
    }

    public void searchForPatientNumber(String phoneNumber) {
        searchPatient(phoneNumber);
        Assert.assertEquals(emptySearchResult.getText(), "No patients match");
        Assert.assertEquals(registerPatientLabel.getText(), "Patient is not registered");
        Assert.assertTrue(registerAsNewPatientButton.isDisplayed());
    }

    public void searchForInvalidPhoneNumber(String phoneNumber) {
        searchPatient(phoneNumber);
        Assert.assertEquals(emptySearchResult.getText(), "No patients match");
        Assert.assertEquals(registerPatientLabel.getText(), "Patient is not registered");
        Assert.assertTrue(registerAsNewPatientButton.isDisplayed());
    }
}
