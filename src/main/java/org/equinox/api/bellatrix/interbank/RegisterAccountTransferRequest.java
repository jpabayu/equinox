package org.equinox.api.bellatrix.interbank;

import org.equinox.api.bellatrix.BaseMemberRequest;
import org.equinox.api.bellatrix.RequestPath;
import org.equinox.api.data.Constants;

public class RegisterAccountTransferRequest extends BaseMemberRequest {
	
	private static final long serialVersionUID = 1992806955692419046L;
	
    private int bankId;
    private String accountNo;
    private String accountName;
    private String description;
	
	public RegisterAccountTransferRequest() {
		super(RequestPath.INTERBANKS, "registerAccountTransfer");
	}
	
	@Override
	public String getBodyContent() {
		String usernameField = super.getBodyContent();
		sb.setLength(0);
		sb.append(usernameField);
		sb.append(Constants.THREE_INDENT).append("<bankID>").append(bankId).append("</bankID>\n");
		sb.append(Constants.THREE_INDENT).append("<accountNo>").append(accountNo).append("</accountNo>\n");
		sb.append(Constants.THREE_INDENT).append("<accountName>").append(accountName).append("</accountName>\n");
		sb.append(Constants.THREE_INDENT).append("<description>").append(description).append("</description>\n");
		
		return sb.toString();
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
