package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pages.LoginPage;

public class LaunchAppSteps extends BaseSteps {
    @Given("^(\\w+) Launches app$")
    public void launchApp(String User) {
        getDriverInstanceFor(User);
    }

    @And("^(\\w+) resets app$")
    public void userResetsApp(String User) { new LoginPage(getDriverInstanceFor(User)).resetApp();
    }
}
