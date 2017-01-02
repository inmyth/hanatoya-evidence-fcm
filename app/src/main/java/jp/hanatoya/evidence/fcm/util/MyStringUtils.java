package jp.hanatoya.evidence.fcm.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;



public class MyStringUtils {

    public static String getDate(long ts) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+9"));
        calendar.setTimeInMillis(ts * 1000);
        return formatter.format(calendar.getTime());
    }
}
