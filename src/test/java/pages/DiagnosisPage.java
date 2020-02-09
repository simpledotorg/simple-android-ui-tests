package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiagnosisPage extends BasePage {
    private AppiumDriver driver;

    public DiagnosisPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "newmedicalhistory_save")
    private WebElement NextButton;

    @FindBy(id = "diagnosisViewContainer")
    private WebElement diagnosisViewContainer;

    private By hypertension = By.id("hypertensionDiagnosisView");
    private By diabetes = By.id("diabetesDiagnosisView");
    private By yesCheckBox = By.id("yesCheckBox");

    public void tapsOnNextButton() {
        NextButton.click();
    }

    //this method will select diagnosis for hypertention and diabetes yes checkbox
    // this method can be improved to make it random selection of value
    //currently we don't have any test which assert any info based on diagnosis selectionn
    public void selectDiagnosis() {
        diagnosisViewContainer.findElement(hypertension).findElement(yesCheckBox).click();
        diagnosisViewContainer.findElement(diabetes).findElement(yesCheckBox).click();
    }
}
