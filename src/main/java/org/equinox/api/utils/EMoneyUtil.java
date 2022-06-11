package org.equinox.api.utils;

import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;
import org.equinox.api.data.Constants;

public final class EMoneyUtil {
	
	private static final TimeZone TIME_ZONE = TimeZone.getTimeZone("GMT"+Constants.JPA_TIMEZONE);
	
	public static String generateTraceNumber(String trxName) {
		return generateTraceNumber(trxName, null);
	}
	
	public static String generateTraceNumber(String trxName, String stan) {
		StringBuilder sb = new StringBuilder();
		
		switch(trxName) {
			case Constants.TRX_TRANSFER_MEMBER:
				sb.append("4001");
				break;
			case Constants.TRX_BANK_TRANSFER:
				sb.append("4002");
				break;
			case Constants.TRX_NAROBIL:
				sb.append("4003");
				break;
			case Constants.TRX_TELCO_PREPAID:
				sb.append("4101");
				break;
			case Constants.TRX_TELCO_POSTPAID:
				sb.append("4102");
				break;
			case Constants.TRX_PLN_PREPAID:
				sb.append("4201");
				break;
			case Constants.TRX_PLN_POSTPAID:
				sb.append("4202");
				break;
			case Constants.TRX_PLN_NONTAGLIS:
				sb.append("4203");
				break;
			case Constants.TRX_PDAM:
				sb.append("4301");
				break;
			case Constants.TRX_BPJS:
				sb.append("4401");
				break;
			case Constants.TRX_QRIS:
				sb.append("4501");
				break;
			default:
				sb.append("4000");
				break;
		}
		
		sb.append("19");
		sb.append(System.currentTimeMillis());
		
		if(StringUtils.isBlank(stan)) {
			Random r = new Random();
			int lrand = r.nextInt(1000000);
			String rand = String.valueOf(lrand);
			int size = 6;
			if (rand.length() == 1) {
				sb.append(StringUtils.rightPad(rand, size, '0'));
			} else {
				sb.append(StringUtils.leftPad(rand, size, '0'));
			}
		} else {
			sb.append(stan);
		}
			
		
		return sb.toString();
	}
	
	//format yyyy-MM-dd'T'HH:mm:ssXXX
	public static String getTransactionDate() {
		Calendar calendar = java.util.Calendar.getInstance(TIME_ZONE);
        StringBuilder sb = new StringBuilder();
        
        int year = calendar.get(Calendar.YEAR);
        sb.append(year);
        
        int month = calendar.get(Calendar.MONTH)+1;
        sb.append("-").append((month < 10) ? "0" : "").append(month);
        
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        sb.append("-").append((day < 10) ? "0" : "").append(day);
        
        sb.append("T");
        
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        sb.append((hour < 10) ? "0" : "").append(hour);
        
        int minute = calendar.get(Calendar.MINUTE);
        sb.append(":").append((minute < 10) ? "0" : "").append(minute);
        
        int second = calendar.get(Calendar.SECOND);
        sb.append(":").append((second < 10) ? "0" : "").append(second);
        
        sb.append(Constants.JPA_TIMEZONE);
        
       return sb.toString();
	}
}
