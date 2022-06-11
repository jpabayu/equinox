package org.equinox.api.bellatrix.interbank;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.equinox.api.bellatrix.BaseResponse;
import org.equinox.api.bellatrix.BellatrixJAXBContext;
import org.equinox.api.bellatrix.BellatrixStatus;

@XmlAccessorType(XmlAccessType.FIELD)
public class BankAccountTransferPaymentResponse extends BaseResponse {
	
	private static final long serialVersionUID = 1992806955692419065L;
	
    private String accountNumber;
    private String bankName;
    private BigDecimal finalAmount;
    private BigDecimal totalFees;
    private BigDecimal transactionAmount;
    private String traceNumber;
    private String transactionNumber;
    
    @XmlElement(name="twoFactorAuthentication")
    private boolean twoFA; //2 factor authentication
	
	public BankAccountTransferPaymentResponse() {
		super();
	}
	
	@Override
	public void parseResponse(String xmlString) throws Exception {
		BellatrixJAXBContext context = BellatrixJAXBContext.getInstance();
		BankAccountTransferPaymentResponse result = context.parseString(
				xmlString, "bankAccountTransferPaymentResponse", BankAccountTransferPaymentResponse.class);
		
		if(result != null) {
        	this.status = result.getStatus();
        	
        	this.accountNumber = result.getAccountNumber();
            this.bankName = result.getBankName();
            this.finalAmount = result.getFinalAmount();
            this.totalFees = result.getTotalFees();
            this.transactionAmount = result.getTransactionAmount();
            this.traceNumber = result.getTraceNumber();
            this.transactionNumber = result.getTransactionNumber();
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

	public boolean isTwoFA() {
		return twoFA;
	}

	public void setTwoFA(boolean twoFA) {
		this.twoFA = twoFA;
	}
	
}
