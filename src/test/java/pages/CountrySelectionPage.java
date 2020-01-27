package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CountrySelectionPage extends BasePage {
    private AppiumDriver driver;

    public CountrySelectionPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(id="contentContainer")
    private WebElement contentContainer;

    @FindBy(className = "android.widget.TextView")
    private WebElement selectYourContryText;

    @FindBy(id="nextButton")
    private WebElement nextButton;

   private void tapsOnCountryRadioButton(String country){
       driver.findElement(By.xpath("//android.widget.RadioButton[contains(@text,'"+country+"')]")).click();
   }

   private void tapsOnNextButton(){
       waitForElementToBeVisible(nextButton);
       nextButton.click();
   }

   public void selectCountry(String country){
       waitForElementToBeVisible(selectYourContryText);
       tapsOnCountryRadioButton(country);
       tapsOnNextButton();
   }
}
