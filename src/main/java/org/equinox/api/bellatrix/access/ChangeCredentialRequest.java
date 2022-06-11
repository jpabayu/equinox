package org.equinox.api.bellatrix.access;

import org.equinox.api.bellatrix.BaseMemberRequest;
import org.equinox.api.bellatrix.RequestPath;
import org.equinox.api.data.Constants;

public class ChangeCredentialRequest extends BaseMemberRequest {
	
	private static final long serialVersionUID = 1992806955692419019L;
	
	private int accessTypeId;
	private String oldCredential;
	private String newCredential;
	
	public ChangeCredentialRequest() {
		super(RequestPath.ACCESS,"changeCredential");
	}
	
	@Override
	public String getBodyContent() {
		String usernameField = super.getBodyContent();
		sb.setLength(0);
		sb.append(Constants.THREE_INDENT).append("<accessTypeID>").append(accessTypeId).append("</accessTypeID>\n");
		sb.append(Constants.THREE_INDENT).append("<oldCredential>").append(oldCredential).append("</oldCredential>\n");
		sb.append(Constants.THREE_INDENT).append("<newCredential>").append(newCredential).append("</newCredential>\n");
		sb.append(usernameField);
		
		return sb.toString();
	}
	
	public int getAccessTypeId() {
		return accessTypeId;
	}

	public void setAccessTypeId(int accessTypeId) {
		this.accessTypeId = accessTypeId;
	}

	public String getOldCredential() {
		return oldCredential;
	}

	public void setOldCredential(String oldCredential) {
		this.oldCredential = oldCredential;
	}

	public String getNewCredential() {
		return newCredential;
	}

	public void setNewCredential(String newCredential) {
		this.newCredential = newCredential;
	}
}
