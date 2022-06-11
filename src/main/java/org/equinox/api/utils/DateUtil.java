package org.equinox.api.utils;

import java.util.Calendar;
import java.util.TimeZone;

import org.equinox.api.data.Constants;

public final class DateUtil {
	
	//format yyyy-MM-dd HH:mm:ss GMT+07:00 (e.g. 2021-09-13 14:21:08 GMT+07:00)
	public static String getDateTimeWithTimeZone(Calendar calendar) {
		if(calendar == null) return null;
		
		String timezone = "GMT"+Constants.JPA_TIMEZONE;
		calendar.setTimeZone(TimeZone.getTimeZone(timezone));
		
		StringBuilder sb = new StringBuilder();
        
        int year = calendar.get(Calendar.YEAR);
        sb.append(year);
        
        int month = calendar.get(Calendar.MONTH)+1;
        sb.append("-").append((month < 10) ? "0" : "").append(month);
        
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        sb.append("-").append((day < 10) ? "0" : "").append(day);
		
        sb.append(" ");
        
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        sb.append((hour < 10) ? "0" : "").append(hour);
        
        int minute = calendar.get(Calendar.MINUTE);
        sb.append(":").append((minute < 10) ? "0" : "").append(minute);
        
        int second = calendar.get(Calendar.SECOND);
        sb.append(":").append((second < 10) ? "0" : "").append(second);
        
        sb.append(" ").append(timezone);
        
        return sb.toString();
	}
	
	public static int getCurrentYear() {
		Calendar calendar = Calendar.getInstance();
		
		String timezone = "GMT"+Constants.JPA_TIMEZONE;
		calendar.setTimeZone(TimeZone.getTimeZone(timezone));
		
		return calendar.get(Calendar.YEAR);
	}
}
