package org.equinox.api.bellatrix.pos;

import org.equinox.api.bellatrix.BaseRequest;
import org.equinox.api.bellatrix.RequestPath;
import org.equinox.api.data.Constants;

public class LoadTerminalByNNSIDRequest extends BaseRequest {
	
	private static final long serialVersionUID = 1992806955692419087L;
	
    private String terminalId;
    private String nnsId;
	
	public LoadTerminalByNNSIDRequest() {
		super(RequestPath.POS, "loadTerminalByNNSID");
	}
	
	@Override
	public String getBodyContent() {
		sb.setLength(0);
		
		if(terminalId != null) {
			sb.append(Constants.THREE_INDENT).append("<terminalID>").append(terminalId).append("</terminalID>\n");
		}
		
		if(nnsId != null) {
			sb.append(Constants.THREE_INDENT).append("<nnsID>").append(nnsId).append("</nnsID>\n");
		}
		
		return sb.toString();
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getNnsId() {
		return nnsId;
	}

	public void setNnsId(String nnsId) {
		this.nnsId = nnsId;
	}
	
}
