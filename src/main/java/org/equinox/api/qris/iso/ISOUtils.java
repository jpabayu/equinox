package org.equinox.api.qris.iso;

import java.util.Calendar;

import org.apache.commons.lang.StringUtils;
import org.equinox.api.qris.GlobalComponent;
import org.equinox.api.qris.StanCounter;
import org.equinox.controller.ContextLoader;
import org.jpos.iso.ISOMsg;
import org.springframework.beans.factory.annotation.Autowired;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IAtomicReference;
import org.apache.commons.codec.digest.DigestUtils;

public class ISOUtils {
	@Autowired
	private static ContextLoader contextLoader;
	
	public static String getPlnSwitcherId() {
		return "JTL53L3";
	}

	// bit 4
	public static String getAmount(long amount) {
		String amountStr = String.valueOf(amount);
		return StringUtils.leftPad(amountStr, 12, '0');
	}

	// bit 7
	public static String getTransmissionDateTime(StringBuilder sb, Calendar calendar) {
		// don't use string format because it slower!
		// return String.format("%1$tm%1$td%1$tH%1$tM%1$tS", calendar);
		sb.setLength(0);
		int month = calendar.get(Calendar.MONTH) + 1;
		sb.append((month < 10) ? "0" : "").append(month);

		int day = calendar.get(Calendar.DAY_OF_MONTH);
		sb.append((day < 10) ? "0" : "").append(day);

		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		sb.append((hour < 10) ? "0" : "").append(hour);

		int minute = calendar.get(Calendar.MINUTE);
		sb.append((minute < 10) ? "0" : "").append(minute);

		int second = calendar.get(Calendar.SECOND);
		sb.append((second < 10) ? "0" : "").append(second);

		return sb.toString();
	}

	// bit 11
	public static String getBPJSStan() {
		HazelcastInstance instance = GlobalComponent.getHazelcastInstance();

		if (instance != null) {
			IAtomicReference<Integer> ref = instance.getAtomicReference("stan-bpjs");
			ref.set(ref.get());
			Integer result = ref.alterAndGet(new StanCounter());

			return StringUtils.leftPad(result.toString(), 6, '0');
		} else {
			return "000000";
		}
	}

	// bit 11
	public static String getMultibillerStan() {
		HazelcastInstance instance = GlobalComponent.getHazelcastInstance();

		if (instance != null) {
			IAtomicReference<Integer> ref = instance.getAtomicReference("stan-multibiller");
			ref.set(ref.get());
			Integer result = ref.alterAndGet(new StanCounter());

			return StringUtils.leftPad(result.toString(), 6, '0');
		} else {
			return "000000";
		}
	}

	// bit 11
	public static String getPLNStan() {
		HazelcastInstance instance = GlobalComponent.getHazelcastInstance();

		if (instance != null) {
			IAtomicReference<Integer> ref = instance.getAtomicReference("stan-pln");
			ref.set(ref.get());
			Integer result = ref.alterAndGet(new StanCounter());

			return StringUtils.leftPad(result.toString(), 6, '0');
		} else {
			return "000000";
		}
	}

	// bit 11
	public static String getQRISStan() {
		HazelcastInstance instance = GlobalComponent.getHazelcastInstance();

		if (instance != null) {
			IAtomicReference<Integer> ref = instance.getAtomicReference("stan-qris");
			ref.set(ref.get());
			Integer result = ref.alterAndGet(new StanCounter());

			return StringUtils.leftPad(result.toString(), 6, '0');
		} else {
			return "000000";
		}
	}

	// bit 12
	public static String getLocalTransactionTime(StringBuilder sb, Calendar calendar) {
		// don't use string format because it slower!
		// return String.format("%1$tH%1$tM%1$tS", calendar);

		sb.setLength(0);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		sb.append((hour < 10) ? "0" : "").append(hour);

		int minute = calendar.get(Calendar.MINUTE);
		sb.append((minute < 10) ? "0" : "").append(minute);

		int second = calendar.get(Calendar.SECOND);
		sb.append((second < 10) ? "0" : "").append(second);

		return sb.toString();
	}

	// bit 13
	public static String getLocalTransactionDate(StringBuilder sb, Calendar calendar) {
		// don't use string format because it slower!
		// return String.format("%1$tm%1$td", calendar);

		sb.setLength(0);
		int month = calendar.get(Calendar.MONTH) + 1;
		sb.append((month < 10) ? "0" : "").append(month);

		int day = calendar.get(Calendar.DAY_OF_MONTH);
		sb.append((day < 10) ? "0" : "").append(day);

		return sb.toString();
	}

	// bit 15
	public static String getSettlementDate(StringBuilder sb, Calendar calendar) {
		// don't use string format because it slower!
		// return String.format("%1$tm%1$td", calendar);

		sb.setLength(0);
		int month = calendar.get(Calendar.MONTH) + 1;
		sb.append((month < 10) ? "0" : "").append(month);

		int day = calendar.get(Calendar.DAY_OF_MONTH);
		sb.append((day < 10) ? "0" : "").append(day);

		return sb.toString();
	}

	// bit 18
	public static String getMerchantType() {
		return "6021";
	}

	// bit 32
	public static String getAcquiringInstitutionID() {
		// Kode bank mandiri
		return "008";
	}

	// bit 37
	public static String getRetrievalReferenceNumber(StringBuilder sb, String id, String pan, String stan,
			long dateTime, long amount) {
		sb.setLength(0);
		sb.append(pan);
		sb.append(stan);
		sb.append(amount);
		sb.append(dateTime);

		/*
		 * String md5Hex = DigestUtils.md5Hex(sb.toString()).toUpperCase(); return
		 * md5Hex.substring(0, 12);
		 */
		String hash = DigestUtils.sha256Hex(sb.toString()).toUpperCase();
		sb.setLength(0);
		sb.append(hash.substring(0, 6));
		sb.append(hash.substring(hash.length() - 6));
		return sb.toString();
	}

	// bit 37
	public static String getRetrievalReferenceNumber(StringBuilder sb, String id, String pan, String stan,
			long dateTime, String amount) {
		sb.setLength(0);
		sb.append(pan);
		sb.append(stan);
		sb.append(amount);
		sb.append(dateTime);

		/*
		 * String md5Hex = DigestUtils.md5Hex(sb.toString()).toUpperCase(); return
		 * md5Hex.substring(0, 12);
		 */
		String hash = DigestUtils.sha256Hex(sb.toString()).toUpperCase();
		sb.setLength(0);
		sb.append(hash.substring(0, 6));
		sb.append(hash.substring(hash.length() - 6));
		return sb.toString();
	}

	// bit 41
	public static String getMultibillerTid() {
		return contextLoader.getMultibillerISOTID();
	}

	// bit 41
	public static String getPlnTid() {
		return contextLoader.getPlnISOTID();
	}

	// bit 42
	public static String getMultibillerAccId() {
		return contextLoader.getMultibillerISOAccID();
	}

	// bit 42
	public static String getPlnAccId() {
		return contextLoader.getPlnISOAccID();
	}

	// bit 49
	public static String getCurrencyCode() {
		// rupiah
		return "360";
	}

	public static String getISOString(ISOMsg isoMsg) {
		if (isoMsg == null)
			return null;

		try {
			return new String(isoMsg.pack());
		} catch (Exception e) {
			return null;
		}
	}

	public static String decimalFormat(String totalDecimal, String value) {
		return String.format("%." + totalDecimal + "f", value);
	}
}
