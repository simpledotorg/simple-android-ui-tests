package utils;

import java.util.Calendar;

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
