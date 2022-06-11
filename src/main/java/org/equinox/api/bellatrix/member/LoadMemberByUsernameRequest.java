package org.equinox.api.bellatrix.member;

import org.equinox.api.bellatrix.BaseMemberRequest;
import org.equinox.api.bellatrix.RequestPath;

public class LoadMemberByUsernameRequest extends BaseMemberRequest {
	
	private static final long serialVersionUID = 1992806955692419009L;
	
	public LoadMemberByUsernameRequest() {
		super(RequestPath.MEMBERS, "loadMembersByUsername");
	}
	
	@Override
	public String getBodyContent() {
		return super.getBodyContent();
	}
	
}
