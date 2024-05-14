package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {
    public static String format(Date date, String fm) {
        SimpleDateFormat formatter = new SimpleDateFormat(fm);
        return formatter.format(date);
    }
    public static String format(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    public static Date toDate(String date, String fm) {
        SimpleDateFormat formatter = new SimpleDateFormat(fm);
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    public static Date toDate(String date) {
        return toDate(date, "yyyy-MM-dd");
    }
}
