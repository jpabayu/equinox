package org.equinox.api.qris;

public final class CommonUtils {
	// input must contain numbers only
	public static int calculateCheckDigit(String input) {
		String digits = input + "0";
		boolean isSecond = false;

		int[] arrDigit = new int[digits.length()];
		int total = 0;
		for (int i = arrDigit.length - 1; i >= 0; i--) {
			arrDigit[i] = Integer.parseInt(String.valueOf(digits.charAt(i)));

			if (isSecond) {
				// multiply by 2
				int doubled = arrDigit[i] << 1;
				if (doubled > 9) {
					arrDigit[i] = doubled - 9;
				} else {
					arrDigit[i] = doubled;
				}

				isSecond = false;
			} else {
				isSecond = true;
			}

			total += arrDigit[i];
		}

		String strTotal = Integer.toString(total);
		int lastDigit = Integer.parseInt(String.valueOf(strTotal.charAt(strTotal.length() - 1)));

		if (lastDigit > 0) {
			return 10 - lastDigit;
		} else {
			return 0;
		}
	}
}
