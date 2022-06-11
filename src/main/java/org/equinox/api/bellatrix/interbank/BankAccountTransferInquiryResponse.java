package org.equinox.api.bellatrix.interbank;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.equinox.api.bellatrix.BaseResponse;
import org.equinox.api.bellatrix.BellatrixJAXBContext;
import org.equinox.api.bellatrix.BellatrixStatus;

@XmlAccessorType(XmlAccessType.FIELD)
public class BankAccountTransferInquiryResponse extends BaseResponse {
	
	private static final long serialVersionUID = 1992806955692419051L;
	
    private String accountNumber;
    private String bankCode;
    private String bankName;
    private BigDecimal finalAmount;
    private BigDecimal totalFees;
    private BigDecimal transactionAmount;
    
    @XmlElement(name="twoFactorAuthentication")
    private boolean twoFA; //2 factor authentication
	
	public BankAccountTransferInquiryResponse() {
		super();
	}

	@Override
	public void parseResponse(String xmlString) throws Exception {
		BellatrixJAXBContext context = BellatrixJAXBContext.getInstance();
		BankAccountTransferInquiryResponse result = context.parseString(
				xmlString, "bankAccountTransferInquiryResponse", BankAccountTransferInquiryResponse.class);
		
		if(result != null) {
        	this.status = result.getStatus();
            this.accountNumber = result.getAccountNumber();
            this.bankCode = result.getBankCode();
            this.bankName = result.getBankName();
            this.finalAmount = result.getFinalAmount();
            this.totalFees = result.getTotalFees();
            this.transactionAmount = result.getTransactionAmount();
            this.twoFA = result.isTwoFA();
        } else {
        	this.status = new BellatrixStatus();
        }
		
	}
	
	public void standardizedBankName() {
		if(bankName == null || bankName.isEmpty()) return;
		
		Bank bank = new Bank();
		bank.setName(bankName);
		bank.standardizedBankName();
		bankName = bank.getName();
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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

	public BigDecimal getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(BigDecimal finalAmount) {
		this.finalAmount = finalAmount;
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

	public boolean isTwoFA() {
		return twoFA;
	}

	public void setTwoFA(boolean twoFA) {
		this.twoFA = twoFA;
	}
}
