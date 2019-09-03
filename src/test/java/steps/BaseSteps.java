package steps;

import com.testvagrant.commons.entities.SmartBOT;
import com.testvagrant.optimus.device.OptimusController;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.LaunchWebBrowser;
import utils.OptimusImpl;

import java.util.List;

public class BaseSteps {
    protected static OptimusImpl optimus;
    protected static OptimusController controller;
    protected static List<SmartBOT> smartBOTs;
    private static WebDriver chromeDriver;

    protected AppiumDriver getDriverInstanceFor(String appConsumer) {
        return getSmartBOTBelongingTo(appConsumer).getDriver();
    }

    protected WebDriver createChromeDriver() {
        chromeDriver =  new LaunchWebBrowser().getWebBrowser("Chrome");
        return chromeDriver;
    }

    protected WebDriver getChromeDriver(){
        return  chromeDriver;
    }

    protected SmartBOT getSmartBOTBelongingTo(String appConsumer) {
        return optimus.findBOTFor(appConsumer);
    }
}
