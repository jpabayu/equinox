package org.equinox.api.bellatrix.interbank;

import java.util.LinkedList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.equinox.api.bellatrix.BaseResponse;
import org.equinox.api.bellatrix.BellatrixJAXBContext;
import org.equinox.api.bellatrix.BellatrixStatus;

@XmlAccessorType(XmlAccessType.FIELD)
public class LoadAccountTransferResponse extends BaseResponse {
	
	private static final long serialVersionUID = 1992806955692419045L;

	@XmlElement(name="accountTransfer")
	private LinkedList<AccountTransfer> accounts = new LinkedList<AccountTransfer>();
	
	public LoadAccountTransferResponse() {
		super();
	}
	
	public LinkedList<AccountTransfer> getAccounts() {
		return accounts;
	}
	
	public void setAccounts(LinkedList<AccountTransfer> accounts) {
		this.accounts = accounts;
	}

	@Override
	public void parseResponse(String xmlString) throws Exception {
		BellatrixJAXBContext context = BellatrixJAXBContext.getInstance();
		LoadAccountTransferResponse result = context.parseString(
				xmlString, "loadAccountTransferResponse", LoadAccountTransferResponse.class);
		
		if(result != null) {
        	this.status = result.getStatus();
            this.accounts = result.getAccounts();
            
        } else {
        	this.status = new BellatrixStatus();
        }
	}
}
