package steps;

import com.embibe.optimus.utils.ScenarioContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import pages.ScanCardPage;
import utils.ScenarioContextKeys;

public class ScanCardSteps extends BaseSteps {

    @And("^(\\w+) on ScanCard Page verifies page$")
    public void UserOnScanCardPageVerifiesPage(String User) {
        new ScanCardPage(getDriverInstanceFor(User)).verifiesPage();
    }

    @And("^(\\w+) on ScanCard Page enters valid bpshortcode value$")
    public void userEntersValidBpshortcodeValue(String User) {
        String shortCode = ScenarioContext.getData("User", ScenarioContextKeys.BPSHORTCODE);
        new ScanCardPage(getDriverInstanceFor(User)).enterBpshortcodeValue(shortCode);
    }
}
