package org.equinox.api.qris;

public class Constants {
	// indentation
	public static final String ONE_INDENT = "    ";// 4 spaces
	public static final String TWO_INDENT = ONE_INDENT + ONE_INDENT; // 8 spaces
	public static final String THREE_INDENT = TWO_INDENT + ONE_INDENT; // 12 spaces
	public static final String FOUR_INDENT = THREE_INDENT + ONE_INDENT; // 16 spaces

	// transaction name
	public static final String TRX_TRANSFER_MEMBER = "transfer-member";
	public static final String TRX_BANK_TRANSFER = "bank-transfer";
	public static final String TRX_NAROBIL = "narobil";
	public static final String TRX_TELCO_PREPAID = "telco-prepaid";
	public static final String TRX_TELCO_POSTPAID = "telco-postpaid";
	public static final String TRX_PLN_PREPAID = "pln-prepaid";
	public static final String TRX_PLN_POSTPAID = "pln-postpaid";
	public static final String TRX_PLN_NONTAGLIS = "pln-nontaglis";
	public static final String TRX_PDAM = "pdam";
	public static final String TRX_BPJS = "bpjs";
	public static final String TRX_QRIS = "qris";
}
