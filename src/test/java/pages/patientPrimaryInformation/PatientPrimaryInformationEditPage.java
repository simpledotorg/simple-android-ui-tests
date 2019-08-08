package pages.patientPrimaryInformation;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class PatientPrimaryInformationEditPage extends BasePage {
    private AppiumDriver driver;

    public PatientPrimaryInformationEditPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private By edit_phone_number_TextBox = By.id("patientedit_phone_number");
    private By edit_age_TextBox = By.id("patientedit_age");
    private By edit_colony_TextBox = By.id("patientedit_colony_or_village");

    @FindBy(className = "android.widget.Button")
    private WebElement saveButton;

    public void updatePatientInfo(String phone, String age, String colony) {
        waitForElementToBeVisible(saveButton);
        driver.findElement(edit_phone_number_TextBox).sendKeys(phone);
        driver.findElement(edit_age_TextBox).sendKeys(age);
        driver.findElement(edit_colony_TextBox).sendKeys(colony);

        saveButton.click();
    }

    public void addNewPhoneNumber(String phone) {
        driver.findElement(edit_phone_number_TextBox).sendKeys(phone);
        saveButton.click();
    }
}
