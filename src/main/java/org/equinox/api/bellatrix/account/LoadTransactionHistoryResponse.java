package org.equinox.api.bellatrix.account;

import java.util.LinkedList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.equinox.api.bellatrix.BaseResponse;
import org.equinox.api.bellatrix.BellatrixJAXBContext;
import org.equinox.api.bellatrix.BellatrixStatus;

@XmlAccessorType(XmlAccessType.FIELD)
public class LoadTransactionHistoryResponse extends BaseResponse {
	
	private static final long serialVersionUID = 1992806955692419030L;
	
	private LinkedList<Transaction> transfers = new LinkedList<Transaction>();
	
	public LoadTransactionHistoryResponse() {
		super();
	}
	
	public LinkedList<Transaction> getTransfers() {
		return transfers;
	}

	public void setTransfers(LinkedList<Transaction> transfers) {
		this.transfers = transfers;
	}

	//@Override
	public void parseResponse(String xmlString) throws Exception {
		BellatrixJAXBContext context = BellatrixJAXBContext.getInstance();
		LoadTransactionHistoryResponse result = context.parseString(
				xmlString, "loadTransactionHistoryResponse", LoadTransactionHistoryResponse.class);
		
        if(result != null) {
        	this.status = result.getStatus();
            this.transfers = result.getTransfers();
        } else {
        	this.status = new BellatrixStatus();
        }
	}
}
