package org.equinox.api.bellatrix.message;

import org.equinox.api.bellatrix.BaseRequest;
import org.equinox.api.bellatrix.RequestPath;
import org.equinox.api.data.Constants;

public class FlagMessageReaByIdRequest extends BaseRequest {
	
	private static final long serialVersionUID = 1992806955692419038L;
	
	private int id;
	
	public FlagMessageReaByIdRequest() {
		super(RequestPath.MESSAGE, "flagMessageReadByID");
	}
	
	@Override
	public String getBodyContent() {
		sb.setLength(0);
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
