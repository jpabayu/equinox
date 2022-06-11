package org.equinox.api.bellatrix.account;

import java.math.BigDecimal;

import org.equinox.api.bellatrix.BaseResponse;
import org.equinox.api.bellatrix.BellatrixJAXBContext;
import org.equinox.api.bellatrix.BellatrixStatus;

public class LoadBalanceInquiryResponse extends BaseResponse {
	
	private static final long serialVersionUID = 1992806955692419015L;
	private BigDecimal balance;
	private String formattedBalance;
	private BigDecimal reservedAmount;
	private String formattedReservedAmount;
	
	public LoadBalanceInquiryResponse() {
		super();
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getFormattedBalance() {
		return formattedBalance;
	}

	public void setFormattedBalance(String formattedBalance) {
		this.formattedBalance = formattedBalance;
	}

	public BigDecimal getReservedAmount() {
		return reservedAmount;
	}

	public void setReservedAmount(BigDecimal reservedAmount) {
		this.reservedAmount = reservedAmount;
	}

	public String getFormattedReservedAmount() {
		return formattedReservedAmount;
	}

	public void setFormattedReservedAmount(String formattedReservedAmount) {
		this.formattedReservedAmount = formattedReservedAmount;
	}

	@Override
	public void parseResponse(String xmlString) throws Exception {
		BellatrixJAXBContext context = BellatrixJAXBContext.getInstance();
		LoadBalanceInquiryResponse result = context.parseString(
				xmlString, "loadBalanceInquiryResponse", LoadBalanceInquiryResponse.class);
		
		if(result != null) {
        	this.status = result.getStatus();
            this.balance = result.getBalance();
            this.formattedBalance = result.getFormattedBalance();
            this.reservedAmount = result.getReservedAmount();
            this.formattedReservedAmount = result.getFormattedReservedAmount();
        } else {
        	this.status = new BellatrixStatus();
        }
	}
}
