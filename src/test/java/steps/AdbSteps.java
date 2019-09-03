package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import utils.AdbUtils;

public class AdbSteps  extends BaseSteps{
    @And("^(\\w+) run app in Background and relaunch it$")
    public void userRunAppInBackgroundAndRelaunchIt() {
        new AdbUtils().relaunchApp();
    }
}
