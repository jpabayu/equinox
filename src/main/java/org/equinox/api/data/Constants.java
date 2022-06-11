package org.equinox.api.data;

public class Constants {
	
	//indentation
	public static final String ONE_INDENT = "    ";//4 spaces
	public static final String TWO_INDENT = ONE_INDENT + ONE_INDENT; //8 spaces
	public static final String THREE_INDENT = TWO_INDENT + ONE_INDENT; //12 spaces
	public static final String FOUR_INDENT = THREE_INDENT + ONE_INDENT; //16 spaces
	
	//transaction name
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
	
	//key value to store iso data
	public static final String ISO_KEY_2 = "primaryAccountNumber";
	public static final String ISO_KEY_7 = "transmissionDateTime";
	public static final String ISO_KEY_11 = "traceAuditNumber";
	public static final String ISO_KEY_12 = "localTransactionTime";
	public static final String ISO_KEY_13 = "localTransactionDate";
	public static final String ISO_KEY_15 = "settlementDate";
	public static final String ISO_KEY_37 = "RefNum";
	public static final String ISO_KEY_60 = "60";
	public static final String ISO_KEY_61 = "61";
	public static final String ISO_KEY_62 = "62";
	public static final String ISO_KEY_63 = "63";
	
	//hazelcast
	public static final int DEFAULT_TTL_SECONDS = 10;
	public static final String MAP_TRANSACTION_REQUEST = "transactionRequestMap";
	public static final String MAP_EMONEY_PAYMENT_RESPONSE = "emoneyPaymentResponseMap";
	public static final String MAP_ISO_TRANSACTION_REQUEST = "isoTransactionRequestMap";
	public static final String MAP_ISO_TRANSACTION_RESPONSE = "isoTransactionResponseMap";
	public static final String MAP_QRIS_INQUIRY = "qrisInquiryMap";
	public static final String MAP_QRIS_CREDIT = "qrisCreditMap";
	public static final String MAP_QRIS_INVOICE = "qrisInvoiceMap";
	
	//Transaction to JPA
	public static final String JPA_TIMEZONE = "+07:00";
}
