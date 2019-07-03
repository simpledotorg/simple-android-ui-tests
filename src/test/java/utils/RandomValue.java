package utils;

import com.embibe.optimus.utils.ScenarioContext;
import com.github.javafaker.Faker;
import com.mifmif.common.regex.Generex;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

public class RandomValue {

    static Faker faker = new Faker();
    static Generex generex = new Generex("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}");


    public static String getRandomUserId() {
        String id = generex.random();
        return id;
    }

    public static String getRandomUserName() {
        String name = faker.name().firstName();
        return name.toUpperCase();
    }

    public static String getRandomPhoneNumber() {
        String s = String.valueOf(Calendar.getInstance().getTimeInMillis());
        String ss = s.substring(3);
        if (!ss.startsWith("0")) {
            return ss;
        }
        return s.substring(0, 10);
    }

    public static int getRandomPinValue() {
        int pin = new Random().nextInt(10000);
        return pin;
    }


    public static String getRandomBpId() {
        String BpId = generex.random();
        System.out.println(BpId);
        return BpId;
    }

    public static String getRandomPatientId() {
        String patientId = generex.random();
        ScenarioContext.putData("User", ScenarioContextKeys.PATIENT_ID, patientId);
        return patientId;
    }

    // need to remove salutation as current app does not support search for
    //name like MR. o connel,Dr. Strange

    public static String getRandomPatientName() {
        Faker faker2 = new Faker(new Locale("{en-IND}"));

        String name = faker2.name().fullName();
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

    public static String getRandomAddressId() {
        String addressId = generex.random();
        return addressId;
    }

    public static String getRandomPhoneNumberId() {
        String phone = generex.random();
        return phone;
    }

    public static String getRandomProtocolId() {
        return generex.random();
    }

    public static String getRandomAppointmentId() {
        return generex.random();
    }

}
