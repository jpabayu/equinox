package org.equinox.api.bellatrix.virtualaccount;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.equinox.api.bellatrix.BaseResponse;
import org.equinox.api.bellatrix.BellatrixJAXBContext;
import org.equinox.api.bellatrix.BellatrixStatus;

@XmlAccessorType(XmlAccessType.FIELD)
public class InquiryVAResponse extends BaseResponse {
	
	private static final long serialVersionUID = 1992806955692419078L;
	
	private String paymentCode;
	private String name;
	private BigDecimal amount;
	private String bankCode;
	private String bankName;
	private String description;
	private String email;
	private boolean fullPayment;
	private boolean persistent;
	private boolean subscribed;
	private String referenceNumber;
	private String expiredAt;
	private String formattedExpiredAt;
	
	@XmlElement(name="ticketID")
	private String ticketId;
    
	private Originator originator;
	
	public InquiryVAResponse() {
		super();
	}
	
	@Override
	public void parseResponse(String xmlString) throws Exception {
		BellatrixJAXBContext context = BellatrixJAXBContext.getInstance();
		InquiryVAResponse result = context.parseString(
				xmlString, "inquiryVAResponse", InquiryVAResponse.class);
		
		if(result != null) {
        	this.status = result.getStatus();
        	this.paymentCode = result.getPaymentCode();
        	this.name = result.getName();
        	this.amount = result.getAmount();
        	this.bankCode = result.getBankCode();
        	this.bankName = result.getBankName();
        	this.description = result.getDescription();
        	this.email = result.getEmail();
        	this.fullPayment = result.isFullPayment();
        	this.persistent = result.isPersistent();
        	this.subscribed = result.isSubscribed();
        	this.referenceNumber = result.getReferenceNumber();
        	this.expiredAt = result.getExpiredAt();
        	this.formattedExpiredAt = result.getFormattedExpiredAt();
        	this.ticketId = result.getTicketId();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isFullPayment() {
		return fullPayment;
	}

	public void setFullPayment(boolean fullPayment) {
		this.fullPayment = fullPayment;
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

	public String getFormattedExpiredAt() {
		return formattedExpiredAt;
	}

	public void setFormattedExpiredAt(String formattedExpiredAt) {
		this.formattedExpiredAt = formattedExpiredAt;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public Originator getOriginator() {
		return originator;
	}

	public void setOriginator(Originator originator) {
		this.originator = originator;
	}
}
