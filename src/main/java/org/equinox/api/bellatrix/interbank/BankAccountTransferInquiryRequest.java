package org.equinox.api.bellatrix.interbank;

import org.equinox.api.bellatrix.BaseMemberRequest;
import org.equinox.api.bellatrix.RequestPath;
import org.equinox.api.data.Constants;

public class BankAccountTransferInquiryRequest extends BaseMemberRequest {
	
	private static final long serialVersionUID = 1992806955692419050L;
	
    private String accountNumber;
    private String accountName;
    private long amount;
	private int bankId;
	
	public BankAccountTransferInquiryRequest() {
		super(RequestPath.INTERBANKS, "bankAccountTransferInquiry");
	}
	
	@Override
	public String getBodyContent() {
		String usernameField = super.getBodyContent();
		sb.setLength(0);
		sb.append(usernameField);
		sb.append(Constants.THREE_INDENT).append("<accountNumber>").append(accountNumber).append("</accountNumber>\n");
		sb.append(Constants.THREE_INDENT).append("<accountName>").append(accountName).append("</accountName>\n");
		sb.append(Constants.THREE_INDENT).append("<amount>").append(amount).append("</amount>\n");
		sb.append(Constants.THREE_INDENT).append("<bankID>").append(bankId).append("</bankID>\n");
		
		return sb.toString();
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		if(accountName == null) {
			this.accountName = "";
			return;
		}
		
		this.accountName = accountName;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	
}
