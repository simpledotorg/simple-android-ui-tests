package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.HomePage;

public class HomePageSteps extends BaseSteps {
    @And("^(\\w+) verifies homepage$")
    public void userVerifiesHomepage(String User) {
        new HomePage(getDriverInstanceFor(User)).verifyHomePage();
    }

    @And("^(\\w+) on Homepage taps on (.*) Tab$")
    public void userTapsOnOverdueTab(String User,String tab) {
        new HomePage(getDriverInstanceFor(User)).selectTab(tab);
    }
}
