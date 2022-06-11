package org.equinox.api.qris.gateway;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import org.equinox.api.data.Currency;
import org.equinox.api.qris.DefaultCrcCalculator;
import org.equinox.api.qris.QRDecomposer;

public abstract class QrisGWBaseGenerator implements Serializable {
	
	private static final long serialVersionUID = 8892806955692419084L;
	
	protected String acquirerDomain;
	protected String merchantPAN;
	protected String merchantID;
	protected String merchantName;
	protected String merchantEmail;
	protected String merchantCity;
	protected String merchantCriteria;
	protected String merchantType;
	protected String countryCode;
	protected String postalCode;
	protected String acceptorTID;
	protected Currency transactionCurrency;
	protected String felloTerminalId;
	protected String notificationUrl;
	protected String rrn;
	protected String authID;
	protected String stan;
	
	protected boolean percentageTip;
	protected BigDecimal amount;
	protected BigDecimal convenienceFee;
	protected boolean merchantOnUs;
	protected int transferTypeId;
	protected String additionalData;
	protected boolean staticQR;
	protected String fromMember;
	
	public QrisGWBaseGenerator() {
		this.staticQR = true;
		this.amount = null;
		this.convenienceFee = null;
		this.percentageTip = false;
	}
	
	public QrisGWBaseGenerator(boolean staticQR, BigDecimal amount, BigDecimal convenienceFee, boolean percentageTip) {
		this.staticQR = staticQR;
		this.amount = amount;
		this.convenienceFee = convenienceFee;
		this.percentageTip = percentageTip;
	}

	public abstract HashMap<String, String> generateRequest() throws Exception;
	
	public String getAcquirerDomain() {
		return acquirerDomain;
	}

	public void setAcquirerDomain(String acquirerDomain) {
		this.acquirerDomain = acquirerDomain;
	}

	public String getMerchantPAN() {
		return merchantPAN;
	}
	
	public String getMerchantPAN(boolean withCheckDigit) {
		if(withCheckDigit) return getMerchantPAN();
		
		if(merchantPAN == null) return null;
		
		if(merchantPAN.isEmpty()) return "";
		
		return merchantPAN.substring(0, merchantPAN.length()-1);
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

	public String getMerchantEmail() {
		return merchantEmail;
	}

	public void setMerchantEmail(String merchantEmail) {
		this.merchantEmail = merchantEmail;
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

	public String getFelloTerminalId() {
		return felloTerminalId;
	}

	public void setFelloTerminalId(String felloTerminalId) {
		this.felloTerminalId = felloTerminalId;
	}

	public String getNotificationUrl() {
		return notificationUrl;
	}

	public void setNotificationUrl(String notificationUrl) {
		this.notificationUrl = notificationUrl;
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

	public String getStan() {
		return stan;
	}

	public void setStan(String stan) {
		this.stan = stan;
	}

	public BigDecimal getAmount() {
		return amount;
	}
	
	public String getAmountString() {
		return amount.toPlainString();
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public BigDecimal getConvenienceFee() {
		return convenienceFee;
	}
	
	public String getConvenienceFeeString() {
		return convenienceFee.toPlainString();
	}
	
	public void setConvenienceFee(BigDecimal convenienceFee) {
		if(percentageTip) {
			if(convenienceFee == null) {
				this.convenienceFee = new BigDecimal("0.00");
			} else {
				this.convenienceFee = convenienceFee;
			}
		} else {
			this.convenienceFee = convenienceFee;
		}
	}
	
	public boolean isMerchantOnUs() {
		return merchantOnUs;
	}

	public void setMerchantOnUs(boolean merchantOnUs) {
		this.merchantOnUs = merchantOnUs;
	}
	
	public int getTransferTypeId() {
		return transferTypeId;
	}

	public void setTransferTypeId(int transferTypeId) {
		this.transferTypeId = transferTypeId;
	}

	public String getAdditionalData() {
		return additionalData;
	}

	public void setAdditionalData(String additionalData) {
		this.additionalData = additionalData;
	}
	
	public boolean isStaticQR() {
		return staticQR;
	}

	public void setStaticQR(boolean staticQR) {
		this.staticQR = staticQR;
	}
	
	public String getFromMember() {
		return fromMember;
	}

	public void setFromMember(String fromMember) {
		this.fromMember = fromMember;
	}

	public BigDecimal getTotalAmount() {
		if(percentageTip) {
			BigDecimal tipValue = amount.multiply(convenienceFee)
					.divide(new BigDecimal(100))
					.setScale(2, RoundingMode.HALF_DOWN);
			return amount.add(tipValue);
		} else {
			if(convenienceFee == null) {
				return amount.setScale(2, RoundingMode.HALF_DOWN);
			}
			
			return amount.add(convenienceFee)
					.setScale(2, RoundingMode.HALF_DOWN);
		}
		
	}
	
	public String getTotalAmountString() {
		return getTotalAmount()
				.toPlainString();
	}

	public boolean isPercentageTip() {
		return percentageTip;
	}

	public void setPercentageTip(boolean percentageTip) {
		this.percentageTip = percentageTip;
		
		if(percentageTip) {
			if(convenienceFee == null) {
				convenienceFee = new BigDecimal("0.00");
			}
		}
	}
	
	public String getInvoiceId() {
		if(additionalData == null || additionalData.isEmpty()) return null;
		
		QRDecomposer decomposer = new QRDecomposer(additionalData);
		decomposer.setCrc(new DefaultCrcCalculator());
		
		Map<String, String> tag62Map;
		try {
			tag62Map = decomposer.doDecompose();
			if(tag62Map.containsKey("01")) {
				return tag62Map.get("01");
			}
		} catch(Exception e) {}
		
		return null;
	}
}
