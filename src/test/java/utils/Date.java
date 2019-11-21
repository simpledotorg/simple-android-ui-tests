package utils;

import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.TimeZone;

public class Date {

    public static String getCurrentDate_In_YYYY_MM_DD() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dtf.format(localDate);
    }

    public static String getCurrentDate_IN_DD_MM_YY() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");

        Calendar cal = Calendar.getInstance();
        return sdf.format(cal.getTime());
    }

    public static String getCurrentDateIn_RFC339_Format() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        Calendar currentTime = Calendar.getInstance();
        return sdf.format(currentTime.getTime());
    }

    public static String getBackDateIn_DD_MM_YYYY_Format(int dd) {
        SimpleDateFormat dtf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = getBackDate(dd);
        return dtf.format(cal.getTime());
    }

    public static String getBackDateIn_RFC339_Format(int dd) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        Calendar cal = getBackDate(dd);
        return sdf.format(cal.getTime());
    }

    //adding 30 days in current date to create appointment
    public static String appointmentScheduleDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, +30);

        return sdf.format(cal.getTime());
    }

    public static String appointmentScheduleDate(int dd) {
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

    public String getDate_IN_DD_MMM_YYYY(String str) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //converting string to date with the help of parse func
        java.util.Date dat = sdf.parse(str);

        //converting it to desired format
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy");
        return sdf2.format(dat);
    }

    @Test
    public void check() throws ParseException {
        System.out.println(getDate_IN_DD_MMM_YYYY("2019-10-15T06:48:45Z"));
    }
}
