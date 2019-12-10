package pages.patientPrimaryInformation;

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
import pages.BasePage;
import utils.Date;
import utils.RandomValue;
import utils.ScenarioContextKeys;

import java.util.List;

public class BpSection extends BasePage {
    private AppiumDriver driver;

    @FindBy(id = "bloodpressureentry_systolic")
    private MobileElement systolicBp;

    @FindBy(id = "bloodpressureentry_diastolic")
    private MobileElement diastolicBp;

    @FindBy(id = "systolicEditText")
    private MobileElement systolicEditText;

    @FindBy(id = "diastolicEditText")
    private MobileElement diastolicEditText;

    @FindBy(id = "bloodpressureentry_next_arrow")
    private WebElement nextArrow;

    @FindBy(id = "dayEditText")
    private WebElement day;

    @FindBy(id = "monthEditText")
    private WebElement month;

    @FindBy(id = "yearEditText")
    private WebElement year;

    @FindBy(id = "newBp")
    private WebElement addNewBpButton;

    @FindBy(id = "alertTitle")
    private WebElement updatePopupText;

    @FindBy(id = "android:id/button1")
    private WebElement savePhoneNumberButton;

    @FindBy(id = "android:id/button2")
    private WebElement skipPhoneNumberButton;

    @FindBy(id = "patientsummary_item_bp_days_ago")
    private WebElement daysAgoInfo;

    @FindBy(id = "removeBloodPressureButton")
    private WebElement removeLink;

    @FindBy(id = "android:id/button1")
    private WebElement removeButton;

    @FindBy(id = "android:id/button2")
    private WebElement cancelButton;

    @FindBy(id = "patientsummary_item_bp_placeholder")
    private WebElement bpSummary;

    @FindBy(id = "patientsummary_item_layout")
    private List<WebElement> summaryLayout;

    @FindBys({@FindBy(id = "patientsummary_item_bp_readings")})
    private List<WebElement> bpReadings;

    @FindBy(id = "bpDateButton")
    private WebElement bpDate;

    @FindBy(id = "patientsummary_item_layout")
    private WebElement bpLayout1;

    private By heartIcon = By.id("patientsummary_bp_reading_heart");
    private By bpLevel = By.id("patientsummary_item_bp_level");
    private By daysAgo = By.id("patientsummary_item_bp_days_ago");
    private By reading = By.id("patientsummary_item_bp_readings");

    @FindBy(id = "addphone_phone")
    private MobileElement phoneNumberTextFeild;

    @FindBy(id = "updatephone_phone")
    private WebElement updatePhoneNumberTextFeild;

    public BpSection(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }

    public void enterBpInfo(String systolic, String diastolic) {

        String reading = systolic + " / " + diastolic;
        ScenarioContext.putData("User", ScenarioContextKeys.READING, reading);
        systolicBp.setValue(systolic);
        diastolicBp.setValue(diastolic);
    }

    public void tapsOnNextArrow() {
        nextArrow.click();
    }

    public void entersDate(String sDate) {
        String[] str = sDate.split("-");
        String dd = str[0];
        String mm = str[1];
        String yy = str[2];

        bpDate.click();
        waitForElementToBeClickable(day);
        day.clear();
        day.sendKeys(dd);
        month.clear();
        month.sendKeys(mm);
        pressEnter();
    }

    public void tapsOnAddNewBpButton() {
        addNewBpButton.click();
    }

    public void addPhoneNumber() {
        phoneNumberTextFeild.setValue(RandomValue.getRandomPhoneNumber());
        savePhoneNumberButton.click();
    }

    public void verifiesUpdatePopUp() {
        Assert.assertTrue(updatePopupText.getText().equals("Update phone number"));
    }

    public void tapsOnSkipButton() {
        skipPhoneNumberButton.click();
    }

    public void enterBackDate() {
        entersDate(Date.getBackDateIn_DD_MM_YYYY_Format(10));
    }

    public void tapsOnEditBpLink() {
        daysAgoInfo.click();
    }

    public void tapsOnRemoveLink() {
        removeLink.click();
    }

    public void tapsOnCancelButton() {
        cancelButton.click();
    }

    public void tapsOnRemoveButton() {
        removeButton.click();
    }

    public void verifiesBpSummary() {
        Assert.assertTrue(bpSummary.getText().equals("No blood pressures added"), "No Blood pressure added text should be displayed");
    }

    public int getSummaryLayoutCount() {
        return summaryLayout.size();
    }

    public void verfiesBpList() {
        if (getSummaryLayoutCount() == 0) {
            Assert.fail("Bp list should be displayed");
        }
        String bpCount=ScenarioContext.getData("User",ScenarioContextKeys.BPCOUNT);
        int expectedValue=Integer.parseInt(bpCount)-1;
        Assert.assertEquals(bpReadings.size(),expectedValue,"bp count should dec by 1 as one bpvalue is removed");
        // need to check that removed bp should not be present if we are removing one bp
    }

    public void removeAllBpInfo() {
        for (WebElement ele : summaryLayout) {
            tapsOnEditBpLink();
            tapsOnRemoveLink();
            tapsOnRemoveButton();
        }
    }

    public void updatePhonenumber() {
        updatePhoneNumberTextFeild.sendKeys(RandomValue.getRandomPhoneNumber());
        savePhoneNumberButton.click();
    }

    public void verifiesDaysInformationForBackDate(String value) {
        for (WebElement ele : bpReadings) {
            if (ele.getText().equals(value)) {

                WebElement bpLayout = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'" + value + "')]/.."));
                bpLayout.findElement(reading).getText().equals(value);
                bpLayout.findElement(bpLevel).isDisplayed();
                bpLayout.findElement(heartIcon).isDisplayed();
                Assert.assertTrue(bpLayout.findElement(daysAgo).getText().replaceAll("[^a-zA-Z0-9]", "").contains("10daysago"));
            }
        }
    }

    public void verifiesDaysInfo(String value) {
        for (WebElement ele : bpReadings) {
            if (ele.getText().equals(value)) {
                WebElement bpLayout = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'" + value + "')]/.."));
                bpLayout.findElement(reading).getText().equals(value);
                bpLayout.findElement(bpLevel).isDisplayed();
                bpLayout.findElement(heartIcon).isDisplayed();
                Assert.assertTrue(bpLayout.findElement(daysAgo).getText().replaceAll("[^a-zA-Z0-9]", "").contains("Today"));
            }
        }
    }

    public void updateBpInfo(String systolic, String diastolic) {

        String reading = systolic + " / " + diastolic;
        ScenarioContext.putData("User", ScenarioContextKeys.READING, reading);

        systolicEditText.click();
        systolicEditText.clear();
        diastolicEditText.click();
        diastolicEditText.clear();


        systolicEditText.setValue(systolic);
        diastolicEditText.setValue(diastolic);
    }

    public void noBpPresent() {
        Assert.assertEquals(getSummaryLayoutCount(),0);
    }
}
