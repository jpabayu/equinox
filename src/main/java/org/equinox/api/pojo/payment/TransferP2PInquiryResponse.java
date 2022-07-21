package org.equinox.api.pojo.payment;

import java.math.BigDecimal;

import org.equinox.api.bellatrix.member.BaseMember;

public class TransferP2PInquiryResponse {
	
	private BigDecimal finalAmount;
	private BaseMember fromMember;
	private BaseMember toMember;
	private BigDecimal totalFees;
	private BigDecimal transactionAmount;
	
	public BigDecimal getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(BigDecimal finalAmount) {
		this.finalAmount = finalAmount;
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
	
	public BigDecimal getTotalFees() {
		return totalFees;
	}

	public void setTotalFees(BigDecimal totalFees) {
		this.totalFees = totalFees;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
}
