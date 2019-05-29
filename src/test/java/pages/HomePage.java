package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(id = "home_facility_change_button")
    private WebElement faciltiyChangeButton;

    @FindBy(className = "androidx.appcompat.app.ActionBar$Tab")
    private List<WebElement> Tabs;

    private AppiumDriver driver;

    public HomePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public void verifyHomePage() {
        waitForElementToBeVisible(faciltiyChangeButton);
        Assert.assertTrue(faciltiyChangeButton.getText().contains("CHC Bagta"));
        Assert.assertEquals(Tabs.size(), 3);
    }
}
