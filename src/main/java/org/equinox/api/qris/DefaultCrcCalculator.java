package org.equinox.api.qris;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

public class DefaultCrcCalculator implements CRCCalculator, Serializable {
	
	private static final long serialVersionUID = 8892806955692419081L;
	private int initValue;
	private int polynomial;

	public DefaultCrcCalculator() {
		this.initValue = 0xFFFF;
		this.polynomial = 0x1021;
	}

	public DefaultCrcCalculator(int initValue, int polynomial) {
		this.initValue = initValue;
		this.polynomial = polynomial;
	}

	@Override
	public String computeCRC(String data) {
		byte[] bytes = data.getBytes();

		for (byte b : bytes) {
			for (int i = 0; i < 8; i++) {
				boolean bit = ((b >> (7 - i) & 1) == 1);
				boolean c15 = ((initValue >> 15 & 1) == 1);
				initValue <<= 1;
				if (c15 ^ bit)
					initValue ^= polynomial;
			}
		}

		initValue &= 0xffff;
		
		String result = Integer.toHexString(initValue).toUpperCase();
        
        if(result.length() < 4) return StringUtils.leftPad(result, 4, "0");
        
        return result;
	}

	public int getCrc() {
		return initValue;
	}

	public int getPolynomial() {
		return polynomial;
	}

	public void setPolynomial(int polynomial) {
		this.polynomial = polynomial;
	}

	public void setInitValue(int initValue) {
		this.initValue = initValue;

	}
}
