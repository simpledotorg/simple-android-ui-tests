package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class PatientPrimaryInfoSection extends BasePage {

    private AppiumDriver driver;

    @FindBy(id = "patiententry_phone_number")
    private WebElement PhoneNumberTextBox;

    @FindBy(id = "patiententry_age")
    private WebElement ageTextBox;

    @FindBys({
            @FindBy(className = "android.widget.RadioButton")
    })
    private List<WebElement> gender;

    @FindBy(id = "patiententry_colony_or_village")
    private WebElement colonyTextBox;

    @FindBy(id = "patiententry_district")
    private WebElement districtTextBox;

    @FindBy(id = "patiententry_state")
    private WebElement stateTextBox;
    
    @FindBy(className = "android.widget.Button")
    private WebElement nextButton;

    @FindBy(xpath="//android.widget.TextView[contains(@text,'Phone number cannot be less than 6 digits')]")
    private WebElement phoneNumberErrorMsg;

    @FindBy(id="patiententry_gender_validation_error")
    private WebElement genderValidationerrorMsg;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Enter colony / village / ward')]")
    private WebElement colonyValidationerrorMsg;

//    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Enter patient’s age')]")
//    private WebElement AgeValidationerrorMsg;

    @FindBy(id="patiententry_date_of_birth")
    private WebElement enterDateOfBirth;


    public PatientPrimaryInfoSection(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private void enterPhoneNumber(String number) {
        PhoneNumberTextBox.sendKeys(number+"\n");
    }

    private void enterAge(String age) {
        ageTextBox.sendKeys(age+"\n");
    }

    private void enterGender(String value) {
        System.out.println(gender.size()+"genderSize");
        for (WebElement ele : gender) {
            System.out.println(ele.getText());
            if (ele.getText().equals(value)) {
                ele.click();
            }
        }
    }

    private void enterColony(String value){
        colonyTextBox.sendKeys(value+"\n");
    }

    public void enterDistrict(String value){
        districtTextBox.sendKeys(value+"\n");
    }

    public void enterState(String value){
        stateTextBox.sendKeys(value+"\n");
    }
    
    public void clickNextButton(){
        nextButton.click();
    }

    public void enterPatientInfo(String phone,String age,String gender,String colony){
        enterPhoneNumber(phone);
        enterAge(age);
        enterGender(gender);
        enterColony(colony);
        Assert.assertTrue(districtTextBox.getText().equalsIgnoreCase("Bathinda"));
        Assert.assertTrue(stateTextBox.getText().equalsIgnoreCase("Punjab"));
        clickNextButton();
    }

    public void validateErrorMessage(){
        Assert.assertTrue(phoneNumberErrorMsg.isDisplayed());
//        Assert.assertTrue(genderValidationerrorMsg.getText().contains("Choose gender"));
        Assert.assertTrue(colonyValidationerrorMsg.isDisplayed());
//        Assert.assertTrue(AgeValidationerrorMsg.isDisplayed());
    }

    public void enterPatientInvalidPatientInfo(String phonenumber) {
        enterPhoneNumber(phonenumber);
        clickNextButton();
        driver.hideKeyboard();
    }

    public void enterInvalidDate(String sDate) {
        enterDateOfBirth.sendKeys(sDate);
        clickNextButton();
//        need to add ASSERTION when defect will get fixed
    }
}
