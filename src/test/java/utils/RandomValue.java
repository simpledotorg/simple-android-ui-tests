package utils;

import com.embibe.optimus.utils.ScenarioContext;
import com.mifmif.common.regex.Generex;

import java.util.Calendar;
import java.util.Random;

public class RandomValue {

    public static String getRandomId(){
        Generex generex= new Generex("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}");
        String id = generex.random();
        return id;
    }

    public static String getRandomUserName(){
        int num = new Random().nextInt(100);
        String name="QaTestUser "+num;
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


    public static String getRandomBpId(){
        Generex generex= new Generex("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}");
        String BpId=generex.random();
        System.out.println(BpId);
        return BpId;
    }

    public static String getRandomPatientId(){
        Generex generex= new Generex("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}");
        String patientId=generex.random();
        return patientId;
    }

    public static String getRandomPatientName(){
        int num = new Random().nextInt(100);
        String name="QaTestPatient"+num;
        ScenarioContext.putData("User",ScenarioContextKeys.PATIENT_NAME,name);
        return name;
    }
}
