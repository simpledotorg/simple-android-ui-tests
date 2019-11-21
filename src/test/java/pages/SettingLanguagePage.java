package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingLanguagePage extends BasePage {
    private AppiumDriver driver;

    public SettingLanguagePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }

    @FindBy(id = "toolbar")
    private WebElement toolBar;

    private By backButton = By.className("android.widget.ImageButton");
    private By Text = By.className("android.widget.TextView");

    @FindBy(id = "doneButton")
    private WebElement doneButton;

    public void selectLanguage(String slanguage) {
         waitForElementToBeVisible(doneButton);
        driver.findElement(By.xpath("//android.widget.RadioButton[contains(@text,'" + slanguage + "')]")).click();
    }

    public void selectDoneButton() {
        doneButton.click();
    }
}
