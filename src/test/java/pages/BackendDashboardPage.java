package pages;

import com.embibe.optimus.utils.ScenarioContext;
import constants.BackendDashboardConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ScenarioContextKeys;

public class BackendDashboardPage extends BasePage {

    public BackendDashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(wd, this);
    }
}
