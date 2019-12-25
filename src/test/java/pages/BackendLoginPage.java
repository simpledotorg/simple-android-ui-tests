package pages;

import com.embibe.optimus.utils.ScenarioContext;
import constants.BackendDashboardConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ScenarioContextKeys;

public class BackendLoginPage extends BasePage {

    @FindBy(id = "email_authentication_email")
    private WebElement email;

    @FindBy(id = "email_authentication_password")
    private WebElement password;

    @FindBy(css = "input.btn.btn-primary")
    private WebElement loginButton;

    public BackendLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(wd, this);
    }

    public void loginInAsServerAdmin() {

        String env= ScenarioContext.getData("User",ScenarioContextKeys.ENV);
        if (env.contains("QA")) {
            email.sendKeys(BackendDashboardConstants.QAADMIN);
            password.sendKeys(BackendDashboardConstants.QAPASSWORD);
        }else{
            email.sendKeys(BackendDashboardConstants.SBXADMIN);
            password.sendKeys(BackendDashboardConstants.SBXASSWORD);
        }

        loginButton.click();
    }
}
