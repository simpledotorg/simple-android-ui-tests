package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.HomePage;
import qaApiServices.appointments.CreateAppointment;

public class HomePageSteps extends BaseSteps {
    @And("^(\\w+) verifies homepage$")
    public void userVerifiesHomepage(String User) {
        new HomePage(getDriverInstanceFor(User)).verifyHomePage();
    }

    @And("^(\\w+) on Homepage taps on (.*) Tab$")
    public void userTapsOnOverdueTab(String User,String tab) {
        new HomePage(getDriverInstanceFor(User)).selectTab(tab);
    }
    @And("^(\\w+) navigates back$")
    public void userNavigatesBack(String User) {
        new HomePage(getDriverInstanceFor(User)).navigateBack();
    }

    @And("^(\\w+) taps on back button$")
    public void userTapsOnBackButton(String User) throws Throwable {
        new HomePage(getDriverInstanceFor(User)).tapsOnBackButton();
    }

}
