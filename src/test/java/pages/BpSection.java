package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BpSection  extends BasePage{
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

        String[] str=sDate.split("/");
        String dd=str[0];
        System.out.println(dd+"dd");
        String mm= str[1];
        String yy=str[2];
        waitForElementToBeClickable(day);
        day.sendKeys(dd + "\n");
    }

}
