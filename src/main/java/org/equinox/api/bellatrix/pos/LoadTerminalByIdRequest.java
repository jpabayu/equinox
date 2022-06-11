package org.equinox.api.bellatrix.pos;

import org.equinox.api.bellatrix.BaseRequest;
import org.equinox.api.bellatrix.RequestPath;
import org.equinox.api.data.Constants;

public class LoadTerminalByIdRequest extends BaseRequest {
	
	private static final long serialVersionUID = 1992806955692419082L;
	
    private Integer terminalId;
    private String toMember;
    private String nnsId;
	
	public LoadTerminalByIdRequest() {
		super(RequestPath.POS, "loadTerminalByID");
	}
	
	@Override
	public String getBodyContent() {
		sb.setLength(0);
		
		if(terminalId != null) {
			sb.append(Constants.THREE_INDENT).append("<terminalID>").append(terminalId).append("</terminalID>\n");
		}
		
		if(toMember != null) {
			sb.append(Constants.THREE_INDENT).append("<toMember>").append(toMember).append("</toMember>\n");
		}
		
		if(nnsId != null) {
			sb.append(Constants.THREE_INDENT).append("<nnsID>").append(nnsId).append("</nnsID>\n");
		}
		
		return sb.toString();
	}

	public Integer getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(Integer terminalId) {
		this.terminalId = terminalId;
	}

	public String getToMember() {
		return toMember;
	}

	public void setToMember(String toMember) {
		this.toMember = toMember;
	}

	public String getNnsId() {
		return nnsId;
	}

	public void setNnsId(String nnsId) {
		this.nnsId = nnsId;
	}
	
}
