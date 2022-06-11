package org.equinox.api.bellatrix.payment;

import java.math.BigDecimal;

import org.equinox.api.bellatrix.BaseResponse;
import org.equinox.api.bellatrix.BellatrixJAXBContext;
import org.equinox.api.bellatrix.BellatrixStatus;
import org.equinox.api.bellatrix.member.BaseMember;

public class DoInquiryResponse extends BaseResponse {
	
	private static final long serialVersionUID = 1992806955692419067L;
	
	private BigDecimal finalAmount;
	private BaseMember fromMember;
	private BaseMember toMember;
	private BigDecimal totalFees;
	private BigDecimal transactionAmount;
	private TransferType transferType;

	public DoInquiryResponse() {
		super();
	}

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

	public TransferType getTransferType() {
		return transferType;
	}

	public void setTransferType(TransferType transferType) {
		this.transferType = transferType;
	}
	
	@Override
	public void parseResponse(String xmlString) throws Exception {
		BellatrixJAXBContext context = BellatrixJAXBContext.getInstance();
		DoInquiryResponse result = context.parseString(
				xmlString, "doInquiryResponse", DoInquiryResponse.class);
		
		if(result != null) {
        	this.status = result.getStatus();
        	this.finalAmount = result.getFinalAmount();
        	this.fromMember = result.getFromMember();
        	this.toMember = result.getToMember();
        	this.totalFees = result.getTotalFees();
            this.transactionAmount = result.getTransactionAmount();
        	this.transferType = result.getTransferType();
        } else {
        	this.status = new BellatrixStatus();
        }
		
	}
}
