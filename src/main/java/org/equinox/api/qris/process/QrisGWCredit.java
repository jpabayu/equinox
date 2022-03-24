package org.equinox.api.qris.process;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

import org.equinox.api.qris.CommonUtils;
import org.equinox.api.qris.Currency;
import org.equinox.controller.ContextLoader;
import org.springframework.beans.factory.annotation.Autowired;

import org.apache.commons.lang.StringUtils;

public class QrisGWCredit extends QrisGWBaseGenerator {

	private static final long serialVersionUID = 5806471214223078040L;
	private String acquirerDomain;
	private String merchantPAN;
	private String merchantID;
	private String merchantName;
	private String merchantCity;
	private String merchantCriteria;
	private String merchantType;
	private String countryCode;
	private String postalCode;
	private String additionalData;
	private String acceptorTID;
	private Currency transactionCurrency;
	private String stan;
	private String transferId;
	private String traceNumber;
	private String customerPAN;
	private String customerName;
	private String rrn;
	private String authID;

	@Autowired
	private static ContextLoader contextLoader;

	public QrisGWCredit(QrisGWInquiry inquiryData, BigDecimal amount, BigDecimal convenienceFee) throws Exception {
		super(inquiryData.getAmount(), inquiryData.getConvenienceFee(), inquiryData.isPercentageTip());

		authID = inquiryData.getAuthID();

		BigDecimal zero = new BigDecimal("0");
		if (this.amount == null || this.amount.compareTo(zero) <= 0) {
			if (amount == null || amount.compareTo(zero) <= 0) {
				this.amount = zero;
			} else if (amount.compareTo(zero) > 0) {
				this.amount = amount;
			}
		}

		if (this.percentageTip) {
			if (this.convenienceFee == null || this.convenienceFee.compareTo(zero) < 0) {
				this.convenienceFee = zero;
			}
		} else {
			if (this.convenienceFee != null) {
				if (this.convenienceFee.compareTo(zero) <= 0) {
					if (convenienceFee == null || convenienceFee.compareTo(zero) <= 0) {
						this.convenienceFee = zero;
					} else {
						this.convenienceFee = convenienceFee;
					}
				}
			}
		}

		acquirerDomain = inquiryData.getAcquirerDomain();
		merchantPAN = inquiryData.getMerchantPAN();
		merchantID = inquiryData.getMerchantID();
		merchantName = inquiryData.getMerchantName();
		merchantCity = inquiryData.getMerchantCity();
		merchantCriteria = inquiryData.getMerchantCriteria();
		merchantType = inquiryData.getMerchantType();
		countryCode = inquiryData.getCountryCode();
		postalCode = inquiryData.getPostalCode();
		additionalData = inquiryData.getAdditionalData();
		acceptorTID = inquiryData.getAcceptorTID();
		transactionCurrency = inquiryData.getTransactionCurrency();
		stan = inquiryData.getStan();
		rrn = inquiryData.getRrn();
		merchantOnUs = inquiryData.isMerchantOnUs();
		transferTypeId = inquiryData.getTransferTypeId();
	}

	@Override
	public HashMap<String, String> generateRequest() throws Exception {
		HashMap<String, String> result = new HashMap<String, String>();

		result.put("transferID", transferId);
		result.put("authID", authID);

		String nnsJPA = contextLoader.getNnsJPA();
		StringBuilder sb = new StringBuilder();
		sb.append(nnsJPA);
		sb.append(StringUtils.leftPad(customerPAN, 10, "0"));
		int checkDigit = CommonUtils.calculateCheckDigit(sb.toString());
		sb.append(checkDigit);
		result.put("customerPAN", sb.toString());

		result.put("customerName", customerName);
		result.put("traceNumber", traceNumber);
		result.put("amount", amount.toPlainString());

		BigDecimal zero = new BigDecimal("0");
		if (convenienceFee == null) {
			result.put("convenienceFee", "-1");
		} else if (convenienceFee.compareTo(zero) >= 0) {
			if (percentageTip) {
				BigDecimal tipValue = amount.multiply(convenienceFee).divide(new BigDecimal(100)).setScale(2,
						RoundingMode.HALF_DOWN);

				result.put("convenienceFee", amount.add(tipValue).setScale(2, RoundingMode.HALF_DOWN).toPlainString());
			} else {
				result.put("convenienceFee", convenienceFee.toPlainString());
			}

		} else {
			result.put("convenienceFee", "0.00");
		}

		result.put("rrn", rrn);
		result.put("merchantPAN", merchantPAN);
		result.put("acquiringID", merchantPAN.substring(0, 8));

		result.put("acceptorID", merchantID);

		if (merchantCriteria == null) {
			result.put("merchantCriteria", "URE");
		} else {
			result.put("merchantCriteria", merchantCriteria);
		}

		result.put("merchantType", merchantType);
		result.put("transactionCurrency", transactionCurrency.getCodeNumber());
		result.put("countryCode", countryCode);
		result.put("merchantName", merchantName);
		result.put("merchantCity", merchantCity);
		result.put("postalCode", postalCode);

		if (additionalData != null) {
			result.put("additionalData", additionalData);
		} else {
			result.put("additionalData", "");
		}

		if (acceptorTID != null) {
			result.put("acceptorTID", acceptorTID);
		} else {
			result.put("acceptorTID", merchantID);
		}

		result.put("sof", "60");

		return result;
	}

	public String getAcquirerDomain() {
		return acquirerDomain;
	}

	public void setAcquirerDomain(String acquirerDomain) {
		this.acquirerDomain = acquirerDomain;
	}

	public String getMerchantPAN() {
		return merchantPAN;
	}

	public void setMerchantPAN(String merchantPAN) {
		this.merchantPAN = merchantPAN;
	}

	public String getMerchantID() {
		return merchantID;
	}

	public void setMerchantID(String merchantID) {
		this.merchantID = merchantID;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getMerchantCity() {
		return merchantCity;
	}

	public void setMerchantCity(String merchantCity) {
		this.merchantCity = merchantCity;
	}

	public String getMerchantCriteria() {
		return merchantCriteria;
	}

	public void setMerchantCriteria(String merchantCriteria) {
		this.merchantCriteria = merchantCriteria;
	}

	public String getMerchantType() {
		return merchantType;
	}

	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getAdditionalData() {
		return additionalData;
	}

	public void setAdditionalData(String additionalData) {
		this.additionalData = additionalData;
	}

	public String getAcceptorTID() {
		return acceptorTID;
	}

	public void setAcceptorTID(String acceptorTID) {
		this.acceptorTID = acceptorTID;
	}

	public Currency getTransactionCurrency() {
		return transactionCurrency;
	}

	public void setTransactionCurrency(Currency transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}

	public String getStan() {
		return stan;
	}

	public void setStan(String stan) {
		this.stan = stan;
	}

	public String getTransferId() {
		return transferId;
	}

	public void setTransferId(String transferId) {
		this.transferId = transferId;
	}

	public String getTraceNumber() {
		return traceNumber;
	}

	public void setTraceNumber(String traceNumber) {
		this.traceNumber = traceNumber;
	}

	public String getCustomerPAN() {
		return customerPAN;
	}

	public void setCustomerPAN(String customerPAN) {
		this.customerPAN = customerPAN;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getRrn() {
		return rrn;
	}

	public void setRrn(String rrn) {
		this.rrn = rrn;
	}

	public String getAuthID() {
		return authID;
	}

	public void setAuthID(String authID) {
		this.authID = authID;
	}
}
