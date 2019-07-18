package utils;

import com.embibe.optimus.utils.ScenarioContext;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.Locale;

public class CreateFaker {

    public Faker faker = new Faker(new Locale("{en-IND}"));

    // need to remove salutation as current app does not support search for
    //name like MR. o connel,Dr. Strange
    public String getRandomPatientName() {

        String name = faker.name().fullName();
        String replace = "";

        String[] s = {"Mr.", "Dr.", "Miss.", "Jr.", "MS.", "MR.", "DR.","MISS.","MISS","MS","Miss","Ms","Ms." };
        for (String ss : s) {
            if (name.contains(ss)) {
                replace = name.replace(ss, "").trim().toUpperCase();
                ScenarioContext.putData("User", ScenarioContextKeys.PATIENT_NAME, replace);
                return replace;
            }
        }
        ScenarioContext.putData("User", ScenarioContextKeys.PATIENT_NAME, name.toUpperCase());
        return name;
    }
}
