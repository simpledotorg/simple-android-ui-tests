package utils;

import com.embibe.optimus.utils.ScenarioContext;
import com.github.javafaker.Faker;

import java.util.Locale;

public class CreateFaker {

    public Faker faker = new Faker(new Locale("{en-IND}"));

    // need to remove salutation as current app does not support search for
    //name like MR. o connel,Dr. Strange
    public String getRandomPatientName() {

        String name = faker.name().fullName();
        String replace = "";

        String[] s = {"Mr.", "Dr.", "Miss.", "Jr.", "MS.", "MR.", "DR."};
        for (String ss : s) {
            if (name.contains(ss)) {
                ScenarioContext.putData("User", ScenarioContextKeys.PATIENT_NAME, name);
                replace = name.replace(ss, "").trim().toUpperCase();
                return replace;
            }
        }
        ScenarioContext.putData("User", ScenarioContextKeys.PATIENT_NAME, name);
        return name.toUpperCase();
    }
}
