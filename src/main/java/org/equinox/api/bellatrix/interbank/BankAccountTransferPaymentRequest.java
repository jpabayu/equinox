package org.equinox.api.bellatrix.interbank;

import org.equinox.api.bellatrix.BaseMemberRequest;
import org.equinox.api.bellatrix.RequestPath;
import org.equinox.api.data.Constants;

public class BankAccountTransferPaymentRequest extends BaseMemberRequest {
	
	private static final long serialVersionUID = 1992806955692419064L;
	
    private String accountNumber;
    private String accountName;
    private long amount;
	private int bankId;
	private String description;
	private String remark;
	private String traceNumber;
	private String otp;
	
	public BankAccountTransferPaymentRequest() {
		super(RequestPath.INTERBANKS, "bankAccountTransferPayment");
	}

	@Override
	public String getBodyContent() {
		String usernameField = super.getBodyContent();
		sb.setLength(0);
		sb.append(usernameField);
		sb.append(Constants.THREE_INDENT).append("<accountNumber>").append(accountNumber).append("</accountNumber>\n");
		
		if(accountName != null && !accountName.isEmpty()) {
			sb.append(Constants.THREE_INDENT).append("<accountName>").append(accountName).append("</accountName>\n");
		}
		
		sb.append(Constants.THREE_INDENT).append("<amount>").append(amount).append("</amount>\n");
		sb.append(Constants.THREE_INDENT).append("<bankID>").append(bankId).append("</bankID>\n");
		sb.append(Constants.THREE_INDENT).append("<traceNumber>").append(traceNumber).append("</traceNumber>\n");
		
		if(description != null && !description.isEmpty()) {
			sb.append(Constants.THREE_INDENT).append("<description><![CDATA[").append(description).append("]]></description>\n");
		}
		
		if(remark != null && !remark.isEmpty()) {
			sb.append(Constants.THREE_INDENT).append("<remark><![CDATA[").append(remark).append("]]></remark>\n");
		}
		
		if(otp != null && !otp.isEmpty()) {
			sb.append(Constants.THREE_INDENT).append("<otp>").append(otp).append("</otp>\n");
		}
		
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

	public String getTraceNumber() {
		return traceNumber;
	}

	public void setTraceNumber(String traceNumber) {
		this.traceNumber = traceNumber;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}
	
}
