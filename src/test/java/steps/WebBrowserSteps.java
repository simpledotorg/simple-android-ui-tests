package steps;

import com.embibe.optimus.utils.ScenarioContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.BackendDashboardPage;
import pages.BackendFacilitiesPage;
import pages.BackendLoginPage;
import utils.ScenarioContextKeys;

public class WebBrowserSteps extends BaseSteps {
    public WebBrowserSteps() {
        createChromeDriver();
    }

    @And("^Login as Server Admin$")
    public void loginAsServerAdmin() {
        new BackendLoginPage(getChromeDriver()).loginInAsServerAdmin();
    }

    @Then("^Server Admin allows access for user from backend$")
    public void serverAdminAllowsAccessForUserFromBackend(){
        String username=ScenarioContext.getData("User",ScenarioContextKeys.USER_NAME);
        new BackendFacilitiesPage(getChromeDriver()).allowUserAccess(username);
    }

    @And("^Server Admin denies user access from backend$")
    public void serverAdminDeniesUserAccessFromBackend() throws Throwable {
        String username=ScenarioContext.getData("User",ScenarioContextKeys.USER_NAME);
        new BackendFacilitiesPage(getChromeDriver()).denyUserAccess(username);
    }

    @And("^Server Admin selects (.*) option from manage overlay$")
    public void serverAdminSelectsFacilitiesOptionFromManageOverlay(String option)  {
        new BackendFacilitiesPage(getChromeDriver()).selectManageOption(option);
    }

    @And("^Server Admins selects facility name (.*)$")
    public void serverAdminsSelectsFacilityNameCHCBagta(String facName) throws Throwable {
        new BackendFacilitiesPage(getChromeDriver()).selectFacility(facName);
    }
}
