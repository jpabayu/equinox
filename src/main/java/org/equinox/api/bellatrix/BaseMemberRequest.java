package org.equinox.api.bellatrix;

import org.equinox.api.data.Constants;

public abstract class BaseMemberRequest extends BaseRequest {
	
	private static final long serialVersionUID = 1992806955692419002L;
	protected String username;

	public BaseMemberRequest(RequestPath requestPath, String requestName) {
		super(requestPath, requestName);
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String getBodyContent() {
		sb.setLength(0);
		sb.append(Constants.THREE_INDENT).append("<username>").append(username).append("</username>\n");
		return sb.toString();
	}
}
