package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import pages.PlayStorePage;

public class PlayStoreSteps extends BaseSteps {
    @And("^(\\w+) taps on Update button in play store$")
    public void tapsOnUpdateButtonInPlayStore(String User) {
        new PlayStorePage(getDriverInstanceFor(User)).clickOnUpdateButton();
    }

    @And("^(\\w+) taps on open button$")
    public void userTapsOnOpenButton(String User)  {
        new PlayStorePage(getDriverInstanceFor(User)).clickOnOpenButton();
    }
}
