package pages;

import com.embibe.optimus.utils.ScenarioContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import qaApiServices.patients.GetPatientInfo;
import qaApiServices.user.RegisterUser;
import utils.ScenarioContextKeys;

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
        waitFor(2000);
        nextButton.click();
    }

    public void searchForRegisteredPatientWithBpInfo(String patientName) {
        searchPatient(patientName);

        waitFor(5000);

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
        waitForElementToBeVisible(emptySearchResult);
        Assert.assertEquals(emptySearchResult.getText(), "No patients match");
        Assert.assertEquals(registerPatientLabel.getText(), "Patient is not registered");
        Assert.assertTrue(registerAsNewPatientButton.isDisplayed());
    }

    public void searchForRegisteredPatientWithoutBPInfo(String patientName) {
        searchPatient(patientName);

        waitFor(5000);


        String status = "false";
        for (WebElement ele : header) {
            if (ele.getText().equalsIgnoreCase("Other Results")) {
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
        scrollToElement("Enter patient's name");
        searchPatientTextBox.click();
    }

    public void verifiesAlphabeticalLog() {
        Assert.assertTrue(facilityLabel.getText().toUpperCase().contains("ALL PATIENTS"), "All Patient label is not displayed");

        new RegisterUser().registerNewUser();
        List<String> allPatientsName = new GetPatientInfo().getAllPatientsInfo();
        List<String> expectedPatientNameSortedList = allPatientsName.stream().sorted().collect(Collectors.toList());

        List<String> actualPatientName = new ArrayList<>();
        int count = 0;

        hideKeyboard();

        while (count <= allPatientsName.size()) {
            for (WebElement p : patientList) {
                actualPatientName.add(p.getText().split(",")[0].toUpperCase());
                count++;
            }
            scrollDown();
        }
        expectedPatientNameSortedList.equals(actualPatientName);
    }

    public void searchForRegisteredPatientByPhoneNumber(String phoneNumber) {
        searchPatient(phoneNumber);
        Assert.assertTrue(patientList.size() == 1, " only one result should be displayed for unique phonennumber");
    }

    public void searchForRegisteredPatientByDuplicatePhoneNumber(String phoneNumber) {
        searchPatient(phoneNumber);
        Assert.assertTrue(patientList.size() == 2, "only 2 patient should be forduplicate phonenNumber");
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

    public void verifiesResultForRegisteredPatientWithBpPassport() {
        String status = "false";
        for (WebElement ele : header) {
            if (ele.getText().toUpperCase().contains("HAS VISITED")) {
                status = "true";
                break;
            }
        }
        Assert.assertEquals(status, "true", "has visited section isn't displayed");
        Assert.assertTrue(registerAsNewPatientButton.isDisplayed());
        String patientName = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_NAME);
        verifyPatientInfo(patientName);
    }

    @FindBy(xpath = "//android.widget.LinearLayout/android.widget.LinearLayout")
    private WebElement resultBlock;

    private By genderLabel = By.id("genderLabel");
    private By nameLabel = By.id("patientNameAgeGenderLabel");
    private By phoneNumberLabel = By.id("phoneNumberLabel");
    private By text = By.id("android.widget.TextView");
    private By lastBpLabel = By.id("lastBpLabel");
    private By addressLabel = By.id("addressLabel");
    


    public void verifyPatientInfo(String pName) {
        isElementPresent(genderLabel);
        resultBlock.findElement(nameLabel).getText().split(",")[0].toUpperCase().equals(pName);
        isElementPresent(addressLabel);
        String varNumber = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_PHONE_NUMBER);
        resultBlock.findElement(phoneNumberLabel).getText().equals(varNumber);
        isElementPresent(text);

//        resultBlock.findElement(lastBpLabel).getText().equals();
    }

    private void verifyPatientInfo(String pName ,String value) {
        isElementPresent(genderLabel);
        resultBlock.findElement(nameLabel).getText().split(",")[0].toUpperCase().equals(pName);
        isElementPresent(addressLabel);

        if (value.equals("withoutPhonenumber")) {
            Assert.assertFalse(isElementPresent(phoneNumberLabel));
//            resultBlock.findElement(lastBpLabel).getText().equals();

        } else if (value.equals("withoutBp")) {
            Assert.assertFalse(isElementPresent(lastBpLabel));
            String varNumber = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_PHONE_NUMBER);
            resultBlock.findElement(phoneNumberLabel).getText().equals(varNumber);

        } else if (value.equals("withoutPhonenumberAndBp")) {
            Assert.assertFalse(isElementPresent(phoneNumberLabel));
            Assert.assertFalse(isElementPresent(lastBpLabel));

        } else {

            String varNumber = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_PHONE_NUMBER);
            resultBlock.findElement(phoneNumberLabel).getText().equals(varNumber);
            isElementPresent(text);
//            resultBlock.findElement(lastBpLabel).getText().equals();
        }
    }

    public void searchForPatientFromOtherFacility(String pName, String... paramValue) {
        searchPatient(pName);
        String status = "false";
        for (WebElement ele : header) {
            if (ele.getText().equalsIgnoreCase("Other Results")) {
                status = "true";
            }
        }
        Assert.assertEquals(status, "true", "other result section isn't displayed");
        verifyPatientInfo(pName,paramValue[0]);
    }

    public void searchForPatientFromOtherFacility(String pName) {
        searchPatient(pName);
        String status = "false";
        for (WebElement ele : header) {
            if (ele.getText().equalsIgnoreCase("Other Results")) {
                status = "true";
            }
        }
        Assert.assertEquals(status, "true", "other result section isn't displayed");
        verifyPatientInfo(pName);
    }
}

