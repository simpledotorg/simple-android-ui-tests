package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ScanCardPage extends BasePage {

    private AppiumDriver driver;

    public ScanCardPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "toolBar")
    private WebElement toolBar;

    private By backbutton = By.className("android.widget.ImageButton");
    private By Text = By.className("android.widget.TextView");

    private By scannerImage = By.id("viewFinderImageView");

    @FindBy(xpath="//android.widget.LinearLayout/android.widget.TextView")
    private WebElement shortCodeText;

    @FindBy(className = "android.widget.EditText")
    private WebElement shortCodeEditTextBox;

    public void verifiesPage() {

        isElementPresent(backbutton);
        Assert.assertTrue(toolBar.findElement(Text).getText().equals("Scan card ID"));

        isElementPresent(scannerImage);

        System.out.println(shortCodeText.getText()+"actual");
        Assert.assertTrue(shortCodeText.getText().equals("or type BP Passport number"),"text is different");
        Assert.assertTrue(shortCodeEditTextBox.getText().equals("123 4567"));

    }

    public void enterBpshortcodeValue(String value) {
        shortCodeEditTextBox.sendKeys(value);
        pressEnter();
    }
}
