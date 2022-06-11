package org.equinox.api.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public final class CurrencyUtil {
	
	public static String getIDRFormat(double amount) {
        String prefix = "Rp.";
        String format = "#,##0.00";
        
        DecimalFormat formatter = new DecimalFormat(format);
        String output = formatter.format(amount);
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append(output.replaceAll(",", "."));
        int idx = sb.lastIndexOf(".");
        sb.replace(idx, idx+1, ",");
        
        return sb.toString();
	}
	
	public static String getIDRFormat(BigDecimal amount) {
        String prefix = "Rp.";
        String format = "#,##0.00";
        
        DecimalFormat formatter = new DecimalFormat(format);
        String output = formatter.format(amount);
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append(output.replaceAll(",", "."));
        int idx = sb.lastIndexOf(".");
        sb.replace(idx, idx+1, ",");
        
        return sb.toString();
	}
	
}
