package utils;

import com.embibe.optimus.utils.ScenarioContext;
import constants.BackendDashboardConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchWebBrowser {

    WebDriver driver;

    public WebDriver getWebBrowser(String Browser) {

        if (Browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
            driver = new ChromeDriver();
            String env = ScenarioContext.getData("User", ScenarioContextKeys.ENV);

            System.out.println(env+"env");
            if (env.contains("QA")) {
                driver.get(BackendDashboardConstants.QAEnvUrl);
            } else {
                driver.get(BackendDashboardConstants.SandboxUrl);
            }
        }
        driver.manage().window().maximize();
        return driver;
    }
}
