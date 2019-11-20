package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java8.En;
import pages.SettingPage;

public class SettingSteps extends BaseSteps {

    @And("^(\\w+) taps on change button$")
    public void tapsOnChangeButton(String User) {
            new SettingPage(getDriverInstanceFor(User)).tapsOnChangeButton();
    }

    @Then("^(\\w+) taps on Done button$")
    public void userTapsOnDoneButton(String User)  {
        new SettingPage(getDriverInstanceFor(User)).selectDoneButton();
    }

    @And("^(\\w+) on setting page selects a language as $")
    public void userOnSettingPageSelectsALanguage(String User,String lang)  {
        new SettingPage(getDriverInstanceFor(User)).selectALanguage(lang);
    }

    @Then("^(\\w+) taps on Done button and verify language selection (.*)$")
    public void userTapsOnDoneButtonAndVerifyLanguageSelectionLang(String User, String lang) {
        new SettingPage(getDriverInstanceFor(User)).selectALanguageAndVerifyLanguageSelection(lang);
    }

    @Then("^(\\w+) verifies default text for lang setting$")
    public void userVerifiesDefaultTextForLangSetting(String User) {
        new SettingPage(getDriverInstanceFor(User)).verifyDefaultText();
    }
}
