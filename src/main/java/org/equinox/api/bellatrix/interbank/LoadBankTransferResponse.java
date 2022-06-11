package org.equinox.api.bellatrix.interbank;

import java.util.Iterator;
import java.util.LinkedList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.equinox.api.bellatrix.BaseResponse;
import org.equinox.api.bellatrix.BellatrixJAXBContext;
import org.equinox.api.bellatrix.BellatrixStatus;

@XmlAccessorType(XmlAccessType.FIELD)
public class LoadBankTransferResponse extends BaseResponse {
	
	private static final long serialVersionUID = 1992806955692419043L;
	
	@XmlElement(name="bankDetails")
	private LinkedList<Bank> banks = new LinkedList<Bank>();
	
	public LoadBankTransferResponse() {
		super();
	}
		
	public void filterBanks() {
		if(banks == null || banks.isEmpty()) return;
		
		Iterator<Bank> iterator = banks.iterator();
		while (iterator.hasNext()) {
			Bank bank = iterator.next();
			if(!bank.standardizedBankName()) {
				iterator.remove();
		    }
		}
	}
	
	public LinkedList<Bank> getBanks() {
		return banks;
	}

	public void setBanks(LinkedList<Bank> banks) {
		this.banks = banks;
	}

	@Override
	public void parseResponse(String xmlString) throws Exception {
		BellatrixJAXBContext context = BellatrixJAXBContext.getInstance();
		LoadBankTransferResponse result = context.parseString(
				xmlString, "loadBankTransferResponse", LoadBankTransferResponse.class);
		
		if(result != null) {
        	this.status = result.getStatus();
            this.banks = result.getBanks();
            
        } else {
        	this.status = new BellatrixStatus();
        }
	}
}
