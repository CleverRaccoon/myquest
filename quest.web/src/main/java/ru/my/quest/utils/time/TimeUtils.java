package ru.my.quest.utils.time;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 * Created by maksim on 6/9/2016.
 */
public class TimeUtils {

    private TimeUtils(){

    }


    public static Long getCurrentTimeByTimeZone(String timeZone){
       return DateTime.now(DateTimeZone.forID(timeZone)).getMillis();
    }
}
