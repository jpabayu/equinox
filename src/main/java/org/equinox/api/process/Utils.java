package org.equinox.api.process;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.equinox.api.qris.Constants;

public abstract class Utils {
	private static Logger logger = Logger.getLogger(Utils.class);
	private static String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
			+ "A-Z]{2,7}$";

	public static String formatAmount(BigDecimal amount) {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
		symbols.setGroupingSeparator('.');
		symbols.setDecimalSeparator(',');
		DecimalFormat df = new DecimalFormat("#,##0.00", symbols);
		return "Rp." + df.format(amount);
	}

	public static String GenerateRandomNumber(int charLength) {
		return String.valueOf(charLength < 1 ? 0
				: new Random().nextInt((9 * (int) Math.pow(10, charLength - 1)) - 1)
						+ (int) Math.pow(10, charLength - 1));
	}

	public static String GenerateTransactionNumber() {
		int randomNum = ThreadLocalRandom.current().nextInt(100000, 999999 + 1);
		return String.valueOf(randomNum);
	}

	public static String getRandomNumberInRange(String max) {
		Random r = new Random();
		Long lrand = r.longs(1, (Long.valueOf(max) + 1)).limit(1).findFirst().getAsLong();
		String rand = String.valueOf(lrand);
		int size = max.length();
		String pad;
		if (rand.length() == 1) {
			pad = StringUtils.rightPad(rand, size, '0');
		} else {
			pad = StringUtils.leftPad(rand, size, '0');
		}
		return pad;
	}

	public static String getMD5Hash(String source) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			String hex = (new HexBinaryAdapter()).marshal(md5.digest(source.getBytes("UTF-8")));
			return hex.toLowerCase();
		} catch (Exception ex) {
			return null;
		}
	}

	public static String GetCurrentDate() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format.format(date);
	}

	public static String GetDate(String form) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat(form);
		return format.format(date);
	}

	public static String generateTraceNum() {
		Random rnd = new Random();
		int n = 10000000 + rnd.nextInt(90000000);
		String a = Integer.toString(n);
		return a;
	}

	public static String formatDate(Date date) {
		return DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
	}

	public static String addHourToDate(Integer hourAdd) {
		LocalDateTime nextTime = LocalDateTime.now().plusHours(hourAdd);
		return nextTime.toString();
	}

	public static boolean validateString(String s, String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		return m.matches();
	}

	public static boolean isValidEmail(String email) {
		Pattern pattern = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pattern.matcher(email).matches();
	}

	public static String generateTraceNumber(String trxName, String stan) {
		StringBuilder sb = new StringBuilder();

		switch (trxName) {
		case Constants.TRX_TRANSFER_MEMBER:
			sb.append("1001");
			break;
		case Constants.TRX_BANK_TRANSFER:
			sb.append("1002");
			break;
		case Constants.TRX_NAROBIL:
			sb.append("1003");
			break;
		case Constants.TRX_TELCO_PREPAID:
			sb.append("1101");
			break;
		case Constants.TRX_TELCO_POSTPAID:
			sb.append("1102");
			break;
		case Constants.TRX_PLN_PREPAID:
			sb.append("1201");
			break;
		case Constants.TRX_PLN_POSTPAID:
			sb.append("1202");
			break;
		case Constants.TRX_PLN_NONTAGLIS:
			sb.append("1203");
			break;
		case Constants.TRX_PDAM:
			sb.append("1301");
			break;
		case Constants.TRX_BPJS:
			sb.append("1401");
			break;
		case Constants.TRX_QRIS:
			sb.append("1501");
			break;
		default:
			sb.append("1000");
			break;
		}

		sb.append("19");
		sb.append(System.currentTimeMillis());

		if (StringUtils.isBlank(stan)) {
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

	// format yyyy-MM-dd HH:mm:ss GMT+07:00 (e.g. 2021-09-13 14:21:08 GMT+07:00)
	public static String getDateTimeWithTimeZone(Calendar calendar) {
		if (calendar == null)
			return null;

		String timezone = "GMT" + "+07:00";
		calendar.setTimeZone(TimeZone.getTimeZone(timezone));

		StringBuilder sb = new StringBuilder();

		int year = calendar.get(Calendar.YEAR);
		sb.append(year);

		int month = calendar.get(Calendar.MONTH) + 1;
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

		String timezone = "GMT" + "+07:00";
		calendar.setTimeZone(TimeZone.getTimeZone(timezone));

		return calendar.get(Calendar.YEAR);
	}

	public static String getIDRFormat(double amount) {
		String prefix = "Rp.";
		String format = "#,##0.00";

		DecimalFormat formatter = new DecimalFormat(format);
		String output = formatter.format(amount);
		StringBuilder sb = new StringBuilder();
		sb.append(prefix);
		sb.append(output.replaceAll(",", "."));
		int idx = sb.lastIndexOf(".");
		sb.replace(idx, idx + 1, ",");

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
		sb.replace(idx, idx + 1, ",");

		return sb.toString();
	}

	public static String getQRISMerchantReceipt(String acceptedLanguage, String mpan, String mid, String merchantName,
			String transactionDate, String transactionNumber, String traceNumber, String rrn, String invoiceId,
			String amount) {
		StringBuilder sb = new StringBuilder();

		if (acceptedLanguage != null) {
			if (acceptedLanguage.equals("en-US")) {
				sb.append("Dear Fello Merchant,\n");
				sb.append("PAN: ").append(mpan).append("\n");
				sb.append("MID: ").append(mid).append("\n");
				sb.append("Name: ").append(merchantName).append("\n\n");

				sb.append("You have received a QRIS payment with details as follow:\n");
				sb.append("Transaction Date: ").append(transactionDate).append("\n");
				sb.append("Transaction Number: ").append(transactionNumber).append("\n");
				sb.append("Trace Number: ").append(traceNumber).append("\n");
				sb.append("RRN: ").append(rrn).append("\n");
				sb.append("Invoice ID: ").append(invoiceId).append("\n");
				sb.append("Amount: ").append(amount).append("\n\n");

				sb.append("We hope this information will be useful to you.\n\n");

				sb.append("Best regards,\n");
				sb.append("Fello Team");

				return sb.toString();
			}
		}

		sb.append("Hai Merchant Fello,\n");
		sb.append("PAN: ").append(mpan).append("\n");
		sb.append("MID: ").append(mid).append("\n");
		sb.append("Nama: ").append(merchantName).append("\n\n");

		sb.append("Anda telah menerima pembayaran QRIS dengan detail sebagai berikut:\n");
		sb.append("Tanggal Transaksi: ").append(transactionDate).append("\n");
		sb.append("Nomor Transaksi: ").append(transactionNumber).append("\n");
		sb.append("Trace Number: ").append(traceNumber).append("\n");
		sb.append("RRN: ").append(rrn).append("\n");
		sb.append("Nomor Invoice: ").append(invoiceId).append("\n");
		sb.append("Jumlah: ").append(amount).append("\n\n");

		sb.append("Kami harap informasi ini bermanfaat bagi anda.\n\n");

		sb.append("Salam,\n");
		sb.append("Tim Fello");

		return sb.toString();
	}
}
