package steps;

import com.embibe.optimus.utils.ScenarioContext;
import com.testvagrant.commons.utils.JsonUtil;
import com.testvagrant.monitor.exceptions.DeviceReleaseException;
import com.testvagrant.optimus.device.OptimusController;
import cucumber.api.Result;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import qaApiServices.deleteUser.DeleteApi;
import utils.OptimusImpl;
import utils.ScenarioContextKeys;

import java.io.IOException;


public class StartingSteps extends BaseSteps {

    @Before
    public void setUp(Scenario scenario) throws Exception {
        String buildEnv = System.getProperty("testFeed");
        ScenarioContext.putData("User", ScenarioContextKeys.ENV, buildEnv);

        String country = System.getProperty("env");
        ScenarioContext.putData("User", ScenarioContextKeys.COUNTRY, country);

        String testFeed = System.getProperty("testFeed") + ".json";
        String appJson = new JsonUtil().getAppJson(testFeed);
        controller = new OptimusController(appJson, scenario);
        smartBOTs = controller.registerSmartBOTs();
        System.out.println("Appium Services are..." + smartBOTs.size());
        smartBOTs.forEach(smartBOT -> System.out.println(smartBOT.getAppiumService()));
        optimus = new OptimusImpl(smartBOTs);

    }

    @After
    public void tearDown(Scenario scenario) throws IOException, DeviceReleaseException {
        Result.Type status = scenario.getStatus();
        if (status.equals(Result.Type.FAILED) || status.equals(Result.Type.UNDEFINED) || status.equals(Result.Type.PENDING)
                || status.equals(Result.Type.AMBIGUOUS)) {
            try {
                if (scenario.isFailed()) {
                    byte[] failedScreens = optimus.getScreenCapture();
                    scenario.embed(failedScreens, "image/png");
                }
            } catch (Exception e) {
                System.out.println("some platform doesn't support screenshot");
            }
        }
        try {
            getChromeDriver().quit();
        } catch (Exception e1) {
        } finally {
//            new DeleteApi().DeleteUser();
            controller.deRegisterSmartBOTs(smartBOTs);
        }
    }
}

