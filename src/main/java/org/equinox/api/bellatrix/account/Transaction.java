package org.equinox.api.bellatrix.account;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.equinox.api.bellatrix.member.BaseMember;
import org.equinox.api.bellatrix.payment.TransferType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Transaction implements Serializable {
	
	private static final long serialVersionUID = 1992806955692419032L;
	
	private String id;
	private BigDecimal amount;
    private boolean chargedBack;
    
    @XmlElement(name="parentID")
    private String parentId;
    
    private String description;
    private String remark;
    private String formattedAmount;
    private String formattedTransactionDate;
    private String traceNumber;
    private String referenceNumber;
    private String transactionDate;
    private String transactionNumber;
    private String transactionState;
    private String originator;
    private BaseMember fromMember;
    private BaseMember toMember;
    private TransferType transferType;
	
    public String getId() {
		return id;
	}
    
	public void setId(String id) {
		this.id = id;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public boolean isChargedBack() {
		return chargedBack;
	}
	
	public void setChargedBack(boolean chargedBack) {
		this.chargedBack = chargedBack;
	}
	
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
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

	public String getFormattedAmount() {
		return formattedAmount;
	}
	
	public void setFormattedAmount(String formattedAmount) {
		this.formattedAmount = formattedAmount;
	}
	
	public String getFormattedTransactionDate() {
		return formattedTransactionDate;
	}
	
	public void setFormattedTransactionDate(String formattedTransactionDate) {
		this.formattedTransactionDate = formattedTransactionDate;
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
	
	public String getTransactionState() {
		return transactionState;
	}
	
	public void setTransactionState(String transactionState) {
		this.transactionState = transactionState;
	}
	
	public String getOriginator() {
		return originator;
	}

	public void setOriginator(String originator) {
		this.originator = originator;
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
	
	public TransferType getTransferType() {
		return transferType;
	}
	
	public void setTransferType(TransferType transferType) {
		this.transferType = transferType;
	}
}
