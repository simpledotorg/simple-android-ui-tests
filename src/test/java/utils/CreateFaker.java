package utils;

import com.embibe.optimus.utils.ScenarioContext;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.Locale;
import java.util.Random;

public class CreateFaker {

    public Faker faker = new Faker(new Locale("{en-IND}"));

    // need to handle special character(.) as current app does not support search for salutation
    //name like MR. o connel,Dr. Strange
    public String getRandomPatientName() {
        String name = faker.name().fullName().replaceAll("[^a-zA-Z0-9]", " ").toUpperCase();
        ScenarioContext.putData("User", ScenarioContextKeys.PATIENT_NAME, name);
        return name;
    }

    public static String getRandomAge() {
        return new CreateFaker().faker.random().nextInt(40, 80).toString();
    }

    public static String getGender() {
        String[] arr = {"Male", "Female", "Transgender"};
        int i = new Random().nextInt(3);
        return arr[i];
    }
}
