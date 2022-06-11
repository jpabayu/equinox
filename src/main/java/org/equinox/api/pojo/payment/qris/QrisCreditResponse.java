package org.equinox.api.pojo.payment.qris;

import java.math.BigDecimal;

import org.equinox.api.data.Currency;

import com.fasterxml.jackson.annotation.JsonInclude;

public class QrisCreditResponse {
	
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
	private boolean percentageTip;
	private BigDecimal amount;
	private BigDecimal convenienceFee;
	private BigDecimal totalAmount;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String traceNumber;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String referenceNumber;
	
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
	
	public boolean isPercentageTip() {
		return percentageTip;
	}
	
	public void setPercentageTip(boolean percentageTip) {
		this.percentageTip = percentageTip;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public BigDecimal getConvenienceFee() {
		return convenienceFee;
	}
	
	public void setConvenienceFee(BigDecimal convenienceFee) {
		this.convenienceFee = convenienceFee;
	}
	
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getTraceNumber() {
		return traceNumber;
	}
	
	public void setTraceNumber(String traceNumber) {
		this.traceNumber = traceNumber;
	}
	
	public String getReferenceNumber() {
		return referenceNumber;
	}
	
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
}
