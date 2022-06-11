package org.equinox.api.bellatrix.access;

import org.equinox.api.bellatrix.BaseMemberRequest;
import org.equinox.api.bellatrix.RequestPath;
import org.equinox.api.data.Constants;

public class CredentialStatusRequest extends BaseMemberRequest {
	
	private static final long serialVersionUID = 1992806955692419004L;
	
	private int accessTypeId;
	
	public CredentialStatusRequest() {
		super(RequestPath.ACCESS, "credentialStatus");
	}
	
	@Override
	public String getBodyContent() {
		String usernameField = super.getBodyContent();
		sb.setLength(0);
		sb.append(Constants.THREE_INDENT).append("<accessTypeID>").append(accessTypeId).append("</accessTypeID>\n");
		sb.append(usernameField);
		
		return sb.toString();
	}
	
	public int getAccessTypeId() {
		return accessTypeId;
	}

	public void setAccessTypeId(int accessTypeId) {
		this.accessTypeId = accessTypeId;
	}
}
