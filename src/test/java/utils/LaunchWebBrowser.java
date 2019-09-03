package utils;

import constants.BackendDashboardConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchWebBrowser {

    WebDriver driver;

    public WebDriver getWebBrowser(String Browser) {

        if (Browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
            driver = new ChromeDriver();
            driver.get(BackendDashboardConstants.QAEnvUrl);
        }
        driver.manage().window().maximize();
        return driver;
    }
}
