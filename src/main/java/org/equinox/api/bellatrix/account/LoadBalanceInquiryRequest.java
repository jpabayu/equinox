package org.equinox.api.bellatrix.account;

import org.equinox.api.bellatrix.BaseMemberRequest;
import org.equinox.api.bellatrix.RequestPath;
import org.equinox.api.data.Constants;

public class LoadBalanceInquiryRequest extends BaseMemberRequest {
	
	private static final long serialVersionUID = 1992806955692419014L;
	private int accountId;
	
	public LoadBalanceInquiryRequest() {
		super(RequestPath.ACCOUNTS, "loadBalanceInquiry");
	}
	
	@Override
	public String getBodyContent() {
		String usernameField = super.getBodyContent();
		sb.setLength(0);
		sb.append(Constants.THREE_INDENT).append("<accountID>").append(accountId).append("</accountID>\n");
		sb.append(usernameField);
		
		return sb.toString();
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
}
