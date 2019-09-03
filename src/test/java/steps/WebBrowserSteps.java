package steps;

import com.embibe.optimus.utils.ScenarioContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.BackendDashboardPage;
import utils.ScenarioContextKeys;

public class WebBrowserSteps extends BaseSteps {
    public WebBrowserSteps() {
        createChromeDriver();
    }

    @And("^Login as Server Admin$")
    public void loginAsServerAdmin() {
        new BackendDashboardPage(getChromeDriver()).loginInAsServerAdmin();
    }

    @Then("^Server Admin denies request from backend$")
    public void userDenyRequestFromBackend()  {
        String username=ScenarioContext.getData("User",ScenarioContextKeys.USER_NAME);
        new BackendDashboardPage(getChromeDriver()).denyUserAccess(username);
    }

    @Then("^Server Admin allows access for user from backend$")
    public void serverAdminAllowsAccessForUserFromBackend(){
        new BackendDashboardPage(getChromeDriver()).allowUserAccess();
    }
}
