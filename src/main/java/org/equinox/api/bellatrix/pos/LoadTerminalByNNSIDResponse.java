package org.equinox.api.bellatrix.pos;

import java.util.LinkedList;

import org.equinox.api.bellatrix.BaseResponse;
import org.equinox.api.bellatrix.BellatrixJAXBContext;
import org.equinox.api.bellatrix.BellatrixStatus;

public class LoadTerminalByNNSIDResponse extends BaseResponse {
	
	private static final long serialVersionUID = 1992806955692419088L;
	
	private LinkedList<Terminal> terminal = new LinkedList<Terminal>();

	public LoadTerminalByNNSIDResponse() {
		super();
	}
	
	@Override
	public void parseResponse(String xmlString) throws Exception {
		BellatrixJAXBContext context = BellatrixJAXBContext.getInstance();
		LoadTerminalByNNSIDResponse result = context.parseString(
				xmlString, "loadTerminalByNNSIDResponse", LoadTerminalByNNSIDResponse.class);
		
		if(result != null) {
        	this.status = result.getStatus();
        	this.terminal = result.getTerminal();
        } else {
        	this.status = new BellatrixStatus();
        }
		
	}

	public LinkedList<Terminal> getTerminal() {
		return terminal;
	}

	public void setTerminal(LinkedList<Terminal> terminal) {
		this.terminal = terminal;
	}
	
}
