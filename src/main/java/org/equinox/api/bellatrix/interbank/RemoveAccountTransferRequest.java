package org.equinox.api.bellatrix.interbank;

import org.equinox.api.bellatrix.BaseMemberRequest;
import org.equinox.api.bellatrix.RequestPath;
import org.equinox.api.data.Constants;

public class RemoveAccountTransferRequest extends BaseMemberRequest {
	
	private static final long serialVersionUID = 1992806955692419048L;
	
	private int id;
	
	public RemoveAccountTransferRequest() {
		super(RequestPath.INTERBANKS, "removeAccountTransfer");
	}
	
	@Override
	public String getBodyContent() {
		String usernameField = super.getBodyContent();
		sb.setLength(0);
		sb.append(usernameField);
		sb.append(Constants.THREE_INDENT).append("<id>").append(id).append("</id>\n");
		
		return sb.toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
