package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class RecentPatientSection  extends BasePage{

    private AppiumDriver driver;

    @FindBys({@FindBy(id = "recentpatient_item_title")})
    private List<WebElement> recentPatientNameList;

    @FindBy(id = "seeall_button")
    private WebElement seeAllButton;

    @FindBy(id="statusBarBackground")
    private WebElement background;


    public RecentPatientSection(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void verifiesSeeAllOption() {

        waitForElementToBeVisible(recentPatientNameList.get(0));
        for(int i=0;i<=5;i++)
        {
          try{
              seeAllButton.isDisplayed();
          }
          catch(Exception e){
//              scrollDown();
          }
        }
    }
}
