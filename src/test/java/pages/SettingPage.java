package pages;

import com.embibe.optimus.utils.ScenarioContext;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ScenarioContextKeys;

public class SettingPage extends BasePage {

    private AppiumDriver driver;
    private SettingLanguagePage settingLanguagePage;


    public SettingPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        settingLanguagePage = new SettingLanguagePage(driver);
    }

    @FindBy(id = "toolbar")
    private WebElement toolBar;

    private By backButton = By.className("android.widget.ImageButton");
    private By string = By.className("android.widget.TextView");

    @FindBy(className = "android.view.View")
    private WebElement settingLayout;

    private By userName = By.id("userName");
    private By userNumber = By.id("userNumber");
    private By changeLanguageButton = By.id("changeLanguageButton");

    @FindBy(id="currentLanguage")
    private WebElement currentLanguage;


    public void verifySettingScreen() {
        driver.findElement(userName).getText().equals(ScenarioContext.getData("User", ScenarioContextKeys.USER_NAME));
        driver.findElement(userNumber).getText().equals(ScenarioContext.getData("User", ScenarioContextKeys.USER_PHONENUMBER));
        waitFor(500);
        currentLanguage.getText().equals("Select a language");
        isElementPresent(changeLanguageButton);
    }

    public void tapsOnChangeButton() {
        driver.findElement(changeLanguageButton).click();
    }

    public void selectALanguageAndVerifyLanguageSelection(String lang) {
        settingLanguagePage.selectLanguage(lang);
        settingLanguagePage.selectDoneButton();
        String text = currentLanguage.getText();
        Assert.assertEquals("selected language isn't displayed in select language screen",text,lang);
    }

    public void selectDoneButton() {
        settingLanguagePage.selectDoneButton();
    }

    public void selectALanguage(String lang){
        settingLanguagePage.selectLanguage(lang);
    }

    public void verifyDefaultText() {
        String text = currentLanguage.getText();
        Assert.assertEquals("selected language isn't displayed in select language screen",text,"Select a language");
    }
}
