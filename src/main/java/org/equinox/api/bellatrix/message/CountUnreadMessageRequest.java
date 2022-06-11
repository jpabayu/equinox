package org.equinox.api.bellatrix.message;

import org.equinox.api.bellatrix.BaseMemberRequest;
import org.equinox.api.bellatrix.RequestPath;

public class CountUnreadMessageRequest extends BaseMemberRequest {
	
	private static final long serialVersionUID = 1992806955692419034L;
	
	public CountUnreadMessageRequest() {
		super(RequestPath.MESSAGE, "countUnreadMessage");
	}
	
	@Override
	public String getBodyContent() {
		return super.getBodyContent();
	}
	
}
