package org.equinox.api.bellatrix.access;

import org.equinox.api.bellatrix.BaseMemberRequest;
import org.equinox.api.bellatrix.RequestPath;
import org.equinox.api.data.Constants;

public class GetCredentialRequest extends BaseMemberRequest {
	
	private static final long serialVersionUID = 1992806955692419022L;
	
	private int accessTypeId;
	
	public GetCredentialRequest() {
		super(RequestPath.ACCESS, "getCredential");
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
