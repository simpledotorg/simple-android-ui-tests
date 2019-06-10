package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MedicineSection extends BasePage {
    private AppiumDriver driver;

    public MedicineSection(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "patientsummary_prescriptions_update")
    private WebElement addNewMedicineButton;

    public void tapsOnAddNewMedicineButton(){
        addNewMedicineButton.click();
    }
}
