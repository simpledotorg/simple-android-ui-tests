package utils;

import com.embibe.optimus.utils.ScenarioContext;
import com.github.javafaker.Faker;

import java.util.Locale;

public class CreateFaker {

    public Faker faker = new Faker(new Locale("{en-IND}"));

    // need to special character(.) as current app does not support search for salutation
    //name like MR. o connel,Dr. Strange
    public String getRandomPatientName() {
        String name = faker.name().fullName().replaceAll("[^a-zA-Z0-9]", " ").toUpperCase();
        ScenarioContext.putData("User", ScenarioContextKeys.PATIENT_NAME, name);
        return name;
    }

    public static String getRandomAge() {
        return new CreateFaker().faker.random().nextInt(40, 80).toString();
    }
}
