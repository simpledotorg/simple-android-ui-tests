package steps;

import cucumber.api.java.en.Given;

public class LaunchAppSteps extends BaseSteps{
    @Given("^(\\w+) Launches app$")
    public void launchApp(String User) {
      getDriverInstanceFor(User);
    }
}
