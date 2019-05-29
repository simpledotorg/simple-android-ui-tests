package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import pages.HomePage;

public class HomePageSteps extends BaseSteps {
    @And("^(\\w+) verifies homepage$")
    public void userVerifiesHomepage(String User) {
        new HomePage(getDriverInstanceFor(User)).verifyHomePage();
    }
}
