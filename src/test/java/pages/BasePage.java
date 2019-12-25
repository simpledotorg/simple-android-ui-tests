package pages;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    private AppiumDriver driver;
    private WebDriverWait wait;
    protected WebDriver wd;


    @FindBy(xpath = "//android.widget.ImageButton[@content-desc = 'Navigate up']")
    protected WebElement backButton;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);
    }

    public BasePage(WebDriver driver) {
        this.wd = driver;
        wait = new WebDriverWait(wd, 30);
    }

    public boolean allowPermissionPopup() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        try {
            By allowXpath = By.xpath("//*[@text='Allow']");
            WebElement acceptElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(allowXpath));
            acceptElement.click();
            acceptElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(allowXpath));
            acceptElement.click();
            return true;
        } catch (TimeoutException e) {
        }
        return false;
    }

    public void waitForElementToBeVisible(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForElementToBeVisible(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {

        }
    }

    public WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeSelected(WebElement element) {
        wait.until(ExpectedConditions.elementSelectionStateToBe(element, true));
    }

    public void waitForElementToBeRefreshed(WebElement element) {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
    }

    public void waitForElementToBeRefreshed(By by) {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(by)));
    }

    public void waitForElementToBeClickable(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement waitForPresenceOfElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForPresenceOfAllElements(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public boolean waitForTextToBePresentInElement(By by, String text) {
        try {
            if (wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text)))
                return true;
        } catch (TimeoutException e) {
            return false;
        }
        return false;
    }

    public boolean waitForTextToBeNonEmpty(final By by) {
        (new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(by).getText().length() != 0;
            }
        });
        return false;
    }


    public void waitForInvisibilityOfElementByText(By by, String text) {
        wait.until(ExpectedConditions.invisibilityOfElementWithText(by, text));
    }

    public void waitForElementToBeInvisible(By by) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitForElementToBeChecked(WebElement element) {
        wait.until(elementToBeChecked(element));
    }

    private static ExpectedCondition<WebElement> elementToBeChecked(
            final WebElement element) {
        return new ExpectedCondition<WebElement>() {

            public ExpectedCondition<WebElement> visibilityOfElement =
                    ExpectedConditions.visibilityOf(element);

            @Override
            public WebElement apply(WebDriver driver) {
                WebElement element = visibilityOfElement.apply(driver);
                try {
                    if (element != null && element.getAttribute("checked").equals("true")) {
                        return element;
                    } else {
                        return null;
                    }
                } catch (StaleElementReferenceException e) {
                    return null;
                }
            }

            @Override
            public String toString() {
                return "element to be checked : " + element;
            }
        };
    }

    public void tapOnBackButton() {
        waitForElementToBeClickable(backButton);
        backButton.click();
    }

    public void sendKeys(WebElement elem, String text) {
        waitForElementToBeClickable(elem);
        elem.click();
        if (text != null) {
            if (!elem.getText().isEmpty()) {
                elem.clear();
            }
            elem.sendKeys(text);
        } else {
            Assert.assertNotNull(elem.getText());
        }
        driver.getKeyboard();
        hideKeyboard();
    }

    public void hideKeyboard() {
        try {
            driver.hideKeyboard();
        } catch (WebDriverException e) {
        }
    }

    public void clickBy(By by) {
        waitForElementToBeClickable(by);
        driver.findElement(by).click();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean clickAny(By... bys) {
        for (By by : bys)
            if (!driver.findElements(by).isEmpty()) {
                driver.findElement(by).click();
                waitForElementToBeInvisible(by);
                return true;
            }
        return false;
    }

    public void scrollDown() {

        Dimension size = driver.manage().window().getSize();

        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.4);
        int x = (size.width / 2);

        System.out.println(startY + "" + endY + "" + x);

        new TouchAction(driver).press(PointOption.point(x, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(x, endY))
                .release().perform();
    }

    public void pressEnter() {
        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "done"));
    }

    public void pressSearchButton() {
        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
    }


    public void runAppInBackgroudAndrelaunch() {
        driver.runAppInBackground(Duration.ofSeconds(1));
    }

    public String getAllDigitsInString(String str) {
        String expStr = "";
        for (int i = 0; i <= str.length() - 1; i++) {
            if (Character.isDigit(str.charAt(i))) {
                expStr = expStr + str.charAt(i);
            }
        }
        return expStr;
    }

    public void waitFor(int timeunit) {
        try {
            Thread.sleep(timeunit);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String scrollToElement(String text) {

        try {
            MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+text+"\").instance(0))"
            ));
            return "true";
        } catch (Exception e) {
            return "false";
        }

    }
}
