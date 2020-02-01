package utils;

import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Date {

    // this method will return date in given format like "dd-MM-yy","dd-MM-yyyy",dd-MMM-yyy
    public static String getCurrentDate(String dateFormat) {

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

        Calendar cal = Calendar.getInstance();
        dateFormat = sdf.format(cal.getTime());

        dateFormat = dateFormat.replaceFirst("^0+(?!$)", "");

        return dateFormat;
    }

//     backDate value is used to create retro active bp
//     dateFormat arg for type of date you want as output
//     dd         arg for no of days need to subtracted from currentdate

    public static String getBackDate(String dateFormat, int dd) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

        Calendar currentTime = getBackDate(dd);
        return sdf.format(currentTime.getTime());
    }

    // this method will help to create a patient info with patient/sync api in backdate
    // to create a patient in previous quater/month
    // at server side we use RFC339 format for date
    public static String getCurrentDateIn_RFC339_Format() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        Calendar currentTime = Calendar.getInstance();
        return sdf.format(currentTime.getTime());
    }

    public static String getBackDateIn_RFC339_Format(int dd) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        Calendar cal = getBackDate(dd);
        return sdf.format(cal.getTime());
    }

    //adding 30 days in current date to create appointment
    public static String scheduleAppointmentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, +30);

        return sdf.format(cal.getTime());
    }

    public static String scheduleAppointmentWithBackDate(int dd) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        Calendar cal = getBackDate(dd);
        //adding 30 days in back date to c reate appointment
        cal.add(Calendar.DATE, +30);
        return sdf.format(cal.getTime());
    }

    private static Calendar getBackDate(int dd) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -dd);
        return cal;
    }
}
