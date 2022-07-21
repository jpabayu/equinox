package org.equinox.api.pojo.payment;

import java.math.BigDecimal;
import org.equinox.api.pojo.BaseRequest;

public class TransferP2PPaymentConfirmationResponse extends BaseRequest {
	
	private static final long serialVersionUID = 2093406955692419052L;
	
	private BigDecimal amount;
	private String description;
	private String fromMember;
	private String toMember;
	private String traceNumber;
	private String transactionNumber;
	
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
	
	public String getFromMember() {
		return fromMember;
	}
	
	public void setFromMember(String fromMember) {
		this.fromMember = fromMember;
	}
	
	public String getToMember() {
		return toMember;
	}
	
	public void setToMember(String toMember) {
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
}
