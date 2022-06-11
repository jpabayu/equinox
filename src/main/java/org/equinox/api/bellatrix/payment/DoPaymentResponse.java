package org.equinox.api.bellatrix.payment;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.equinox.api.bellatrix.BaseResponse;
import org.equinox.api.bellatrix.BellatrixJAXBContext;
import org.equinox.api.bellatrix.BellatrixStatus;
import org.equinox.api.bellatrix.member.BaseMember;

@XmlAccessorType(XmlAccessType.FIELD)
public class DoPaymentResponse extends BaseResponse {
	
	private static final long serialVersionUID = 1992806955692419069L;
	
	private long id;
	private BigDecimal amount;
	private String description;
	private String remark;
	private BaseMember fromMember;
	private BaseMember toMember;
	private String traceNumber;
	private String transactionNumber;
	private TransferType transferType;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BaseMember getFromMember() {
		return fromMember;
	}
	
	public void setFromMember(BaseMember fromMember) {
		this.fromMember = fromMember;
	}
	
	public BaseMember getToMember() {
		return toMember;
	}
	
	public void setToMember(BaseMember toMember) {
		this.toMember = toMember;
	}
	
	public String getTraceNumber() {
		return traceNumber;
	}
	
	public void setTraceNumber(String traceNumber) {
		this.traceNumber = traceNumber;
	}
	
	public String getTransactionNumber() {
		return transactionNumber;
	}
	
	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public TransferType getTransferType() {
		return transferType;
	}
	
	public void setTransferType(TransferType transferType) {
		this.transferType = transferType;
	}
	
	@Override
	public void parseResponse(String xmlString) throws Exception {
		BellatrixJAXBContext context = BellatrixJAXBContext.getInstance();
		DoPaymentResponse result = context.parseString(
				xmlString, "doPaymentResponse", DoPaymentResponse.class);
		
		if(result != null) {
        	this.status = result.getStatus();
        	this.id = result.getId();
        	this.amount = result.getAmount();
        	this.description = result.getDescription();
        	this.remark = result.getRemark();
        	this.fromMember = result.getFromMember();
        	this.toMember = result.getToMember();
        	this.traceNumber = result.getTraceNumber();
        	this.transactionNumber = result.getTransactionNumber();
        	this.transferType = result.getTransferType();
        } else {
        	this.status = new BellatrixStatus();
        }
		
	}
}
