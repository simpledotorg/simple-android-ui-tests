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
    


    public PatientPrimaryInfoSection(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private void enterPhoneNumber(String number) {
        PhoneNumberTextBox.sendKeys(number);
    }

    private void enterAge(String age) {
        ageTextBox.sendKeys(age);
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
        colonyTextBox.sendKeys(value);
    }

    public void enterDistrict(String value){
        districtTextBox.sendKeys(value);
    }

    public void enterState(String value){
        stateTextBox.sendKeys(value);
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
}
