package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;

public class RecentPatientPage extends BasePage{

    AppiumDriver driver;

    public RecentPatientPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void isPatientPresent(String patientName) {
        
    }

    public void isPatientNotPresent(String patientName) {
    }

    public void verifiesSeeAllOption() {
    }

    public void selectPatientFromRecentPatientList(){

    }
}
