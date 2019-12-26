package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlayStorePage extends BasePage {

    @FindBy(id="com.android.vending:id/right_button")
    private WebElement updateButton;

    @FindBy(id = "com.android.vending:id/right_button")
    private WebElement openButton;

    private AppiumDriver driver;

    public PlayStorePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickOnUpdateButton() {
        waitFor(3000);
        updateButton.click();
    }

    public void clickOnOpenButton() {
        waitFor(30000);
        waitForElementToBeVisible(openButton);
        openButton.click();
        waitFor(2000);
    }
}
