package org.equinox.api.bellatrix.account;

import org.equinox.api.bellatrix.BaseMemberRequest;
import org.equinox.api.bellatrix.RequestPath;
import org.equinox.api.data.Constants;

public class LoadTransactionHistoryRequest extends BaseMemberRequest {
	
	private static final long serialVersionUID = 1992806955692419029L;
	private int accountId;
	private int currentPage;
	private int pageSize;
	private String fromDate;
	private String toDate;
	
	public LoadTransactionHistoryRequest() {
		super(RequestPath.ACCOUNTS, "loadTransactionHistory");
	}
	
	@Override
	public String getBodyContent() {
		String usernameField = super.getBodyContent();
		sb.setLength(0);
		sb.append(usernameField);
		sb.append(Constants.THREE_INDENT).append("<accountID>").append(accountId).append("</accountID>\n");
		sb.append(Constants.THREE_INDENT).append("<currentPage>").append(currentPage).append("</currentPage>\n");
		sb.append(Constants.THREE_INDENT).append("<pageSize>").append(pageSize).append("</pageSize>\n");
		sb.append(Constants.THREE_INDENT).append("<fromDate>").append(fromDate).append("</fromDate>\n");
		sb.append(Constants.THREE_INDENT).append("<toDate>").append(toDate).append("</toDate>\n");
		
		return sb.toString();
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
}
