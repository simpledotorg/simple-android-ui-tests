package utils;

import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Random;

public class RandomValue {
    public static String getRandomId(){

        int num = new Random().nextInt(100);
        String id="5fc3dbcb-7db6-4ae9-ac2e-62e9c8940f"+num;
        System.out.println(id);
        return id;
    }

    public static String getRandomUserName(){

        int num = new Random().nextInt(100);
        String name="QaTestUser "+num;
        System.out.println(name);
        return name;
    }

    public static String getRandomPhoneNumber(){
        String s = String.valueOf(Calendar.getInstance().getTimeInMillis());
        String ss = s.substring(3);
        if (!ss.startsWith("0")) {
            return ss;
        }
        return s.substring(0, 10);
    }

    public static int getRandomPinValue(){
        int pin = new Random().nextInt(10000);
        return pin;
    }
}
