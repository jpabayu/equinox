package org.equinox.api.bellatrix.interbank;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ScheduleTransfer implements Serializable {
	
	private static final long serialVersionUID = 1992806955692419062L;
	
	private int id;
	
	@XmlElement(name="accountNo")
	private String accountNumber;
	
	private String accountName;
	
	@XmlElement(name="fromMemberID")
	private long fromMemberId;
	
	@XmlElement(name="bankID")
	private int bankId;
	
	private String scheduleDate;
	
	@XmlElement(name="transferTypeID")
	private int transferTypeId;
	
	private boolean enabled;
	
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
	
	public long getFromMemberId() {
		return fromMemberId;
	}
	
	public void setFromMemberId(long fromMemberId) {
		this.fromMemberId = fromMemberId;
	}
	
	public int getBankId() {
		return bankId;
	}
	
	public void setBankId(int bankId) {
		this.bankId = bankId;
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
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
