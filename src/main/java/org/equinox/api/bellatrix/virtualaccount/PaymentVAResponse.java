package org.equinox.api.bellatrix.virtualaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.equinox.api.bellatrix.BaseResponse;
import org.equinox.api.bellatrix.BellatrixJAXBContext;
import org.equinox.api.bellatrix.BellatrixStatus;

@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentVAResponse extends BaseResponse {
	
	private static final long serialVersionUID = 1992806955692419081L;
	
	private String paymentCode;
	private String username;
	private String name;
	private String description;
	private boolean persistent;
	private boolean subscribed;
	private String referenceNumber;
	private String expiredAt;
	private String traceNumber;
	private String transactionDate;
	private String transactionNumber;
	private Originator originator;
	
	public PaymentVAResponse() {
		super();
	}
	
	@Override
	public void parseResponse(String xmlString) throws Exception {
		BellatrixJAXBContext context = BellatrixJAXBContext.getInstance();
		PaymentVAResponse result = context.parseString(
				xmlString, "paymentVAResponse", PaymentVAResponse.class);
		
		if(result != null) {
        	this.status = result.getStatus();
        	this.paymentCode = result.getPaymentCode();
        	this.username = result.getUsername();
        	this.name = result.getName();
        	this.description = result.getDescription();
        	this.persistent = result.isPersistent();
        	this.subscribed = result.isSubscribed();
        	this.referenceNumber = result.getReferenceNumber();
        	this.expiredAt = result.getExpiredAt();
        	this.traceNumber = result.getTraceNumber();
        	
        	this.transactionDate = result.getTransactionDate();
        	int dotIdx = this.transactionDate.indexOf(".");
    		if(dotIdx > 0) {
    			String dateTime = this.transactionDate.substring(0, dotIdx);
    			
    			int plusIdx = this.transactionDate.indexOf("+");
    			if(plusIdx > 0) {
    				String timeZone = this.transactionDate.substring(plusIdx);
    				this.transactionDate = dateTime + timeZone;
    			} else {
    				this.transactionDate = dateTime;
    			}
    		}
        	
        	this.transactionNumber = result.getTransactionNumber();
        	this. originator = result.getOriginator();
        } else {
        	this.status = new BellatrixStatus();
        }
	}

	public String getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPersistent() {
		return persistent;
	}

	public void setPersistent(boolean persistent) {
		this.persistent = persistent;
	}

	public boolean isSubscribed() {
		return subscribed;
	}

	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getExpiredAt() {
		return expiredAt;
	}

	public void setExpiredAt(String expiredAt) {
		this.expiredAt = expiredAt;
	}

	public String getTraceNumber() {
		return traceNumber;
	}

	public void setTraceNumber(String traceNumber) {
		this.traceNumber = traceNumber;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public Originator getOriginator() {
		return originator;
	}

	public void setOriginator(Originator originator) {
		this.originator = originator;
	}
}
