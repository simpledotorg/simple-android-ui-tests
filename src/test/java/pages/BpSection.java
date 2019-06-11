package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.RandomValue;

import java.util.List;

public class BpSection extends BasePage {
    private AppiumDriver driver;

    @FindBy(id = "bloodpressureentry_systolic")
    private WebElement systolicBp;

    @FindBy(id = "bloodpressureentry_diastolic")
    private WebElement diastolicBp;

    @FindBy(id = "bloodpressureentry_next_arrow")
    private WebElement nextArrow;

    @FindBy(id = "bloodpressureentry_day")
    private WebElement day;

    @FindBy(id = "bloodpressureentry_month")
    private WebElement month;

    @FindBy(id = "bloodpressureentry_year")
    private WebElement year;

    @FindBy(id = "patientsummary_item_newbp")
    private WebElement addNewBpButton;

    @FindBy(id = "alertTitle")
    private WebElement updatePopupText;

    @FindBy(id = "android:id/button1")
    private WebElement savePhoneNumberButton;

    @FindBy(id = "android:id/button2")
    private WebElement skipPhoneNumberButton;

    @FindBy(id = "patientsummary_item_bp_days_ago")
    private WebElement daysAgoInfo;

    @FindBy(id = "bloodpressureentry_remove")
    private WebElement removeLink;

    @FindBy(id = "android:id/button1")
    private WebElement removeButton;

    @FindBy(id = "android:id/button2")
    private WebElement cancelButton;

    @FindBy(id = "patientsummary_item_bp_placeholder")
    private WebElement bpSummary;

    @FindBy(id = "patientsummary_item_layout")
    private List<WebElement> summaryLayout;


    public BpSection(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private void enterSystolicBp(String value) {
        systolicBp.sendKeys(value);
    }

    private void enterDiastolicBp(String value) {
        diastolicBp.sendKeys(value);
    }

    public void enterBpInfo(String systolic, String diastolic) {
        enterSystolicBp(systolic);
        enterDiastolicBp(diastolic);
    }

    public void tapsOnNextArrow() {
        nextArrow.click();
    }

    public void entersDate(String sDate) {

        String[] str = sDate.split("/");
        String dd = str[0];
        System.out.println(dd + "dd");
        String mm = str[1];
        String yy = str[2];
        waitForElementToBeClickable(day);
        day.sendKeys(dd);
        month.sendKeys(mm);
        year.sendKeys(yy + "\n");
    }

    public void tapsOnAddNewBpButton() {
        addNewBpButton.click();
    }


    @FindBy(id = "addphone_phone")
    private WebElement phoneNumberTextFeild;

    public void addPhoneNumber() {
        phoneNumberTextFeild.sendKeys(RandomValue.getRandomPhoneNumber());
        savePhoneNumberButton.click();
    }

    public void verifiesUpdatePopUp() {
        Assert.assertTrue(updatePopupText.getText().equals("Update phone number"));
    }

    public void tapsOnSkipButton() {
        skipPhoneNumberButton.click();
    }

    public void enterPastDate() {
//        need to add  past date function
        String pastDate = "01/06/19";
        entersDate(pastDate);
    }

    public void verifiesDaysInformation() {
        waitForElementToBeVisible(daysAgoInfo);
//        need to create data to assertt exact days info
        Assert.assertTrue(daysAgoInfo.getText().contains("days ago"));
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
        int count = getSummaryLayoutCount();
        if (count == 0) {
            Assert.fail("Bp list should be displayed");
        }
    }

    public void removeAllBpInfo() {

        System.out.println(summaryLayout.size() + "size");
        int size=summaryLayout.size();
        for (int i = 0; i <=size-1; i++) {
            tapsOnEditBpLink();
            tapsOnRemoveLink();
            tapsOnRemoveButton();
        }
    }
}
