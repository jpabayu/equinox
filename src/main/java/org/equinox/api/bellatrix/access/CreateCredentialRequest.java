package org.equinox.api.bellatrix.access;

import org.equinox.api.bellatrix.BaseMemberRequest;
import org.equinox.api.bellatrix.RequestPath;
import org.equinox.api.data.Constants;

public class CreateCredentialRequest extends BaseMemberRequest {
	
	private static final long serialVersionUID = 1992806955692419018L;
	
	private int accessTypeId;
	private String credential;
	
	public CreateCredentialRequest() {
		super(RequestPath.ACCESS,"createCredential");
	}
	
	@Override
	public String getBodyContent() {
		String usernameField = super.getBodyContent();
		sb.setLength(0);
		sb.append(Constants.THREE_INDENT).append("<accessTypeID>").append(accessTypeId).append("</accessTypeID>\n");
		sb.append(Constants.THREE_INDENT).append("<credential>").append(credential).append("</credential>\n");
		sb.append(usernameField);
		
		return sb.toString();
	}
	
	public int getAccessTypeId() {
		return accessTypeId;
	}

	public void setAccessTypeId(int accessTypeId) {
		this.accessTypeId = accessTypeId;
	}

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}
}
