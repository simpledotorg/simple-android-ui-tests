package pages;

import com.embibe.optimus.utils.ScenarioContext;
import constants.BackendDashboardConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ScenarioContextKeys;

public class BackendDashboardPage extends BasePage {

    @FindBy(id = "email_authentication_email")
    private WebElement email;

    @FindBy(id="email_authentication_password")
    private WebElement password;

    @FindBy(css = "input.btn.btn-primary")
    private WebElement loginButton;

    public BackendDashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(wd, this);
    }

    public void loginInAsServerAdmin() {
        email.sendKeys(BackendDashboardConstants.ADMIN);
        password.sendKeys(BackendDashboardConstants.PASSWORD);
        loginButton.click();
    }

    public void denyUserAccess(String username) {
        System.out.println(username+"username");
        wd.findElement(By.id("navbarDropdown")).click();
        wd.findElement(By.xpath("//div[@class=\"dropdown-menu show\"]/a[contains(text(),\"Facilities\")]")).click();
        wd.findElement(By.xpath("//*[contains(text(), 'CHC Bagta')]")).click();
        wd.findElement(By.xpath("//*[contains(text(), '"+username+"')]")).click();
        wd.findElement(By.xpath("//*[contains(text(), 'Deny access')]")).click();
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.getElementById('reason_for_denial').setAttribute('value', 'mobile incorrect')");

        WebElement element = wd.findElement(By.cssSelector("input.btn.btn-outline-danger"));
        js.executeScript("arguments[0].click();", element);
    }

    public void allowUserAccess() {
        String name=ScenarioContext.getData("User",ScenarioContextKeys.USER_NAME);

        wd.findElement(By.id("navbarDropdown")).click();
        wd.findElement(By.xpath("//div[@class=\"dropdown-menu show\"]/a[contains(text(),\"Facilities\")]")).click();
        wd.findElement(By.xpath("//*[contains(text(), 'CHC Bagta')]")).click();
        wd.findElement(By.xpath("//*[contains(text(), '"+name+"')]")).click();
        wd.findElement(By.xpath("//*[contains(text(), 'Allow access')]/../input")).click();
        wd.switchTo().alert().accept();
    }
}
