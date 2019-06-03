package pages;

import io.appium.java_client.AppiumDriver;
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

    public void tapsOnNextButton() {
        NextButton.click();
    }
}
