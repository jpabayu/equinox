package org.equinox.api.bellatrix.interbank;

import org.equinox.api.bellatrix.BaseRequest;
import org.equinox.api.bellatrix.RequestPath;
import org.equinox.api.data.Constants;

public class UpdateScheduleTransferRequest extends BaseRequest {
	
	private static final long serialVersionUID = 1992806955692419056L;
	
    private int id;
    private String accountNumber;
    private String accountName;
    private Integer bankId;
    private Long fromMemberId;
    private String scheduleDate;
    private Integer transferTypeId;
    private Boolean enabled;
	
	public UpdateScheduleTransferRequest() {
		super(RequestPath.INTERBANKS, "updateScheduleTransfer");
	}
	
	@Override
	public String getBodyContent() {
		sb.setLength(0);
		sb.append(Constants.THREE_INDENT).append("<id>").append(id).append("</id>\n");
		
		if(accountNumber != null) {
			sb.append(Constants.THREE_INDENT).append("<accountNo>").append(accountNumber).append("</accountNo>\n");
		}
		
		if(accountName != null) {
			sb.append(Constants.THREE_INDENT).append("<accountName>").append(accountName).append("</accountName>\n");
		}
		
		if(bankId != null) {
			sb.append(Constants.THREE_INDENT).append("<bankID>").append(bankId).append("</bankID>\n");
		}
		
		if(fromMemberId != null) {
			sb.append(Constants.THREE_INDENT).append("<fromMemberID>").append(fromMemberId).append("</fromMemberID>\n");
		}
		
		if(scheduleDate != null) {
			sb.append(Constants.THREE_INDENT).append("<scheduleDate>").append(scheduleDate).append("</scheduleDate>\n");
		}
		
		if(transferTypeId != null) {
			sb.append(Constants.THREE_INDENT).append("<transferTypeID>").append(transferTypeId).append("</transferTypeID>\n");
		}
		
		if(enabled != null) {
			sb.append(Constants.THREE_INDENT).append("<enabled>").append(enabled).append("</enabled>\n");
		}
		
		return sb.toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public Long getFromMemberId() {
		return fromMemberId;
	}

	public void setFromMemberId(Long fromMemberId) {
		this.fromMemberId = fromMemberId;
	}

	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	
	public void setScheduleDateByDay(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public Integer getTransferTypeId() {
		return transferTypeId;
	}

	public void setTransferTypeId(Integer transferTypeId) {
		this.transferTypeId = transferTypeId;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
}
