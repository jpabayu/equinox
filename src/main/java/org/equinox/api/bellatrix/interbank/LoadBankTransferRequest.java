package org.equinox.api.bellatrix.interbank;

import org.equinox.api.bellatrix.BaseMemberRequest;
import org.equinox.api.bellatrix.RequestPath;
import org.equinox.api.data.Constants;

public class LoadBankTransferRequest extends BaseMemberRequest {
	
	private static final long serialVersionUID = 1992806955692419042L;
	
	private int currentPage;
	private int pageSize;
	
	public LoadBankTransferRequest() {
		super(RequestPath.INTERBANKS, "loadBankTransfer");
	}
	
	@Override
	public String getBodyContent() {
		String usernameField = super.getBodyContent();
		sb.setLength(0);
		sb.append(usernameField);
		sb.append(Constants.THREE_INDENT).append("<currentPage>").append(currentPage).append("</currentPage>\n");
		sb.append(Constants.THREE_INDENT).append("<pageSize>").append(pageSize).append("</pageSize>\n");
		
		return sb.toString();
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
}
