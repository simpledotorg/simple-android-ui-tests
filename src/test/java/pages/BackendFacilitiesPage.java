package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BackendFacilitiesPage extends BasePage {
    JavascriptExecutor js = null;

    @FindBy(css = "input.btn.btn-outline-danger")
    private WebElement deleteButton;

    public BackendFacilitiesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(wd, this);
        js = (JavascriptExecutor) wd;
    }

    //to select option from manage overlay
    public void selectManageOption(String option) {
        wd.findElement(By.id("navbarDropdown")).click();
        wd.findElement(By.xpath("//div[@class='dropdown-menu show']/a[contains(text(),'" + option + "')]")).click();
    }

    //one can allow or deny access from Manage>facilities page
    // In qa env as user got auto approved,we cannot set access from dashboard user view section.
    public void denyUserAccess(String userName) {

        wd.findElement(By.xpath("//*[text()='"+userName+"']")).click();
        wd.findElement(By.xpath("//*[text()='Deny access']")).click();

        js.executeScript("document.getElementById('reason_for_denial').setAttribute('value', 'mobile incorrect')");
        js.executeScript("arguments[0].click();", deleteButton);
    }

    public void allowUserAccess(String userName){
        wd.findElement(By.xpath("//*[text()='"+userName+"']")).click();
        wd.findElement(By.xpath("//*[text()='Allow access']")).click();
        wd.switchTo().alert().accept();
    }

    public void selectFacility(String facilityName) {
        wd.findElement(By.xpath("//*[text()='" + facilityName + "']")).click();
    }
}
