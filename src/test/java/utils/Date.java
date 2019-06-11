package utils;

import org.testng.annotations.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Date {

    public static String getCurrentDate() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy");
        return dtf.format(localDate);
    }


    @Test
    public void getDate() {

    }

}
