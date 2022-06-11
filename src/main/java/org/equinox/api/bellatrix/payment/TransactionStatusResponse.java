package org.equinox.api.bellatrix.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.equinox.api.bellatrix.BaseResponse;
import org.equinox.api.bellatrix.BellatrixJAXBContext;
import org.equinox.api.bellatrix.BellatrixStatus;
import org.equinox.api.bellatrix.account.Transaction;

@XmlAccessorType(XmlAccessType.FIELD)
public class TransactionStatusResponse extends BaseResponse {
	
	private static final long serialVersionUID = 1992806955692419075L;

	@XmlElement(name="transfers")
	private Transaction transaction;
	
	public TransactionStatusResponse() {
		super();
	}
	
	@Override
	public void parseResponse(String xmlString) throws Exception {
		BellatrixJAXBContext context = BellatrixJAXBContext.getInstance();
		TransactionStatusResponse result = context.parseString(
				xmlString, "transactionStatusResponse", TransactionStatusResponse.class);
		
        if(result != null) {
        	this.status = result.getStatus();
            this.transaction = result.getTransaction();
            
        } else {
        	this.status = new BellatrixStatus();
        }
		
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
}
