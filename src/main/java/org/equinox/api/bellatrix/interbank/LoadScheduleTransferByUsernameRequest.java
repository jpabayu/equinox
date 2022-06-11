package org.equinox.api.bellatrix.interbank;

import org.equinox.api.bellatrix.BaseMemberRequest;
import org.equinox.api.bellatrix.RequestPath;

public class LoadScheduleTransferByUsernameRequest extends BaseMemberRequest {
	
	private static final long serialVersionUID = 1992806955692419061L;
	
	public LoadScheduleTransferByUsernameRequest() {
		super(RequestPath.INTERBANKS, "loadScheduleTransferByUsername");
	}
	
	@Override
	public String getBodyContent() {
		return super.getBodyContent();
	}
	
}
