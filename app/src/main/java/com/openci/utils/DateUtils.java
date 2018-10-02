package com.openci.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils {

    private static final long ONE_SECOND_MILLS = 1000L;
    private static final long ONE_MINUTE_MILLS = ONE_SECOND_MILLS * 60;
    private static final long ONE_HOUR_MILLS = ONE_MINUTE_MILLS * 60;
    private static final long ONE_DAY_MILLS = ONE_HOUR_MILLS * 24;
    private static final long ONE_MONTH_MILLS = ONE_HOUR_MILLS * 31;

    private static int timelineOffset = TimeZone.getDefault().getRawOffset();

    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.getDefault());

    public static Long rfc3339ToMills(String dateInString) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss", Locale.getDefault());
        try {
            cal.setTime(simpleDateFormat.parse(dateInString
                    .replace("Z", "")
                    .replace("T", "-")
            ));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cal.getTimeInMillis() + timelineOffset;
    }

    public static String getDate(Long timeMills) {
        long duration = System.currentTimeMillis() - timeMills;

        if(duration > ONE_MONTH_MILLS) {
            return dateFormatter.format(new Date(timeMills));
        } else {
            return convertToHumanReadableDuration(duration, false);
        }
    }

    public static String convertToHumanReadableDuration(Long durationMills, boolean accurate) {
        Long duration = durationMills;
        StringBuffer buffer = new StringBuffer();
        Long temp;

        if (duration >= ONE_SECOND_MILLS) {
            //Calculate days
            temp = duration / ONE_DAY_MILLS;
            if (temp > 0) {
                duration -= temp * ONE_DAY_MILLS;
                if(temp > 1) {
                    buffer.append(temp)
                            .append(" day")
                            .append("s ");
                } else {
                    buffer.append(temp)
                            .append(" day")
                            .append(" ");
                }
            }

            //Calculate hours
            temp = duration / ONE_HOUR_MILLS;
            if (temp > 0) {
                duration -= temp * ONE_HOUR_MILLS;
                if(temp > 1) {
                    buffer.append(temp)
                            .append(" hour")
                            .append("s ");
                } else {
                    buffer.append(temp)
                            .append(" hour")
                            .append(" ");
                }
            }

            if (accurate || buffer.indexOf("day") == -1) {

                //Calculate minutes
                temp = duration / ONE_MINUTE_MILLS;
                if (temp > 0) {
                    duration -= temp * ONE_MINUTE_MILLS;
                    buffer.append(temp).append(" min ");
                }
            }

            if (accurate || buffer.indexOf("hours") == -1) {

                //Calculate seconds
                temp = duration / ONE_SECOND_MILLS;
                if (temp > 0) {
                    buffer.append(temp).append(" sec");
                }
            }
            return buffer.toString();
        } else {
            return "now";
        }
    }
}
