package org.equinox.api.qris.gateway;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.equinox.api.config.Configuration;
import org.equinox.api.config.Key;
import org.equinox.api.utils.CommonUtil;

public class QrisGWCredit extends QrisGWBaseGenerator {
	
	private static final long serialVersionUID = 8892806955692419085L;
	
	private String transferId;
	private String traceNumber;
	private String customerPAN;
	private String customerName;
	
	public QrisGWCredit(
			QrisGWInquiry inquiryData, BigDecimal amount, 
			BigDecimal convenienceFee
	) throws Exception {
		super(inquiryData.isStaticQR(), inquiryData.getAmount(), inquiryData.getConvenienceFee(), inquiryData.isPercentageTip());
		
		authID = inquiryData.getAuthID();
		
		BigDecimal zero = new BigDecimal("0");
		if(this.amount == null || this.amount.compareTo(zero) <= 0) {
			if(amount == null || amount.compareTo(zero) <= 0) {
				this.amount = zero;
			} else if(amount.compareTo(zero) > 0) {
				this.amount  = amount;
			}
		}
		
		if(this.percentageTip) {
			if(this.convenienceFee == null || this.convenienceFee.compareTo(zero) < 0) {
				this.convenienceFee = zero;
			}
		} else {
			if(this.convenienceFee != null) {
				if(this.convenienceFee.compareTo(zero) <= 0) {
					if(convenienceFee == null || convenienceFee.compareTo(zero) <= 0) {
						this.convenienceFee = zero;
					} else {
						this.convenienceFee = convenienceFee;
					}
				}
			}
		}
		
		fromMember = inquiryData.getFromMember();
		acquirerDomain = inquiryData.getAcquirerDomain();
		merchantPAN = inquiryData.getMerchantPAN();
		merchantID = inquiryData.getMerchantID();
		merchantName = inquiryData.getMerchantName();
		merchantEmail = inquiryData.getMerchantEmail();
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
		felloTerminalId = inquiryData.getFelloTerminalId();
		notificationUrl = inquiryData.getNotificationUrl();
	}

	@Override
	public HashMap<String, String> generateRequest() throws Exception {
		Configuration config = Configuration.getInstance();
		HashMap<String, String> result = new HashMap<String, String>();
		
		result.put("transferID", transferId);
		result.put("authID", authID);
		
		String nnsJPA = config.getString(Key.NNS_JPA);
		StringBuilder sb = new StringBuilder();
		sb.append(nnsJPA);
		sb.append(StringUtils.leftPad(customerPAN, 10, "0"));
		int checkDigit = CommonUtil.calculateCheckDigit(sb.toString());
		sb.append(checkDigit);
		result.put("customerPAN", sb.toString() );
		
		result.put("customerName", customerName);
		result.put("traceNumber", traceNumber);
		result.put("amount", amount.toPlainString());
		
		BigDecimal zero = new BigDecimal("0");
		if(convenienceFee == null) {
			result.put("convenienceFee", "-1");
		} else if(convenienceFee.compareTo(zero) >= 0) {
			if(percentageTip) {
				BigDecimal tipValue = amount.multiply(convenienceFee)
						.divide(new BigDecimal(100))
						.setScale(2, RoundingMode.HALF_DOWN);
				
				result.put("convenienceFee", amount.add(tipValue)
						.setScale(2, RoundingMode.HALF_DOWN).toPlainString());
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
		
		if(merchantCriteria == null) {
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
		
		if(additionalData != null) {
			result.put("additionalData", additionalData);
		} else {
			result.put("additionalData", "");
		}
		
		if(acceptorTID != null) {
			result.put("acceptorTID", acceptorTID);
		} else {
			result.put("acceptorTID", merchantID);
		}
		
		result.put("sof", "60");
		
		return result;
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
}
