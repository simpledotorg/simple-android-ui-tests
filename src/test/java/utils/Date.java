package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {

    public static String getCurrentDate(){
        LocalDate localDate= LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy");
        return dtf.format(localDate);
    }
}
