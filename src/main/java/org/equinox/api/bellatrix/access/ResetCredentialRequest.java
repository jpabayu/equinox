package org.equinox.api.bellatrix.access;

import org.equinox.api.bellatrix.BaseMemberRequest;
import org.equinox.api.bellatrix.RequestPath;
import org.equinox.api.data.Constants;

public class ResetCredentialRequest extends BaseMemberRequest {
	
	private static final long serialVersionUID = 1992806955692419016L;
	
	private int accessTypeId;
	private String email;
	private String newCredential;
	
	public ResetCredentialRequest() {
		super(RequestPath.ACCESS, "resetCredential");
	}
	
	@Override
	public String getBodyContent() {
		String usernameField = super.getBodyContent();
		sb.setLength(0);
		sb.append(Constants.THREE_INDENT).append("<accessTypeID>").append(accessTypeId).append("</accessTypeID>\n");
		sb.append(Constants.THREE_INDENT).append("<email>").append((email != null) ? email : "").append("</email>\n");
		sb.append(Constants.THREE_INDENT).append("<newCredential>").append((newCredential != null) ? newCredential : "").append("</newCredential>\n");
		sb.append(usernameField);
		
		return sb.toString();
	}
	
	public int getAccessTypeId() {
		return accessTypeId;
	}

	public void setAccessTypeId(int accessTypeId) {
		this.accessTypeId = accessTypeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNewCredential() {
		return newCredential;
	}

	public void setNewCredential(String newCredential) {
		this.newCredential = newCredential;
	}
}
