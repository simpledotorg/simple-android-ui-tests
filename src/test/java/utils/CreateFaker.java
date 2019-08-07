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

        String[] s = {"MS","MR","DR","MISS","MRS"};
        for (String ss : s) {
            if (name.toUpperCase().contains(ss)) {
                replace = name.replace(ss, "").trim().toUpperCase().replaceAll("[^a-zA-Z0-9]", "");
                ScenarioContext.putData("User", ScenarioContextKeys.PATIENT_NAME, replace);
                return replace;
            }
        }
        ScenarioContext.putData("User", ScenarioContextKeys.PATIENT_NAME, name.toUpperCase());
        return name;
    }

    public static String getRandomAge(){
        return new CreateFaker().faker.random().nextInt(40,80).toString();

    }
}
