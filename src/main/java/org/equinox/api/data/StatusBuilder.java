package org.equinox.api.data;

public abstract class StatusBuilder {

	public static ResponseStatus getStatus(String arg) {
		try {
			ResponseStatus rs = StatusBuilder.getStatus(Status.valueOf(arg));
			return rs;
		} catch (IllegalArgumentException e) {
			return new ResponseStatus("E99", "UNDEFINED_ERROR", "Undefined Error");
		}
	}

	public static String getHttpStatus(String arg) {
		String rc = Status.valueOf(arg).httpStatusCode();
		return rc;
	}

	public static ResponseStatus getStatus(Status arg) {
		switch (arg) {
		case PROCESSED:
			return new ResponseStatus("A00", "PROCESSED", "Transaction completed");
		case VALID:
			return new ResponseStatus("A01", "VALID", "Valid PIN");
		case REQUEST_RECEIVED:
			return new ResponseStatus("A02", "REQUEST_RECEIVED", "Your Transaction has been received for processing");
		case REQUEST_IN_PROGRESS:
			return new ResponseStatus("A03", "REQUEST_IN_PROGRESS", "Your request is in progress");
		case TRANSACTION_IN_PROGRESS:
			return new ResponseStatus("A03", "TRANSACTION_IN_PROGRESS", "Your transaction is in progress");
		case PENDING:
			return new ResponseStatus("A03", "PENDING", "Request pending");
		case INVALID:
			return new ResponseStatus("A14", "INVALID", "The inputted PIN is wrong");
		case CREDENTIAL_INVALID:
			return new ResponseStatus("A14", "CREDENTIAL_INVALID", "Invalid credential");
		case SERVICE_NOT_ALLOWED:
			return new ResponseStatus("A16", "SERVICE_NOT_ALLOWED", "Group not allowed to access Webservices");
		case SERVICE_NOT_FOUND:
			return new ResponseStatus("A17", "SERVICE_NOT_FOUND", "Requested service is not available");
		case BLOCKED:
			return new ResponseStatus("A18", "BLOCKED", "Your account has been blocked. Please contact Customer Care");
		case UNAUTHORIZED_ACCESS:
			return new ResponseStatus("A90", "UNAUTHORIZED_ACCESS", "We cannot authorized you, please check your authorization");
		case INVALID_DEVICE_UID:
			return new ResponseStatus("A91", "INVALID_DEVICE_UID", "Invalid device uid");
		case ACCESS_DENIED:
			return new ResponseStatus("A97", "ACCESS_DENIED", "Invalid Access, please contact administrator");
		case BILLER_NOT_FOUND:
			return new ResponseStatus("B01", "BILLER_NOT_FOUND", "Biller not found on system");
		case BANK_NOT_FOUND:
			return new ResponseStatus("B14", "BANK_NOT_FOUND", "The specified Bank not found");
		case BANK_ACCOUNT_ALREADY_REGISTERED:
			return new ResponseStatus("B15", "BANK_ACCOUNT_ALREADY_REGISTERED", "The specified bank account already registered");
		case BANK_ACCOUNT_NOT_FOUND:
			return new ResponseStatus("B16", "BANK_ACCOUNT_NOT_FOUND", "The specified bank account no found");
		case BANK_ACCOUNT_LIMIT:
			return new ResponseStatus("B17", "BANK_ACCOUNT_LIMIT", "You have reached your bank account");
		case INVALID_URL:
			return new ResponseStatus("B21", "INVALID_URL", "Invalid URL");
		case INVALID_OTP:
			return new ResponseStatus("C14", "INVALID_OTP", "OTP already expired or not found");
		case INVALID_MERCHANT:
			return new ResponseStatus("C15", "INVALID_MERCHANT", "Invalid merchant/merchant not found");
		case INVALID_TRANSACTION:
			return new ResponseStatus("C16", "INVALID_TRANSACTION", "Invalid transaction, please try again from begining");
		case INVALID_AMOUNT:
			return new ResponseStatus("C17", "INVALID_AMOUNT", "Invalid Amount");
		case MESSAGE_FORMAT_ERROR:
			return new ResponseStatus("C18", "MESSAGE_FORMAT_ERROR", "There is an format error on the message");
		case EMAIL_NOT_VERIFY:
			return new ResponseStatus("E01", "EMAIL_NOT_VERIFY", "Please verify your email");
		case HOST_CONNECTION_TIMEOUT:
			return new ResponseStatus("E98", "HOST_CONNECTION_TIMEOUT", "Connect timeout");
		case HOST_CONNECTION_FAILED:
			return new ResponseStatus("E97", "HOST_CONNECTION_FAILED", "Failed to connect to the host");
		case UNDEFINED_ERROR:
			return new ResponseStatus("E99", "UNDEFINED_ERROR", "Undefined Error");
		case ISO_INVALID_MERCHANT_TYPE:
			return new ResponseStatus("I03", "ISO_INVALID_MERCHANT_TYPE", "Invalid merchant");
		case ISO_TRANSACTION_FAILED:
			return new ResponseStatus("I07", "ISO_TRANSACTION_FAILED", "Transaction failed, please try again later");
		case ISO_REQUEST_IN_PROGRESS:
			return new ResponseStatus("I09", "ISO_REQUEST_IN_PROGRESS", "Request in progress");
		case ISO_INVALID_METER_OR_CUSTOMER_ID:
			return new ResponseStatus("I09", "ISO_INVALID_METER_OR_CUSTOMER_ID", "The specified meter/customer id is invalid");
		case ISO_INACTIVE_MTI:
			return new ResponseStatus("I11", "ISO_INACTIVE_MTI", "Inactive MTI");
		case ISO_INVALID_TRANSACTION:
			return new ResponseStatus("I12", "ISO_INVALID_TRANSACTION", "Invalid transaction");
		case ISO_INACTIVE_USER:
			return new ResponseStatus("I12", "ISO_INACTIVE_USER", "Invalid user");
		case ISO_SERVER_IS_DOWN:
			return new ResponseStatus("I13", "ISO_SERVER_IS_DOWN", "Application server is down");
		case ISO_INVALID_ID:
			return new ResponseStatus("I14", "ISO_INVALID_ID", "Unidentified/invalid Phone/ID number");
		case ISO_INVALID_CARD_NUMBER:
			return new ResponseStatus("I14", "ISO_INVALID_CARD_NUMBER", "Card number not found");
		case ISO_INVALID_CUSTOMER_ID:
			return new ResponseStatus("I14", "ISO_INVALID_CUSTOMER_ID", "The specified customer id is invalid");
		case ISO_INVALID_REGISTRATION_NUMBER:
			return new ResponseStatus("I14", "ISO_INVALID_REGISTRATION_NUMBER", "The specified registration number is invalid");
		case ISO_INVALID_VA:
			return new ResponseStatus("I14", "ISO_INVALID_VA", "Unidentified/invalid VA number");
		case ISO_PACKET_COMPOSITION_FAILURE_PLN:
			return new ResponseStatus("I15", "ISO_PACKET_COMPOSITION_FAILURE_PLN", "ISO packet composition failure");
		case ISO_PACKET_DECOMPOSITION_FAILURE_PLN:
			return new ResponseStatus("I16", "ISO_PACKET_DECOMPOSITION_FAILURE_PLN", "ISO packet decomposition failure");
		case ISO_CUSTOMER_IS_BLOCKED:
			return new ResponseStatus("I16", "ISO_CUSTOMER_IS_BLOCKED", "Customer has been blocked");
		case ISO_INVALID_NOMINAL:
			return new ResponseStatus("I17", "ISO_INVALID_NOMINAL", "System cannot find the specified nominal");
		case ISO_UNKNOWN_MTI:
			return new ResponseStatus("I17", "ISO_UNKNOWN_MTI", "Unknown MTI");
		case ISO_REQUEST_TIMEOUT:
			return new ResponseStatus("I18", "ISO_REQUEST_TIMEOUT", "Request timeout");
		case ISO_PENDING:
			return new ResponseStatus("I18", "ISO_PENDING", "Please try to do a manual check");
		case ISO_UNKNOWN_MESSAGE:
			return new ResponseStatus("I21", "ISO_UNKNOWN_MESSAGE", "Unknown MTI / the message did not support by the biller");
		case ISO_UNPAID_TRANSACTION:
			return new ResponseStatus("I22", "ISO_UNPAID_TRANSACTION", "Unpaid transaction, if the reversal message has been sent without being paid");
		case ISO_SEAT_ALREADY_TAKEN:
			return new ResponseStatus("I23", "ISO_SEAT_ALREADY_TAKEN", "Seat already taken / not available");
		case ISO_MESSAGING_FAILURE:
			return new ResponseStatus("I23", "ISO_MESSAGING_FAILURE", "There is an error when composing/decomposing message");
		case ISO_FAILED_CANCEL_PAYMENT:
			return new ResponseStatus("I24", "ISO_FAILED_CANCEL_PAYMENT", "Cannot cancel payment, ticket has been printed or ticket cannot be reversed");
		case ISO_FAILED_GET_TRANSACTION_STATUS:
			return new ResponseStatus("I24", "ISO_FAILED_GET_TRANSACTION_STATUS", "Failed get transaction status");
		case ISO_FAILED_UPDATE_PAX:
			return new ResponseStatus("I25", "ISO_FAILED_UPDATE_PAX", "Cant update pax, ticket has been paid");
		case ISO_INVALID_DATA:
			return new ResponseStatus("I26", "ISO_INVALID_DATA", "The data of passengers/customer did not complete/invalid");
		case ISO_UNKNOWN_MTI_OR_PROCESSING_CODE:
			return new ResponseStatus("I26", "ISO_UNKNOWN_MTI_OR_PROCESSING_CODE", "Unknown MTI or processing code");
		case ISO_SCHEDULE_NOT_FOUND:
			return new ResponseStatus("I27", "ISO_SCHEDULE_NOT_FOUND", "Schedule not available");
		case ISO_UNEXPECTED_QUERY_RESULT:
			return new ResponseStatus("I27", "ISO_UNEXPECTED_QUERY_RESULT", "Unexpected query result");
		case ISO_QUERY_RESULT_NOT_FOUND:
			return new ResponseStatus("I28", "ISO_QUERY_RESULT_NOT_FOUND", "Query result not found");
		case ISO_UNDEFINED_QUERY_CODE:
			return new ResponseStatus("I29", "ISO_UNDEFINED_QUERY_CODE", "Undefined query code");
		case ISO_PACKET_DECOMPOSITION_FAILURE:
			return new ResponseStatus("I29", "ISO_PACKET_DECOMPOSITION_FAILURE", "ISO packet decomposition failure");
		case ISO_PACKET_COMPOSITION_FAILURE:
			return new ResponseStatus("I30", "ISO_PACKET_COMPOSITION_FAILURE", "ISO packet composition failure");
		case ISO_BANK_ID_NOT_FOUND:
			return new ResponseStatus("I31", "ISO_BANK_ID_NOT_FOUND", "Bank ID not registered");
		case ISO_SWITCHER_ID_NOT_FOUND:
			return new ResponseStatus("I32", "ISO_SWITCHER_ID_NOT_FOUND", "Switcher ID not registered");
		case ISO_BILLER_CODE_NOT_FOUND:
			return new ResponseStatus("I33", "ISO_BILLER_CODE_NOT_FOUND", "Biller/product code not registered");
		case ISO_BILL_HAS_BEEN_PAID:
			return new ResponseStatus("I34", "ISO_BILL_HAS_BEEN_PAID", "Bill has been paid");
		case ISO_PREMI_HAS_BEEN_PAID:
			return new ResponseStatus("I34", "ISO_PREMI_HAS_BEEN_PAID", "Premi has been paid");
		case ISO_ALREADY_REGISTERED:
			return new ResponseStatus("I35", "ISO_ALREADY_REGISTERED", "Already registered");
		case ISO_BLOCKED_PHONE_NUMBER:
			return new ResponseStatus("I43", "ISO_BLOCKED_PHONE_NUMBER", "Blocked/expired phone number");
		case ISO_VOUCHER_OUT_OF_STOCK:
			return new ResponseStatus("I44", "ISO_VOUCHER_OUT_OF_STOCK", "Voucher out of stock");
		case ISO_INVALID_TOTAL_FEE:
			return new ResponseStatus("I46", "ISO_INVALID_TOTAL_FEE", "Total fee not match/invalid");
		case ISO_INVALID_DATE_FORMAT:
			return new ResponseStatus("I47", "ISO_INVALID_DATE_FORMAT", "Invalid date format");
		case ISO_KWH_EXCEEDS_MAXIMUM:
			return new ResponseStatus("I47", "ISO_KWH_EXCEEDS_MAXIMUM", "KWH exceeds the maximum limit");
		case ISO_MAX_TOTAL_PAYMENT_EXCEEDED:
			return new ResponseStatus("I48", "ISO_MAX_TOTAL_PAYMENT_EXCEEDED", "You can only pay, max for 12 months");
		case ISO_REGISTRATION_NUMBER_EXPIRED:
			return new ResponseStatus("I48", "ISO_REGISTRATION_NUMBER_EXPIRED", "Registration number is expired");
		case ISO_BILL_AMOUNT_NOT_MATCH:
			return new ResponseStatus("I51", "ISO_BILL_AMOUNT_NOT_MATCH", "The amount entered does not match with the specified bill amount");
		case ISO_BILLER_SECURITY_FAILURE:
			return new ResponseStatus("I55", "ISO_BILLER_SECURITY_FAILURE", "Biller security failure");
		case ISO_TRANSACTION_NOT_PERMITTED:
			return new ResponseStatus("I58", "ISO_TRANSACTION_NOT_PERMITTED", "Transaction not permitted to terminal");
		case ISO_PAYMENT_IS_NOT_ALLOWED:
			return new ResponseStatus("I58", "ISO_PAYMENT_IS_NOT_ALLOWED", "Payment is not allowed");
		case ISO_DATA_MISMATCH:
			return new ResponseStatus("I58", "ISO_DATA_MISMATCH", "The data contains mismatched value");
		case ISO_INSUFFICIENT_DEPOSIT:
			return new ResponseStatus("I61", "ISO_INSUFFICIENT_DEPOSIT", "Insufficient/invalid deposit");
		case ISO_CONSUMER_IS_BLOCKED:
			return new ResponseStatus("I63", "ISO_CONSUMER_IS_BLOCKED", "Consumer has been blocked");
		case ISO_UNABLE_ROUTE_TRANSACTION:
			return new ResponseStatus("I73", "ISO_UNABLE_ROUTE_TRANSACTION", "Unable to route transaction");
		case ISO_PRODUCT_CODE_NOT_FOUND:
			return new ResponseStatus("I73", "ISO_PRODUCT_CODE_NOT_FOUND", "Product code is not registered in the system");
		case ISO_BELOW_MINIMUM_PURCHASE:
			return new ResponseStatus("I75", "ISO_BELOW_MINIMUM_PURCHASE", "Minimum purchase is Rp. 20.000,00");
		case ISO_INVALID_METER_ID:
			return new ResponseStatus("I77", "ISO_INVALID_METER_ID", "The specified meter id is invalid");
		case ISO_WRONG_REGISTRATION_NUMBER:
			return new ResponseStatus("I77", "ISO_WRONG_REGISTRATION_NUMBER", "The specified registration number is invalid");
		case ISO_BILL_NOT_FOUND:
			return new ResponseStatus("I82", "ISO_BILL_NOT_FOUND", "The bill is not available yet");
		case ISO_TOO_CLOSE_TO_PREVIOUS_TRANSACTION:
			return new ResponseStatus("I88", "ISO_TOO_CLOSE_TO_PREVIOUS_TRANSACTION", "Too close to previous transactions");
		case ISO_INVALID_PRODUCT_CODE:
			return new ResponseStatus("I88", "ISO_INVALID_PRODUCT_CODE", "Product is not registered on the gateway");
		case ISO_INVALID_PAYMENT:
			return new ResponseStatus("I89", "ISO_INVALID_PAYMENT", "Payment failed because it has reached the time limit");
		case ISO_INVALID_AUTODEBET_STATUS:
			return new ResponseStatus("I89", "ISO_INVALID_AUTODEBET_STATUS", "Active status only allowed 1 or 0");
		case ISO_AUTODEBET_INACTIVED:
			return new ResponseStatus("I90", "ISO_AUTODEBET_INACTIVED", "Autodebit registration status is inactived, please update data");
		case ISO_CUT_OFF_IN_PROGRESS:
			return new ResponseStatus("I90", "ISO_CUT_OFF_IN_PROGRESS", "Cut-off is in progress");
		case ISO_AUTODEBET_ALREADY_REGISTERED_OTHER_BANK:
			return new ResponseStatus("I91", "ISO_AUTODEBET_ALREADY_REGISTERED_OTHER_BANK", "Already registered autodebit in other bank");
		case ISO_AUTODEBET_ALREADY_REGISTERED:
			return new ResponseStatus("I92", "ISO_AUTODEBET_ALREADY_REGISTERED", "Already registered autodebit");
		case ISO_AUTODEBET_NOT_REGISTERED:
			return new ResponseStatus("I93", "ISO_AUTODEBET_NOT_REGISTERED", "Unregistered autodebit");
		case ISO_INVALID_LENGTH_CARD_NUMBER:
			return new ResponseStatus("I94", "ISO_INVALID_LENGTH_CARD_NUMBER", "Invalid card number length");
		case ISO_REVERSAL_HAS_BEEN_MADE:
			return new ResponseStatus("I94", "ISO_REVERSAL_HAS_BEEN_MADE", "Reversal has been made");
		case ISO_AUTODEBET_INCOMPLETE_DATA:
			return new ResponseStatus("I95", "ISO_AUTODEBET_INCOMPLETE_DATA", "Incomplete cardnumber or other data");
		case ISO_AUTODEBET_MUST_NUMBER:
			return new ResponseStatus("I96", "ISO_AUTODEBET_MUST_NUMBER", "Cardnumber, bank account, and mobile should be number");
		case ISO_SYSTEM_MALFUNCTION:
			return new ResponseStatus("I96", "ISO_SYSTEM_MALFUNCTION", "System malfunction");
		case ISO_REVERSAL_FAILED:
			return new ResponseStatus("I96", "ISO_REVERSAL_FAILED", "System cannot find the payment for this registration number");
		case ISO_FAILED_GET_STATUS:
			return new ResponseStatus("I96", "ISO_FAILED_GET_STATUS", "Suspect transaction. Please contact customer service");
		case ISO_INVALID_REVERSAL:
			return new ResponseStatus("I97", "ISO_INVALID_REVERSAL", "Failed to reverse the payment because it has reached the time limit");
		case ISO_INVALID_AUTODEBET_DATE:
			return new ResponseStatus("I97", "ISO_INVALID_AUTODEBET_DATE", "Autodebit date should be between 1-28");
		case ISO_INVALID_CARD_NUMBER_STATUS:
			return new ResponseStatus("I98", "ISO_INVALID_CARD_NUMBER_STATUS", "Unidentified/invalid Card Number Status");
		case ISO_INVALID_REFERENCE_NUMBER:
			return new ResponseStatus("I98", "ISO_INVALID_REFERENCE_NUMBER", "Invalid reference number, it does not match with previous request");
		case ISO_INVALID_BILL_AMOUNT:
			return new ResponseStatus("I99", "ISO_INVALID_BILL_AMOUNT", "The amount entered does not match with the specified bill amount");
		case KYC_REJECTED:
			return new ResponseStatus("K01", "KYC_REJECTED", "Upgrade account has been rejected, please verify your data");
		case KYC_PENDING:
			return new ResponseStatus("K02", "KYC_PENDING", "Upgrade account in process");
		case SESSION_EXPIRED:
			return new ResponseStatus("L17", "SESSION_EXPIRED", "Session token is already expired");
		case INVALID_SIGNATURE:
			return new ResponseStatus("L21", "INVALID_SIGNATURE", "Invalid message signature");
		case EMAIL_ALREADY_VERIFIED:
			return new ResponseStatus("M13", "EMAIL_ALREADY_VERIFIED", "Email already verified on system");
		case MEMBER_NOT_FOUND:
			return new ResponseStatus("M14", "MEMBER_NOT_FOUND", "Member not found on system");
		case DESTINATION_MEMBER_NOT_FOUND:
			return new ResponseStatus("M15", "DESTINATION_MEMBER_NOT_FOUND", "Destination member not found on system");
		case UNAUTHORIZED_MEMBER_ACCESS:
			return new ResponseStatus("M16", "UNAUTHORIZED_MEMBER_ACCESS", "You don't have access to specified member");
		case MEMBER_ALREADY_REGISTERED:
			return new ResponseStatus("M17", "MEMBER_ALREADY_REGISTERED", "Member already registered on system");
		case ACCOUNT_ACTIVATION_NEEDED:
			return new ResponseStatus("M18", "ACCOUNT_ACTIVATION_NEEDED", "Please activate your account");
		case INVALID_PARAMETER:
			return new ResponseStatus("P14", "INVALID_PARAMETER", "Invalid request parameter");
		case INVALID_REFERRAL_CODE:
			return new ResponseStatus("P15", "INVALID_REFERRAL_CODE", "Invalid referral code");
		case DUPLICATE_TRANSACTION:
			return new ResponseStatus("P16", "DUPLICATE_TRANSACTION", "Duplicate transaction entry");
		case INVALID_QR_CRC:
			return new ResponseStatus("Q02", "INVALID_QR_CRC", "The data data inside QR has invalid CRC");
		case INVALID_QR:
			return new ResponseStatus("Q03", "INVALID_QR", "Invalid QR data or QR is expired");
		case UNSUPPORTED_MERCHANT:
			return new ResponseStatus("Q04", "UNSUPPORTED_MERCHANT", "Fello unable to do a payment for this merchant at the moment");
		case SCHEDULED_TRANSFER_NOT_FOUND:
			return new ResponseStatus("S01", "SCHEDULED_TRANSFER_NOT_FOUND", "We cannot find the scheduled transfer");
		case ACCOUNT_NOT_FOUND:
			return new ResponseStatus("S14", "ACCOUNT_NOT_FOUND", "Specified account not found");
		case INVALID_ACCOUNT:
			return new ResponseStatus("S15", "INVALID_ACCOUNT", "Invalid source account/permission not allowed");
		case INVALID_FEE_ACCOUNT:
			return new ResponseStatus("S16", "INVALID_FEE_ACCOUNT", "Invalid fee from source account");
		case INVALID_DESTINATION_ACCOUNT:
			return new ResponseStatus("S17", "INVALID_DESTINATION_ACCOUNT", "Invalid destination account/permission not allowed");
		case INVALID_FEE_DESTINATION_ACCOUNT:
			return new ResponseStatus("S18", "INVALID_FEE_DESTINATION_ACCOUNT", "Invalid fee for destination account");
		case INVALID_PHONE_NUMBER:
			return new ResponseStatus("S19", "INVALID_PHONE_NUMBER", "The phone number start with unsupported code or the length is invalid");
		case INVALID_DESTINATION_PHONE_NUMBER:
			return new ResponseStatus("S20", "INVALID_DESTINATION_PHONE_NUMBER", "Invalid destination phone number. Please check again");
		case INVALID_DENOM:
			return new ResponseStatus("S21", "INVALID_DENOM", "Denom not found");
		case INSUFFICIENT_BALANCE:
			return new ResponseStatus("S22", "INSUFFICIENT_BALANCE", "You dont have enough balance to process this transaction");
		case TRANSACTION_LIMIT_REACHED:
			return new ResponseStatus("S39", "TRANSACTION_LIMIT_REACHED", "Your account has reached the limit for doing a transaction");
		case CREDIT_LIMIT_REACHED:
			return new ResponseStatus("S40", "CREDIT_LIMIT_REACHED", "Your account credit limit has reached");
		case DESTINATION_CREDIT_LIMIT_REACHED:
			return new ResponseStatus("S41", "DESTINATION_CREDIT_LIMIT_REACHED", "The destination account credit limit has reached");
		case MONTHLY_CREDIT_LIMIT_REACHED:
			return new ResponseStatus("S42", "MONTHLY_CREDIT_LIMIT_REACHED", "Your monthly account limit has reached");
		case MONTHLY_DESTINATION_CREDIT_LIMIT_REACHED:
			return new ResponseStatus("S43", "MONTHLY_DESTINATION_CREDIT_LIMIT_REACHED", "The destination monthly limit has reached");
		case NO_TRANSACTION:
			return new ResponseStatus("S84", "NO_TRANSACTION", "No transaction found for the specified account/id/key");
		case INVALID_TRANSFER_TYPE:
			return new ResponseStatus("T14", "INVALID_TRANSFER_TYPE", "Invalid transfer type ID");
		case TRANSACTION_AMOUNT_BELOW_LIMIT:
			return new ResponseStatus("T16", "TRANSACTION_AMOUNT_BELOW_LIMIT", "Transaction amount is below the threshold limit");
		case TRANSACTION_AMOUNT_ABOVE_LIMIT:
			return new ResponseStatus("T18", "TRANSACTION_AMOUNT_ABOVE_LIMIT", "Transaction amount is above the threshold limit");
		case TRANSACTION_BLOCKED:
			return new ResponseStatus("T40", "TRANSACTION_BLOCKED", "Transaction is blocked, please contact administrator");
		case OTP_VALIDATION_FAILED:
			return new ResponseStatus("T64", "OTP_VALIDATION_FAILED", "Wrong OTP, please retry");
		case OTP_EXPIRED:
			return new ResponseStatus("T65", "OTP_EXPIRED", "OTP already expired, please retry");
		case UNSUPPORTED_CURRENCY:
			return new ResponseStatus("U02", "UNSUPPORTED_CURRENCY", "... currency is not supported by our system at the moment");
		case PAYMENT_CANCELED:
			return new ResponseStatus("V13", "PAYMENT_CANCELED", "Transaction failed");
		case PAYMENT_CODE_NOT_FOUND:
			return new ResponseStatus("V14", "PAYMENT_CODE_NOT_FOUND", "The specified Payment Code already expired or not found");
		case PAYMENT_NOT_FOUND:
			return new ResponseStatus("V15", "PAYMENT_NOT_FOUND", "Payment transaction is expired or not found");
		default:
			return new ResponseStatus("E99", "UNKNOWN_ERROR", "Unknown Error");
		}
	}
}
