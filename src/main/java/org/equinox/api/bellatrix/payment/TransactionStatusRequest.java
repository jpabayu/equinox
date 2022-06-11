package org.equinox.api.bellatrix.payment;

import org.equinox.api.bellatrix.BaseRequest;
import org.equinox.api.bellatrix.RequestPath;
import org.equinox.api.data.Constants;

public class TransactionStatusRequest extends BaseRequest {
	
	private static final long serialVersionUID = 1992806955692419074L;
	
    private String traceNumber;
	
	public TransactionStatusRequest() {
		super(RequestPath.PAYMENTS, "transactionStatus");
	}
	
	@Override
	public String getBodyContent() {
		sb.setLength(0);
		sb.append(Constants.THREE_INDENT).append("<traceNumber>").append(traceNumber).append("</traceNumber>\n");
		
		return sb.toString();
	}

	public String getTraceNumber() {
		return traceNumber;
	}

	public void setTraceNumber(String traceNumber) {
		this.traceNumber = traceNumber;
	}
	
}
