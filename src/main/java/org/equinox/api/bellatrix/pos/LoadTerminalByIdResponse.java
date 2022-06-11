package org.equinox.api.bellatrix.pos;

import org.equinox.api.bellatrix.BaseResponse;
import org.equinox.api.bellatrix.BellatrixJAXBContext;
import org.equinox.api.bellatrix.BellatrixStatus;
import org.equinox.api.bellatrix.member.BaseMember;

public class LoadTerminalByIdResponse extends BaseResponse {
	
	private static final long serialVersionUID = 1992806955692419083L;
	
	private Terminal terminal;
	private BaseMember toMember;

	public LoadTerminalByIdResponse() {
		super();
	}
	
	@Override
	public void parseResponse(String xmlString) throws Exception {
		BellatrixJAXBContext context = BellatrixJAXBContext.getInstance();
		LoadTerminalByIdResponse result = context.parseString(
				xmlString, "loadTerminalByIDResponse", LoadTerminalByIdResponse.class);
		
		if(result != null) {
        	this.status = result.getStatus();
        	this.terminal = result.getTerminal();
        	this.toMember = result.getToMember();
        } else {
        	this.status = new BellatrixStatus();
        }
		
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	public BaseMember getToMember() {
		return toMember;
	}

	public void setToMember(BaseMember toMember) {
		this.toMember = toMember;
	}
	
}
