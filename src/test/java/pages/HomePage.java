package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(id = "home_facility_change_button")
    private WebElement faciltiyChangeButton;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Overdue')]")
    private WebElement overdueTab;

    @FindBy(id= "backButton")
    private WebElement backbutton;


    private AppiumDriver driver;

    public HomePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void verifyHomePage() {
        waitForElementToBeVisible(faciltiyChangeButton);
        Assert.assertTrue(faciltiyChangeButton.getText().contains("CHC Bagta"));
    }

    public void selectTab(String name) {
        waitForElementToBeVisible(overdueTab);
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'" + name + "')]")).click();
    }

    public void tapsOnBackButton() {
        backbutton.click();
    }
}
