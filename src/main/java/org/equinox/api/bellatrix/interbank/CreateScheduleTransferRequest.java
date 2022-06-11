package org.equinox.api.bellatrix.interbank;

import org.equinox.api.bellatrix.BaseRequest;
import org.equinox.api.bellatrix.RequestPath;
import org.equinox.api.data.Constants;

public class CreateScheduleTransferRequest extends BaseRequest {
	
	private static final long serialVersionUID = 1992806955692419054L;
    
    private String accountName;
    private String accountNumber;
    private int bankId;
    private long fromMemberId;
    private String scheduleDate;
    private int transferTypeId;
    private Boolean enabled;
	
	
	public CreateScheduleTransferRequest() {
		super(RequestPath.INTERBANKS, "createScheduleTransfer");
	}
	
	@Override
	public String getBodyContent() {
		sb.setLength(0);
		sb.append(Constants.THREE_INDENT).append("<accountName>").append(accountName).append("</accountName>\n");
		sb.append(Constants.THREE_INDENT).append("<accountNo>").append(accountNumber).append("</accountNo>\n");
		sb.append(Constants.THREE_INDENT).append("<bankID>").append(bankId).append("</bankID>\n");
		sb.append(Constants.THREE_INDENT).append("<fromMemberID>").append(fromMemberId).append("</fromMemberID>\n");
		sb.append(Constants.THREE_INDENT).append("<scheduleDate>").append(scheduleDate).append("</scheduleDate>\n");
		sb.append(Constants.THREE_INDENT).append("<transferTypeID>").append(transferTypeId).append("</transferTypeID>\n");
		
		if(enabled == null) {
			enabled = new Boolean(true);
			sb.append(Constants.THREE_INDENT).append("<enabled>").append(enabled).append("</enabled>\n");
		}
		
		return sb.toString();
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public long getFromMemberId() {
		return fromMemberId;
	}

	public void setFromMemberId(long fromMemberId) {
		this.fromMemberId = fromMemberId;
	}

	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public int getTransferTypeId() {
		return transferTypeId;
	}

	public void setTransferTypeId(int transferTypeId) {
		this.transferTypeId = transferTypeId;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
}
