package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends BasePage {

    @FindBy(id = "facilitySelectButton")
    private WebElement facilityChangeButton;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'OVERDUE')]")
    private WebElement overdueTab;

    @FindBy(id= "backButton")
    private WebElement backbutton;

    @FindBy(id="openSettings")
    private WebElement settingIcon;

    private AppiumDriver driver;

    public HomePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void verifyHomePage() {
        waitForElementToBeVisible(facilityChangeButton);
        Assert.assertTrue(facilityChangeButton.getText().contains("CHC Bagta"));
    }

    public void selectTab(String name) {
        waitForElementToBeVisible(overdueTab);
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'" + name + "')]")).click();
    }

    public void tapsOnBackButton() {
        backbutton.click();
    }

    public void tapsOnSettingScreen() {
        settingIcon.click();
    }

}
