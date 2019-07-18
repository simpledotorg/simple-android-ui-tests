package utils;

import com.embibe.optimus.utils.ScenarioContext;
import com.github.javafaker.Faker;
import com.mifmif.common.regex.Generex;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

public class RandomValue {

    public static String getRandomPhoneNumber() {
        String s = String.valueOf(Calendar.getInstance().getTimeInMillis());
        String ss = s.substring(3);
        if (!ss.startsWith("0")) {
            return ss;
        }
        return s.substring(0, 10);
    }

}
