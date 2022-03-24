package org.equinox.api.qris;

import java.util.HashMap;

import org.equinox.api.data.ResponseStatus;
import org.equinox.api.data.Status;
import org.equinox.api.data.StatusBuilder;

public class QrisGWStatusMapper {
	private static final Object lock = new Object();

	// static variable single_instance of type Singleton
	private static volatile QrisGWStatusMapper qrisGWStatusMapper = null;

	private HashMap<String, ResponseCode> rcMap = null;

	// private constructor restricted to this class itself
	private QrisGWStatusMapper() {
		rcMap = new HashMap<String, ResponseCode>();

		String rc = "00";
		rcMap.put(rc, new ResponseCode(rc, "Sukses", ResponseCodeStatus.SUCCESS));

		rc = "03";
		rcMap.put(rc, new ResponseCode(rc, "Invalid Merchant", ResponseCodeStatus.FAILED));

		rc = "05";
		rcMap.put(rc, new ResponseCode(rc, "Do not Honor", ResponseCodeStatus.FAILED));

		rc = "06";
		rcMap.put(rc, new ResponseCode(rc, "Undefined Error", ResponseCodeStatus.FAILED));

		rc = "12";
		rcMap.put(rc, new ResponseCode(rc, "Invalid Transaction", ResponseCodeStatus.FAILED));

		rc = "13";
		rcMap.put(rc, new ResponseCode(rc, "Invalid Amount", ResponseCodeStatus.FAILED));

		rc = "30";
		rcMap.put(rc, new ResponseCode(rc, "Format Error", ResponseCodeStatus.FAILED));

		rc = "65";
		rcMap.put(rc, new ResponseCode(rc, "Exceeds Transaction Frequency Limit", ResponseCodeStatus.FAILED));

		rc = "68";
		rcMap.put(rc, new ResponseCode(rc, "Suspend Transaction", ResponseCodeStatus.SUSPECT));

		rc = "73";
		rcMap.put(rc, new ResponseCode(rc, "Page not Found", ResponseCodeStatus.FAILED));

		rc = "90";
		rcMap.put(rc, new ResponseCode(rc, "Cutoff in Progress", ResponseCodeStatus.FAILED));

		rc = "91";
		rcMap.put(rc, new ResponseCode(rc, "Link down", ResponseCodeStatus.FAILED));

		rc = "92";
		rcMap.put(rc, new ResponseCode(rc, "Invalid Routing", ResponseCodeStatus.FAILED));

		rc = "94";
		rcMap.put(rc, new ResponseCode(rc, "Duplicate Transmission", ResponseCodeStatus.FAILED));

		rc = "96";
		rcMap.put(rc, new ResponseCode(rc, "System Malfunction", ResponseCodeStatus.FAILED));

	}

	// static method to create instance of Singleton class
	private static QrisGWStatusMapper getInstance() {
		QrisGWStatusMapper mapper = qrisGWStatusMapper;
		if (mapper == null) {
			synchronized (lock) {
				mapper = qrisGWStatusMapper;
				if (mapper == null) {
					mapper = new QrisGWStatusMapper();
					qrisGWStatusMapper = mapper;
				}
			}
		}

		return mapper;
	}

	public static ResponseCode getStatus(String responseCode) {
		QrisGWStatusMapper mapper = getInstance();

		if (responseCode == null)
			return mapper.rcMap.get("06");

		if (mapper.rcMap.containsKey(responseCode)) {
			return mapper.rcMap.get(responseCode);
		} else {
			return mapper.rcMap.get("06");
		}
	}

	public static ResponseStatus getEquinoxStatus(String responseCode) {
		ResponseCode rc = getStatus(responseCode);
		return getEquinoxStatus(rc);
	}

	public static ResponseStatus getEquinoxStatus(ResponseCode responseCode) {

		if (responseCode == null)
			return StatusBuilder.getStatus(Status.UNDEFINED_ERROR.name());

		switch (responseCode.getCode()) {
		case "00":
			return StatusBuilder.getStatus(Status.PROCESSED.name());
		case "03":
			return StatusBuilder.getStatus(Status.INVALID_MERCHANT.name());
		case "05":
			return StatusBuilder.getStatus(Status.INVALID_TRANSACTION.name());
		case "06":
			return StatusBuilder.getStatus(Status.UNDEFINED_ERROR.name());
		case "12":
			return StatusBuilder.getStatus(Status.INVALID_TRANSACTION.name());
		case "13":
			return StatusBuilder.getStatus(Status.INVALID_AMOUNT.name());
		case "30":
			return StatusBuilder.getStatus(Status.MESSAGE_FORMAT_ERROR.name());
		case "65":
			return StatusBuilder.getStatus(Status.MONTHLY_CREDIT_LIMIT_REACHED.name());
		case "68":
			return StatusBuilder.getStatus(Status.PENDING.name());
		case "73":
			return StatusBuilder.getStatus(Status.ISO_UNABLE_ROUTE_TRANSACTION.name());
		case "90":
			return StatusBuilder.getStatus(Status.ISO_CUT_OFF_IN_PROGRESS.name());
		case "91":
			return StatusBuilder.getStatus(Status.ISO_SERVER_IS_DOWN.name());
		case "92":
			return StatusBuilder.getStatus(Status.ISO_UNABLE_ROUTE_TRANSACTION.name());
		case "94":
			return StatusBuilder.getStatus(Status.DUPLICATE_TRANSACTION.name());
		case "96":
			return StatusBuilder.getStatus(Status.ISO_SYSTEM_MALFUNCTION.name());
		default:
			return StatusBuilder.getStatus(Status.UNDEFINED_ERROR.name());
		}
	}
}
